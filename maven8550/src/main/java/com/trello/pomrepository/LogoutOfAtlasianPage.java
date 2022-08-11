package com.trello.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutOfAtlasianPage {
	WebDriver driver;
	
	public LogoutOfAtlasianPage(){}
	
	public LogoutOfAtlasianPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[.='Log out']")
	private WebElement logoutButton;
	
	public WebElement logoutButton() {
		return logoutButton;
	}
}
