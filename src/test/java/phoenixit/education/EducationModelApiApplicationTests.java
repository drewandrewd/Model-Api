package phoenixit.education;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;
import phoenixit.education.models.ModelRequest;
import phoenixit.education.services.ModelService;

@Slf4j
@SpringBootTest
class EducationModelApiApplicationTests {
    private ModelService modelService;

    @Test
    void contextLoads() {
    }

    @Test
    void createTest() {
        ModelRequest modelRequest = new ModelRequest();
        modelRequest.setName("Andrew2");
        modelRequest.setComment("comment");
        log.info("Response: " + modelService.create(modelRequest));
    }

    @Autowired
    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }
}
