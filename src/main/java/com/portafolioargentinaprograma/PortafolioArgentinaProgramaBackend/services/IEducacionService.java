
package com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.services;

import com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.models.Educacion;
import java.util.List;

public interface IEducacionService {
    public List<Educacion> verEducacion();
    public void crearEducacion(Educacion e);
    public void borrarEducacion(Long id);
    public Educacion buscarEducacion(Long id);
}
