package sistema.biblioteca.Repositorio;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import sistema.biblioteca.Entidad.BibliotecaMaterial;
@Repository
public interface BibliotecaMaterialRepositorio extends JpaRepository<BibliotecaMaterial,Long> {
    
}
