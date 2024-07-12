package med.voll.api.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @PostMapping
    public void registrarMedico(@RequestBody String parametro){
        System.out.println("El request llega correctamente");
        System.out.println(parametro);
    }
}
