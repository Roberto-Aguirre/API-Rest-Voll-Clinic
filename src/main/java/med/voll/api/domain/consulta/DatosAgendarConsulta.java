package med.voll.api.domain.consulta;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;

public record DatosAgendarConsulta(
                Long id,
    @NotBlank Long idPaciente,
    @NotBlank Long idMedico,
    @NotBlank @Future LocalDateTime fecha) {

}
