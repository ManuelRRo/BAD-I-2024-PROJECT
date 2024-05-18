package sistema.biblioteca.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sistema.biblioteca.Entidad.BibliotecaMaterial;
import sistema.biblioteca.Entidad.Usuario;

import java.util.List;
@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario,Long> {
    @Query("SELECT u FROM Usuario u WHERE u.username LIKE concat('%', :searchTerm, '%')")
    List<Usuario> findByUserName(@Param("searchTerm") String searchTerm);

}
