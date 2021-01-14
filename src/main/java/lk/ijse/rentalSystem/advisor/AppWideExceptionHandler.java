package lk.ijse.rentalSystem.advisor;

import lk.ijse.rentalSystem.util.StandardRespond;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity exceptionHandler(RuntimeException ex){
        StandardRespond respond = new StandardRespond(500, "Error", ex.getMessage());
        return new ResponseEntity(respond, HttpStatus.OK);
    }
}
