package es.cjolalla.catalogingredients.ingrediente;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

/**
 * 
 * @author carlosgosu
 *
 */
@Entity
@Table(name="ingrediente")
//Esto se usa para que se guarde auditoria por hibernate envers (en una tabla espejo que se poblara con cada cambio en los datos)
@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED) //Indicamos que no audite las tablas relacionadas si las tuviera, solo esta.
@AuditTable(value="ingrediente_aud")
public class Ingrediente implements Serializable{
	
	private static final long serialVersionUID = 5136608123665049523L;

	//Si fuera Oracle pondriamos secuencias
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "documento_secuence_generator")
	//@SequenceGenerator(name = "documento_secuence_generator", sequenceName = "documento_seq")
	//MySQL usa columnas AUTO_INCREMENT en vez de secuencias como Oracle. Para el AutoIncrement se pone Identity
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nombre")
	private String nombre;
	private Integer kcal;
	private BigDecimal precio;
	
	//Optimistic locking https://www.byteslounge.com/tutorials/jpa-entity-versioning-version-and-optimistic-locking
	@Version
	private Integer version;
	
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
