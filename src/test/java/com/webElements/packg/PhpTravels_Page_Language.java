package com.webElements.packg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.project.pom.Base;

public class PhpTravels_Page_Language extends Base {

    By languageMenuLocator = By.xpath("//a[@role='button' and @data-bs-toggle='dropdown']");
    By germanyOptionLocator = By.xpath("//*[@id=\"navbarSupportedContent\"]/div[2]/ul/li[1]/ul/li[7]/a/span");
    By verificationTextLocator = By.xpath("//strong[contains(text(), 'Ihre Reise beginnt hier!')]");

    public PhpTravels_Page_Language(WebDriver driver) {
        super(driver);
    }

    public void selectGermanyLanguage() {
        click(languageMenuLocator); 
        click(germanyOptionLocator); 
    }

    public boolean isVerificationTextDisplayed() {
        return isDisplayed(verificationTextLocator); 
    }
}
