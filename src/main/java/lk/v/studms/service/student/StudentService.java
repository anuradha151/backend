package lk.v.studms.service.student;

import lk.v.studms.dto.student.GuardianDTO;
import lk.v.studms.dto.student.StudentDTO;

import java.util.List;

public interface StudentService {

    void saveStudent(StudentDTO studentDTO);

    void updateStudent(StudentDTO studentDTO);

    StudentDTO findByStudentUUID(String studentUUID);

    List<StudentDTO> findAll();

    List<StudentDTO> findByStudentName(String name);

    List<StudentDTO> findByStudentNic(String nic);

    List<GuardianDTO> findByGuardianName(String query);
}
