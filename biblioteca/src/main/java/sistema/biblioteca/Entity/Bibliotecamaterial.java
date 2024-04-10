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
@Table(name = "BIBLIOTECAMATERIAL")
public class Bibliotecamaterial {

    @Id
    @Column(name = "ID_MATERIAL_BIBLIOTECA", nullable = false)
    private BigDecimal idMaterialBiblioteca;

    @Column(name = "ID_IDIOMA")
    private BigDecimal idIdioma;

    @Column(name = "ID_AUTOR")
    private BigDecimal idAutor;

    @Column(name = "CANTIDAD")
    private BigDecimal cantidad;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "COSTO_PRESTAMO")
    private BigDecimal costoPrestamo;

    @Column(name = "TITULO")
    private String titulo;

    public void setIdMaterialBiblioteca(BigDecimal idMaterialBiblioteca) {
        this.idMaterialBiblioteca = idMaterialBiblioteca;
    }

    public BigDecimal getIdMaterialBiblioteca() {
        return idMaterialBiblioteca;
    }

    public void setIdIdioma(BigDecimal idIdioma) {
        this.idIdioma = idIdioma;
    }

    public BigDecimal getIdIdioma() {
        return idIdioma;
    }

    public void setIdAutor(BigDecimal idAutor) {
        this.idAutor = idAutor;
    }

    public BigDecimal getIdAutor() {
        return idAutor;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setCostoPrestamo(BigDecimal costoPrestamo) {
        this.costoPrestamo = costoPrestamo;
    }

    public BigDecimal getCostoPrestamo() {
        return costoPrestamo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return "Bibliotecamaterial{" +
                "idMaterialBiblioteca=" + idMaterialBiblioteca + '\'' +
                "idIdioma=" + idIdioma + '\'' +
                "idAutor=" + idAutor + '\'' +
                "cantidad=" + cantidad + '\'' +
                "descripcion=" + descripcion + '\'' +
                "costoPrestamo=" + costoPrestamo + '\'' +
                "titulo=" + titulo + '\'' +
                '}';
    }
}
