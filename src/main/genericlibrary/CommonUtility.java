package com.demowebshop.genericlibrary;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.io.FileHandler;

public class CommonUtility 
{
	public void takeScreenShot(WebDriver driver, String name) 
	{
		try 
		{
			FileHandler.copy(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), 
					new File("./ScreenShots/"+name+".png"));
		} 
		catch (WebDriverException | IOException e) 
		{
			e.printStackTrace();
		}
	}
}
