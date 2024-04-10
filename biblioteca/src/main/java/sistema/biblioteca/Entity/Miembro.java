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
@Table(name = "MIEMBRO")
public class Miembro {

    @Id
    @Column(name = "CARNET", nullable = false)
    private BigDecimal carnet;

    @Column(name = "ID_USUARIO")
    private BigDecimal idUsuario;

    @Column(name = "PENALIZADO")
    private BigDecimal penalizado;

    public void setCarnet(BigDecimal carnet) {
        this.carnet = carnet;
    }

    public BigDecimal getCarnet() {
        return carnet;
    }

    public void setIdUsuario(BigDecimal idUsuario) {
        this.idUsuario = idUsuario;
    }

    public BigDecimal getIdUsuario() {
        return idUsuario;
    }

    public void setPenalizado(BigDecimal penalizado) {
        this.penalizado = penalizado;
    }

    public BigDecimal getPenalizado() {
        return penalizado;
    }

    @Override
    public String toString() {
        return "Miembro{" +
                "carnet=" + carnet + '\'' +
                "idUsuario=" + idUsuario + '\'' +
                "penalizado=" + penalizado + '\'' +
                '}';
    }
}
