package phoenixit.education.jsonRPC;

import com.googlecode.jsonrpc4j.JsonRpcParam;
import com.googlecode.jsonrpc4j.JsonRpcService;
import phoenixit.education.exceptions.ModelNotFoundException;
import phoenixit.education.models.ModelRequest;
import phoenixit.education.models.ModelResponse;

@JsonRpcService("/api")
public interface API {

    ModelResponse create(@JsonRpcParam(value = "modelRequest") ModelRequest modelRequest);
    ModelResponse update(@JsonRpcParam(value = "modelRequest") ModelRequest modelRequest) throws ModelNotFoundException;
    ModelResponse delete(@JsonRpcParam(value = "id") String id) throws ModelNotFoundException;
}