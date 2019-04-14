package es.cjolalla.catalogingredients.ingrediente.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import es.cjolalla.catalogingredients.ingrediente.Ingrediente;
import es.cjolalla.catalogingredients.ingrediente.IngredienteService;


//Anotacion que equivale a @Controller + @ResponseBody
@RestController
public class IngredienteRestController {
	
	private final IngredienteService ingredienteService;
	
	@Autowired
	public IngredienteRestController(IngredienteService ingredienteService) {
		this.ingredienteService = ingredienteService;
	}
	
	@GetMapping(value= "/ingredientes")
	public List<Ingrediente> findByNombre() {
		return ingredienteService.devolverIngredientesTodos();
	}

	@GetMapping(value= "/ingredientes/{nombre}")
	public Ingrediente findByNombre(@PathVariable("nombre") String nombre) {
		return ingredienteService.devolverIngrediente(nombre);
	}
}
