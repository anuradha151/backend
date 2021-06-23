package lk.v.studms.repository.subject;

import lk.v.studms.dto.subject.SubjectDTO;
import lk.v.studms.model.subject.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author - Anuradha Ranasinghe on 2020-09-19
 * @project - stud-ms
 **/
public interface SubjectRepository extends JpaRepository<Subject, Integer> {

    @Query("SELECT new lk.v.studms.dto.subject.SubjectDTO(s.subjectId,s.subject) FROM Subject s")
    List<SubjectDTO> findAllSubjects();
}
