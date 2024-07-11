package TestNG;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class DemoListenerScript extends BaseClass {
	@Test
	public void method1()
	{
	Assert.assertEquals(false, true);	
	}
	@Test
	public void method2()
	{
		Assert.assertEquals(false, true);	
	}
	@Test
	public void method3()
	{
		Assert.assertEquals(false, true);	
	}
	@Test
	public void method4()
	{
		Assert.assertEquals(false, false);	
	}

}
