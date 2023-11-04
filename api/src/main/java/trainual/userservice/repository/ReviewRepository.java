package trainual.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trainual.userservice.model.Review;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByUserId(Long userId);
}
