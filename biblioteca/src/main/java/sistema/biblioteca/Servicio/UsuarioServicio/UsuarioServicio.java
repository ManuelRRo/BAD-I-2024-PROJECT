package sistema.biblioteca.Servicio.UsuarioServicio;

import sistema.biblioteca.DTO.UsuarioRegistroDTO;
import sistema.biblioteca.Entidad.Usuario;

public interface UsuarioServicio {
    public Usuario save(UsuarioRegistroDTO registroDTO);

}
