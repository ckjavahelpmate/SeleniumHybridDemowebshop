package com.demowebshop.elementrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(xpath = "//a[ text() = 'Register']")
	private WebElement registerButton;

	@FindBy(xpath = "//a[ @class = 'ico-login']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//a[ @class = 'account']")
	private WebElement logedEmail;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getRegisterButton() {
		return registerButton;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getLogedEmail() {
		return logedEmail;
	}
	

}
