
package com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.repositorys;


import com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.models.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitutoRepository extends JpaRepository<Educacion, Long>{
    
}
