package com.tests;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.webElements.packg.PhpTravels_Page_Language;

public class PhpTravels_Page_LanguageTest {

    private WebDriver driver;
    private PhpTravels_Page_Language phpTravelsLanguagePage;

    @Before
    public void setUp() {
    	phpTravelsLanguagePage = new PhpTravels_Page_Language(driver);
        driver = phpTravelsLanguagePage.chromeDriverConnection();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        //driver.quit();
    }

    @Test
    public void testSelectGermanyLanguageAndVerifyText() {
        phpTravelsLanguagePage.visit("https://phptravels.net/"); 

        phpTravelsLanguagePage.selectGermanyLanguage();
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

        assertTrue("El texto de verificación no está presente después de seleccionar el idioma Germany.",
                phpTravelsLanguagePage.isVerificationTextDisplayed());
    }
}
