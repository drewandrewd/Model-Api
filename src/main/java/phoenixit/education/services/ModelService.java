package phoenixit.education.services;

import phoenixit.education.exceptions.ModelNotFoundException;
import phoenixit.education.models.Model;
import phoenixit.education.models.ModelRequest;
import phoenixit.education.models.ModelResponse;

import java.util.List;

public interface ModelService {

    List<Model> findByName(String name) throws ModelNotFoundException;

    ModelResponse create(ModelRequest modelRequest) throws Throwable;

    ModelResponse update(ModelRequest modelRequest) throws Throwable;

    ModelResponse delete(String id) throws Throwable;
}
