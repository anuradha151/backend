package lk.v.studms.repository.subject;

import lk.v.studms.dto.subject.BatchDTO;
import lk.v.studms.dto.subject.SubjectDTO;
import lk.v.studms.model.subject.StudentBatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author - Anuradha Ranasinghe on 2020-09-19
 * @project - stud-ms
 **/
public interface StudentBatchRepository extends JpaRepository<StudentBatch, Integer> {

    @Query("SELECT new lk.v.studms.dto.subject.BatchDTO(s.batch.batchUUID,s.batch.name) FROM StudentBatch s WHERE s.student.studentId=?1")
    List<BatchDTO> findByStudentId(int studentId);

}
