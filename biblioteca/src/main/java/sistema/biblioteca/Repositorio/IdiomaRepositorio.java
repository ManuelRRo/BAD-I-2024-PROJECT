package sistema.biblioteca.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import sistema.biblioteca.Entidad.Idioma;

public interface IdiomaRepositorio extends JpaRepository<Idioma,Long> {
//    @Query("select e from Estudiante e " +
//            "where lower(e.nombre) like lower(concat('%',:searchTerm,'%')) " +
//            "or lower(e.apellido) like lower(concat('%',:searchTerm,'%'))")
//    List<Idioma> BuscarIdioma(@Param("searchTerm") String searchTerm);
}
