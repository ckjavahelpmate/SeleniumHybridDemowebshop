package com.demowebshop.testscripts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.demowebshop.genericlibrary.BaseTest;
import com.demowebshop.genericlibrary.PageTitles;

public class TC003_VerifyUserIsAbleToAddProductToWishlist extends BaseTest
{
	@Test(groups = "System")
	public void addToWishList() throws FileNotFoundException, IOException
	{
//		1.Launch Browser
//		2.Verify Home page is displayed
//		3.click on login link
//		3.Verify login page is displayed
//		4.click on Books link
		driver.findElement(By.xpath("//a[ @href = '/books']")).click();
//		5.Verify Books Page is Displayed
		if( driver.getTitle().equals(PageTitles.BOOKS_PAGE))
		{
			System.out.println("Books Page is displayed");
		}
		else
		{
			System.out.println("Books Page is not displayed");
		}
//		6.Click on Fiction EX Book Link
		driver.findElement(By.xpath("//a[ text() = 'Fiction EX']")).click();
		driver.findElement(By.xpath("//h1[ @itemprop = 'name' and "
				+ "contains( text(), 'Fiction EX')]/../../div[6]/div/input[@type='button']")).click();
//		7.click on wish list link
		driver.findElement(By.xpath("//span[ text() = 'Wishlist']")).click();
//		8.Verify wish list page is displayed
		if( driver.getTitle().equals(PageTitles.WISHLIST_PAGE))
		{
			System.out.println("wish list Page is displayed");
		}
		else
		{
			System.out.println("wish list Page is not displayed");
		}
//		9.Verify Fiction EX book is Displayed
		List<WebElement> products = driver.findElements(By.xpath("//table/tbody/tr/td[4]/a"));
		boolean flag = true ;
		for (WebElement product : products) 
		{
			if( product.getText().equals("Fiction EX"))
			{
				System.out.println("Fiction EX book is Displayed"); flag = false ; break ;
			}
		}
		if(flag)
		{
			System.out.println("Fiction EX book is not Displayed");
		}
//		10.click on Fiction Ex book remove checkBox 
		products = driver.findElements(By.xpath("//table/tbody/tr/td[4]/a"));
		 flag = true ;
		 int index = 1 ;
		for (WebElement product : products) 
		{
			if( product.getText().equals("Fiction EX"))
			{
				WebElement element = driver.findElement(By.xpath("//table/tbody/tr["+index +"]/td[1]/input"));
				element.click();
				System.out.println("clicked on Fiction Ex book remove checkBox"); flag = false ; break ;
			}
			index++ ;
		}
		if(flag)
		{
			System.out.println("Not clicked on Fiction Ex book remove checkBox");
		}
//		11.Click on Update wish list button
		driver.findElement(By.name("updatecart")).click();
//		12.Verify Fiction book is removed From wish list
		products = driver.findElements(By.xpath("//table/tbody/tr/td[4]/a"));
		flag = true ;
		for (WebElement product : products) 
		{
			if( product.getText().equals("Fiction EX"))
			{
				System.out.println("Fiction book is not removed from wish list"); flag = false ; break ;
			}
		}
		if(flag)
		{
			System.out.println("Fiction Book is removed from wish list");
		}
//		13.logout
//		14.close the Browser
		
	}
	
}
