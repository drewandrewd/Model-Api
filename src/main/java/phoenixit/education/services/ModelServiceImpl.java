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
    public List<ModelResponse> update(ModelRequest modelRequest) throws ModelNotFoundException {
        List<Model> model = new ModelServiceImpl().findByName(modelRequest.getName());
        List<ModelResponse> modelResponses= new ArrayList<>();
        Model updating = converter.requestToModel(modelRequest);
        String updatingName = updating.getName();
        String updatingComment = updating.getComment();
        ModelType updatingType = updating.getType();
        for (Model current : model) {
            if (!current.equals(updating)) {
                if(!current.getName().equals(updatingName)) {
                    current.setName(updatingName);
                }
                if(!current.getName().equals(updatingName)) {
                    current.setName(updatingName);
                }
                if(!current.getComment().equals(updatingComment)) {
                    current.setComment(updatingComment);
                }
                if(!current.getType().equals(updatingType)) {
                    current.setType(updatingType);
                }
                modelResponses.add(converter.modelToResponse(current));
            }
        }
        return modelResponses;
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
