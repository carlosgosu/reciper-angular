package es.cjolalla.catalogingredients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Equivale a las anotaciones
//@Configure
//@AutoConfiguration
//@ComponentScan
//Como esta incluido el starter-web tambien se incluye la siguiente anotacion
//@EnableWebMvc
//Excluimos el SecurityAutoConfiguration para poder configurar nosotros la parte de seguridad
//@SpringBootApplication(exclude= {SecurityAutoConfiguration.class})
@SpringBootApplication
public class CatalogIngredientsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogIngredientsApplication.class, args);
	}

}
