package com.trello.qsp.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloHomePage {
	private WebDriver driver;

	public TrelloHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@data-uuid='MJFtCCgVhXrVl7v9HA7EH_login']")
	private WebElement loginLink;

	public WebElement getLoginLink() {
		return loginLink;
	}

}
