package sistema.biblioteca.Entidad.Composite;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class PrestaKey implements Serializable {
    @Column(name="id_mora")
    private long id_mora;

    @Column(name = "id_material")
    private long id_material;
}
