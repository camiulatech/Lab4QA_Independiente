package com.webElements.packg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.project.pom.Base;

public class PhpTravels_Page_Tours extends Base {

	By tourCityDropdownLocator = By.xpath("//span[@aria-labelledby='select2-tours_city-container']"); 
    By cityInputLocator = By.className("select2-search__field"); 
    By searchButtonLocator = By.cssSelector("button.search_button.btn.btn-primary"); 
    By selectedCityLocator = By.id("select2-tours_city-container"); 

    public PhpTravels_Page_Tours(WebDriver driver) {
        super(driver);
    }

    public void searchTourByCity(String city) throws InterruptedException {
        click(tourCityDropdownLocator);
        Thread.sleep(1000); 

        type(city, cityInputLocator);
        Thread.sleep(1000); 

        WebElement cityInput = findElement(cityInputLocator);
        cityInput.sendKeys("\n"); 
        Thread.sleep(1000); 

        if (!isCitySelected(city)) {
            System.out.println("La ciudad no se seleccionó correctamente.");
        }

        click(searchButtonLocator);
        Thread.sleep(2000); 
    }

    public boolean isCitySelected(String expectedCity) {
        String selectedCityText = findElement(selectedCityLocator).getText(); 
        return selectedCityText.toLowerCase().contains(expectedCity.toLowerCase()); 
    }
}
