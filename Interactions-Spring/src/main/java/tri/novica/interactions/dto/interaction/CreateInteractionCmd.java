package tri.novica.interactions.dto.interaction;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CreateInteractionCmd {

    private String title;
    private String description;
    private LocalDateTime date = LocalDateTime.now();
    private List<CreatePersonCascade> persons;
    private List<CreateTagCascade> tags;

}
