package trainual.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trainual.userservice.model.Badge;
import trainual.userservice.model.Feedback;

import java.util.List;

public interface BadgeRepository extends JpaRepository<Badge, Long> {
}
