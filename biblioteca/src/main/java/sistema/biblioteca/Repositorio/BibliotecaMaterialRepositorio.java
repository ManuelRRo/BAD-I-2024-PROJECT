package sistema.biblioteca.Repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sistema.biblioteca.Entidad.BibliotecaMaterial;
import java.util.List;
@Repository
public interface BibliotecaMaterialRepositorio extends JpaRepository<BibliotecaMaterial,Long> {
    @Query("select e from BibliotecaMaterial e " +
    "where lower(e.titulo) like lower(concat('%',:searchTerm,'%'))")// +
    //"or lower(e.apellido) like lower(concat('%',:searchTerm,'%'))")
    List<BibliotecaMaterial> BuscarMaterial(@Param("searchTerm") String searchTerm); 
}
