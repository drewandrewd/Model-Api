package phoenixit.education.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import phoenixit.education.models.Model;

import java.util.List;

public interface ModelRepository extends MongoRepository<Model, String> {

    List<Model> findByName(String name);


}
