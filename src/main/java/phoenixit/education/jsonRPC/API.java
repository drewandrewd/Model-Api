package phoenixit.education.jsonRPC;

import com.googlecode.jsonrpc4j.JsonRpcParam;
import com.googlecode.jsonrpc4j.JsonRpcService;
import org.springframework.data.domain.Sort;
import phoenixit.education.exceptions.JsonRpcException;
import phoenixit.education.exceptions.ModelNotFoundException;
import phoenixit.education.models.ModelRequest;
import phoenixit.education.models.ModelResponse;

import java.util.List;

@JsonRpcService("/api/v1/model.json")
public interface API {

    ModelResponse create(@JsonRpcParam(value = "modelRequest") ModelRequest modelRequest) throws Throwable;
    ModelResponse update(@JsonRpcParam(value = "modelRequest") ModelRequest modelRequest) throws Throwable;
    ModelResponse delete(@JsonRpcParam(value = "id") String id) throws Throwable;
    void fetchAll(@JsonRpcParam(value = "field") String field, @JsonRpcParam(value = "direction") Sort.Direction direction) throws ModelNotFoundException;
    void fetchAllWithPagination(@JsonRpcParam(value = "field") String field, @JsonRpcParam(value = "direction") Sort.Direction direction, @JsonRpcParam(value = "pages") int pages, @JsonRpcParam(value = "size") int size) throws ModelNotFoundException;
    void fetchById(@JsonRpcParam(value = "id") String id);
    boolean fetchByClassNodeId(@JsonRpcParam(value = "classNodeId") Long classNodeId) throws Throwable;
    boolean fetchByModelNodeId(@JsonRpcParam(value = "modelNodeId") Long modelNodeId) throws Throwable;
    List<Long> fetchModelsByClassNodeId(@JsonRpcParam(value = "classNodeId") Long classNodeId) throws JsonRpcException;
}
