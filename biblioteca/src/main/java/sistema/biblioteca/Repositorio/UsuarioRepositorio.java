package sistema.biblioteca.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sistema.biblioteca.Entidad.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

}
