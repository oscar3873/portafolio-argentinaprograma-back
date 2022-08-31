
package com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.services;

import com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.models.Skill;
import com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.repositorys.SkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService implements ISkillService{
    
    @Autowired
    public SkillRepository skillRepo;
    
    @Override
    public List<Skill> verSkills() {
        return skillRepo.findAll();
    }

    @Override
    public void crearSkill(Skill s) {
        skillRepo.save(s);
    }

    @Override
    public void borrarSkill(Long id) {
        skillRepo.deleteById(id);
    }

    @Override
    public Skill buscarSkill(Long id) {
        return skillRepo.findById(id).orElse(null);
    }
    
}
