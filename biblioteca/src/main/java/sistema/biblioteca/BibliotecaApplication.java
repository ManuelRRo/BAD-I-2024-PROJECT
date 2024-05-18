package sistema.biblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import sistema.biblioteca.Entidad.Autor;
import sistema.biblioteca.Entidad.BibliotecaMaterial;
import sistema.biblioteca.Entidad.Idioma;
import sistema.biblioteca.Entidad.Usuario;
import sistema.biblioteca.Repositorio.*;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import sistema.biblioteca.Servicio.BiblioMaterialServicio;
import sistema.biblioteca.Servicio.Miembro.MiembroServicio;
import sistema.biblioteca.Servicio.UsuarioServicio.UsuarioServicio;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class)
public class BibliotecaApplication implements CommandLineRunner{

	public static void main(String[] args) {

		SpringApplication.run(BibliotecaApplication.class, args);
	}
	@Autowired	
	IdiomaRepositorio idiomaRepositorio ;
	@Autowired	
	AutorRepositorio autorRepositorio ;
	@Autowired	
	BibliotecaMaterialRepositorio bmRepositorio ;
	@Autowired
    private PrestaRepositorio prestamoRepository;

	@Autowired
	private UsuarioServicio userService;

	@Autowired
	private MiembroServicio miembroServicio;

	@Autowired
	private BiblioMaterialServicio biblioMaterialServicio;

	@Transactional
    public void registrarPrestamos() {
        prestamoRepository.registrarPrestamos("FF20001", 4L); // Llama al procedimiento con el carnet 'DD23001' y el id_material_nuevo 2
    }

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		// Idioma idiom1 = new Idioma("Espanol");
		// idiomaRepositorio.save(idiom1);
		// Autor autor1 = new Autor("Neruda");
		// autorRepositorio.save(autor1);
		// BibliotecaMaterial bm1 = new BibliotecaMaterial(idiom1,autor1,"Movie 1","The best movie",3);
		// bmRepositorio.save(bm1);
		//registrarPrestamos();
		//userService.nuevoUsuario("franito","wachito2");
		//userService.nuevoUsuario("manrik","wachito3");
//		String usuarios;
//		usuarios = userService.encontrarPorUsername("marita");
//		System.out.println(usuarios);
//
//		System.out.println("Username de FreanitL: "+miembroServicio.econtrarCarnetPorUsername("franito"));
//		List<Object> lista = new ArrayList<>();
		//bmRepositorio.listaDeLibrosPorAutor("Thomas",lista);
		List<BibliotecaMaterial> listMaterial= biblioMaterialServicio.ListarPorAutor("Pedro");
		try{
			for (BibliotecaMaterial obj: listMaterial){
				System.out.println("Titulo: "+obj.getTitulo());
				System.out.println("Descripcion: "+obj.getDescripcion());
				System.out.println("Autor: "+obj.getAutor().getNombre_autor());
			}
		}catch (NullPointerException e){
			System.out.println("Lista Vacia");
		}

	}
    

}
