package med.voll.api.domain.consulta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.PacienteRepository;

@Service
public class AgendaDeConsultaService {
    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    public void agendar(DatosAgendarConsulta datosAgendarConsulta) {
        System.out.println(datosAgendarConsulta);
        // System.out.println(datosAgendarConsulta.id());
        var paciente = pacienteRepository.findById(datosAgendarConsulta.idPaciente()).get();
        
        var medico = medicoRepository.findById(datosAgendarConsulta.idMedico()).get();

        var consulta = new Consulta(datosAgendarConsulta, paciente, medico);
        consultaRepository.save(consulta);
    }
}
