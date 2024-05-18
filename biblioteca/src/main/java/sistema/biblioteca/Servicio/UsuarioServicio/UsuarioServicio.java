package sistema.biblioteca.Servicio.UsuarioServicio;

import sistema.biblioteca.Entidad.Usuario;

public interface UsuarioServicio {
    public String encontrarPorUsername (String nombre_usuario);
    public Usuario encontrarUsuarioPorUsername (String nombre_usuario);
    public Integer nuevoUsuario (String user_name,String password);
}
