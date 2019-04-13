package es.cjolalla.catalogingredients.ingrediente;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author carlosgosu
 *
 */
@Entity
@Table(name="ingrediente")
public class Ingrediente {
	
	//Si fuera Oracle pondriamos secuencias
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "documento_secuence_generator")
	//@SequenceGenerator(name = "documento_secuence_generator", sequenceName = "documento_seq")
	//MySQL usa columnas AUTO_INCREMENT en vez de secuencias como Oracle. Para el AutoIncrement se pone Identity
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private Integer kcal;
	private BigDecimal precio;
	
	public Ingrediente() {
		super();
	}

	public Ingrediente(String nombre, Integer kcal, BigDecimal precio) {
		super();
		this.nombre = nombre;
		this.kcal = kcal;
		this.precio = precio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getKcal() {
		return kcal;
	}

	public void setKcal(Integer kcal) {
		this.kcal = kcal;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

}
