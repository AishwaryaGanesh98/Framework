package TestNG;

import org.testng.annotations.Test;

public class Group3 {
	
	@Test(groups = "ad hoc")
	public void g()
	{
		System.out.println("g has been executed");
	}
	
	@Test(groups = "functional")
	public void h()
	{
		System.out.println("h has been executed");
	}
	
	@Test(groups = "smoke")
	public void i()
	{
		System.out.println("i has been executed");
	}
}
