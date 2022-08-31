
package com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.services;

import com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.models.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.repositorys.PersonaRepository;

@Service
public class PersonaService implements IPersonaService{
    @Autowired
    public PersonaRepository PersonaRepo;
    
    @Override
    public List<Persona> verPersona() {
        return PersonaRepo.findAll();
    }

    @Override
    public void crearPersona(Persona p) {
        PersonaRepo.save(p);
    }

    @Override
    public void borrarPersona(Long id) {
        PersonaRepo.deleteById(id);
    }

    @Override
    public Persona buscarPersona(Long id) {
        return PersonaRepo.findById(id).orElse(null);
    }
}
