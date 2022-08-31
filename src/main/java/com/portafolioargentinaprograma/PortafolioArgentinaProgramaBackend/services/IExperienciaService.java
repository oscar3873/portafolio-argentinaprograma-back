
package com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.services;

import com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend.models.Experiencia;
import java.util.List;

public interface IExperienciaService {
    public List<Experiencia> verExperiencia();
    public void crearExperiencia(Experiencia e);
    public void borrarExperiencia(Long id);
    public Experiencia buscarExperiencia(Long id);
    
    
}
