package sistema.biblioteca.Entidad;

import jakarta.persistence.*;

@Entity
public class DetalleTransaccionMembresia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_detalle_transaccion_membresia;
    @Column(name = "monto",nullable = false)
    private Float monto;
    @Column(name = "fecha",nullable = false)
    private String fecha;

}
