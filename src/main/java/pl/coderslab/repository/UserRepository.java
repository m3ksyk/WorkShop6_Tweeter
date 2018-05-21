package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("Select t from Tweet t Join t.user u Where u.id = :id")
    List<Tweet> findAllByUser(Long id);

    User findByPassword(String password);
    User findByEmail(String email);


}
