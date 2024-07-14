package med.voll.api.domain.direccion;

import com.fasterxml.jackson.annotation.JsonAlias;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroDireccion(
		@NotBlank @JsonAlias("calle") String calle,
		@NotBlank @JsonAlias("distrito") String distrito,
		@NotBlank @JsonAlias("ciudad") String ciudad,
		@NotBlank @JsonAlias("numero") String numero,
		
		@NotBlank @JsonAlias("complemento") String complemento

) {

}
