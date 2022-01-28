package phoenixit.education.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import phoenixit.education.models.Model;

import java.util.List;

@Repository
public class ModelCustomRepositoryImpl implements ModelCustomRepository{

    private MongoTemplate mongoTemplate;

    @Override
    public List<Model> fetchAll(String field, Sort.Direction direction) {
        Query query = new Query();
        query.with(Sort.by(direction, field));
        return mongoTemplate.find(query, Model.class);
    }

    @Override
    public Page<Model> fetchAllWithPagination(String field, Sort.Direction direction, int pages, int size) {
        Pageable pageable = PageRequest.of(pages, size, Sort.by(direction, field));
        Query query = new Query();
        query.with(pageable);
        return new PageImpl<>( mongoTemplate.find(query, Model.class));
    }

    @Autowired
    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
}
