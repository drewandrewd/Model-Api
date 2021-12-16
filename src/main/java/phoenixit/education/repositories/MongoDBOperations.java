package phoenixit.education.repositories;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import phoenixit.education.models.Model;

public class MongoDBOperations implements MongoRepository<Model, String> {

    @Override
    public void delete(MongoOperations operation, String id) {
        Query search = new Query(Criteria.where("id").is(id));
        operation.remove(search, Model.class);;
    }

    @Override
    public Model findOne(MongoOperations operation, String id) {
        Query search = new Query(Criteria.where("id").is(id));
        return operation.findOne(search, Model.class);
    }

    @Override
    public void save(MongoOperations operation, Model saved) {
        operation.save(saved);
    }
}
