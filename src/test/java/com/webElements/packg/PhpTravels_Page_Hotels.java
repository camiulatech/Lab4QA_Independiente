package com.webElements.packg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.project.pom.Base;

public class PhpTravels_Page_Hotels extends Base{

    By cityDropdownLocator = By.cssSelector(".select2-selection--single"); 
    By cityInputLocator = By.className("select2-search__field"); 
    By searchButtonLocator = By.xpath("//*[@id=\"hotels-search\"]/div/div[5]/button"); 
   
    By selectedCityLocator = By.id("select2-hotels_city-container"); 

    
	public PhpTravels_Page_Hotels(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	 public void searchHotelByCity(String city) throws InterruptedException {
	        click(cityDropdownLocator); 
	        Thread.sleep(1000); 

	        type(city, cityInputLocator);
	        Thread.sleep(1000); 

	        WebElement cityInput = findElement(cityInputLocator);
	        cityInput.sendKeys("\n"); 

	        click(searchButtonLocator); 
	        Thread.sleep(1000); 
	    }

	    public boolean isCitySelected(String expectedCity) {
	        String selectedCityText = findElement(selectedCityLocator).getText(); 
	        return selectedCityText.toLowerCase().contains(expectedCity.toLowerCase()); 
	    }
}
