package phoenixit.education.models;

import lombok.*;

import java.util.Date;

@Data
public class ModelResponse {

    @NonNull private String id;
    @NonNull private String name;
    @NonNull private String comment;
    @NonNull private Long nodeId;
    @NonNull private Date createAt;
    @NonNull private Date updateAt;
    @NonNull private String creator;
    @NonNull private String updater;
}
