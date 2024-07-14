package com.demowebshop.testscripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.demowebshop.genericlibrary.BaseTest;
import com.demowebshop.genericlibrary.PageTitles;

public class TC002_VerifyUserIsAbleToAddProductsToCartAndRemove extends BaseTest
{
	@Test(groups = "System")
	public void addProductToCart() throws FileNotFoundException, IOException, InterruptedException, AWTException 
	{
//		1.Launch Browser
//		2.Verify home page displayed
//		3.click on login link
//		4.Verify login page is displayed
//		5.click on digital downloads link
		driver.findElement(By.xpath("//a[ contains( text(),'Digital downloads')]")).click();
//		6.Verify digital downloads page is displayed
		Assert.assertEquals(driver.getTitle(), PageTitles.DIGITAL_DOWNLOADS_PAGE,"Digital downloads page is not displayed");
		Reporter.log("Digital downloads page is displayed", true );
//		7.add All Products to cart
		List<WebElement> elements = driver.findElements(By.xpath("//input[ @class ='button-2 product-box-add-to-cart-button']"));
		for (WebElement webElement : elements) 
		{
			webElement.click();
			Thread.sleep(2000);
		}
//		8.click on Shopping cart link
		driver.findElement(By.xpath("//span[ text() ='Shopping cart']")).click();
//		9.Verify shopping cart page is displayed
		Assert.assertEquals(driver.getTitle(), PageTitles.SHOPPING_CART_PAGE,"Shopping cart page is not displayed");
		Reporter.log("Shopping cart page is displayed", true );
//		10.Verify all products are displayed in cart
		List<WebElement> cartProducts = driver.findElements(By.xpath("//table[ @class = 'cart']/tbody/tr"));
		Assert.assertEquals(elements.size(), cartProducts.size(),"all products are not displayed in cart" ) ;
		Reporter.log("all products are displayed in cart", true );
//		Taking ScreenShots
		commonUtility.takeScreenShot(driver, "addProductToCart");
//		11.remove all products from cart
		cartProducts = driver.findElements(By.xpath("//table[ @class = 'cart']/tbody/tr/td[1]/input"));
		for (WebElement product : cartProducts) {
			product.click();
		}
		Robot robot = new Robot() ;
		robot.keyPress(KeyEvent.VK_ENTER) ;
		robot.keyRelease(KeyEvent.VK_ENTER);
//		12.Verify all products are removed from cart
		String text = driver.findElement(By.xpath("// div[ @class = 'order-summary-content']")).getText();
		Assert.assertTrue(text.contains("Your Shopping Cart is empty!") , "all products are not removed from cart");
		Reporter.log("all products are removed from cart", true );
//		13.click on logout
//		14.Close browser
		
	}
	
}


