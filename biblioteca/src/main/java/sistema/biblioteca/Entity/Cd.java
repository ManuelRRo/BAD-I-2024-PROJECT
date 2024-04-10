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
@Table(name = "CD")
public class Cd {

    @Id
    @Column(name = "ID_MATERIAL_BIBLIOTECA", nullable = false)
    private BigDecimal idMaterialBiblioteca;

    @Column(name = "IFPI")
    private String ifpi;

    public void setIdMaterialBiblioteca(BigDecimal idMaterialBiblioteca) {
        this.idMaterialBiblioteca = idMaterialBiblioteca;
    }

    public BigDecimal getIdMaterialBiblioteca() {
        return idMaterialBiblioteca;
    }

    public void setIfpi(String ifpi) {
        this.ifpi = ifpi;
    }

    public String getIfpi() {
        return ifpi;
    }

    @Override
    public String toString() {
        return "Cd{" +
                "idMaterialBiblioteca=" + idMaterialBiblioteca + '\'' +
                "ifpi=" + ifpi + '\'' +
                '}';
    }
}
