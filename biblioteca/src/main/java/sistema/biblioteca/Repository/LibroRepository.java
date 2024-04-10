package sistema.biblioteca.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import sistema.biblioteca.Entity.Libro;

public interface LibroRepository extends JpaRepository<Libro, BigDecimal>, JpaSpecificationExecutor<Libro> {

}