package med.voll.api.domain.usuarios;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DatosAutenticacionUsuario(
@JsonAlias("login") String login,    
@JsonAlias("clave") String clave
) {

}
