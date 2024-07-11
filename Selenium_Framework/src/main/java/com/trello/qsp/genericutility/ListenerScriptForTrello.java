package com.trello.qsp.genericutility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.trello.qsp.pomrepo.TrelloHomePage;
import com.trello.qsp.pomrepo.TrelloLoginPage;

@Listeners(ListenerClass.class)
public class ListenerScriptForTrello extends BaseClass {

	   @Test
		public void trelloHomePage() throws IOException {
			TrelloHomePage homePage = new TrelloHomePage(driver);
//			Assert.assertEquals(driver.get(fileUtils.readTheDataFromPropertiesFile("url"),driver.getCurrentUrl());
			homePage.getLoginLink().click();
			
		}

		@Test(priority = 2)
		public void trelloLoginPage() throws IOException {
			TrelloHomePage homePage = new TrelloHomePage(driver);
			homePage.getLoginLink().click();
			TrelloLoginPage loginPage = new TrelloLoginPage(driver);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.titleIs("Log in to continue - Log in with Atlassian account"));
			loginPage.getUsername().sendKeys(fileutils.readTheDataFromPropertyFile("username"));
			loginPage.getContinueButton().submit();
			loginPage.getPassword().sendKeys(fileutils.readTheDataFromPropertyFile("password"));
			loginPage.getContinueButton().submit();
		}
}
