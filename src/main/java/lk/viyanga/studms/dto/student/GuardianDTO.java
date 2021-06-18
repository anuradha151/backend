package lk.viyanga.studms.dto.student;

/**
 * @author - Anuradha Ranasinghe on 2020-09-19
 * @project - stud-ms
 **/
public class GuardianDTO {

    private String guardianUUID;
    private String guardianName;
    private String guardianNIC;
    private String guardianContactNumber;

    @Override
    public String toString() {
        return "GuardianDTO{" +
                "guardianUUID='" + guardianUUID + '\'' +
                ", guardianName='" + guardianName + '\'' +
                ", guardianNIC='" + guardianNIC + '\'' +
                ", guardianContactNumber='" + guardianContactNumber + '\'' +
                '}';
    }

    public String getGuardianUUID() {
        return guardianUUID;
    }

    public void setGuardianUUID(String guardianUUID) {
        this.guardianUUID = guardianUUID;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public String getGuardianNIC() {
        return guardianNIC;
    }

    public void setGuardianNIC(String guardianNIC) {
        this.guardianNIC = guardianNIC;
    }

    public String getGuardianContactNumber() {
        return guardianContactNumber;
    }

    public void setGuardianContactNumber(String guardianContactNumber) {
        this.guardianContactNumber = guardianContactNumber;
    }
}
