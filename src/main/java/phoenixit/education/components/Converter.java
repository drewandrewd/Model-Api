package phoenixit.education.components;

import org.springframework.stereotype.Component;
import phoenixit.education.models.Model;
import phoenixit.education.models.ModelList;
import phoenixit.education.models.ModelRequest;
import phoenixit.education.models.ModelResponse;
import phoenixit.education.services.LoggerService;

import java.util.Date;

@Component
public class Converter {

    public Model requestToModel(ModelRequest modelRequest) {
        Model model = new Model();
        model.setName(modelRequest.getName());
        model.setComment(modelRequest.getComment());
        return model;
    }

    public ModelResponse modelToResponse(Model model) {
        return new ModelResponse(model.getId(), model.getName(), model.getComment(), model.getNodeId(), model.getCreateAt(), model.getUpdateAt(), model.getCreator(), model.getUpdater());
    }
}
