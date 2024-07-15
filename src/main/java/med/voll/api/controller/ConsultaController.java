package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import med.voll.api.domain.consulta.DatosDetalleConsulta;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/pacientes")
public class ConsultaController {
    @Autowired
    private ConsultaRepository consultaRepository;
    @PostMapping("path")
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DatosAgendarConsulta datos){
        System.out.println(datos);
        return ResponseEntity.ok(new DatosDetalleConsulta(datos));
    }


}
