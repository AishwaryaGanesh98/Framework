package com.trello.qsp.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloLogOut {

	WebDriver driver;

	public TrelloLogOut(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='B1uWdim9Jd0dJ9']")
	private WebElement settingsButton;
	public WebElement getSettingsButton() {
		return settingsButton;
	}

	@FindBy(xpath = "//button[@data-testid='account-menu-logout']")
	private WebElement logoutButton;
	public WebElement getLogoutButton() {
		return logoutButton;
	}

	@FindBy(id = "logout-submit")
	private WebElement logoutSubmit;
	public WebElement getLogoutSubmit() {
		return logoutSubmit;
	}
}
