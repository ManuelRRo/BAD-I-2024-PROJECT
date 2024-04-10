package sistema.biblioteca.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import sistema.biblioteca.Entity.Bibliotecamaterial;

public interface BibliotecamaterialRepository extends JpaRepository<Bibliotecamaterial, BigDecimal>, JpaSpecificationExecutor<Bibliotecamaterial> {

}