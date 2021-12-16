package phoenixit.education.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
public class ModelResponse {

    @Getter @Setter private String id;

    @Getter @Setter private String name;
    @Getter @Setter private String comment;
    @Getter @Setter private Long nodeId;
    @Getter @Setter private Date createAt;
    @Getter @Setter private Date updateAt;
    @Getter @Setter private String creator;
    @Getter @Setter private String updater;
}
