package phoenixit.education;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import phoenixit.education.exceptions.JsonRpcException;
import phoenixit.education.exceptions.ModelNotFoundException;
import phoenixit.education.models.Model;
import phoenixit.education.models.ModelRequest;
import phoenixit.education.models.ModelResponse;
import phoenixit.education.repositories.ModelRepository;
import phoenixit.education.services.ModelLinkService;
import phoenixit.education.services.ModelService;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.Sort.Direction.DESC;

@Slf4j
@SpringBootTest
class EducationModelApiApplicationTests {

    private ModelService modelService;
    private ModelRepository repository;
    private ModelLinkService modelLinkService;

    @Test
    void contextLoads() {
    }
//
//    @Test
//    void createTest() {
//        ModelRequest modelRequest = new ModelRequest();
//        modelRequest.setName("Andrew0000");
//        modelRequest.setComment("comment0");
//        modelRequest.setType("Paper");
//        String id = modelService.create(modelRequest).getId();
//        log.info("Response: " + id);
//        Optional<Model> model = repository.findById(id);
//        log.info("model " + model);
//    }
//
//    @Test
//    void updateTest() throws ModelNotFoundException {
//        ModelRequest modelRequest = new ModelRequest();
//        modelRequest.setId("61bc6a2b5b61ce233dfc8611");
//        modelRequest.setName("Andrew8");
//        modelRequest.setComment("commentOOP");
//        modelRequest.setType("Electronic");
//        log.info("Response: " + modelService.update(modelRequest));
//
//    }
//
//    @Test
//    void deleteTest() throws ModelNotFoundException {
//        ModelRequest modelRequest = new ModelRequest();
//        modelRequest.setId("61bc6a2b5b61ce233dfc8611");
//        modelService.delete(modelRequest);
//        //log.info("Delete: " + );
//    }
//
    @Test
    void fetchAllTest() throws ModelNotFoundException {
        List<ModelResponse> list = modelService.fetchAll("name", DESC);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName());
        }
    }

    @Test
    void fetchAllWithPaginationTest() {
        Page<ModelResponse> listOfModels = modelService.fetchAllWithPagination("name", DESC, 1, 5);
        System.out.println(listOfModels);
    }

//    @Test void fetchByIdTest() {
//        Model model = modelService.fetchById("61e05b1cf1d16059e3f4368c");
//        System.out.println(model.getName());
//    }

    @Test void fetchByClassNodeIdTest() throws Throwable {
        System.out.println(modelLinkService.fetchByClassNodeId(84354L));;
    }

    @Test
    void fetchModelsByClassNodeIdTest() throws JsonRpcException {
        List<Long> list = modelLinkService.fetchModelsByClassNodeId(84354L);
        System.out.println(list);
    }

    @Autowired
    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }

    @Autowired
    public void setRepository(ModelRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setModelLinkService(ModelLinkService modelLinkService) {
        this.modelLinkService = modelLinkService;
    }
}
