package med.voll.api.domain.medico;

import med.voll.api.domain.direccion.DatosDireccion;

public record DatosResponseMedico(
    Long id, String nombre, String email, String telefono,String documento,DatosDireccion direccion
) {

    public DatosResponseMedico(Medico medico) {
        this(medico.getId(),medico.getNombre(),medico.getEmail(),medico.getTelefono(),medico.getDocumento(),new DatosDireccion(medico.getDatosDireccion()));
    }
}