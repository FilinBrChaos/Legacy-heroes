package trainual.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trainual.userservice.model.Feedback;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

    List<Feedback> findByUserId(Long userId);
}
