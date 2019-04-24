package es.cjolalla.catalogingredients.security.dominio;

import org.springframework.security.core.GrantedAuthority;

import es.cjolalla.catalogingredients.usuarios.Perfil;

public class PerfilGrantedAuthority implements GrantedAuthority{

	private Perfil perfil;
	
	public PerfilGrantedAuthority(Perfil perfil) {
		this.perfil = perfil;
	}
	
	//Los roles les anteponemos "ROLE_" que por defecto es como los detecta spring security en la expresion hasRole (esta expresion asume que empieza por ROLE_)
	@Override
	public String getAuthority() {
		return "ROLE_" + perfil.getPerfil();
	}

}
