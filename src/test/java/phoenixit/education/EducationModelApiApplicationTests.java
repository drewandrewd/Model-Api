package phoenixit.education;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;
import phoenixit.education.exceptions.ModelNotFoundException;
import phoenixit.education.models.Model;
import phoenixit.education.models.ModelRequest;
import phoenixit.education.repositories.ModelRepository;
import phoenixit.education.services.ModelService;

import java.util.Optional;

@Slf4j
@SpringBootTest
class EducationModelApiApplicationTests {
    private ModelService modelService;
    private ModelRepository repository;

    @Test
    void contextLoads() {
    }

    @Test
    void createTest() {
        ModelRequest modelRequest = new ModelRequest();
        modelRequest.setName("Andrew0000");
        modelRequest.setComment("comment0");
        modelRequest.setType("Paper");
        String id = modelService.create(modelRequest).getId();
        log.info("Response: " + id);
        Optional<Model> model = repository.findById(id);
        log.info("model " + model);
    }

    @Test
    void updateTest() throws ModelNotFoundException {
        ModelRequest modelRequest = new ModelRequest();
        modelRequest.setId("61bc6a2b5b61ce233dfc8611");
        modelRequest.setName("Andrew8");
        modelRequest.setComment("commentOOP");
        modelRequest.setType("Electronic");
        log.info("Response: " + modelService.update(modelRequest));

    }

    @Test
    void deleteTest() throws ModelNotFoundException {
        ModelRequest modelRequest = new ModelRequest();
        modelRequest.setId("61bc6a2b5b61ce233dfc8611");
        modelService.delete(modelRequest);
        //log.info("Delete: " + );
    }

    @Autowired
    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }

    @Autowired
    public void setRepository(ModelRepository repository) {
        this.repository = repository;
    }
}
