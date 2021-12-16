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
        return new Model(ModelList.getModelsArray().size() + "", modelRequest.getName(), modelRequest.getComment(), (long) ModelList.getModelsArray().size(), new Date(new Date().getTime()), new Date(new Date().getTime()), "admin", "admin");
    }

    public ModelResponse modelToResponse(Model model) {
        return new ModelResponse(model.getId(), model.getName(), model.getComment(), model.getNodeId(), model.getCreateAt(), model.getUpdateAt(), model.getCreator(), model.getUpdater());
    }
}
