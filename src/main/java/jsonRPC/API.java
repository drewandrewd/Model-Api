package jsonRPC;

import com.googlecode.jsonrpc4j.JsonRpcParam;
import com.googlecode.jsonrpc4j.JsonRpcService;
import phoenixit.education.models.ModelRequest;

@JsonRpcService("/api")
public interface API {

    ModelRequest create(@JsonRpcParam(value = "a1111") String id, @JsonRpcParam(value = "Andrew") String name, @JsonRpcParam(value = "comment") String comment, @JsonRpcParam(value = "Paper") String type);
}
