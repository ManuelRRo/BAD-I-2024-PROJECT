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
@Table(name = "MORA")
public class Mora {

    @Id
    @Column(name = "ID_MORA", nullable = false)
    private BigDecimal idMora;

    @Column(name = "CARNET")
    private BigDecimal carnet;

    @Column(name = "MORA_PRESTAMO")
    private BigDecimal moraPrestamo;

    @Column(name = "COSTO_PRESTAMO")
    private BigDecimal costoPrestamo;

    public void setIdMora(BigDecimal idMora) {
        this.idMora = idMora;
    }

    public BigDecimal getIdMora() {
        return idMora;
    }

    public void setCarnet(BigDecimal carnet) {
        this.carnet = carnet;
    }

    public BigDecimal getCarnet() {
        return carnet;
    }

    public void setMoraPrestamo(BigDecimal moraPrestamo) {
        this.moraPrestamo = moraPrestamo;
    }

    public BigDecimal getMoraPrestamo() {
        return moraPrestamo;
    }

    public void setCostoPrestamo(BigDecimal costoPrestamo) {
        this.costoPrestamo = costoPrestamo;
    }

    public BigDecimal getCostoPrestamo() {
        return costoPrestamo;
    }

    @Override
    public String toString() {
        return "Mora{" +
                "idMora=" + idMora + '\'' +
                "carnet=" + carnet + '\'' +
                "moraPrestamo=" + moraPrestamo + '\'' +
                "costoPrestamo=" + costoPrestamo + '\'' +
                '}';
    }
}
