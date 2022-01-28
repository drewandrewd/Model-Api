package phoenixit.education.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import phoenixit.education.models.Model;

import java.util.List;


public interface ModelCustomRepository {

    List<Model> fetchAll(String field, Sort.Direction direction);
    Page<Model> fetchAllWithPagination(String field, Sort.Direction direction, int pages, int size);
}
