package trainual.userservice.entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity(name = "review")
public class Review {

    @Id
    @Column(name = "review_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @Column(name = "description")
    private String lastName;

}
