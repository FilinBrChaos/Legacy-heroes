package trainual.userservice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;


@Data
@Entity(name = "review")
@NoArgsConstructor
public class Feedback {

    @Id
    @Column(name = "review_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "from_user_id")
    private Integer fromUserId;

    @Column(name = "comment")
    private String comment;

    @Column(name = "badgeUrl")
    private String badgeUrl;

    @Column(name = "score")
    private Integer score;

    @Column(name = "create_date", updatable = false)
    @CreationTimestamp
    private Date createDate;
}
