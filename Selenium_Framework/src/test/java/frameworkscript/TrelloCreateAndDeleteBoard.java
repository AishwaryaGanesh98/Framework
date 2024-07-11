package frameworkscript;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.trello.qsp.genericutility.BaseClass;
import com.trello.qsp.pomrepo.TrelloBoardPage;
import com.trello.qsp.pomrepo.TrelloDeleteBoard;
import com.trello.qsp.pomrepo.TrelloHomePage;
import com.trello.qsp.pomrepo.TrelloLogOut;
import com.trello.qsp.pomrepo.TrelloLoginPage;

public class TrelloCreateAndDeleteBoard extends BaseClass {
	@Test
	public void checkWhetherTheUserCanLogin_CreateTheBoard_DeleteTheBoard_LogoutFromTrello() throws IOException {
		TrelloHomePage homePage = new TrelloHomePage(driver);
		homePage.getLoginLink().click();
		TrelloLoginPage loginPage = new TrelloLoginPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait.until(ExpectedConditions.elementToBeClickable(loginPage.getUsername()))
				.sendKeys(fileutils.readTheDataFromPropertyFile("username"));
		loginPage.getContinueButton().submit();
		wait.until(ExpectedConditions.elementToBeClickable(loginPage.getPassword()))
				.sendKeys(fileutils.readTheDataFromPropertyFile("password"));
		loginPage.getContinueButton().submit();
		TrelloBoardPage boardPage = new TrelloBoardPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(boardPage.getCreateLink()));
		boardPage.getCreateLink().click();
		boardPage.getCreateTextField().sendKeys(fileutils.readTheDataFromPropertyFile("boardname"));
		wait.until(ExpectedConditions.elementToBeClickable(boardPage.getCreateButton()));
		Assert.assertEquals(boardPage.getCreateButton().isEnabled(), true);
		boardPage.getCreateButton().click();
		TrelloDeleteBoard deleteBoard = new TrelloDeleteBoard(driver);
		deleteBoard.getOptionsButton().click();
		wait.until(ExpectedConditions.elementToBeClickable(deleteBoard.getCloseBoardBtn()));
		deleteBoard.getCloseBoardBtn().click();
		deleteBoard.getClose().click();
		deleteBoard.getPermanentlyDeleteBoard().click();
		deleteBoard.getDeleteButton().click();
		TrelloLogOut logOut = new TrelloLogOut(driver);
		logOut.getSettingsButton().click();
		logOut.getLogoutButton().click();
		logOut.getLogoutSubmit().click();
		wait.until(ExpectedConditions.titleContains("Manage Your Team’s Projects"));

	}
}
