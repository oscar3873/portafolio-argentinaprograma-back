
package com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.controllers;

import com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.models.Skill;
import com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.services.ISkillService;
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
@CrossOrigin(origins = {"*"}, methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("api/skill")
public class SkillController {
    
    @Autowired
    private ISkillService skillServ;
    
    @GetMapping("/ver")
    @ResponseBody
    public List<Skill> verSkills(){
        return this.skillServ.verSkills();
    }
    
    @PostMapping("/new")
    public void agregarSkill(@RequestBody Skill e){
        this.skillServ.crearSkill(e);
    }
    
    @PutMapping("/{id}")
    public void actualizarSkill(@PathVariable(value = "id") Long id,
    @Valid @RequestBody Skill empModificada){
        skillServ.borrarSkill(id);
        empModificada.setId(id);
        this.skillServ.crearSkill(empModificada);
        
    }
    
    @DeleteMapping("/delete/{id}")
    public void borrarSkill(@PathVariable Long id){
        skillServ.borrarSkill(id);
    }
}