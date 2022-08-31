
package com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.models.Experiencia;

@Repository
public interface ExperienciaRepository extends JpaRepository<Experiencia, Long>{
    
}
