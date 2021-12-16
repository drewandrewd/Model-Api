package phoenixit.education.services;

import phoenixit.education.models.Model;
import phoenixit.education.models.ModelRequest;
import phoenixit.education.models.ModelResponse;

public class ConvertService {

    public void requestToModel(ModelRequest modelRequest) {
        /*try {
            Model model = new Model(ModelList.getModelsArray().size() + "", modelRequest.getName(), modelRequest.getComment(), (long) ModelList.getModelsArray().size(), new Date(new Date().getTime()), new Date(new Date().getTime()), "admin", "admin");
            ModelList.getModelsArray().add(model);
        } catch (Exception e) {
            LoggerService.getLogger().error("Ошибка конвертации!", e);
        }*/
    }

    public void modelToResponse(Model model) {
        try {
            ModelResponse modelResponse = new ModelResponse(model.getId(), model.getName(), model.getComment(), model.getNodeId(), model.getCreateAt(), model.getUpdateAt(), model.getCreator(), model.getUpdater());
        } catch (Exception e) {
            LoggerService.getLogger().error("Ошибка конвертации!", e);
        }
    }
}
