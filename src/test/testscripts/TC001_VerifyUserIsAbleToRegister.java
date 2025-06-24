package com.demowebshop.testscripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demowebshop.elementrepository.HomePage;
import com.demowebshop.elementrepository.RegisterPage;
import com.demowebshop.genericlibrary.BaseTest;
import com.demowebshop.genericlibrary.PageTitles;

public class TC001_VerifyUserIsAbleToRegister extends BaseTest {
	@Test(groups = "Integration", dataProvider = "register")
	public void registerTestCase(String firstName, String lastName, String email, String password, String confirmPassword ) throws FileNotFoundException, IOException {
//		1.Launch Browser
//		2.Verify Home page is displayed
//		3.click on Register button
		HomePage homePage = new HomePage(driver);
		homePage.getRegisterButton().click();
		
//		4.Verify Register page is displayed
		Assert.assertEquals(driver.getTitle() , PageTitles.REGISTER_PAGE,"Register page Not displayed" );
		Reporter.log("Register Page is Displayed", true );
		
//		5.Enter user details and click on register button
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.getMaleRadioButton().click();
		registerPage.getFirstName().sendKeys(firstName);
		registerPage.getLastName().sendKeys(lastName);
		registerPage.getEmail().sendKeys(email);
		registerPage.getPassword().sendKeys(password);
		registerPage.getConfirmPassword().sendKeys(confirmPassword);
		registerPage.getRegisterButton().click();
		
//		6.Click on continue button
		registerPage.getContinueButton().click();
		
//		7.Verify user is registered successfully
		String actualEmail = homePage.getLogedEmail().getText();
		Assert.assertEquals(actualEmail, email , "user is not registered") ;
		Reporter.log("User registered successfully", true );
		
//		8.Logout
//		9.close Browser
	}
	
	@DataProvider(name = "register")
	public Object[][] register() throws EncryptedDocumentException, FileNotFoundException, IOException 
	{
		return dataUtility.getAllDataFromExcel("DemoWebShop");
	}
}
