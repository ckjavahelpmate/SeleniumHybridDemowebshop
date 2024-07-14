package com.demowebshop.genericlibrary;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest 
{
	protected DataUtility dataUtility = new DataUtility();
	protected CommonUtility commonUtility = new CommonUtility();
	protected WebDriver driver ;

	@Parameters("Browser")
	@BeforeClass(alwaysRun = true)
	public void launchBrowser(@Optional("Chrome") String browser) throws FileNotFoundException, IOException 
	{
		if( browser.equals("Chrome")) 
		{
			driver = new ChromeDriver();
		}
		else if( browser.equals("Edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("Enter Valid Browser");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(dataUtility.getDataFromProperties("url"));

		Assert.assertEquals(driver.getTitle(), PageTitles.HOME_PAGE, "Home Page is not Displayed");
		Reporter.log("Home Page is Displayed", true );
	}
//	@BeforeMethod(alwaysRun = true)
	public void login() throws FileNotFoundException, IOException 
	{
		String email = dataUtility.getDataFromProperties("email");
		String password = dataUtility.getDataFromProperties("password");

		driver.findElement(By.xpath("//a[ @class = 'ico-login']")).click() ;
		Assert.assertEquals(driver.getTitle(), PageTitles.LOGIN_PAGE, "Login Page is not Displayed");
		Reporter.log("Login page is displayed", true );
		driver.findElement(By.id("Email")).sendKeys( email, Keys.TAB, password, Keys.TAB, Keys.ENTER );
		Assert.assertEquals(driver.getTitle(), PageTitles.HOME_PAGE, "Home Page is not Displayed");
		Reporter.log("Home Page is Displayed", true );
	}
	@AfterMethod(alwaysRun = true)
	public void logout() 
	{
		driver.findElement(By.xpath("//a[ text() = 'Log out']")).click() ;
	}
	@AfterClass(alwaysRun = true)
	public void closeBrowser() 
	{
		driver.close();
	}
}
