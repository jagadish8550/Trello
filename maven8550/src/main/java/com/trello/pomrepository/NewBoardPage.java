package com.trello.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewBoardPage {
	WebDriver driver;
	
	NewBoardPage(){}
	
	public NewBoardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[.='Show menu']")
	private WebElement showMenuLink;
	
	@FindBy(xpath = "//a[contains(.,'More')]")
	private WebElement moreButton;
	
	@FindBy(xpath = "//a[contains(.,'Close board…')]")
	private WebElement closeBoardButton;
	
	@FindBy(css = "input[value='Close']")
	private WebElement closeButton;
	
	@FindBy(xpath = "//button[text()='Permanently delete board']")
	private WebElement permanentlyDeleteButton;
	
	@FindBy(xpath = "//button[text()='Delete']")
	private WebElement deleteButton;
	
	public WebElement showMenuLink() {
		return showMenuLink;
	}
	
	public WebElement moreButton() {
		return moreButton;
	}
	
	public WebElement closeBoardButton() {
		return closeBoardButton;
	}
	
	public WebElement closeButton() {
		return closeButton;
	}
	
	public WebElement permanentlyDeleteButton() {
		return permanentlyDeleteButton;
	}
	
	public WebElement deleteButton() {
		return deleteButton;
	}
}
