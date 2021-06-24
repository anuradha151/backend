package lk.v.studms.dto.student;

/**
 * @author - Anuradha Ranasinghe on 2020-09-19
 * @project - stud-ms
 **/
public class GuardianDTO {

    private String guardianUUID;
    private String name;
    private String nic;
    private String contactNumber;
    private String email;

    public String getGuardianUUID() {
        return guardianUUID;
    }

    public GuardianDTO() {
    }

    public GuardianDTO(String guardianUUID, String name, String nic, String contactNumber, String email) {
        this.guardianUUID = guardianUUID;
        this.name = name;
        this.nic = nic;
        this.contactNumber = contactNumber;
        this.email = email;
    }

    public void setGuardianUUID(String guardianUUID) {
        this.guardianUUID = guardianUUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
