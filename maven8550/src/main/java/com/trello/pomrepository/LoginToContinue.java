package com.trello.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginToContinue {
	WebDriver driver;
	
	public LoginToContinue() {	}
	
	public LoginToContinue(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "password")
	private WebElement passwordTextField;
	
	@FindBy(id = "login-submit")
	private WebElement loginButton;
	
	public WebElement passswordTextField() {
		return passwordTextField;
	}
	
	public WebElement loginButton() {
		return loginButton;
	}
}
