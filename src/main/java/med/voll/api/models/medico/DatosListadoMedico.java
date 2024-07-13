package med.voll.api.models.medico;


public record DatosListadoMedico(
    String nombre,
    String email,
    String documentoId,
    String especialidad
) {
    public DatosListadoMedico(Medico medico){
        this(medico.getNombre(),medico.getEspecialidad().toString(),medico.getDocumento(),medico.getEmail());
    }
}
