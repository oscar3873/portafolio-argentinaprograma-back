package com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.services;

import com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.models.Experiencia;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.repositorys.ExperienciaRepository;

@Service
public class ExperienciaService implements IExperienciaService{

    @Autowired
    public ExperienciaRepository ExperienciaRepo;
    
    @Override
    public List<Experiencia> verExperiencia() {
        return ExperienciaRepo.findAll();
    }

    @Override
    public void crearExperiencia(Experiencia e) {
        ExperienciaRepo.save(e);
    }

    @Override
    public void borrarExperiencia(Long id) {
        ExperienciaRepo.deleteById(id);
    }

    @Override
    public Experiencia buscarExperiencia(Long id) {
        return ExperienciaRepo.findById(id).orElse(null);
    }
    
}
