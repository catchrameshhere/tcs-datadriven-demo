package test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pom.Login;

public class LoginTest extends Base{
	
	Login login;
	
	@BeforeClass
	public void beforeClass() {
		login = new Login(driver);
	}

	@Parameters({"validUsername", "validPassword"})
	@Test
	public void validUsernameValidPasswordTest(String username, String password) {
		login.login(username, password);
	}
	
	@Parameters({"validUsername", "invalidPassword"})
	@Test
	public void validUsernameInvalidPasswordTest(String username, String password) {
		login.login(username, password);
	}
	
	@Parameters({"invalidUsername", "validPassword"})
	@Test
	public void invalidUsernameValidPasswordTest(String username, String password) {
		login.login(username, password);
	}
	
	@Parameters({"invalidUsername", "invalidPassword"})
	@Test
	public void invalidUsernameInvalidPasswordTest(String username, String password) {
		login.login(username, password);
	}
	
	@Parameters({"validPassword"})
	@Test
	public void blankUsernameValidPasswordTest(String password) {
		login.login("", password);
	}
	
	@Parameters({"validUsername"})
	@Test
	public void validUsernameBlankPasswordTest(String username) {
		login.login(username, "");
	}
}
