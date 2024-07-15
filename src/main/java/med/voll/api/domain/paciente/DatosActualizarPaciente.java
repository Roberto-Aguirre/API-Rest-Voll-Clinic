package med.voll.api.domain.paciente;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.direccion.DatosDireccion;
import med.voll.api.domain.direccion.DatosRegistroDireccion;

public record DatosActualizarPaciente(
        @NotNull
        Long id,
        String nombre,
        String telefono,
        DatosRegistroDireccion direccion) {
}