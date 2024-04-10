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
@Table(name = "MATERIAL")
public class Material {

    @Id
    @Column(name = "ID_MAT_MAP", nullable = false)
    private BigDecimal idMatMap;

    @Column(name = "MATERIAL_MAPA_NOMBRE", nullable = false)
    private String materialMapaNombre;

    public void setIdMatMap(BigDecimal idMatMap) {
        this.idMatMap = idMatMap;
    }

    public BigDecimal getIdMatMap() {
        return idMatMap;
    }

    public void setMaterialMapaNombre(String materialMapaNombre) {
        this.materialMapaNombre = materialMapaNombre;
    }

    public String getMaterialMapaNombre() {
        return materialMapaNombre;
    }

    @Override
    public String toString() {
        return "Material{" +
                "idMatMap=" + idMatMap + '\'' +
                "materialMapaNombre=" + materialMapaNombre + '\'' +
                '}';
    }
}
