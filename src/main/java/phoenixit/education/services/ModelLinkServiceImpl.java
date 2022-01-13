package phoenixit.education.services;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import phoenixit.education.exceptions.JsonRpcException;
import phoenixit.education.models.Model;
import phoenixit.education.models.ModelLinkMessage;

@Service
public class ModelLinkServiceImpl implements ModelLinkService {

    private JsonRpcHttpClient jsonRpcHttpClient;

    @Override
    public Long create(String name, Long classNodeId) throws Throwable {
        ModelLinkMessage model = new ModelLinkMessage();
        model.setModelNodeTitle(name);
        model.setClassNodeId(classNodeId);
        try {
            Long modelNodeId = jsonRpcHttpClient.invoke("create", new Object[]{model}, Long.class);
            return modelNodeId;
        } catch (Exception e) {
            throw new JsonRpcException();
        }
    }

    @Override
    public void update(String name, Long modelNodeId, Long classNodeId) throws Throwable {
        ModelLinkMessage model = new ModelLinkMessage();
        model.setModelNodeTitle(name);
        model.setModelNodeId(modelNodeId);
        model.setClassNodeId(classNodeId);
        try {
            jsonRpcHttpClient.invoke("update", new Object[]{model}, ModelLinkMessage.class);
        } catch (Exception e) {
            throw new JsonRpcException();
        }
    }

    @Override
    public void delete(Long modelNodeId) throws Throwable {
        try {
            jsonRpcHttpClient.invoke("modelDelete", new Object[]{modelNodeId}, Long.class);
        } catch (Exception e) {
            throw new JsonRpcException();
        }
    }

    @Autowired
    @Qualifier("jsonRpcHttpClient")
    public void setJsonRpcHttpClient(JsonRpcHttpClient jsonRpcHttpClient) {
        this.jsonRpcHttpClient = jsonRpcHttpClient;
    }
}
