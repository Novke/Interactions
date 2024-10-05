package tri.novica.interactions.dto;

import lombok.Data;

@Data
public class CreatePersonCmd {
    private String name;
    private String lastname;
    private String description;
}
