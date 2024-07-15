package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.consulta.AgendaDeConsultaService;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import med.voll.api.domain.consulta.DatosDetalleConsulta;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/consultas")
public class ConsultaController {
    @Autowired
    private AgendaDeConsultaService consultaService;
    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DatosAgendarConsulta datos){
        var datosConsulta = new DatosDetalleConsulta(datos);
        consultaService.agendar(datos);
        System.out.println(datosConsulta);
        return ResponseEntity.ok(datosConsulta);
    }


}
