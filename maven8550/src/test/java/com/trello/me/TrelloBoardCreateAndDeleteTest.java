package com.trello.me;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.trello.pomrepository.BaseClass;
import com.trello.pomrepository.NewBoardPage;
import com.trello.pomrepository.TrelloBoardsPage;

public class TrelloBoardCreateAndDeleteTest extends BaseClass {
	
	@Test
	public void trelloBoardTest() throws IOException {
		WebDriverWait wait = webUtil.explicitWait(driver);
		TrelloBoardsPage trelloBoardPage=new TrelloBoardsPage(driver);
		trelloBoardPage.createNewBoard().click();
		trelloBoardPage.boardTitleTextField().sendKeys(fileUtil.getPropetyValue("boardname"));
		wait.until(ExpectedConditions.elementToBeClickable(trelloBoardPage.createButton()));
		trelloBoardPage.createButton().click();
		wait.until(ExpectedConditions.urlContains(fileUtil.getPropetyValue("boardname")));
		ArrayList<String> list =new ArrayList<String>();
		for(int i=1;i<7;i++) {
			list.add(fileUtil.getWorkbookStringValue("LoginpageTC Data", 0, i));
		}
		for (String name : list) {
			driver.switchTo().activeElement().sendKeys(name);
			driver.switchTo().activeElement().sendKeys(Keys.ENTER);
		} 
		NewBoardPage newBoardPage=new NewBoardPage(driver);
		newBoardPage.showMenuLink().click();
		newBoardPage.moreButton().click();
		newBoardPage.closeBoardButton().click();
		newBoardPage.closeButton().click();
		newBoardPage.permanentlyDeleteButton().click();
		newBoardPage.deleteButton().click();
	}
}
