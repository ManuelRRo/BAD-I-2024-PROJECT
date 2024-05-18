package sistema.biblioteca.Servicio;

import java.util.List;

import sistema.biblioteca.Entidad.BibliotecaMaterial;

public interface BiblioMaterialServicio {

    public List<BibliotecaMaterial> ListarTodo();
    public List<BibliotecaMaterial> ListarPorAutor(String nombreAutor);
    public List<BibliotecaMaterial> ListarTodo(String stringFilter);
    public BibliotecaMaterial econtrarPorId(Long id);
    
}
