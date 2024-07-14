package med.voll.api.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.medico.DatosActualizarMedico;
import med.voll.api.domain.medico.DatosListadoMedico;
import med.voll.api.domain.medico.DatosRegistroMedico;
import med.voll.api.domain.medico.DatosResponseMedico;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;

import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    public ResponseEntity<DatosResponseMedico> registrarMedico(@RequestBody @Valid DatosRegistroMedico datosRegistroMedico, UriComponentsBuilder uriComponentsBuilder){
        Medico medico = medicoRepository.save(new Medico(datosRegistroMedico));
        DatosResponseMedico datosResponseMedico = new DatosResponseMedico(medico);
        //Return 201 Created
        //Return URL para encontrar al medico
        URI url = uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(url).body(datosResponseMedico);
    } 
    @GetMapping
    public ResponseEntity<Page<DatosListadoMedico>> listadoMedicos(@PageableDefault(size = 2,sort = "nombre") Pageable paginacion){
        return ResponseEntity.ok(medicoRepository.findByActivoTrue(paginacion)
        .map(DatosListadoMedico::new));
    }
    @PutMapping
    @Transactional
    public ResponseEntity<DatosResponseMedico> actualizarMedico(@RequestBody @Valid DatosActualizarMedico datosActualizarMedico){
        Medico medico = medicoRepository.getReferenceById(datosActualizarMedico.id());
        medico.actualizarDatos(datosActualizarMedico);
        return ResponseEntity.ok(new DatosResponseMedico(medico));
    }
    //!Borrar Logico
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteMedico(@PathVariable Long id){
        Medico medico = medicoRepository.getReferenceById(id);
        medico.desactivarMedico();
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<DatosResponseMedico> retornaDatosMedico(@PathVariable Long id){
        
        Medico medico = medicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DatosResponseMedico(medico));
    }
    //! dELETE BASE DE DATOS
    // @DeleteMapping("/{id}")
    // @Transactional
    // public void eliminarMedico(@PathVariable Long id) {
    //     Medico medico = medicoRepository.getReferenceById(id);
    //     medicoRepository.delete(medico);
    // }
    
}
