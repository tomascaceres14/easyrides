package com.ctd.ProyectoIntegrador;

import com.ctd.ProyectoIntegrador.controller.CategoriaController;
import com.ctd.ProyectoIntegrador.model.Categoria;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CategoriaControllerTests {

	@Autowired
	CategoriaController controller;

	@Test
	@Order(1)
	public void getCategorias(){
		// Verifico que el body de la consulta (donde viene el objeto de tipo Categoria) no sea nulo.
		Assertions.assertNotNull(controller.buscar(1).getBody());
		Assertions.assertNotNull(controller.buscar(2).getBody());
	}

	@Test
	@Order(2)
	public void postCategorias(){
		// Creo una nueva categoria para insertar en base de datos
		Categoria categoria = new Categoria("Bicicleta", "dos ruedas saludables", "urldeprueba.com");

		controller.guardar(categoria);

		// Verifico que se haya guardado correctamente.
		Assertions.assertNotNull(controller.buscar(4).getBody());
	}

	@Test
	@Order(3)
	public void updateOdontologo(){

		// Obtengo instancias actuales de bbdd
		Categoria categoria1 = controller.buscar(1).getBody();
		Categoria categoria2 = controller.buscar(2).getBody();


		// Creo instancias de categorias con atributos que quiero actualizar
		Categoria parcheCategoria1 = new Categoria("Veloces", null, "urlActualizadaDesdeTest.com");
		Categoria parcheCategoria2 = new Categoria("Coches Lujosos", null, null);

		// Actualizo
		controller.actualizar(1, parcheCategoria1);
		controller.actualizar(2, parcheCategoria2);

		// Nuevos
		Categoria newCat1 = controller.buscar(1).getBody();
		Categoria newCat2 = controller.buscar(2).getBody();

		// Verifico que la anterior categoria sea distinta a la actualizada
		Assertions.assertNotEquals(categoria1, newCat1);
		Assertions.assertNotEquals(categoria2, newCat2);

		// Verifico que la segunda categoria haya actualizado solamente el titulo
		Assertions.assertNotEquals(categoria2.getTitulo(), newCat2.getTitulo());
		Assertions.assertEquals(categoria2.getDescripcion(), newCat2.getDescripcion());

	}

	@Test
	@Order(4)
	public void deleteOdontologo(){

		// Obtengo instancias de la base de datos de odontologos creados anteriormente
		Categoria categoria1 = controller.buscar(1).getBody();
		Categoria categoria2 = controller.buscar(2).getBody();

		// Elimino ambas
		controller.eliminar(categoria1.getId());
		controller.eliminar(categoria2.getId());

		// Verifico que se hayan eliminado correctamente
		Assertions.assertNull(controller.buscar(1).getBody());
		Assertions.assertNull(controller.buscar(2).getBody());

	}

}
