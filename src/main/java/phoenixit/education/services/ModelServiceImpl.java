package phoenixit.education.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phoenixit.education.components.Converter;
import phoenixit.education.exceptions.ModelNotFoundException;
import phoenixit.education.models.Model;
import phoenixit.education.models.ModelRequest;
import phoenixit.education.models.ModelResponse;
import phoenixit.education.models.ModelType;
import phoenixit.education.repositories.ModelRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ModelServiceImpl implements ModelService {

    private ModelRepository modelRepository;
    private Converter converter;
    private ModelLinkServiceImpl modelLinkService;

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
    public ModelResponse create(ModelRequest modelRequest) throws Throwable {
        Model model = converter.requestToModel(modelRequest);
        model.setCreateAt(new Date());
        model.setCreator("admin");
        model.setNodeId(modelLinkService.create(modelRequest.getName(), modelRequest.getClassNodeId()));//todo get from Neo4J component
        return converter.modelToResponse(modelRepository.save(model));
    }

    @Override
    public ModelResponse update(ModelRequest modelRequest) throws Throwable {
        Model updating = converter.requestToModel(modelRequest);
        log.info("updating: " + updating);
        String updatingName = updating.getName();
        String updatingComment = updating.getComment();
        ModelType updatingType = updating.getType();
        Optional<Model> current = modelRepository.findById(updating.getId());
        log.info("current: " + current);
        if (current.isPresent()) {
            Model newModel = current.get();
            if (!newModel.equals(updating)) {
                if(!newModel.getName().equals(updatingName)) {
                    newModel.setName(updatingName);
                }
                if(!newModel.getComment().equals(updatingComment)) {
                    newModel.setComment(updatingComment);
                }
                if(!newModel.getType().equals(updatingType)) {
                    newModel.setType(updatingType);
                }
                newModel.setUpdateAt(new Date());
                newModel.setUpdater("admin");
            }
            modelLinkService.update(newModel.getName(), modelRequest.getClassNodeId());
            return converter.modelToResponse(modelRepository.save(newModel));
        } else {
            throw new ModelNotFoundException();
        }
    }

    @Override
    public ModelResponse delete(String id) throws Throwable {
        Optional<Model> current = modelRepository.findById(id);
        if (!current.isPresent()) {
            throw new ModelNotFoundException();
        }
        Model newModel = current.get();
        modelRepository.delete(newModel);
        modelLinkService.delete(newModel.getNodeId());
        return converter.modelToResponse(newModel);
    }

    @Autowired
    public void setModelRepository(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Autowired
    public void setConverter(Converter converter) {
        this.converter = converter;
    }

    @Autowired
    public void setModelLinkService(ModelLinkServiceImpl modelLinkService) {
        this.modelLinkService = modelLinkService;
    }
}
