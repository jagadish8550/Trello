package com.trello.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloBoardsPage {
	WebDriver driver;

	public TrelloBoardsPage(){}
	
	public TrelloBoardsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()='Create new board']")
	private WebElement createNewBoard;
	
	@FindBy(css = "input[data-test-id='create-board-title-input']")
	private WebElement boardTitleTextField;
	
	@FindBy(xpath = "//button[text()='Create']")
	private WebElement createButton;
	
	@FindBy(css =  "button[data-test-id='header-member-menu-button']")
	private WebElement memberMenuButton;
	
	@FindBy(xpath = "//button[.='Log out']")
	private WebElement logoutOption;
	
	public WebElement createNewBoard() {
		return createNewBoard;
	}
	
	public WebElement boardTitleTextField() {
		return boardTitleTextField;
	}
	
	public WebElement createButton() {
		return createButton;
	}
	
	public WebElement memberMenuButton() {
		return memberMenuButton;
	}
	
	public WebElement logoutOption() {
		return logoutOption;
	}
}
