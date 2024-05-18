package sistema.biblioteca.security.UserDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sistema.biblioteca.Entidad.Usuario;
import sistema.biblioteca.Servicio.UsuarioServicio.UsuarioServicio;

@Service
public class CustomUserDetailService implements UserDetailsService {
    private UsuarioServicio servicio;

    CustomUserDetailService (UsuarioServicio servicio){
        this.servicio = servicio;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = servicio.encontrarUsuarioPorUsername(username);

        if (usuario == null){
            throw new UsernameNotFoundException("Usuario no encontrado con nombre de usuario: " + username);

        }

        return org.springframework.security.core.userdetails.User
                .withUsername(usuario.getUsername())
                .password(usuario.getPassword())
                .roles(usuario.getRol().getNombre_rol()) // Supongamos que tienes un método getRoles en tu entidad User
                .build();
    }
}
