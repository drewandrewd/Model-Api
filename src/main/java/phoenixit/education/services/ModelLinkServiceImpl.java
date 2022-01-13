package phoenixit.education.services;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import phoenixit.education.models.Model;

@Service
public class ModelLinkServiceImpl implements ModelLinkService {

    private JsonRpcHttpClient jsonRpcHttpClient;

    @Override
    public Long create(String name, Long classNodeId) throws Throwable {
        Model model = jsonRpcHttpClient.invoke("create", new Object[]{name, classNodeId}, Model.class);
        return model.getNodeId();
    }

    @Override
    public void update(String name, Long classNodeId) throws Throwable {
        jsonRpcHttpClient.invoke("delete", new Object[]{name, classNodeId}, Model.class);
    }

    @Override
    public void delete(Long modelNodeId) throws Throwable {
        jsonRpcHttpClient.invoke("delete", new Object[]{modelNodeId}, Model.class);
    }

    @Autowired
    @Qualifier("jsonRpcHttpClient")
    public void setJsonRpcHttpClient(JsonRpcHttpClient jsonRpcHttpClient) {
        this.jsonRpcHttpClient = jsonRpcHttpClient;
    }
}
