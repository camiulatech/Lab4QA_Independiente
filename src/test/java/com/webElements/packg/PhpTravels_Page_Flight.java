package com.webElements.packg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.project.pom.Base;

public class PhpTravels_Page_Flight extends Base {

    By oneWayLocator = By.xpath("//*[@id=\"flights-search\"]/div[1]/div[1]/div/div/div/div[1]"); 
    By roundTripLocator = By.xpath("//*[@id=\"flights-search\"]/div[1]/div[1]/div/div/div/div[2]"); 
    By returningInputLocator = By.id("return_date"); 
    
    By icelandairOptionLocator = By.xpath("//label[@for='oneway_flights_0']"); 
    By icelandairTextLocator = By.xpath("//p[contains(text(), 'Icelandair')]"); 
    
    public PhpTravels_Page_Flight(WebDriver driver) {
        super(driver);
    }

    public boolean applyIcelandairFilterAndVerify() throws InterruptedException {
        click(icelandairOptionLocator);
        Thread.sleep(1000); 

        WebElement icelandairText = findElement(icelandairTextLocator);
        boolean textContainsIcelandair = icelandairText.getText().toLowerCase().contains("icelandair");

        return textContainsIcelandair;
    }
    
    public void selectRoundTrip() {
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

        click(roundTripLocator); 
    }
    
    public void selectOneWay() {
        try {
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        click(oneWayLocator); 
    }

    public boolean isReturningInputVisible() {
        return isDisplayed(returningInputLocator); 
    }
    
}
