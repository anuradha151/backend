package lk.v.studms.dto.student;

import lk.v.studms.dto.enums.Gender;
import lk.v.studms.dto.subject.BatchDTO;
import lk.v.studms.dto.subject.SubjectDTO;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

/**
 * @author - Anuradha Ranasinghe on 2020-07-19
 * @project - stud-ms
 **/
public class StudentDTO {

    private String studentUUID;
    private String name;
    private String address;
    private String email;
    private String contactNumber;
    private String nic;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private GuardianDTO guardian;
    private List<String> batchIds;
    private List<BatchDTO> batches;

    public List<BatchDTO> getBatches() {
        return batches;
    }

    public void setBatches(List<BatchDTO> batches) {
        this.batches = batches;
    }

    public String getStudentUUID() {
        return studentUUID;
    }

    public void setStudentUUID(String studentUUID) {
        this.studentUUID = studentUUID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getBatchIds() {
        return batchIds;
    }

    public void setBatchIds(List<String> batchIds) {
        this.batchIds = batchIds;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "studentUUID='" + studentUUID + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", nic='" + nic + '\'' +
                ", gender=" + gender +
                ", guardian=" + guardian +
                ", batchIds=" + batchIds +
                ", batches=" + batches +
                '}';
    }

    public GuardianDTO getGuardian() {
        return guardian;
    }

    public void setGuardian(GuardianDTO guardian) {
        this.guardian = guardian;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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
}
