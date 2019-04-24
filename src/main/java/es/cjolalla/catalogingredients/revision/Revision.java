package es.cjolalla.catalogingredients.revision;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

/**
 * Entidad que guardara la informacion de las revisiones de envers
 * @author carlosgosu
 *
 */
@Entity
@Table(name="REVISION_INFO")
@RevisionEntity(CustomRevisionListener.class) //AuditingEntityListener.class es proveida
public class Revision {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@RevisionNumber
	private Long id;
	
	//JPA 2 no soporta los tipos de localDateTime de java 8 ni todos los nuevos de la API. Tendremos que usar Date ya que solo admite eso y Long
	@Column(name="REVISION_TIME")
  	@Temporal(TemporalType.TIMESTAMP)
  	@RevisionTimestamp
	private Date hora;
	
	@Column(name="REVISION_USER_NAME")
	private String userName;
	
	@Column(name="IP")
	private String ip;
	
	@Column(name="SESSION_ID")
	private String sessionId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	
}
