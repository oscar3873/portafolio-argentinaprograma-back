
package com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.repositorys;

import com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.models.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Long>{
    
}
