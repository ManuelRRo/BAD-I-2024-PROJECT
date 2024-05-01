package sistema.biblioteca.Servicio.IdiomaService;

import java.util.List;

import sistema.biblioteca.Entidad.Idioma;

public interface IdiomaServicio {
    public List<Idioma> listarTodosLosIdiomas();

    public List<Idioma> listarTodosLosIdiomas(String stringFilter);

    public Idioma guardarIdioma(Idioma idioma);

    public Idioma obtenerEstudiantePorId(Long id);

    public Idioma actualizarEstudiante(Idioma idioma);

    public void eliminar(Idioma idioma);
}
