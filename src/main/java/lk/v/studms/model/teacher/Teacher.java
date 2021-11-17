package lk.v.studms.model.teacher;

import lk.v.studms.model.DateAudit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Teacher extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int teacherId;
    private String teacherUUID;
    private String name;
    private String nic;
    private String email;
    private String contactNumber;

    public Teacher() {
        teacherUUID = UUID.randomUUID().toString();
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherUUID() {
        return teacherUUID;
    }

    public void setTeacherUUID(String teacherUUID) {
        this.teacherUUID = teacherUUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
