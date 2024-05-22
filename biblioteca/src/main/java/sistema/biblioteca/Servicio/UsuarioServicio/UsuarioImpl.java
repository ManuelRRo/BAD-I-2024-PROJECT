package sistema.biblioteca.Servicio.UsuarioServicio;

import org.springframework.stereotype.Service;
import sistema.biblioteca.DTO.UsuarioRegistroDTO;
import sistema.biblioteca.Entidad.Rol;
import sistema.biblioteca.Entidad.Usuario;
import sistema.biblioteca.Repositorio.UsuarioRepositorio;

import java.util.Arrays;

@Service
public class UsuarioImpl implements UsuarioServicio {

    private UsuarioRepositorio usuarioRepositorio;

    public UsuarioImpl(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @Override
    public Usuario save(UsuarioRegistroDTO registroDTO) {
        Usuario usuario = new Usuario(registroDTO.getNombre_usuario(),
                registroDTO.getUsername(),
                registroDTO.getCorreo(), registroDTO.getPassword(),
                Arrays.asList(new Rol("ROLE_USER")));
        return usuarioRepositorio.save(usuario);
    }
}
