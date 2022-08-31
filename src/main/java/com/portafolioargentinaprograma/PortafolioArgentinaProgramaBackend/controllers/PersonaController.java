
package com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.controllers;

import com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.models.Persona;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.services.IPersonaService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("api/persona")
public class PersonaController {
    @Autowired
    private IPersonaService experienciaServ;
    
    @GetMapping("/ver")
    @ResponseBody
    public List<Persona> verExperiencia(){
        return this.experienciaServ.verPersona();
    }
    
    @PostMapping("/new")
    public void agregarExperiencia(@RequestBody Persona p){
        this.experienciaServ.crearPersona(p);
    }
    
    @PutMapping("/{id}")
    public void actualizarExperiencia(@PathVariable(value = "id") Long id,
    @Valid @RequestBody Persona empModificada){
        experienciaServ.borrarPersona(id);
        empModificada.setId(id);
        this.experienciaServ.crearPersona(empModificada);
        
    }
    
    @DeleteMapping("/delete/{id}")
    public void borrarExperiencia(@PathVariable Long id){
        experienciaServ.borrarPersona(id);
    }
}
