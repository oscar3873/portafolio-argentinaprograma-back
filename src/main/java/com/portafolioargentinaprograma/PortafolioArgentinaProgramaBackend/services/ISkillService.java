
package com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.services;

import com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.models.Skill;
import java.util.List;

public interface ISkillService {
    
    public List<Skill> verSkills();
    public void crearSkill(Skill e);
    public void borrarSkill(Long id);
    public Skill buscarSkill(Long id);
    
}
