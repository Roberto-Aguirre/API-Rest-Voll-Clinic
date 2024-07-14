package med.voll.api.infra;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class TratadorDeErrores {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErrores(){
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarError400(MethodArgumentNotValidException e){
        var errores = e.getFieldErrors().stream().map(DatosErrorValidacion::new).toList();
        return ResponseEntity.badRequest().body(errores);
    }
    private record DatosErrorValidacion(String campo,String error) {
        public DatosErrorValidacion(FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }
    }
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity tratarErrorDuplicadoSQL(SQLIntegrityConstraintViolationException e){
        return ResponseEntity.badRequest().body(new DatosErrorGuardar(e));
    }
    public record DatosErrorGuardar(int codigoError,String mensaje){
        public DatosErrorGuardar(SQLIntegrityConstraintViolationException error){
            this(error.getErrorCode(),"Campo duplicado al intentar guardar en base de datos");
        }
    }
}
