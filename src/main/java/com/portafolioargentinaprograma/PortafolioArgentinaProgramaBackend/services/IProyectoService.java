
package com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.services;

import com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.models.Proyecto;
import java.util.List;


public interface IProyectoService {
    public List<Proyecto> verProyectos();
    public void crearProyecto(Proyecto e);
    public void borrarProyecto(Long id);
    public Proyecto buscarProyecto(Long id);
}
