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
@Table(name = "LIBRO")
public class Libro {

    @Id
    @Column(name = "ID_MATERIAL_BIBLIOTECA", nullable = false)
    private BigDecimal idMaterialBiblioteca;

    @Column(name = "ES_OBRA_DE_REFERENCIA", nullable = false)
    private BigDecimal esObraDeReferencia;

    @Column(name = "ISBN", nullable = false)
    private String isbn;

    @Column(name = "LOGO")
    private String logo;

    public void setIdMaterialBiblioteca(BigDecimal idMaterialBiblioteca) {
        this.idMaterialBiblioteca = idMaterialBiblioteca;
    }

    public BigDecimal getIdMaterialBiblioteca() {
        return idMaterialBiblioteca;
    }

    public void setEsObraDeReferencia(BigDecimal esObraDeReferencia) {
        this.esObraDeReferencia = esObraDeReferencia;
    }

    public BigDecimal getEsObraDeReferencia() {
        return esObraDeReferencia;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getLogo() {
        return logo;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "idMaterialBiblioteca=" + idMaterialBiblioteca + '\'' +
                "esObraDeReferencia=" + esObraDeReferencia + '\'' +
                "isbn=" + isbn + '\'' +
                "logo=" + logo + '\'' +
                '}';
    }
}
