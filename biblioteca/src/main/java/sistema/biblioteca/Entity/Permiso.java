package sistema.biblioteca.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

/**
 * $table.getTableComment()
 */
@Entity
@Table(name = "PERMISO")
public class Permiso {

    @Id
    @Column(name = "ID_PERMISO", nullable = false)
    private BigDecimal idPermiso;

    @Column(name = "NOMBRE_PERMISO", nullable = false)
    private String nombrePermiso;

    public void setIdPermiso(BigDecimal idPermiso) {
        this.idPermiso = idPermiso;
    }

    public BigDecimal getIdPermiso() {
        return idPermiso;
    }

    public void setNombrePermiso(String nombrePermiso) {
        this.nombrePermiso = nombrePermiso;
    }

    public String getNombrePermiso() {
        return nombrePermiso;
    }

    @Override
    public String toString() {
        return "Permiso{" +
                "idPermiso=" + idPermiso + '\'' +
                "nombrePermiso=" + nombrePermiso + '\'' +
                '}';
    }
}
