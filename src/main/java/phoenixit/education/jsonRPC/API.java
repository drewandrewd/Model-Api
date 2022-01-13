package phoenixit.education.jsonRPC;

import com.googlecode.jsonrpc4j.JsonRpcParam;
import com.googlecode.jsonrpc4j.JsonRpcService;
import phoenixit.education.exceptions.ModelNotFoundException;
import phoenixit.education.models.ModelRequest;
import phoenixit.education.models.ModelResponse;

@JsonRpcService("/api/v1/model.json")
public interface API {

    ModelResponse create(@JsonRpcParam(value = "modelRequest") ModelRequest modelRequest) throws Throwable;
    ModelResponse update(@JsonRpcParam(value = "modelRequest") ModelRequest modelRequest) throws ModelNotFoundException;
    ModelResponse delete(@JsonRpcParam(value = "id") String id) throws Throwable;
}
