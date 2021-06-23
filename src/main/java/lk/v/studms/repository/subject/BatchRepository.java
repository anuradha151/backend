package lk.v.studms.repository.subject;

import lk.v.studms.model.subject.Batch;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BatchRepository {

    @Query("SELECT b FROM Batch b WHERE b.batchUUID=?1")
    Optional<Batch> findByUUID(String studentUUID);

}
