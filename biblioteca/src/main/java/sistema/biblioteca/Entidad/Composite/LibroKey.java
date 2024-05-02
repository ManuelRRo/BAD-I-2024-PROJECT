package sistema.biblioteca.Entidad.Composite;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class LibroKey implements Serializable {
    @Column(name="id_material")
    private Long id_material;
}
