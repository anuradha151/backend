package lk.v.studms.repository.student;

import lk.v.studms.model.Guardian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * @author - Anuradha Ranasinghe on 2020-07-19
 * @project - stud-ms
 **/
public interface GuardianRepository extends JpaRepository<Guardian, Integer> {

    @Query("SELECT g FROM Guardian g WHERE g.guardianUUID=?1")
    Optional<Guardian> findByUUID(String uuid);

}
