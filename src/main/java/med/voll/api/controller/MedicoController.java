package med.voll.api.controller;

import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.models.medico.DatosListadoMedico;
import med.voll.api.models.medico.DatosRegistroMedico;
import med.voll.api.models.medico.Medico;
import med.voll.api.models.medico.MedicoRepository;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    public void registrarMedico(@RequestBody @Valid DatosRegistroMedico datosRegistroMedico){
        medicoRepository.save(new Medico(datosRegistroMedico));
    }
    @GetMapping
    public Page<DatosListadoMedico> listadoMedicos(@PageableDefault(size = 2,sort = "nombre") Pageable paginacion){
        return medicoRepository.findAll(paginacion)
        .map(DatosListadoMedico::new);
    }
}
