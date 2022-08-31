
package com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.controllers;

import com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.models.Experiencia;
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
import com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.services.IExperienciaService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("api/experiencia")
public class ExperienciaController {
    
    @Autowired
    private IExperienciaService experienciaServ;
    
    @GetMapping("/ver")
    @ResponseBody
    public List<Experiencia> verExperiencia(){
        return this.experienciaServ.verExperiencia();
    }
    
    @PostMapping("/new")
    public void agregarExperiencia(@RequestBody Experiencia e){
        this.experienciaServ.crearExperiencia(e);
    }
    
    @PutMapping("/{id}")
    public void actualizarExperiencia(@PathVariable(value = "id") Long id,
    @Valid @RequestBody Experiencia empModificada){
        experienciaServ.borrarExperiencia(id);
        empModificada.setId(id);
        this.experienciaServ.crearExperiencia(empModificada);
        
    }
    
    @DeleteMapping("/delete/{id}")
    public void borrarExperiencia(@PathVariable Long id){
        experienciaServ.borrarExperiencia(id);
    }
}
