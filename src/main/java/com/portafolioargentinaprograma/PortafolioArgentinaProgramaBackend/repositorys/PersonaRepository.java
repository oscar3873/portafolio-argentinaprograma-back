
package com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.models.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long>{
    
}
