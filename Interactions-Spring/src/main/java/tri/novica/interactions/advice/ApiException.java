package tri.novica.interactions.advice;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ApiException {

    private String reason;
    private LocalDateTime time;

}
