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
@Table(name = "DETALLEPRESTAMO")
public class Detalleprestamo {

    @Id
    @Column(name = "ID_MORA", nullable = false)
    private BigDecimal idMora;

    @Id
    @Column(name = "ID_MATERIAL_BIBLIOTECA", nullable = false)
    private BigDecimal idMaterialBiblioteca;

    @Column(name = "FECHA_PRESTAMO", nullable = false)
    private String fechaPrestamo;

    @Column(name = "FECHA_RETORNO", nullable = false)
    private String fechaRetorno;

    @Column(name = "ESTA_ACTIVO", nullable = false)
    private BigDecimal estaActivo;

    public void setIdMora(BigDecimal idMora) {
        this.idMora = idMora;
    }

    public BigDecimal getIdMora() {
        return idMora;
    }

    public void setIdMaterialBiblioteca(BigDecimal idMaterialBiblioteca) {
        this.idMaterialBiblioteca = idMaterialBiblioteca;
    }

    public BigDecimal getIdMaterialBiblioteca() {
        return idMaterialBiblioteca;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaRetorno(String fechaRetorno) {
        this.fechaRetorno = fechaRetorno;
    }

    public String getFechaRetorno() {
        return fechaRetorno;
    }

    public void setEstaActivo(BigDecimal estaActivo) {
        this.estaActivo = estaActivo;
    }

    public BigDecimal getEstaActivo() {
        return estaActivo;
    }

    @Override
    public String toString() {
        return "Detalleprestamo{" +
                "idMora=" + idMora + '\'' +
                "idMaterialBiblioteca=" + idMaterialBiblioteca + '\'' +
                "fechaPrestamo=" + fechaPrestamo + '\'' +
                "fechaRetorno=" + fechaRetorno + '\'' +
                "estaActivo=" + estaActivo + '\'' +
                '}';
    }
}
