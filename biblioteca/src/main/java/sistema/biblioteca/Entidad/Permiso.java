package sistema.biblioteca.Entidad;

import jakarta.persistence.*;

@Entity
public class Permiso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_permiso;

    @Column(name = "nombre_permiso",nullable = false)
    private String nombre_permiso;
}
