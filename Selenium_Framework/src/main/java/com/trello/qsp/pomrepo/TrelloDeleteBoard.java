package com.trello.qsp.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloDeleteBoard {
	WebDriver driver;

	public TrelloDeleteBoard(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@aria-label='Show menu']")
	private WebElement optionsButton;
	public WebElement getOptionsButton() {
		return optionsButton;
	}

	@FindBy(xpath = "//a[contains(@class,'board-menu-navigation-item-link board-menu-navigation-item-link-v2 js-close')]")
	private WebElement closeBoardBtn;
	public WebElement getCloseBoardBtn() {
		return closeBoardBtn;
	}

	@FindBy(xpath = "//input[@data-testid='close-board-confirm-button']")
	private WebElement close;
	public WebElement getClose() {
		return close;
	}

	@FindBy(xpath = "//button[text()='Permanently delete board']")
	private WebElement permanentlyDeleteBoard;
	public WebElement getPermanentlyDeleteBoard() {
		return permanentlyDeleteBoard;
	}

	@FindBy(xpath = "//button[text()='Delete']")
	private WebElement deleteButton;
	public WebElement getDeleteButton() {
		return deleteButton;
	}

	

	

	

	

	

}
