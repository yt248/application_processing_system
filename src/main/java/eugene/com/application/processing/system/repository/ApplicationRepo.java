package eugene.com.application.processing.system.repository;


import eugene.com.application.processing.system.model.Application;
import eugene.com.application.processing.system.model.StatusApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepo extends JpaRepository<Application, Long> {

    @Query("select ap from Application ap where ap.status =:statusApplication")
    List<Application> findApplicationByStatus(@Param("statusApplication") StatusApplication statusApplication);

}
