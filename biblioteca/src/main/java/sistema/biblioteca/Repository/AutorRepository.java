package sistema.biblioteca.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import sistema.biblioteca.Entity.Autor;

public interface AutorRepository extends JpaRepository<Autor, BigDecimal>, JpaSpecificationExecutor<Autor> {

}