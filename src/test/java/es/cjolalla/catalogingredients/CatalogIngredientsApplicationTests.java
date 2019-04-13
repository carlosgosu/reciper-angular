package es.cjolalla.catalogingredients;

import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import es.cjolalla.catalogingredients.ingrediente.Ingrediente;
import es.cjolalla.catalogingredients.ingrediente.IngredienteRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CatalogIngredientsApplicationTests {
	
	@Autowired
	private IngredienteRepository ingredienteRepo;

	@Before
	public void setUp() {
		ingredienteRepo.save(new Ingrediente("Ajo",10,new BigDecimal("1.5", new MathContext(6,RoundingMode.HALF_DOWN))));
		ingredienteRepo.save(new Ingrediente("Agua",0,new BigDecimal("0")));
		ingredienteRepo.save(new Ingrediente("Cebolla",10,new BigDecimal("1")));
	}
	
	@After
	public void cleanUp() {
		ingredienteRepo.deleteAll();
	}
	
	
	@Test
	public void findIngredienteTest() {
		Ingrediente ajo = ingredienteRepo.findByNombre("Ajo");
		//Para comparar BigDecimal con el AssertEquals hay un problema de precision
		Assert.assertEquals(0,new BigDecimal("1.5").compareTo(ajo.getPrecio()));
	}
	
	@Test
	public void findIngredientesPorPrecioMenor() {
		List<Ingrediente> listaIngredientes = ingredienteRepo.findByPrecioMenor(new BigDecimal("1"));
		
		Assert.assertEquals(2, listaIngredientes.size());
	}

}
