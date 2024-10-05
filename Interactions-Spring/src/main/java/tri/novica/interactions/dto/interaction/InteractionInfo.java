package tri.novica.interactions.dto.interaction;

import lombok.Data;
import tri.novica.interactions.dto.PersonInfo;
import tri.novica.interactions.dto.TagInfo;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class InteractionInfo {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime date;
    private List<PersonInfo> persons;
    private List<TagInfo> tags;

}
