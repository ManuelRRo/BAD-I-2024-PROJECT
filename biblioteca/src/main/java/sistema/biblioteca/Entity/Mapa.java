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
@Table(name = "MAPA")
public class Mapa {

    @Id
    @Column(name = "ID_MATERIAL_BIBLIOTECA", nullable = false)
    private BigDecimal idMaterialBiblioteca;

    @Column(name = "ID_MAT_MAP")
    private BigDecimal idMatMap;

    @Column(name = "ID_TAMANO")
    private BigDecimal idTamano;

    @Column(name = "ID_FORMATO")
    private BigDecimal idFormato;

    @Column(name = "ID_CDU")
    private BigDecimal idCdu;

    public void setIdMaterialBiblioteca(BigDecimal idMaterialBiblioteca) {
        this.idMaterialBiblioteca = idMaterialBiblioteca;
    }

    public BigDecimal getIdMaterialBiblioteca() {
        return idMaterialBiblioteca;
    }

    public void setIdMatMap(BigDecimal idMatMap) {
        this.idMatMap = idMatMap;
    }

    public BigDecimal getIdMatMap() {
        return idMatMap;
    }

    public void setIdTamano(BigDecimal idTamano) {
        this.idTamano = idTamano;
    }

    public BigDecimal getIdTamano() {
        return idTamano;
    }

    public void setIdFormato(BigDecimal idFormato) {
        this.idFormato = idFormato;
    }

    public BigDecimal getIdFormato() {
        return idFormato;
    }

    public void setIdCdu(BigDecimal idCdu) {
        this.idCdu = idCdu;
    }

    public BigDecimal getIdCdu() {
        return idCdu;
    }

    @Override
    public String toString() {
        return "Mapa{" +
                "idMaterialBiblioteca=" + idMaterialBiblioteca + '\'' +
                "idMatMap=" + idMatMap + '\'' +
                "idTamano=" + idTamano + '\'' +
                "idFormato=" + idFormato + '\'' +
                "idCdu=" + idCdu + '\'' +
                '}';
    }
}
