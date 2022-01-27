package phoenixit.education.components;

import org.bson.Document;
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
        //model.setNodeId(modelRequest.getClassNodeId());
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

    public Document ResponseToDocument(ModelResponse model) {
        Document document = new Document();
        document.put("id", model.getId());
        document.put("name", model.getName());
        document.put("comment", model.getComment());
        document.put("type", model.getType());
        document.put("nodeId", model.getNodeId());
        document.put("createAt", model.getCreateAt());
        document.put("updateAt", model.getUpdateAt());
        document.put("updater", model.getUpdater());
        document.put("creator", model.getCreator());
        document.put("classNodeId", model.getClassNodeId());
        return document;
    }

    public Model documentToModel(Document document) {
        Model model = new Model();
        model.setId((String) document.get("id"));
        model.setName((String) document.get("name"));
        model.setComment((String) document.get("comment"));
        model.setType(ModelType.convertToEnum((String) document.get("type")));
        return model;
    }
}
