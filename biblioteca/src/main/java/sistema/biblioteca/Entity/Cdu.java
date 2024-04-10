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
@Table(name = "CDU")
public class Cdu {

    @Id
    @Column(name = "ID_CDU", nullable = false)
    private BigDecimal idCdu;

    @Column(name = "CODIGO", nullable = false)
    private BigDecimal codigo;

    public void setIdCdu(BigDecimal idCdu) {
        this.idCdu = idCdu;
    }

    public BigDecimal getIdCdu() {
        return idCdu;
    }

    public void setCodigo(BigDecimal codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "Cdu{" +
                "idCdu=" + idCdu + '\'' +
                "codigo=" + codigo + '\'' +
                '}';
    }
}
