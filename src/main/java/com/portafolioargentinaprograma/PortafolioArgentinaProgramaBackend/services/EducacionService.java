
package com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.services;

import com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.models.Educacion;
import com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.repositorys.InstitutoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService{

    @Autowired
    public InstitutoRepository institutoRepo;
    
    @Override
    public List<Educacion> verEducacion() {
        return institutoRepo.findAll();
    }

    @Override
        public void crearEducacion(Educacion e) {
        institutoRepo.save(e);
    }

    @Override
    public void borrarEducacion(Long id) {
        institutoRepo.deleteById(id);
    }

    @Override
    public Educacion buscarEducacion(Long id) {
        return institutoRepo.findById(id).orElse(null);
    }

    
}
