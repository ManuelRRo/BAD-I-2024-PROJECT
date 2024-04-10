package sistema.biblioteca.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import sistema.biblioteca.Entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, BigDecimal>, JpaSpecificationExecutor<Usuario> {

}