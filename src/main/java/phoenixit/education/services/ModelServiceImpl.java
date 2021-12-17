package phoenixit.education.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phoenixit.education.components.Converter;
import phoenixit.education.exceptions.ModelNotFoundException;
import phoenixit.education.models.Model;
import phoenixit.education.models.ModelRequest;
import phoenixit.education.models.ModelResponse;
import phoenixit.education.models.ModelType;
import phoenixit.education.repositories.ModelRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ModelServiceImpl implements ModelService {

    private ModelRepository modelRepository;
    private Converter converter;
//    private MongoRepository<Model, String> models;
//    private ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
//    private MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

    @Override
    public List<Model> findByName(String name) throws ModelNotFoundException {
        List<Model> model = modelRepository.findByName(name);
        if (!model.isEmpty()) {
            //todo action
        } else {
            //throw exceptions
            throw new ModelNotFoundException();
        }
        return model;
    }

    @Override
    public ModelResponse create(ModelRequest modelRequest) {
        Model model = converter.requestToModel(modelRequest);
        model.setCreateAt(new Date());
        model.setCreator("admin");
        model.setNodeId(1L);//todo get from Neo4J component
        return converter.modelToResponse(modelRepository.save(model));
    }

    @Override
    public ModelResponse update(ModelRequest modelRequest) throws ModelNotFoundException {
        Model updating = converter.requestToModel(modelRequest);
        String updatingName = updating.getName();
        String updatingComment = updating.getComment();
        ModelType updatingType = updating.getType();
        Optional<Model> current = modelRepository.findById(updating.getId());
        if (current.isPresent()) {
            Model newModel = current.get();
            if (!newModel.equals(updating)) {
                if(!newModel.getName().equals(updatingName)) {
                    newModel.setName(updatingName);
                }
                if(!newModel.getName().equals(updatingName)) {
                    newModel.setName(updatingName);
                }
                if(!newModel.getComment().equals(updatingComment)) {
                    newModel.setComment(updatingComment);
                }
                if(!newModel.getType().equals(updatingType)) {
                    newModel.setType(updatingType);
                }
            }
            return converter.modelToResponse(newModel);
        } else {
            throw new ModelNotFoundException();
        }
    }

    @Autowired
    public void setModelRepository(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Autowired
    public void setConverter(Converter converter) {
        this.converter = converter;
    }
}
