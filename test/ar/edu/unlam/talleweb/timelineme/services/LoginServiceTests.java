package ar.edu.unlam.talleweb.timelineme.services;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.unlam.talleweb.timelineme.persistence.PersistenceException;




public class LoginServiceTests {

	LoginService service = new LoginService();

	@Test
	public void testThatAuthenticates() throws PersistenceException {
		String username = "jack";
		String password = "jack";
		Assert.assertTrue("username equals password must authenticate",
				service.authenticate(username, password));
	}
	
	@Test
	public void testThatRefusesAuthentication() throws PersistenceException {
		String username = "jack";
		String password = "sparrow";
		Assert.assertFalse("username not equals password must refuse authentication",
				service.authenticate(username, password));
	}
	
}
