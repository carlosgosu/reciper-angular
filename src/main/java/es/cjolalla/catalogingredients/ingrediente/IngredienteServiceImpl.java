package es.cjolalla.catalogingredients.ingrediente;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
//Por defecto seran sin el readOnly
@Transactional 
public class IngredienteServiceImpl implements IngredienteService{

	private final IngredienteRepository ingredienteRepo;
	
	@Autowired
	public IngredienteServiceImpl(IngredienteRepository ingredienteRepo) {
		Assert.notNull(ingredienteRepo, "IngredienteRepository is null creating IngredienteService");
		this.ingredienteRepo = ingredienteRepo;
	}

	@Override
	@Transactional(readOnly=true)
	public List<Ingrediente> devolverIngredientesMasBaratos(BigDecimal precioTope) {
		return ingredienteRepo.findByPrecioMenor(precioTope);
	}

	@Override
	@Transactional(readOnly=true)
	public Ingrediente devolverIngrediente(String nombre) {
		return ingredienteRepo.findByNombre(nombre);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Ingrediente> devolverIngredientesTodos() {
		return ingredienteRepo.findAll();
	}

	@Override
	public Long incluirIngrediente(Ingrediente nuevo) {
		Ingrediente creado = ingredienteRepo.save(nuevo);
		return creado.getId();
	}

	@Override
	public Ingrediente actualizarIngrediente(Ingrediente actualizado) {
		if (actualizado.getId() != null) {		
			//El getOne devuelve solo un proxy para ver si existe en vez de ir a la BD y traer toda la entidad (pero si la devolvemos da un error el Jackson porque las propiedades son lazy)
			Optional<Ingrediente> ingOpt = ingredienteRepo.findById(actualizado.getId());
			//optional de forma imperativa
			if (ingOpt.isPresent()) {
				Ingrediente ing = ingOpt.get();
				if (actualizado.getNombre() != null) {
					ing.setNombre(actualizado.getNombre());
				}
				if (actualizado.getKcal() != null) {
					ing.setKcal(actualizado.getKcal());
				}
				if (actualizado.getPrecio() != null) {
					ing.setPrecio(actualizado.getPrecio());
				}
				return ing;
			}
		}
		return null;
	}

}
