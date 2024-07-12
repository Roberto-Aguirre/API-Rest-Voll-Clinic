package med.voll.api.models.medico;

import com.fasterxml.jackson.annotation.JsonAlias;

import med.voll.api.models.direccion.DatosRegistroDireccion;

public record DatosRegistroMedico(
    @JsonAlias("nombre")String nombre,
    @JsonAlias("email") String email,
    @JsonAlias("documentoId") String documentoId,
    @JsonAlias("especialidad") Especialidad especialidad,
    @JsonAlias("direccion") DatosRegistroDireccion datosDireccion
) {

}
