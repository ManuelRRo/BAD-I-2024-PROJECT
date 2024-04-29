package sistema.biblioteca.Entidad.ControlPrestamo;

import com.vaadin.flow.component.html.Pre;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "BIBLIOTECA_MATERIAL")
public class BibliotecaMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_material_biblioteca;
    @ManyToOne
    @JoinColumn(name = "id_idioma",nullable = true)
    private Idioma idioma;
    @ManyToOne
    @JoinColumn(name = "id_autor",nullable = true)
    private Autor autor;

//    @ManyToMany
//    @JoinTable(
//            //table name
//            name = "Presta",
//            joinColumns = @JoinColumn(name = "id_material"),
//            inverseJoinColumns = @JoinColumn(name = "id_mora")
//    )
    @OneToMany(mappedBy = "material")
    Set<Presta> presta;
    @Column(name = "titulo",nullable = true)
    private String titulo;
    @Column(name = "descripcion",nullable = true)
    private String descripcion;
    @Column(name = "cantidad",nullable = true)
    private int cantidad;

}
