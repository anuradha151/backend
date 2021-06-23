package lk.v.studms.model;

import javax.persistence.*;
import java.util.UUID;

/**
 * @author - Anuradha Ranasinghe on 2020-07-19
 * @project - stud-ms
 **/
@Entity
public class Guardian {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int guardianId;
    private String guardianUUID;
    private String name;
    private String contactNumber;
    private String nic;
    private String email;


    public Guardian() {
        guardianUUID = UUID.randomUUID().toString();
    }

    public int getGuardianId() {
        return guardianId;
    }

    public void setGuardianId(int guardianId) {
        this.guardianId = guardianId;
    }

    public String getGuardianUUID() {
        return guardianUUID;
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

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
