package lk.v.studms.model.subject;

import lk.v.studms.model.student.Student;

import javax.persistence.*;

/**
 * @author - Anuradha Ranasinghe on 2020-09-19
 * @project - stud-ms
 **/
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"studentId", "batchId"})})
public class StudentBatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentSubjectId;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "studentId")
    private Student student;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "batchId")
    private Batch batch;

    public StudentBatch() {
    }

    public StudentBatch(Student student, Batch batch) {
        this.student = student;
        this.batch = batch;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public int getStudentSubjectId() {
        return studentSubjectId;
    }

    public void setStudentSubjectId(int studentSubjectId) {
        this.studentSubjectId = studentSubjectId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}
