package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;

import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
    @Query("Select t from Tweet t where t.title like :title ORDER BY t.created DESC ")
    List<Tweet> findTweetsWithTitleLike(@Param("title") String title);
    @Query("Select t from Tweet t Join t.user u Where u.id = :id")
    List<Tweet> findAllByUser(Long id);
    void deleteAllByUser(User user);
}
