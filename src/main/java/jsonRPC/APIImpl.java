package jsonRPC;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phoenixit.education.exceptions.ModelNotFoundException;
import phoenixit.education.models.ModelRequest;
import phoenixit.education.models.ModelResponse;
import phoenixit.education.services.ModelService;

@AutoJsonRpcServiceImpl
@Service
public class APIImpl implements API {

 ModelService modelService;
 ModelRequest modelRequest;

    @Override
    public ModelResponse create(String id, String name, String comment, String type) {
        modelRequest.setId(id);
        modelRequest.setName(name);
        modelRequest.setComment(comment);
        modelRequest.setType(type);
        return modelService.create(modelRequest);
    }

    @Override
    public ModelResponse update(String id, String name, String comment, String type) throws ModelNotFoundException {
        modelRequest.setId(id);
        modelRequest.setName(name);
        modelRequest.setComment(comment);
        modelRequest.setType(type);
        return modelService.update(modelRequest);
    }

    @Override
    public ModelRequest delete(String id, String name, String comment, String type) throws ModelNotFoundException {
        modelRequest.setId(id);
        modelRequest.setName(name);
        modelRequest.setComment(comment);
        modelRequest.setType(type);
        return modelService.delete(modelRequest);
    }

    @Autowired
    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }

    @Autowired
    public void setModelRequest(ModelRequest modelRequest) {
        this.modelRequest = modelRequest;
    }
}
