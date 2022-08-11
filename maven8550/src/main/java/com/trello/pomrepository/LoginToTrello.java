package com.trello.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginToTrello {
	WebDriver driver;
	
	LoginToTrello(){}
	
	public LoginToTrello(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "user") private WebElement emailTextFiled;
	
	@FindBy(css = "input[value='Log in with Atlassian']")
	private WebElement loginWithAtlasianButton;
	
	@FindBy(xpath = "//a[text()='Register']")
	private WebElement registerLink;
	
	public WebElement emailTextField() {
		return emailTextFiled;
	}
	
	public WebElement loginWithAtlasianButton() {
		return loginWithAtlasianButton;
	}
	
	public WebElement getRegisterLink() {
		return registerLink;
	}
}
