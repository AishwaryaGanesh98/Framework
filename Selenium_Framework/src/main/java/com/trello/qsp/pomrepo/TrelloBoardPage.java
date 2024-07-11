package com.trello.qsp.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloBoardPage {

	WebDriver driver;

	public TrelloBoardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='board-tile mod-add']")
	private WebElement createLink;
    public WebElement getCreateLink() {
		return createLink;
	}

	@FindBy(xpath = "//input[@data-testid='create-board-title-input']")
	private WebElement createTextField;
	public WebElement getCreateTextField() {
		return createTextField;
	}

	@FindBy(xpath = "//button[text()='Create']")
	private WebElement createButton;
	public WebElement getCreateButton() {
		return createButton;
	}

	

	

}
