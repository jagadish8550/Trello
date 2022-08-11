package com.trello.pomrepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.trello.utils.FileUtility;
import com.trello.utils.WebdriverUtility;

public class BaseClass {
	public WebDriver driver;
	public FileUtility fileUtil=new FileUtility();
	public WebdriverUtility webUtil=new WebdriverUtility();
	
	public BaseClass() {}
	
	public BaseClass(WebDriver driver) throws IOException {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@BeforeClass
	public void browserLaunch() throws IOException {
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	webUtil.implicitWait(driver);
	driver.get(fileUtil.getPropetyValue("url"));
	}
	
	@BeforeMethod
	public void loginToTrello() throws IOException, Throwable {
		WebDriverWait wait = webUtil.explicitWait(driver);
		TrelloHomePage trelloHome=new TrelloHomePage(driver);
		LoginToTrello loginTrello = new LoginToTrello(driver);
		trelloHome.loginLink().click();
		//wait.until(ExpectedConditions.visibilityOf(loginTrello.emailTextField()));
		Thread.sleep(5000);
		loginTrello.emailTextField().sendKeys(fileUtil.getPropetyValue("email"));
		wait.until(ExpectedConditions.visibilityOf(loginTrello.loginWithAtlasianButton()));
		loginTrello.loginWithAtlasianButton().click();
		LoginToContinue login=new LoginToContinue(driver);
		login.passswordTextField().sendKeys(fileUtil.getPropetyValue("password"));
		login.loginButton().submit();
	}
	
	@AfterMethod
	public void logoutFromTrello() {
		WebDriverWait wait = webUtil.explicitWait(driver);
		wait.until(ExpectedConditions.urlContains("boards"));
		TrelloBoardsPage trelloBoardPage = new TrelloBoardsPage();
		trelloBoardPage.memberMenuButton().click();
		trelloBoardPage.logoutOption().click();
		LogoutOfAtlasianPage logoutPage=new LogoutOfAtlasianPage();
		logoutPage.logoutButton().submit();
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.manage().window().minimize();
		driver.quit();
	}
}
