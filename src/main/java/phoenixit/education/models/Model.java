package phoenixit.education.models;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "models")
@Data
public class Model {

    @Id
    private String id;

    private String name;
    private String comment;
    private Long nodeId;
    private Date createAt;
    private Date updateAt;
    private String creator;
    private String updater;

//    public void update(String name, String comment) {
//        this.name = name;
//        this.comment = comment;
//    }
}
