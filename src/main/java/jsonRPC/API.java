package jsonRPC;

import com.googlecode.jsonrpc4j.JsonRpcParam;
import com.googlecode.jsonrpc4j.JsonRpcService;
import phoenixit.education.exceptions.ModelNotFoundException;
import phoenixit.education.models.ModelRequest;
import phoenixit.education.models.ModelResponse;

@JsonRpcService("/api")
public interface API {

    ModelResponse create(@JsonRpcParam(value = "id") String id, @JsonRpcParam(value = "name") String name, @JsonRpcParam(value = "comment") String comment, @JsonRpcParam(value = "type") String type);
    ModelResponse update(@JsonRpcParam(value = "id") String id, @JsonRpcParam(value = "name") String name, @JsonRpcParam(value = "comment") String comment, @JsonRpcParam(value = "type") String type) throws ModelNotFoundException;
    ModelRequest delete(@JsonRpcParam(value = "id") String id, @JsonRpcParam(value = "name") String name, @JsonRpcParam(value = "comment") String comment, @JsonRpcParam(value = "type") String type) throws ModelNotFoundException;
}
