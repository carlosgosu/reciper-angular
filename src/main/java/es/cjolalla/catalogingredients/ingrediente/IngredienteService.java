package es.cjolalla.catalogingredients.ingrediente;

import java.math.BigDecimal;
import java.util.List;

public interface IngredienteService {
	
	Ingrediente devolverIngrediente(String nombre);

	List<Ingrediente> devolverIngredientesTodos();
	
	List<Ingrediente> devolverIngredientesMasBaratos(BigDecimal precioTope);
	
	Long incluirIngrediente(Ingrediente nuevo);
}
