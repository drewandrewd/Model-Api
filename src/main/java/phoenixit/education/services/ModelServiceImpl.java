package phoenixit.education.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phoenixit.education.components.Converter;
import phoenixit.education.exceptions.ModelNotFoundException;
import phoenixit.education.models.Model;
import phoenixit.education.models.ModelRequest;
import phoenixit.education.models.ModelResponse;
import phoenixit.education.repositories.ModelRepository;

import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {

    private ModelRepository modelRepository;
    private Converter converter;
//    private MongoRepository<Model, String> models;
//    private ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
//    private MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");



    @Override
    public List<Model> findByName(String name) throws ModelNotFoundException {
        List<Model> model = modelRepository.findByName("");
        if (!model.isEmpty()) {
            //todo action
        } else {
            //throw exceptions
            throw new ModelNotFoundException();
        }
        return model;
    }

    @Override
    public ModelResponse create(ModelRequest model) {
        return null;
    }

    @Autowired
    public void setModelRepository(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Autowired
    public void setConverter(Converter converter) {
        this.converter = converter;
    }

    /*@Override
    public void create(Model model) {
        models.save(mongoOperation, model);
    }

    @Override
    public void delete(String id) {
        models.delete(mongoOperation, id);
    }

    @Override
    public Model findById(String id) {
        return models.findOne(mongoOperation, id);
    }

    @Override
    public void update(Model model) {
        Model updated = findById(model.getId());
        updated.update(model.getName(), model.getComment());
        models.save(mongoOperation, updated);
    }*/
}
