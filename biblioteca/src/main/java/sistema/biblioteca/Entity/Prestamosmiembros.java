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
@Table(name = "PRESTAMOSMIEMBROS")
public class Prestamosmiembros {

    @Id
    @Column(name = "CARNET", nullable = false)
    private BigDecimal carnet;

    @Id
    @Column(name = "ID_MATERIAL_BIBLIOTECA", nullable = false)
    private BigDecimal idMaterialBiblioteca;

    public void setCarnet(BigDecimal carnet) {
        this.carnet = carnet;
    }

    public BigDecimal getCarnet() {
        return carnet;
    }

    public void setIdMaterialBiblioteca(BigDecimal idMaterialBiblioteca) {
        this.idMaterialBiblioteca = idMaterialBiblioteca;
    }

    public BigDecimal getIdMaterialBiblioteca() {
        return idMaterialBiblioteca;
    }

    @Override
    public String toString() {
        return "Prestamosmiembros{" +
                "carnet=" + carnet + '\'' +
                "idMaterialBiblioteca=" + idMaterialBiblioteca + '\'' +
                '}';
    }
}
