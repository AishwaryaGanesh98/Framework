package com.trello.qsp.listener;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenerClass.class)
public class HomePage extends Baseclass1 {
@Test(priority = 1)
public void loginLink() throws InterruptedException
{
	 driver.findElement(By.xpath("//a[text()='Log in']")).click();
	 Thread.sleep(2000);
}
@Test(priority = 2)
public void vandvLoginPage() throws InterruptedException
{
	 driver.findElement(By.xpath("//a[text()='Log in']")).click();
	 Thread.sleep(2000);
	 Assert.assertEquals("Log in to continue - Log in with Atlassian account", driver.getTitle(),"Login page has not been verified");
	 Thread.sleep(5000);
}
}
