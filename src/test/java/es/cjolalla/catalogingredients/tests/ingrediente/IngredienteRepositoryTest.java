package es.cjolalla.catalogingredients.tests.ingrediente;

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
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import es.cjolalla.catalogingredients.familiaalimento.FamiliaAlimento;
import es.cjolalla.catalogingredients.familiaalimento.FamiliaAlimentoRepository;
import es.cjolalla.catalogingredients.ingrediente.Ingrediente;
import es.cjolalla.catalogingredients.ingrediente.IngredienteRepository;

@RunWith(SpringRunner.class)
//@ComponentScan("es.cjolalla.catalogingredients.tests")
//Esto iniciliza un servlet container y para esto no me hace falta
//@SpringBootTest
//Esto instancia un H2 database, SQL Logging, EntityScan
@DataJpaTest
@ActiveProfiles("test")
public class IngredienteRepositoryTest {
	
	@Autowired
	private IngredienteRepository ingredienteRepo;
	
	@Autowired
	private FamiliaAlimentoRepository familiaAlimentoRepo;

	@Before
	public void setUp() {
		FamiliaAlimento carne = familiaAlimentoRepo.save(new FamiliaAlimento("Carne"));
		FamiliaAlimento verdura = familiaAlimentoRepo.save(new FamiliaAlimento("Verdura"));
		FamiliaAlimento pescado = familiaAlimentoRepo.save(new FamiliaAlimento("Pesacado"));
		
		ingredienteRepo.save(new Ingrediente("Ajo",10,new BigDecimal("1.5", new MathContext(6,RoundingMode.HALF_DOWN)), verdura));
		ingredienteRepo.save(new Ingrediente("Agua",0,new BigDecimal("0"),null));
		ingredienteRepo.save(new Ingrediente("Cebolla",10,new BigDecimal("1"),verdura));
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
		Assert.assertEquals(3,todos.size());
	}

}
