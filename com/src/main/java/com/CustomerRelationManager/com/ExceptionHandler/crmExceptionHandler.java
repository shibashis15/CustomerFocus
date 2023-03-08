package com.CustomerRelationManager.com.ExceptionHandler;
import com.CustomerRelationManager.com.util.CustomerExistsException;
import com.CustomerRelationManager.com.util.CustomerNotFoundException;
import com.CustomerRelationManager.com.util.ErrorResponse;
import com.CustomerRelationManager.com.util.OrderNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
@ControllerAdvice
public class crmExceptionHandler {
    @ExceptionHandler(value = {CustomerNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleCustomerNotFoundException(CustomerNotFoundException customerNotFoundException) {
        ErrorResponse errorResponse = new ErrorResponse(customerNotFoundException.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now());
        return new ResponseEntity<ErrorResponse>(errorResponse , HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = {OrderNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleOrderNotFoundException(OrderNotFoundException orderNotFoundException) {
        ErrorResponse errorResponse = new ErrorResponse(orderNotFoundException.getMessage() , HttpStatus.NOT_FOUND , LocalDateTime.now());
        return new ResponseEntity<>(errorResponse , HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = {CustomerExistsException.class})
    public ResponseEntity<ErrorResponse> handleCustomerExistsException(CustomerExistsException customerExistsException) {
        ErrorResponse errorResponse = new ErrorResponse("Customer Already Exists" , HttpStatus.BAD_REQUEST , LocalDateTime.now());
        return new ResponseEntity<>(errorResponse , HttpStatus.BAD_REQUEST);
    }
}
