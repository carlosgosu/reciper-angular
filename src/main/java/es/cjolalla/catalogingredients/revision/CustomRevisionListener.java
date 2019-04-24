package es.cjolalla.catalogingredients.revision;

import org.hibernate.envers.RevisionListener;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

/**
 * Esta clase escuachara los eventos de modificacion de entidades y guardara en la tabla marcada como RevisionEntity (la Revision de este paquete)
 * @author carlosgosu
 *
 */
public class CustomRevisionListener implements RevisionListener{

	//Cogemos la revision que se va a guardar y la poblamos con informacion adicional
	@Override
	public void newRevision(Object revisionEntity) {
		Revision rev = (Revision) revisionEntity;
		
		//Obtenemos el usuario autenticado y lo guardamos (siempre y cuando realmente este autenticado)
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			rev.setUserName(authentication.getName());
			//Contiene detalles de la auternticacion (IP, session Id), etc...
			WebAuthenticationDetails detalles = (WebAuthenticationDetails) authentication.getDetails();
			rev.setIp(detalles.getRemoteAddress());
			rev.setSessionId(detalles.getSessionId());
		}
		
	}

}
