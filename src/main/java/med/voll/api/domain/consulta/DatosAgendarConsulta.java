package med.voll.api.domain.consulta;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Future;

public record DatosAgendarConsulta(
    Long id,
    Long idPaciente,
    Long idMedico,
    @Future LocalDateTime fecha) {
}
