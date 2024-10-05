package tri.novica.interactions.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "interaction")
public class InteractionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private String title;
    private String description;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "interactions")
    private List<PersonEntity> persons;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "interaction_tag",
            joinColumns = @JoinColumn(name = "interaction_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<TagEntity> tags;
}
