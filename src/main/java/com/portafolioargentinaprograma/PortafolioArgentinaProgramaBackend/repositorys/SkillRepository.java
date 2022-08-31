
package com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.repositorys;

import com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long>{
    
}
