
package com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.controllers;

import com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.models.Proyecto;
import com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.services.IProyectoService;
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

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("api/proyecto")
public class ProyectoController {
    @Autowired
    private IProyectoService proyectoServ;
    
    @GetMapping("/ver")
    @ResponseBody
    public List<Proyecto> verProyectos(){
        return this.proyectoServ.verProyectos();
    }
    
    @PostMapping("/new")
    public void agregarProyecto(@RequestBody Proyecto e){
        this.proyectoServ.crearProyecto(e);
    }
    
    @PutMapping("/{id}")
    public void actualizarProyecto(@PathVariable(value = "id") Long id,
    @Valid @RequestBody Proyecto empModificada){
        proyectoServ.borrarProyecto(id);
        empModificada.setId(id);
        this.proyectoServ.crearProyecto(empModificada);
        
    }
    
    @DeleteMapping("/delete/{id}")
    public void borrarProyecto(@PathVariable Long id){
        proyectoServ.borrarProyecto(id);
    }
}
