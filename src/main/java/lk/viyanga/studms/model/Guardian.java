package lk.viyanga.studms.model;

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
    private String guardianName;
    private String guardianContactNumber;
    private String guardianNIC;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId")
    private Student student;

    public Guardian() {
        guardianUUID = UUID.randomUUID().toString();
    }

    public String getGuardianUUID() {
        return guardianUUID;
    }

    public void setGuardianUUID(String guardianUUID) {
        this.guardianUUID = guardianUUID;
    }

    public int getGuardianId() {
        return guardianId;
    }

    public void setGuardianId(int guardianId) {
        this.guardianId = guardianId;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public String getGuardianContactNumber() {
        return guardianContactNumber;
    }

    public void setGuardianContactNumber(String guardianContactNumber) {
        this.guardianContactNumber = guardianContactNumber;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getGuardianNIC() {
        return guardianNIC;
    }

    public void setGuardianNIC(String guardianNIC) {
        this.guardianNIC = guardianNIC;
    }
}
