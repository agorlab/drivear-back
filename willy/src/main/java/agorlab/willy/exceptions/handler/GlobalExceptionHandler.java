package agorlab.willy.exceptions.handler;

import agorlab.willy.dto.response.ErrorResponseDto;
import agorlab.willy.exceptions.response.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleException(Exception e, HttpServletRequest request) {
        return build(e, HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request) {

        StringBuilder errorMessage = new StringBuilder("Errores de validación: ");
        ex.getBindingResult().getFieldErrors().forEach(e ->
                errorMessage.append(String.format("[%s: %s] ", e.getField(), e.getDefaultMessage()))
        );

        Exception customException = new Exception(errorMessage.toString().trim());

        return build(customException, HttpStatus.BAD_REQUEST, request);
    }


    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorResponseDto> handleBadCredentialsException(BadCredentialsException ex, HttpServletRequest request){
        return build(ex, HttpStatus.UNAUTHORIZED, request);
    }

    @ExceptionHandler(InvalidOperationException.class)
    public ResponseEntity<ErrorResponseDto> handleInvalidOperationException(InvalidOperationException ex, HttpServletRequest request){
        return build(ex, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleResourseNotFoundException(ResourceNotFoundException ex, HttpServletRequest request){
        return build(ex, HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(UnsafeToDeleteException.class)
    public ResponseEntity<ErrorResponseDto> handleUnsafeToDeleteException(UnsafeToDeleteException ex, HttpServletRequest request){
        return build(ex, HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleUserNotFoundException(UserNotFoundException ex, HttpServletRequest request){
        return build(ex, HttpStatus.NOT_FOUND, request);
    }

    private ResponseEntity<ErrorResponseDto> build(Exception ex, HttpStatus status, HttpServletRequest request){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                ex.getMessage(),
                status.value(),
                status.getReasonPhrase(),
                request.getRequestURI()
        );
        return new ResponseEntity<>(errorResponseDto, status);
    }
}