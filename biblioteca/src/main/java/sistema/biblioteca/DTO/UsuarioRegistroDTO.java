package sistema.biblioteca.DTO;


public class UsuarioRegistroDTO {

    private Long id_usuario;
    private String nombre_usuario;
    private String username;
    private String correo;
    private String password;

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UsuarioRegistroDTO(Long id_usuario, String nombre_usuario, String username, String correo, String password) {
        super();
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.username = username;
        this.correo = correo;
        this.password = password;
    }

    public UsuarioRegistroDTO(String nombre_usuario, String username, String correo, String password) {
        super();
        this.nombre_usuario = nombre_usuario;
        this.username = username;
        this.correo = correo;
        this.password = password;
    }

    public UsuarioRegistroDTO(String correo) {
        super();
        this.correo = correo;
    }

    public UsuarioRegistroDTO() {
    }
}
