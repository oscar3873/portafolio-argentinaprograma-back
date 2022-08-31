
package com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.controllers;

import com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.models.Educacion;
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
import com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.services.IEducacionService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("api/educacion")
public class EducacionController {
    @Autowired
    private IEducacionService educacionServ;
    
    @GetMapping("/ver")
    @ResponseBody
    public List<Educacion> verEducacion(){
        return this.educacionServ.verEducacion();
    }
    
    @GetMapping("/ver/{id}")
    @ResponseBody
    public Educacion verEducacionId(@PathVariable(value = "id") Long id){
        return this.educacionServ.buscarEducacion(id);
    }
    
    @PostMapping("/new")
    public void agregarEducacion(@RequestBody Educacion e){
        this.educacionServ.crearEducacion(e);
    }
    
    @PutMapping("/{id}")
    public void actualizarEducacion(@PathVariable(value = "id") Long id,
    @Valid @RequestBody Educacion empModificada){
        educacionServ.borrarEducacion(id);
        empModificada.setId(id);
        this.educacionServ.crearEducacion(empModificada);
        
    }
    
    @DeleteMapping("/delete/{id}")
    public void borrarEducacion(@PathVariable Long id){
        educacionServ.borrarEducacion(id);
    }
}
