package phoenixit.education.repositories;

import org.springframework.data.mongodb.core.MongoOperations;
import phoenixit.education.models.Model;

public interface MongoRepository<M, S> {

    void delete(MongoOperations operation, String id);

    Model findOne(MongoOperations operation, String id);

    void save(MongoOperations operation, Model saved);
}
