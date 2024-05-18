package sistema.biblioteca.Entidad;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Entity
public class Miembro {
    @Id
    private String carnet;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario",referencedColumnName = "id_usuario")
    private Usuario usuario;

    @OneToMany(mappedBy = "miembro", fetch = FetchType.EAGER)
    private List<Mora> moras = new LinkedList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "materiales_miembros",
               joinColumns = @JoinColumn(name = "carnet_miembro", referencedColumnName = "carnet"),
               inverseJoinColumns = @JoinColumn(name = "material_miembro", referencedColumnName = "id_material_biblioteca"))
    private Set<BibliotecaMaterial> lista_material_biblioteca = new HashSet<>();
    
    @Column(name = "penalizado",nullable = false)
    private boolean penalizado;

    public Miembro() {
    }

    public Miembro(Usuario usuario, List<Mora> moras, Set<BibliotecaMaterial> lista_material_biblioteca, boolean penalizado) {
        this.usuario = usuario;
        this.moras = moras;
        this.lista_material_biblioteca = lista_material_biblioteca;
        this.penalizado = penalizado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Mora> getMoras() {
        return moras;
    }

    public void setMoras(List<Mora> moras) {
        this.moras = moras;
    }

    public Set<BibliotecaMaterial> getLista_material_biblioteca() {
        return lista_material_biblioteca;
    }

    public void setLista_material_biblioteca(Set<BibliotecaMaterial> lista_material_biblioteca) {
        this.lista_material_biblioteca = lista_material_biblioteca;
    }

    public boolean isPenalizado() {
        return penalizado;
    }

    public void setPenalizado(boolean penalizado) {
        this.penalizado = penalizado;
    }
}
