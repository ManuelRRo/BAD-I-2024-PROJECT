package sistema.biblioteca.Entidad.ControlPrestamo;

import jakarta.persistence.*;
import sistema.biblioteca.Entidad.Composite.PrestaKey;

import java.util.Date;

@Entity
public class Presta {
    @EmbeddedId
    PrestaKey id;
    @ManyToOne
    @MapsId("id_material")
    @JoinColumn(name = "id_material")
    private BibliotecaMaterial material;

    @ManyToOne
    @MapsId("id_mora")
    @JoinColumn(name = "id_mora")
    private Mora mora;

    @Column(name = "fecha_prestamo")
    private Date fecha_prestamo;
    @Column(name="fecha_retorno")
    private Date fecha_retorno;

    @Column(name = "esta_activo")
    private boolean activo;

}
