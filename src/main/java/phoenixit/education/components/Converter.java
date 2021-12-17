package phoenixit.education.components;

import org.springframework.stereotype.Component;
import phoenixit.education.models.*;
import phoenixit.education.services.LoggerService;

import java.util.Date;

@Component
public class Converter {

    public Model requestToModel(ModelRequest modelRequest) {
        Model model = new Model();
        model.setId(modelRequest.getId());
        model.setName(modelRequest.getName());
        model.setComment(modelRequest.getComment());
        model.setType(ModelType.convertToEnum(modelRequest.getType()));
        return model;
    }

    public ModelResponse modelToResponse(Model model) {
        ModelResponse responce = new ModelResponse();
        responce.setId(model.getId());
        responce.setName(model.getName());
        responce.setComment(model.getComment());
        responce.setType(model.getType().name());
        responce.setNodeId(model.getNodeId());
        responce.setCreateAt(model.getCreateAt());
        responce.setUpdateAt(model.getUpdateAt());
        responce.setCreator(model.getCreator());
        responce.setUpdater(model.getUpdater());
        return  responce;
    }
}
