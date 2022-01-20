package phoenixit.education.models;


import lombok.Getter;

public enum ModelType {

    Electronic("Electronic"),
    Paper("Paper");

    ModelType(String type) {
        this.type = type;
    }

    @Getter private String type;

    public static ModelType convertToEnum(String line) {
        ModelType result = null;
        for (ModelType type : ModelType.values()) {
            if (type.getType().equals(line)) {
                result = type;
                break;
            }
        }
        return result;
    }
}
