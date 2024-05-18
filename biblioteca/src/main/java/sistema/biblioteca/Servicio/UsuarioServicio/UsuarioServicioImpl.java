package sistema.biblioteca.Servicio.UsuarioServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sistema.biblioteca.Entidad.Usuario;
import sistema.biblioteca.Repositorio.UsuarioRepositorio;

import javax.swing.text.html.parser.Entity;
import java.util.List;
@Service
public class UsuarioServicioImpl implements UsuarioServicio{
    private final PasswordEncoder passwordEncoder;
    private final UsuarioRepositorio repo;

    public UsuarioServicioImpl(PasswordEncoder passwordEncoder, UsuarioRepositorio repo) {
        this.passwordEncoder = passwordEncoder;
        this.repo = repo;
    }
    @Override
    public String encontrarPorUsername(String nombre_usuario) {
        List<Usuario> usuarios = repo.findByUserName(nombre_usuario);
        if (!usuarios.isEmpty()) {
            return usuarios.get(0).getUsername();
        } else {
            return null;
        }
    }

    @Override
    public Usuario encontrarUsuarioPorUsername(String nombre_usuario) {
        List<Usuario> usuarios = repo.findByUserName(nombre_usuario);
        if (!usuarios.isEmpty()) {
            return usuarios.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Integer nuevoUsuario (String user_name,String password){
        String codePassword = passwordEncoder.encode(password);
        Usuario nuevoUsuario = new Usuario(
                "Francisco",user_name,"correo@gmail.com",codePassword
        );
        repo.save(nuevoUsuario);
        return 1;
    }
}
