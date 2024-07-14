package com.demowebshop.testscripts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.demowebshop.genericlibrary.BaseTest;
import com.demowebshop.genericlibrary.PageTitles;

public class TC004_VerifyUserIsAbleToPalceOrder extends BaseTest {

	@Test(groups = "System")
	public void placeOrder() throws FileNotFoundException, IOException, InterruptedException 
	{
//		1.Launch Browser
//		2.Verify home page displayed
//		3.click on login link
//		4.Verify login page is displayed
//		5.click on Computers link
		driver.findElement(By.xpath("//a[ contains(text(), 'Computers')]")).click();
//		6.Verify Computers page is displayed
		if( driver.getTitle().equals(PageTitles.COMPUTERS_PAGE))
		{
			System.out.println("Computers page is displayed");
		}
		else
		{
			System.out.println("Computers page is not displayed");
		}
//		7.Click on Desktop link
		driver.findElement(By.xpath("(//a[ @href = '/desktops'])[3]")).click();
//		8.Verify Desktop page is displayed
		if( driver.getTitle().equals(PageTitles.DESKTOPS_PAGE))
		{
			System.out.println("Desktop page is displayed");
		}
		else
		{
			System.out.println("Desktop page is not displayed");
		}
//		7.Click on Simple Computer link
		driver.findElement(By.xpath("//a[ text() ='Simple Computer']")).click();
//		8.Verify Simple Computer page is displayed
		if( driver.getTitle().equals(PageTitles.SIMPLE_COMPUTERS_PAGE))
		{
			System.out.println("Simple Computer page is displayed");
		}
		else
		{
			System.out.println("Simple Computer page is not displayed");
		}
//		9.Click on Processor check box
		driver.findElement(By.id("product_attribute_75_5_31_96")).click();
//		10.click on add to cart button
		driver.findElement(By.id("add-to-cart-button-75")).click();
//		11.click on Shopping cart link
		driver.findElement(By.xpath("//span[ text() ='Shopping cart']")).click();
//		12.Verify shopping cart page is displayed
		if( driver.getTitle().equals(PageTitles.SHOPPING_CART_PAGE))
		{
			System.out.println("Shopping cart page is displayed");
		}
		else
		{
			System.out.println("Shopping cart page is not displayed");
		}
//		13.Verify Simple computer is displayed in cart
		List<WebElement> elements = driver.findElements(By.xpath("//table[@class='cart']/tbody/tr/td[3]/a"));
		for (WebElement webElement : elements) 
		{
			if( webElement.getText().equals("Simple Computer"))
			{
				System.out.println("Simple computer is displayed in cart");
			}
			else
			{
				System.out.println("Simple computer is not displayed in cart");
			}
		}
//		14.click on agree to terms and condition
		driver.findElement(By.id("termsofservice")).click();
//		15.Click on Checkout button
		driver.findElement(By.id("checkout")).click();
//		16.Verify Checkout page is displayed
		if( driver.getTitle().equals(PageTitles.CHECKOUT_PAGE))
		{
			System.out.println("Checkout page is displayed");
		}
		else
		{
			System.out.println("Checkout page is not displayed");
		}
//		17.logout
//		18.close browser

	}
	
}
