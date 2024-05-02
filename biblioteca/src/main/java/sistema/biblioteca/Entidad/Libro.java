package sistema.biblioteca.Entidad;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import sistema.biblioteca.Entidad.Composite.LibroKey;

@Entity
public class Libro {
    @EmbeddedId
    LibroKey id;

    @ManyToOne
    @MapsId("id_material")
    @JoinColumn(name="id_material")
    private BibliotecaMaterial material;

    @Column(name="es_obra_de_referencia")
    private boolean es_obra_de_referencia;

    @Column(name="ISBN")
    private String isbn;

    @Column(name="logo")
    private String logo;
    
}
