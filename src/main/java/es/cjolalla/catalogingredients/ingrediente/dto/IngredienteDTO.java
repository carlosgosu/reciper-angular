package es.cjolalla.catalogingredients.ingrediente.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Para que el eclipse vea los metodos craedos por lombok es necesario ejecutar java -jar lombok.jar y abrira una ventana donde especificaremos donde esta instalado el eclipse
//Lombok anotaciones que se encargan de generar los setters, getters y constructor por defecto
//La anotacion @Data incluirira @ToString , @EqulasAndHashCode, @Getter, @Setter y @RequiredArgsConstructor (con los campos final,si no crea un noArgsConstructor)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class IngredienteDTO implements Serializable{

	private static final long serialVersionUID = -31600360138005257L;

	private Long id;
	private String nombre;
	private Integer kcal;
	private BigDecimal precio;
	private String nombreFamilia;
}
