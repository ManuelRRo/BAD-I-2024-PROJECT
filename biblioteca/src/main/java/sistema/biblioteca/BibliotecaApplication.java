package sistema.biblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sistema.biblioteca.Entidad.Autor;
import sistema.biblioteca.Entidad.BibliotecaMaterial;
import sistema.biblioteca.Entidad.Idioma;
import sistema.biblioteca.Repositorio.AutorRepositorio;
import sistema.biblioteca.Repositorio.BibliotecaMaterialRepositorio;
import sistema.biblioteca.Repositorio.IdiomaRepositorio;
import sistema.biblioteca.Repositorio.PrestaRepositorio;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
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

	@Transactional
    public void registrarPrestamos() {
        prestamoRepository.registrarPrestamos("DD23001", 4L); // Llama al procedimiento con el carnet 'DD23001' y el id_material_nuevo 2
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
	}
    

}
