package sistema.biblioteca.Entidad;

import jakarta.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Miembro {
    @Id
    private String carnet;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario",referencedColumnName = "id_usuario")
    private Usuario usuario;
    @OneToMany(mappedBy = "miembro", fetch = FetchType.EAGER)
    private List<Mora> moras = new LinkedList<>();
    @Column(name = "penalizado",nullable = false)
    private boolean penalizado;
}
