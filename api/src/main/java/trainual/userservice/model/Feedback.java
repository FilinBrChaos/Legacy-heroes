package trainual.userservice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;


@Data
@Entity(name = "feedback")
@NoArgsConstructor
public class Feedback {

    @Id
    @Column(name = "feedback_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "from_user_id")
    private Integer fromUserId;

    @Column(name = "comment")
    private String comment;

    @Column(name = "badge_id")
    private Long badgeId;

    @Column(name = "reward_points")
    private Integer rewardPoints;

    @Column(name = "create_date", updatable = false)
    @CreationTimestamp
    private Date createDate;
}
