package com.stackroute.exception;

import com.stackroute.globalExceptionresource.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {
   @ExceptionHandler(value =TrackNotFoundException.class)
   public ResponseEntity<Response> globalExcNotFound(TrackNotFoundException ex)throws Exception {
       Response response = new Response();
       response.setId(HttpStatus.NOT_FOUND.value());
       response.setMessage(ex.getMessage());
       return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
   }
    @ExceptionHandler(value = TrackAlreadyExistsException.class)
    public ResponseEntity<Response> globalExcAlreadyExists(TrackAlreadyExistsException ex)throws Exception{
        Response response=new Response();
        response.setId(HttpStatus.CONFLICT.value());
        response.setMessage(ex.getMessage());
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }
//    @ExceptionHandler(value = Exception.class)
//    public ResponseEntity<Response> globalException(Exception ex){
//        Response response;
//        return new ResponseEntity<>(response,HttpStatus.CONFLICT);
//    }
}
