package com.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.webElements.packg.PhpTravels_Page_Flight;

public class PhpTravels_Page_FlightTest {
	
	private WebDriver driver;
    PhpTravels_Page_Flight phpTravelsFlightPage;

	@Before
	public void setUp() throws Exception {
        phpTravelsFlightPage = new PhpTravels_Page_Flight(driver);
        driver = phpTravelsFlightPage.chromeDriverConnection();
        driver.manage().window().maximize();
	}
	

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	 @Test
	    public void testApplyIcelandairFilterAndVerify() throws InterruptedException {
		  	phpTravelsFlightPage.visit("https://phptravels.net/flights/ber/jfk/oneway/economy/07-11-2024/1/0/0");

		  	boolean result = phpTravelsFlightPage.applyIcelandairFilterAndVerify();
	        
		  	assertTrue("Las opciones de vuelos de Icelandair no se encuentran correctamente", result);
	    }

	
	 @Test
	    public void testRoundTripInputVisibility() {
		 	phpTravelsFlightPage.visit("https://phptravels.net/flights");
	        
		 	phpTravelsFlightPage.selectRoundTrip();

	        assertTrue("El campo de fecha de retorno no es visible después de seleccionar 'Round Trip'.", phpTravelsFlightPage.isReturningInputVisible());
	    }
	    
	
    @Test
    public void testOneWayInputVisibility() {
        phpTravelsFlightPage.visit("https://phptravels.net/flights");

        phpTravelsFlightPage.selectOneWay();

        assertTrue("El campo de fecha de retorno es visible después de seleccionar 'One Way'.", 
            !phpTravelsFlightPage.isReturningInputVisible());
    }
    
}
