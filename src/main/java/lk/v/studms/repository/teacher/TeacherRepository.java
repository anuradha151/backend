package lk.v.studms.repository.teacher;

import lk.v.studms.model.teacher.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    @Query("SELECT t FROM Teacher t WHERE t.nic=?1")
    Optional<Teacher> findByNic(String nic);

    @Query("SELECT t FROM Teacher t WHERE t.email=?1")
    Optional<Teacher> findByEmail(String email);


}
