package sistema.biblioteca.Entidad;

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

    public PrestaKey getId() {
        return id;
    }

    public void setId(PrestaKey id) {
        this.id = id;
    }

    public BibliotecaMaterial getMaterial() {
        return material;
    }

    public void setMaterial(BibliotecaMaterial material) {
        this.material = material;
    }

    public Mora getMora() {
        return mora;
    }

    public void setMora(Mora mora) {
        this.mora = mora;
    }

    public Date getFecha_prestamo() {
        return fecha_prestamo;
    }

    public void setFecha_prestamo(Date fecha_prestamo) {
        this.fecha_prestamo = fecha_prestamo;
    }

    public Date getFecha_retorno() {
        return fecha_retorno;
    }

    public void setFecha_retorno(Date fecha_retorno) {
        this.fecha_retorno = fecha_retorno;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

  




}
