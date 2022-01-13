package phoenixit.education.services;

import phoenixit.education.models.ModelResponse;

public interface ModelLinkService {

    Long create(String name, Long classNodeId) throws Throwable;
    void update(String name, Long modelNodeId, Long classNodeId) throws Throwable;
    void delete(Long modelNodeId) throws Throwable;
}
