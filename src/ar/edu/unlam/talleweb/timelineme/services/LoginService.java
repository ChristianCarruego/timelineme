package ar.edu.unlam.talleweb.timelineme.services;

import ar.edu.unlam.talleweb.timelineme.model.Persona;
import ar.edu.unlam.talleweb.timelineme.persistence.PersistenceException;



public class LoginService {

	public Boolean authenticate(String username, String password) throws PersistenceException {
		Persona usuarioActual = findByName(username);
		return usuarioActual.getUsername().equals(username) && usuarioActual.getPassword().equals(password);
	}
	
	public Persona findByName(String username) throws PersistenceException{
		PersonaService personaSvc = new PersonaService();
		return personaSvc.findByName(username);
		
	}
	
}
