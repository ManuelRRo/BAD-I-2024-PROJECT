package sistema.biblioteca.Servicio.IdiomaService;

import org.springframework.stereotype.Service;
import sistema.biblioteca.Entidad.ControlPrestamo.Idioma;
import sistema.biblioteca.Repositorio.IdiomaRepositorio;

import java.util.List;
@Service
public class IdiomaServicioImpl implements  IdiomaServicio{
    private IdiomaRepositorio idiomaRepositorio;
    @Override
    public List<Idioma> listarTodosLosIdiomas() {
        return idiomaRepositorio.findAll();
    }

    @Override
    public List<Idioma> listarTodosLosIdiomas(String stringFilter) {
        if(stringFilter == null || stringFilter.isEmpty()){
            return idiomaRepositorio.findAll();
        }else {
//            return idiomaRepositorio.BuscarIdioma(stringFilter);
            return  idiomaRepositorio.findAll();
        }
    }

    @Override
    public Idioma guardarIdioma(Idioma idioma) {
        return idiomaRepositorio.save(idioma);
    }

    @Override
    public Idioma obtenerEstudiantePorId(Long id) {
        return null;
    }

    @Override
    public Idioma actualizarEstudiante(Idioma idioma) {
        return null;
    }

    @Override
    public void eliminar(Idioma idioma) {

    }
}
