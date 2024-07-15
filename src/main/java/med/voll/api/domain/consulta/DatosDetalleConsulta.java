package med.voll.api.domain.consulta;

import java.time.LocalDateTime;

import jakarta.validation.Valid;

public record DatosDetalleConsulta(
    Long id,
    Long idPaciente,
    Long idDoctor,
    LocalDateTime fecha
) {

    public DatosDetalleConsulta(@Valid DatosAgendarConsulta datos) {
        this(datos.id(),datos.idPaciente(),datos.idMedico(),datos.fecha());
    }

}
