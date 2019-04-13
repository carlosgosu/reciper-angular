package es.cjolalla.catalogingredients.ingrediente;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class IngredienteServiceImpl implements IngredienteService{

	private final IngredienteRepository ingredienteRepo;
	
	@Autowired
	public IngredienteServiceImpl(IngredienteRepository ingredienteRepo) {
		Assert.notNull(ingredienteRepo, "IngredienteRepository is null creating IngredienteService");
		this.ingredienteRepo = ingredienteRepo;
	}

	@Override
	public List<Ingrediente> devolverIngredientesMasBaratos(BigDecimal precioTope) {
		return ingredienteRepo.findByPrecioMenor(precioTope);
	}

	@Override
	public Ingrediente devolverIngrediente(String nombre) {
		return ingredienteRepo.findByNombre(nombre);
	}

}
