package es.cjolalla.catalogingredients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//Equivale a las anotaciones
//@Configure
//@AutoConfiguration
//@ComponentScan
//Como esta incluido el starter-web tambien se incluye la siguiente anotacion
//@EnableWebMvc
//Excluimos el SecurityAutoConfiguration para poder configurar nosotros la parte de seguridad
//@SpringBootApplication(exclude= {SecurityAutoConfiguration.class})

@EnableJpaRepositories(repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class) //Esto permite que funcione envers
@SpringBootApplication
public class CatalogIngredientsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogIngredientsApplication.class, args);
	}

}
