package ar.com.ada.api.cursos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.com.ada.api.cursos.entities.Categoria;
import ar.com.ada.api.cursos.repos.CategoriaRepository;
import ar.com.ada.api.cursos.services.CategoriaService;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	CategoriaRepository repoCategoria;
	@Autowired
	CategoriaService categoriaService;


	/*@Test
	void crearCategoriaSinCursoTest() {

		Categoria categoria = new Categoria();
		categoria.setNombre("Matematicas");
		categoria.setDescripcion("vemos algebra y trigonometria");

		repoCategoria.save(categoria);
		// CompareTo devuelve -1 si el izq es menor
		// 0 si son iguales
		// 1 si es mayor
		assertTrue(categoria.getCategoriaId().compareTo(0) == 1);

		Integer nuevaCategoriaId = categoria.getCategoriaId();

		Optional<Categoria> catDesdeDBResultado = repoCategoria.findById(nuevaCategoriaId);
		
		assertTrue(catDesdeDBResultado.isPresent());

		Categoria categoriaDesdeDB = catDesdeDBResultado.get();
		assertEquals("Matematicas", categoriaDesdeDB.getNombre());
		assertEquals("vemos algebra", categoriaDesdeDB.getDescripcion());
	}
	*/

	void tituloTestInicio(String titulo) {
		System.out.println("*********");
		System.out.println("*********");
		System.out.println("INICIO TEST:" + titulo);
		System.out.println("*********");
		System.out.println("*********");

	}

	void tituloTestFin(String titulo) {
		System.out.println("*********");
		System.out.println("*********");
		System.out.println("FIN TEST:" + titulo);
		System.out.println("*********");
		System.out.println("*********");

	}


	@Test
	void crearCategoriaATravesDeServiceTest() {

		tituloTestInicio("categoria Sin Curso");
		Categoria categoria = categoriaService.crearCategoria("MAtematica", "vemos Algebra");
		
		repoCategoria.save(categoria);
		// CompareTo devuelve -1 si el izq es menor
		// 0 si son iguales
		// 1 si es mayor
		assertTrue(categoria.getCategoriaId().compareTo(0) == 1);

		Integer nuevaCategoriaId = categoria.getCategoriaId();

		Optional<Categoria> catDesdeDBResultado = repoCategoria.findById(nuevaCategoriaId);
		
		assertTrue(catDesdeDBResultado.isPresent());

		Categoria categoriaDesdeDB = catDesdeDBResultado.get();
		assertEquals("Matematicas", categoriaDesdeDB.getNombre());
		assertEquals("vemos algebra", categoriaDesdeDB.getDescripcion());
	tituloTestFin("Categoria sin curso");
	}

	}


