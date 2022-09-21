package fr.polytech.fsback.controller;

import fr.polytech.fsback.dto.ErrorMessageDTO;
import fr.polytech.fsback.execption.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class ExceptionsConfig {

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorMessageDTO internalServerError(Exception ex) {
        ex.printStackTrace();
        return new ErrorMessageDTO("INTERNAL_ERROR", null);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessageDTO internalServerError(MethodArgumentNotValidException ex) {
        ex.printStackTrace();
        return new ErrorMessageDTO("BAD_REQUEST", null);
    }

    @ExceptionHandler(value = NotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessageDTO notFoundError(NotFoundException ex) {
        ex.printStackTrace();
        return new ErrorMessageDTO("NOT_FOUND", ex.getMessage());
    }
}