package com.trello.qsp.listener;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenerClass.class)
public class LoginPage extends Baseclass1 {
@Test(priority = 3)
public void enterTheEmail() throws InterruptedException
{
	 driver.findElement(By.xpath("//a[text()='Log in']")).click();
	 Thread.sleep(2000);
	 Assert.assertEquals("Log in to continue - Log in with Atlassian account", driver.getTitle(),"Login page has not been verified");
	 Thread.sleep(5000);
	 driver.findElement(By.id("username")).sendKeys("aishwaryaganesh98@gmail.com");
	 Thread.sleep(2000);
}
@Test(priority = 4)
public void clickOnContinue() throws InterruptedException
{
	 driver.findElement(By.xpath("//a[text()='Log in']")).click();
	 Assert.assertEquals("Log in with Atlassian account", driver.getTitle(),"Login page has not been verified");
	 Thread.sleep(5000);
	 driver.findElement(By.id("username")).sendKeys("aishwaryaganesh98@gmail.com");
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//span[text()='Continue']")).click();
	 Thread.sleep(2000); 
}
@Test(priority = 5)
public void enterThePassword() throws InterruptedException
{
	 driver.findElement(By.xpath("//a[text()='Log in']")).click();
	 Assert.assertEquals("Log in with Atlassian account", driver.getTitle(),"Login page has not been verified");
	 Thread.sleep(5000);
	 driver.findElement(By.id("username")).sendKeys("aishwaryaganesh98@gmail.com");
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//span[text()='Continue']")).click();;
	 Thread.sleep(2000); 
	 driver.findElement(By.id("password")).sendKeys("JoNsNoW<3");
	 Thread.sleep(2000);
}
@Test(priority = 6)
public void clickOnLogin() throws InterruptedException
{
	 driver.findElement(By.xpath("//a[text()='Log in']")).click();
	 Assert.assertEquals("Log in to continue - Log in with Atlassian account", driver.getTitle(),"Login page has not been verified");
	 Thread.sleep(5000);
	 driver.findElement(By.id("username")).sendKeys("aishwaryaganesh98@gmail.com");
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//span[text()='Continue']")).click();
	 Thread.sleep(2000); 
	 driver.findElement(By.id("password")).sendKeys("JoNsNoW<3");
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//span[text()='Log in']")).click();
	 Thread.sleep(2000);
}
}
