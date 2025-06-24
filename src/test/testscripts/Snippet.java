package com.demowebshop.testscripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Snippet {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver() ;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://www.instahyre.com/login/");
		WebElement emailTextField = driver.findElement(By.id("email"));
		Thread.sleep(5000);
		emailTextField.sendKeys("vinayakagr@gmail.com");

		WebElement passwrodTextField = driver.findElement(By.id("password"));
		passwrodTextField.sendKeys("Vinayaka");

		WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
		loginBtn.click();
	}
}
