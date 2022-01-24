package phoenixit.education.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import phoenixit.education.exceptions.ModelNotFoundException;
import phoenixit.education.models.Model;
import phoenixit.education.models.ModelRequest;
import phoenixit.education.models.ModelResponse;

import java.util.List;
import java.util.Optional;

public interface ModelService {

    List<Model> findByName(String name) throws ModelNotFoundException;

    ModelResponse create(ModelRequest modelRequest) throws Throwable;

    ModelResponse update(ModelRequest modelRequest) throws Throwable;

    ModelResponse delete(String id) throws Throwable;

    List<ModelResponse> fetchAll(String field, Sort.Direction direction) throws ModelNotFoundException;

    Page<ModelResponse> fetchAllWithPagination(String field, Sort.Direction direction, int pages, int size);

    ModelResponse fetchById(String id) throws ModelNotFoundException;
}
