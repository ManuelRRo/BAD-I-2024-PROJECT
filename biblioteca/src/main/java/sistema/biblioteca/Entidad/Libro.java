package sistema.biblioteca.Entidad;

import jakarta.persistence.*;

@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_material;
    @Column(name = "es_obra_referencia",nullable = false)
    private boolean es_obra_referencia;
    @Column(name = "isbn",nullable = false)
    private String isbn;
    @Column(name = "ruta_logo",nullable = false)
    private boolean ruta_logo;

}
