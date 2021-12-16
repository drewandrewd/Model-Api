package phoenixit.education.services;

import phoenixit.education.exceptions.ModelNotFoundException;
import phoenixit.education.models.Model;
import phoenixit.education.models.ModelRequest;
import phoenixit.education.models.ModelResponse;

import java.util.List;

public interface ModelService {

    /*void create(Model todo);

    void delete(String id);

    Model findById(String id);

    void update(Model todo);*/

    List<Model> findByName(String name) throws ModelNotFoundException;

    ModelResponse create(ModelRequest modelRequest);
}
