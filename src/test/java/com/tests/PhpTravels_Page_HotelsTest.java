package com.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.webElements.packg.PhpTravels_Page_Hotels;

public class PhpTravels_Page_HotelsTest {
	
	private WebDriver driver;
    PhpTravels_Page_Hotels phpTravelsHotelPage;

	@Before
	public void setUp() throws Exception {
        phpTravelsHotelPage = new PhpTravels_Page_Hotels(driver);
        driver = phpTravelsHotelPage.chromeDriverConnection();
        driver.manage().window().maximize();
        
    	phpTravelsHotelPage.visit("https://phptravels.net/hotels");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

    @Test
    public void testSearchHotelByCity() throws InterruptedException {
    	phpTravelsHotelPage.searchHotelByCity("Dubai");
    	
        assertTrue("La ciudad seleccionada no es Dubai", phpTravelsHotelPage.isCitySelected("Dubai"));
       }
       
}
