package phoenixit.education.models;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "models")
@Data public class Model {

    @Id
    @NonNull private String id;

    @NonNull private String name;
    @NonNull private String comment;
    @NonNull private Long nodeId;
    @NonNull private Date createAt;
    @NonNull private Date updateAt;
    @NonNull private String creator;
    @NonNull private String updater;

//    public void update(String name, String comment) {
//        this.name = name;
//        this.comment = comment;
//    }
}
