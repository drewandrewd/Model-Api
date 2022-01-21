package phoenixit.education.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    private ModelLinkService modelLinkService;

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
        Long modelNodeId = modelLinkService.create(modelRequest.getName(), modelRequest.getClassNodeId());
        model.setNodeId(modelNodeId);//todo get from Neo4J component
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
            modelLinkService.update(modelRequest.getName(), newModel.getNodeId(), modelRequest.getClassNodeId());
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

    @Override
    public List<Model> fetchAll(String field, Sort.Direction direction)  throws ModelNotFoundException {
        //todo call ModelCustomRepository (ModelCustomRepositoryImpl)
        List<Model> list = modelRepository.findAll(Sort.by(direction, field));
        //todo convertToResponse
        return list;
    }

    //todo return Page<ModelResponse>
    @Override
    public List<Model> fetchAllWithPagination(String field, Sort.Direction direction, int pages, int size) {
        Pageable sortModels = PageRequest.of(pages, size, Sort.by(direction, field));
        Page<Model> allPages = modelRepository.findAll(sortModels);
        //todo streams with Page
        List<Model> listOfModels = allPages.getContent();
        //todo convertToResponse
        return listOfModels;
    }

    //todo return ModelResponse
    @Override
    public Model fetchById(String id) {
        //todo isPreset check
        Model model = modelRepository.findById(id).get();
        return model;
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
