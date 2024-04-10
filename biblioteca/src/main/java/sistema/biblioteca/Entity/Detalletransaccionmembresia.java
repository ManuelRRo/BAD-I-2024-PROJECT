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
@Table(name = "DETALLETRANSACCIONMEMBRESIA")
public class Detalletransaccionmembresia {

    @Id
    @Column(name = "ID_DETALLE", nullable = false)
    private BigDecimal idDetalle;

    @Column(name = "CARNET")
    private BigDecimal carnet;

    @Column(name = "MONTO")
    private BigDecimal monto;

    @Column(name = "FECHA")
    private String fecha;

    public void setIdDetalle(BigDecimal idDetalle) {
        this.idDetalle = idDetalle;
    }

    public BigDecimal getIdDetalle() {
        return idDetalle;
    }

    public void setCarnet(BigDecimal carnet) {
        this.carnet = carnet;
    }

    public BigDecimal getCarnet() {
        return carnet;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "Detalletransaccionmembresia{" +
                "idDetalle=" + idDetalle + '\'' +
                "carnet=" + carnet + '\'' +
                "monto=" + monto + '\'' +
                "fecha=" + fecha + '\'' +
                '}';
    }
}
