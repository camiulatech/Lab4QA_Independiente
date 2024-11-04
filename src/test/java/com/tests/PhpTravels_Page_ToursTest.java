package com.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.webElements.packg.PhpTravels_Page_Flight;
import com.webElements.packg.PhpTravels_Page_Tours;

public class PhpTravels_Page_ToursTest {

	private WebDriver driver;
    PhpTravels_Page_Tours phpTravelsToursPage;

	@Before
	public void setUp() throws Exception {
        phpTravelsToursPage = new PhpTravels_Page_Tours(driver);
        driver = phpTravelsToursPage.chromeDriverConnection();
        driver.manage().window().maximize();
        
        phpTravelsToursPage.visit("https://phptravels.net/tours");
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}


	@Test
	public void testSearchTourByCity() throws InterruptedException {
		phpTravelsToursPage.searchTourByCity("Thailand");

	    String currentUrl = driver.getCurrentUrl();
	    assertTrue("La URL no contiene 'Thailand'", currentUrl.contains("thailand"));
	}


}
