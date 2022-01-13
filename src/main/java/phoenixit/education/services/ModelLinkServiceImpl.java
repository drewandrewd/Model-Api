package phoenixit.education.services;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import phoenixit.education.models.Model;
import phoenixit.education.models.ModelLinkMessage;

@Service
public class ModelLinkServiceImpl implements ModelLinkService {

    private JsonRpcHttpClient jsonRpcHttpClient;

    @Override
    public Long create(String name, Long classNodeId) throws Throwable {
        ModelLinkMessage model = jsonRpcHttpClient.invoke("create", new Object[]{name, classNodeId}, ModelLinkMessage.class);
        return model.getModelNodeId();
    }

    @Override
    public void update(String name, Long classNodeId) throws Throwable {
        jsonRpcHttpClient.invoke("update", new Object[]{name, classNodeId}, ModelLinkMessage.class);
    }

    @Override
    public void delete(Long modelNodeId) throws Throwable {
        jsonRpcHttpClient.invoke("delete", new Object[]{modelNodeId}, ModelLinkMessage.class);
    }

    @Autowired
    @Qualifier("jsonRpcHttpClient")
    public void setJsonRpcHttpClient(JsonRpcHttpClient jsonRpcHttpClient) {
        this.jsonRpcHttpClient = jsonRpcHttpClient;
    }
}
