package sistema.biblioteca.Servicio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sistema.biblioteca.Entidad.BibliotecaMaterial;
import sistema.biblioteca.Repositorio.BibliotecaMaterialRepositorio;


import java.util.List;

@Service
public class BiblioMaterialServicioImpl implements BiblioMaterialServicio {

    private static final Logger logger = LoggerFactory.getLogger(BiblioMaterialServicioImpl.class);

    @Autowired
    private BibliotecaMaterialRepositorio repo;

    @Override
    public List<BibliotecaMaterial> ListarTodo() {
        logger.info("Iniciando ListarTodo()");
        List<BibliotecaMaterial> materiales = repo.findAll();
        logger.info("ListarTodo() devolvió {} materiales", materiales.size());
        return materiales;
    }

    @Override
    public BibliotecaMaterial econtrarPorId(Long id) {
        logger.info("Buscando material con ID: {}", id);
        BibliotecaMaterial material = repo.findById(id).orElse(null);
        
        if (material == null) {
            logger.warn("No se encontró ningún material con ID: {}", id);
        } else {
            logger.info("Material encontrado: {}", material);
        }
        return material;
    }
}
