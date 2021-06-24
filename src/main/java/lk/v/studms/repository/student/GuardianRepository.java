package lk.v.studms.repository.student;

import lk.v.studms.dto.student.GuardianDTO;
import lk.v.studms.model.student.Guardian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * @author - Anuradha Ranasinghe on 2020-07-19
 * @project - stud-ms
 **/
public interface GuardianRepository extends JpaRepository<Guardian, Integer> {

    @Query("SELECT g FROM Guardian g WHERE g.guardianUUID=?1")
    Optional<Guardian> findByUUID(String uuid);

    @Query("SELECT new lk.v.studms.dto.student.GuardianDTO(g.guardianUUID,g.name,g.nic,g.contactNumber,g.email) FROM Guardian g WHERE g.name LIKE %?1%")
    List<GuardianDTO> findByNameLike(String name);

}
