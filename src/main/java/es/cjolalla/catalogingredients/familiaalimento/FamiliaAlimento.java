package es.cjolalla.catalogingredients.familiaalimento;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import es.cjolalla.catalogingredients.ingrediente.Ingrediente;

@Entity
@Table(name="familiaAlimento")
public class FamiliaAlimento implements Serializable{

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="nombreFamilia")
	private String nombreFamilia;
	
	@OneToMany(mappedBy="familia")
	private Set<Ingrediente> ingredientes = new HashSet<>();
	
	public FamiliaAlimento() {
		super();
	}

	public FamiliaAlimento(String nombreFamilia) {
		super();
		this.nombreFamilia = nombreFamilia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreFamilia() {
		return nombreFamilia;
	}

	public void setNombreFamilia(String nombreFamilia) {
		this.nombreFamilia = nombreFamilia;
	}
	
	
}
