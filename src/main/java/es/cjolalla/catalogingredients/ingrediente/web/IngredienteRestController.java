package es.cjolalla.catalogingredients.ingrediente.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.cjolalla.catalogingredients.ingrediente.Ingrediente;
import es.cjolalla.catalogingredients.ingrediente.IngredienteService;


//Anotacion que equivale a @Controller + @ResponseBody
@RestController
public class IngredienteRestController {
	
	Logger logger = LoggerFactory.getLogger(IngredienteRestController.class);
	
	private final IngredienteService ingredienteService;
	
	@Autowired
	public IngredienteRestController(IngredienteService ingredienteService) {
		this.ingredienteService = ingredienteService;
	}
	
	@GetMapping(value= "/ingredientes")
	@PreAuthorize("hasRole('ADMIN') or hasAuthority('READ_INGREDIENTES')")
	public List<Ingrediente> findByNombre(Authentication authentication) {
		//Para imprimir todos los permisos que tiene (y el perfil que tambien es una granted authority)
		//logger.info(authentication.getAuthorities().stream().map(auth -> auth.getAuthority()).collect(Collectors.joining(", ","{","}")));
		return ingredienteService.devolverIngredientesTodos();
		
	}

	@GetMapping(value= "/ingredientes/{nombre}")
	public Ingrediente findByNombre(@PathVariable("nombre") String nombre) {
		return ingredienteService.devolverIngrediente(nombre);
	}
	
	@PostMapping(value="/ingredientes")
	public Long incluirIngrediente(@RequestBody Ingrediente ingrediente) {
		logger.info(ingrediente.getNombre());
		return ingredienteService.incluirIngrediente(ingrediente);
	}
	
	@PutMapping("/ingredientes/{id}")
	public Ingrediente actualizarIngrediente(@RequestBody Ingrediente ingrediente, @PathVariable("id") Long id) {
		ingrediente.setId(id);
		return ingredienteService.actualizarIngrediente(ingrediente);
	}
}
