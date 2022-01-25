package phoenixit.education.services;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import phoenixit.education.exceptions.JsonRpcException;
import phoenixit.education.models.Model;
import phoenixit.education.models.ModelLinkMessage;

import java.lang.reflect.Field;
import java.util.List;

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

    @Override
    public String fetchByClassNodeId(Long classNodeId) throws Throwable {
        try {
            Object object = jsonRpcHttpClient.invoke("fetchByClassNodeId", new Object[]{classNodeId}, Object.class);
            Class<?> cl = object.getClass();
            Field[] fields = cl.getDeclaredFields();
            String title = "";
            for(Field field: fields){
                String fieldName = field.getName();
                if(!field.isAccessible()){
                    field.setAccessible(true);
                }
                Object value = field.get(object);
                if (value.toString().contains("title")) {
                    title = value.toString().replace("title=", "");
                }
            }
            return title;
        } catch (JsonRpcException exception) {
            throw new JsonRpcException();
        }
    }

    @Override
    public Long fetchByModelNodeId(Long modelNodeId) throws Throwable {
        try {
            jsonRpcHttpClient.invoke("fetchByModelNodeId", new Object[]{modelNodeId}, Object.class);
            return modelNodeId;
        } catch (JsonRpcException exception) {
            throw new JsonRpcException();
        }
    }

    @Override
    public List<Long> fetchModelsByClassNodeId(Long classNodeId) throws JsonRpcException {
        try {
            List<Long> list = jsonRpcHttpClient.invoke("fetchModelsByClassNodeId", new Object[]{classNodeId}, List.class);
            return list;
        } catch (Throwable e) {
            throw new JsonRpcException();
        }
    }

    @Autowired
    @Qualifier("jsonRpcHttpClient")
    public void setJsonRpcHttpClient(JsonRpcHttpClient jsonRpcHttpClient) {
        this.jsonRpcHttpClient = jsonRpcHttpClient;
    }
}
