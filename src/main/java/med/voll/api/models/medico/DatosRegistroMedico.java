package med.voll.api.models.medico;

import com.fasterxml.jackson.annotation.JsonAlias;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.models.direccion.DatosRegistroDireccion;

public record DatosRegistroMedico(
        @NotBlank @JsonAlias("nombre") String nombre,
        @NotBlank @Email @JsonAlias("email") String email,
        @NotBlank @JsonAlias("telefono") String telefono,
        @NotNull @JsonAlias("activo") Boolean activo,
        @NotBlank @Pattern(regexp = "\\d{4,6}") @JsonAlias("documentoId") String documentoId,
        @NotNull @JsonAlias("especialidad") Especialidad especialidad,
        @NotNull @Valid @JsonAlias("direccion") DatosRegistroDireccion datosDireccion) {

}
