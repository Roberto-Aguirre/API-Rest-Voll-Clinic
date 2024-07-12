package med.voll.api.models.direccion;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DatosRegistroDireccion(
                @JsonAlias("calle") String calle,
				@JsonAlias("distrito") String distrito, 
				@JsonAlias("ciudad") String ciudad,
				@JsonAlias("numero") String numero,
				@JsonAlias("complemento") String complemento

) {

}
