package com.webElements.packg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.project.pom.Base;

public class PhpTravels_Page_Login extends Base{
	
    By emailInputLocator = By.id("email"); 
    By passwordInputLocator = By.id("password"); 
    By loginButtonLocator = By.id("submitBTN"); 
    By userImageLocator = By.xpath("//img[@src='https://phptravels.net/assets/img/user.png' and @alt='user']"); 


	public PhpTravels_Page_Login(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

    public void login(String email, String password) {
        type(email, emailInputLocator); 
        type(password, passwordInputLocator); 
        click(loginButtonLocator); 
    }

    public boolean isUserImageVisible() {
        return isDisplayed(userImageLocator); 
    }
}
