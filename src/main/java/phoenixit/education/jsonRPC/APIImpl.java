package phoenixit.education.jsonRPC;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import phoenixit.education.exceptions.JsonRpcException;
import phoenixit.education.exceptions.ModelNotFoundException;
import phoenixit.education.models.ModelRequest;
import phoenixit.education.models.ModelResponse;
import phoenixit.education.services.ModelLinkService;
import phoenixit.education.services.ModelService;

import java.util.List;

@Service
@AutoJsonRpcServiceImpl
public class APIImpl implements API {

 private ModelService modelService;
 private ModelLinkService modelLinkService;

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

    @Override
    public List<ModelResponse> fetchAll(String field, Sort.Direction direction) throws ModelNotFoundException {
        return modelService.fetchAll(field, direction);
    }

    @Override
    public Page<ModelResponse> fetchAllWithPagination(String field, Sort.Direction direction, int pages, int size) throws ModelNotFoundException {
        return modelService.fetchAllWithPagination(field, direction, pages, size);
    }

    @Override
    public ModelResponse fetchById(String id) throws ModelNotFoundException {
       return modelService.fetchById(id);
    }

    @Override
    public String fetchByClassNodeId(Long classNodeId) throws Throwable {
        return modelLinkService.fetchByClassNodeId(classNodeId);
    }

    @Override
    public Long fetchByModelNodeId(Long modelNodeId) throws Throwable {
        return modelLinkService.fetchByModelNodeId(modelNodeId);
    }

    @Override
    public List<Long> fetchModelsByClassNodeId(Long classNodeId) throws JsonRpcException {
        return modelLinkService.fetchModelsByClassNodeId(classNodeId);
    }

    @Autowired
    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }

    @Autowired
    public void setModelLinkService(ModelLinkService modelLinkService) {
        this.modelLinkService = modelLinkService;
    }
}
