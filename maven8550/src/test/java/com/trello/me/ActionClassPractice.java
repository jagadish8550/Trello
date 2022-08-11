package com.trello.me;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.trello.pomrepository.TrelloHomePage;
import com.trello.utils.FileUtility;

public class ActionClassPractice {
	WebDriver driver;
	FileUtility fileUtil = new FileUtility();
	
	@Test(enabled = false)
	public void contextClickActions() throws IOException, Throwable {
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		TrelloHomePage trelloHome=new TrelloHomePage(driver);
		Actions action = new Actions(driver);
		driver.get(fileUtil.getPropetyValue("url"));
		action.contextClick().perform();
		action.contextClick(trelloHome.loginLink()).perform();
	}
	@Test(enabled = false)
	public void doubleClick() throws InterruptedException {
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		Actions action = new Actions(driver);
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		WebElement alertButton = driver.findElement(By.xpath("//button[.='Double-Click Me To See Alert']"));
		action.doubleClick(alertButton).perform();
		Thread.sleep(5000);
		driver.quit();
	}
	@Test
	public void dragAndDrop() throws InterruptedException {
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		Actions action = new Actions(driver);
		driver.get("https://demo.guru99.com/test/drag_drop.html");
		action.dragAndDrop(driver.findElement(By.partialLinkText("BANK")), driver.findElement(By.id("bank"))).perform();
		Thread.sleep(5000);
		driver.quit();
		
	}
}
