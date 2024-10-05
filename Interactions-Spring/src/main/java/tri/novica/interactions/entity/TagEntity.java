package tri.novica.interactions.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tag")
public class TagEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;

}
