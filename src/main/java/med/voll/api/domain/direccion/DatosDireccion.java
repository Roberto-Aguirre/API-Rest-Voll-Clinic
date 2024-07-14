package med.voll.api.domain.direccion;

public record DatosDireccion(
                String calle,
                String distrito,
                String ciudad,
                String numero,
                String complemento) {
        public DatosDireccion(Direccion direccion) {
                this(direccion.getCalle(), direccion.getDistrito(), direccion.getCiudad(), direccion.getNumero(), direccion.getComplemento());
        }
}
