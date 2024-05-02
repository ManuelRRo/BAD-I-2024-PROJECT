package sistema.biblioteca.Servicio;

import java.util.List;

import sistema.biblioteca.Entidad.BibliotecaMaterial;

public interface BiblioMaterialServicio {

    public List<BibliotecaMaterial> ListarTodo();
    
    public BibliotecaMaterial econtrarPorId(Long id);
    
}
