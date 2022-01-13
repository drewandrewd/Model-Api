package phoenixit.education.jsonRPC;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phoenixit.education.exceptions.ModelNotFoundException;
import phoenixit.education.models.ModelRequest;
import phoenixit.education.models.ModelResponse;
import phoenixit.education.services.ModelService;

@Service
@AutoJsonRpcServiceImpl
public class APIImpl implements API {

 private ModelService modelService;

    @Override
    public ModelResponse create(ModelRequest modelRequest) throws Throwable {
        return modelService.create(modelRequest);
    }

    @Override
    public ModelResponse update(ModelRequest modelRequest) throws Throwable {
        return modelService.update(modelRequest);
    }

    @Override
    public ModelResponse delete(String id) throws Throwable {
        return modelService.delete(id);
    }

    @Autowired
    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }


}
