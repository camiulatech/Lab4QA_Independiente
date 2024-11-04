package com.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.webElements.packg.PhpTravels_Page_Login;

public class PhpTravels_Page_LoginTest {
	
	 private WebDriver driver;
	 PhpTravels_Page_Login phpTravelsLoginPage;

	@Before
	public void setUp() throws Exception {
        phpTravelsLoginPage = new PhpTravels_Page_Login(driver);
        driver = phpTravelsLoginPage.chromeDriverConnection();
        driver.manage().window().maximize();
        
		phpTravelsLoginPage.visit("https://phptravels.net/login");

	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
    public void testLoginWithCorrectPassword() {
        String email = "admin@phptravels.com"; 
        String password = "demoadmin";

        phpTravelsLoginPage.login(email, password);
        
        String currentUrl = driver.getCurrentUrl();
        assertEquals("La URL no es la esperada después del inicio de sesión.", "https://phptravels.net/dashboard", currentUrl);
    }
	
	@Test
	public void testLoginWithIncorrectPassword() {
	    String email = "admin@phptravels.com"; 
	    String incorrectPassword = "passwordincorrecto"; // Contraseña incorrecta

	    phpTravelsLoginPage.login(email, incorrectPassword);
	    
	    try {
	        Thread.sleep(3000); 
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }

	    String currentUrl = driver.getCurrentUrl();
	    
	    assertEquals("Se redirigió a otra página después de un inicio de sesión fallido.", "https://phptravels.net/login", currentUrl);
	}	

}
