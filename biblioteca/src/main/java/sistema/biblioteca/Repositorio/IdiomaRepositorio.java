package sistema.biblioteca.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import sistema.biblioteca.Entidad.Idioma;

public interface IdiomaRepositorio extends JpaRepository<Idioma,Long> {
}
