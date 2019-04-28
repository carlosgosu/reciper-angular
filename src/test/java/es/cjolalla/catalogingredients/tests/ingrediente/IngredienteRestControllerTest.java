package es.cjolalla.catalogingredients.tests.ingrediente;

import java.math.BigDecimal;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import es.cjolalla.catalogingredients.ingrediente.Ingrediente;
import es.cjolalla.catalogingredients.ingrediente.IngredienteService;

@RunWith(SpringRunner.class)
@SpringBootTest //Esta anotacion no puede ir si ya va @WebMvcTest
//Esta anotacion de Spring boot permite que podamos inyectar el MockMvc para probar los controladores
@AutoConfigureMockMvc
//Si en vez de la anterior le ponemos entre parentesis el controlador nos evitamos crear todo el contexto y solo creamos los controladores indicados
//@WebMvcTest(controllers = {IngredienteRestControllerFake.class}) //Si le pongo solo esta en vez de SpringBootTest y AutoConfigureMockMvc no me carga los repositories y falla
@ActiveProfiles("test")
public class IngredienteRestControllerTest {

	@Autowired
    private MockMvc mockMvc;
	
	//Crea un mock de la depedencia del controlador que queremos probar (anotacion de boot)
	@MockBean
	private IngredienteService service;
	
	@Test
	@WithMockUser(username="admin",roles= {"READ_INGREDIENTES"})
	public void testEncontrarIngrediente() throws Exception{
		
		Mockito.when(service.devolverIngrediente("Ajo")).thenReturn(new Ingrediente("Ajo",10,new BigDecimal("1.5")));
		
		this.mockMvc.perform(MockMvcRequestBuilders.get("/ingredientes/Ajo"))
			.andExpect(MockMvcResultMatchers.status().is(200)) //Tambien valdria el metodo status().isOk() directamente
			.andExpect(MockMvcResultMatchers.content().json("{'id':null,'nombre':'Ajo','kcal':10,'precio':1.50}"));
	}
	
	
	@Test
	//Inyecta como si estuviera autenticado el usuario admin con el permiso (Grantedauthority indicado)
	@WithMockUser(username="admin",authorities= {"READ_INGREDIENTES"})
	public void testDevolverTodosIngredientes() throws Exception{
		
		Mockito.when(service.devolverIngrediente("Ajo")).thenReturn(new Ingrediente("Ajo",10,new BigDecimal("1.5")));
		
		this.mockMvc.perform(MockMvcRequestBuilders.get("/ingredientes/Ajo"))
			.andExpect(MockMvcResultMatchers.status().is(200)) //Tambien valdria el metodo status().isOk() directamente
			.andExpect(MockMvcResultMatchers.content().json("{'id':null,'nombre':'Ajo','kcal':10,'precio':1.50}"));
	}
}
