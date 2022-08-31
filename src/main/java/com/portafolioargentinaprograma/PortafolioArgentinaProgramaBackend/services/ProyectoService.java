
package com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.services;

import com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.models.Proyecto;
import com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.repositorys.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectoService{
    
    @Autowired
    public ProyectoRepository proyectoRepo;
    
    @Override
    public List<Proyecto> verProyectos() {
        return proyectoRepo.findAll();
    }

    @Override
    public void crearProyecto(Proyecto e) {
        proyectoRepo.save(e);
    }

    @Override
    public void borrarProyecto(Long id) {
        proyectoRepo.deleteById(id);
    }

    @Override
    public Proyecto buscarProyecto(Long id) {
        return proyectoRepo.findById(id).orElse(null);
    }
}
