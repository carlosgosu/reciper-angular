package es.cjolalla.catalogingredients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Equivale a las anotaciones
//@Configure
//@AutoConfiguration
//@ComponentScan
@SpringBootApplication
public class CatalogIngredientsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogIngredientsApplication.class, args);
	}

}
