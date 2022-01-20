package phoenixit.education.services;

import phoenixit.education.exceptions.JsonRpcException;
import phoenixit.education.models.ModelResponse;

import java.util.List;

public interface ModelLinkService {

    Long create(String name, Long classNodeId) throws Throwable;

    void update(String name, Long modelNodeId, Long classNodeId) throws Throwable;

    void delete(Long modelNodeId) throws Throwable;

    boolean fetchByClassNodeId(Long classNodeId) throws Throwable;

    boolean fetchByModelNodeId(Long modelNodeId) throws Throwable;

    List<Long> fetchModelsByClassNodeId(Long lassNodeId) throws JsonRpcException;
}
