package lk.v.studms.dto.subject;

public class BatchDTO {

    private String batchUUID;
    private String name;

    public BatchDTO(String batchUUID, String name) {
        this.batchUUID = batchUUID;
        this.name = name;
    }

    public String getBatchUUID() {
        return batchUUID;
    }

    public void setBatchUUID(String batchUUID) {
        this.batchUUID = batchUUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
