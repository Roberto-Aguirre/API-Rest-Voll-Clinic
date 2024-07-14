package med.voll.api.models.direccion;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Direccion {
    private String calle;
    private String distrito;
    private String ciudad;
    private String numero;
    private String complemento;
    
    public Direccion(DatosRegistroDireccion datosDireccion) {
    this.calle = datosDireccion.calle();
    this.distrito = datosDireccion.distrito();
    this.ciudad = datosDireccion.ciudad();
    this.numero = datosDireccion.numero();
    this.complemento = datosDireccion.complemento();
    }

    public Direccion actualizarDatos(DatosRegistroDireccion direccion) {
        this.calle = direccion.calle();
        this.distrito = direccion.distrito();
        this.ciudad = direccion.ciudad();
        this.numero = direccion.numero();
        this.complemento = direccion.complemento();
        return this;
    }
}
