package jsonRPC;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import phoenixit.education.models.ModelRequest;

@AutoJsonRpcServiceImpl
public class APIImpl implements API{

    @Override
    public ModelRequest create(String id, String name, String comment, String type) {
        ModelRequest request = new ModelRequest();
        request.setId(id);
        request.setName(name);
        request.setComment(comment);
        request.setType(type);
        return request;
    }
}
