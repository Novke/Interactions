package tri.novica.interactions.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import tri.novica.interactions.exceptions.EntityNotFoundException;

import java.sql.SQLException;
import java.time.LocalDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {EntityNotFoundException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ApiException handleNotFound(Exception ex){
        return new ApiException(ex.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler(value = {SQLException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ApiException handleSQLException(SQLException ex){
        return new ApiException(ex.getMessage(), LocalDateTime.now());
    }

}
