@RestControllerAdvice
public class GlobalExceptionHandler {


@ExceptionHandler(ResourceNotFoundException.class)
public ResponseEntity<String> handleNotFound(ResourceNotFoundException ex) {
return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
}


@ExceptionHandler(ValidationException.class)
public ResponseEntity<String> handleValidation(ValidationException ex) {
return ResponseEntity.badRequest().body(ex.getMessage());
}
}