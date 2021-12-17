package phoenixit.education.services;

import com.googlecode.jsonrpc4j.JsonRpcService;
import phoenixit.education.exceptions.ModelNotFoundException;
import phoenixit.education.models.Model;
import phoenixit.education.models.ModelRequest;
import phoenixit.education.models.ModelResponse;

import java.util.List;

public interface ModelService {

    List<Model> findByName(String name) throws ModelNotFoundException;

    ModelResponse create(ModelRequest modelRequest);

    ModelResponse update(ModelRequest modelRequest) throws ModelNotFoundException;

    void delete(ModelRequest modelRequest) throws ModelNotFoundException;
}
