package phoenixit.education.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ModelRequest {

    private String id;
    private String name;
    private String comment;
    private String type;
    private Long classNodeId;
}
