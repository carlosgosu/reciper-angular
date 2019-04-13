package es.cjolalla.catalogingredients.ingrediente;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import es.cjolalla.catalogingredients.ingrediente.web.IngredienteRestController;

@RunWith(SpringRunner.class)
//@SpringBootTest Esta anotacion no puede ir si ya va @WebMvcTest
//Esta anotacion de Spring boot permite que podamos inyectar el MockMvc para probar los controladores
//@AutoConfigureMockMvc
//Si en vez de la anterior le ponemos entre parentesis el controlador nos evitamos crear todo el contexto y solo creamos los controladores indicados
@WebMvcTest(IngredienteRestController.class)
public class IngredienteRestControllerTest {

	@Autowired
    private MockMvc mockMvc;
	
	//Crea un mock de la depedencia del controlador que queremos probar (anotacion de boot)
	@MockBean
	private IngredienteService service;
	
	@Test
	public void testEncontrarIngrediente() throws Exception{
		
		Mockito.when(service.devolverIngrediente("Ajo")).thenReturn(new Ingrediente("Ajo",10,new BigDecimal("1.5")));
		
		this.mockMvc.perform(MockMvcRequestBuilders.get("/ingredientes/Ajo"))
			.andExpect(MockMvcResultMatchers.status().is(200)) //Tambien valdria el metodo status().isOk() directamente
			.andExpect(MockMvcResultMatchers.content().json("{'id':null,'nombre':'Ajo','kcal':10,'precio':1.50}"));
	}
}
