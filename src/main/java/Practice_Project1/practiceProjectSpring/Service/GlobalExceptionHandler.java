package Practice_Project1.practiceProjectSpring.Service;


import Practice_Project1.practiceProjectSpring.DTO.EmployeeErrorResponse;
import Practice_Project1.practiceProjectSpring.Exception.DepartmentNotFoundException;
import Practice_Project1.practiceProjectSpring.DTO.ErrorResponse;
import Practice_Project1.practiceProjectSpring.Exception.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;

//import org.springframework.web.ErrorResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleDepartmentNotFoundException(DepartmentNotFoundException
                                                                        exception)
    {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage(),
                LocalDateTime.now()
        );

    return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(errorResponse);
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<EmployeeErrorResponse> handleEmployeeNotFoundException( EmployeeNotFoundException
                                                                                              exception)
    {
        EmployeeErrorResponse response =new EmployeeErrorResponse(HttpStatus.NOT_FOUND.value(),
                exception.getMessage(),
                LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(response);
    }



}
