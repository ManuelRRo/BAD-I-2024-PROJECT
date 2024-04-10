package sistema.biblioteca.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import sistema.biblioteca.Entity.Idioma;

public interface IdiomaRepository extends JpaRepository<Idioma, BigDecimal>, JpaSpecificationExecutor<Idioma> {

}