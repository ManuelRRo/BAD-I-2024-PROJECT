package sistema.biblioteca.Entidad;

import jakarta.persistence.*;

@Entity
public class Idioma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_idioma;

    @Column(name = "nombre_idioma",nullable = false)
    private String nombre_idioma;

}
