package eugene.com.application.processing.system.repository;

import eugene.com.application.processing.system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    @Query(value = "select * from users u where u.username = :username", nativeQuery = true)
    User findByUsername(@Param("username") String username);
}
