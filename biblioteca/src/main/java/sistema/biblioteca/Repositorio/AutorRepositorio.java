package sistema.biblioteca.Repositorio;
import org.springframework.data.jpa.repository.JpaRepository;

import sistema.biblioteca.Entidad.Autor;

public interface AutorRepositorio extends JpaRepository<Autor,Long> {

    
} 
