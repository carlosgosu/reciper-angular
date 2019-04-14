package es.cjolalla.catalogingredients.ingrediente;

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
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import es.cjolalla.catalogingredients.ingrediente.web.IngredienteRestController;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class IngredienteRepositoryTest {
	
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
	
	@Test
	public void findIngredientesTodos() {
		List<Ingrediente> todos = ingredienteRepo.findAll();
		//Para comparar BigDecimal con el AssertEquals hay un problema de precision
		Assert.assertEquals(6,todos.size());
	}

}
