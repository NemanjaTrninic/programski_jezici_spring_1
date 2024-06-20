package rs.ac.singidunum.spring_demo.error;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;

import java.net.http.HttpRequest;

@RestControllerAdvice
@Component

//dan6_cas2
public class ErrorController {

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionModel handleDataIntegrityViolationException(DataIntegrityViolationException e , HttpServletRequest request){
        ExceptionModel model = new ExceptionModel();

        model.setName(e.getClass().getSimpleName());
        model.setMessage("Integritet Poruke je ugrozen");
        model.setPath(request.getServletPath());
        return model;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionModel handleDataIntegrityViolationException(Exception e , HttpServletRequest request){
            ExceptionModel model = new ExceptionModel();
            model.setName(e.getClass().getSimpleName());
            model.setMessage(e.getMessage());
            model.setPath(request.getServletPath());
            return model;
    }
}
