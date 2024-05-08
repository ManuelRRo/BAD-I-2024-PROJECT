package sistema.biblioteca.Repositorio;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import sistema.biblioteca.Entidad.Presta;
import sistema.biblioteca.Entidad.Composite.PrestaKey;

@Repository
public interface PrestaRepositorio extends JpaRepository<Presta,PrestaKey> {
  //Sin funciona pero hay que declararlo antes en la base de datos
  @Procedure(procedureName = "registrarPrestamos")
  void registrarPrestamos(@Param("carnet") String carnet, @Param("idMaterialNuevo") Long idMaterialNuevo);
}
