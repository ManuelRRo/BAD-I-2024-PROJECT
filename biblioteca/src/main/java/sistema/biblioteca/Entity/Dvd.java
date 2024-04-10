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
@Table(name = "DVD")
public class Dvd {

    @Id
    @Column(name = "ID_MATERIAL_BIBLIOTECA", nullable = false)
    private BigDecimal idMaterialBiblioteca;

    @Column(name = "TIPO")
    private String tipo;

    public void setIdMaterialBiblioteca(BigDecimal idMaterialBiblioteca) {
        this.idMaterialBiblioteca = idMaterialBiblioteca;
    }

    public BigDecimal getIdMaterialBiblioteca() {
        return idMaterialBiblioteca;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Dvd{" +
                "idMaterialBiblioteca=" + idMaterialBiblioteca + '\'' +
                "tipo=" + tipo + '\'' +
                '}';
    }
}
