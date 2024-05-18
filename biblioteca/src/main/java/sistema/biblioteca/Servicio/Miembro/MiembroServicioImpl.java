package sistema.biblioteca.Servicio.Miembro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sistema.biblioteca.Repositorio.MiembroRepositorio;

@Service
public class MiembroServicioImpl implements MiembroServicio{
    @Autowired
    private MiembroRepositorio repo;
    @Override
    public String econtrarCarnetPorUsername(String username) {
        return repo.findCarnetByUsername(username);
    }
}
