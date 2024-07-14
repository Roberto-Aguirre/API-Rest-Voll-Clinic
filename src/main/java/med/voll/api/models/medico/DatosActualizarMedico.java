package med.voll.api.models.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.models.direccion.DatosRegistroDireccion;

public record DatosActualizarMedico(@NotNull Long id,String nombre,String documento,DatosRegistroDireccion direccion) {

}
