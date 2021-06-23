package lk.v.studms.repository.student;

import lk.v.studms.model.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * @author - Anuradha Ranasinghe on 2020-07-19
 * @project - stud-ms
 **/
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("SELECT s FROM Student s WHERE s.studentUUID=?1")
    Optional<Student> findByUUID(String studentUUID);

    @Query("SELECT s FROM Student s WHERE s.name LIKE %?1%")
    List<Student> findByName(String name);

    @Query("SELECT s FROM Student s WHERE s.nic LIKE %?1%")
    List<Student> findByNicLike(String nic);

    @Query("SELECT s FROM Student s WHERE s.nic=?1")
    Optional<Student> findByNic(String nic);

}
