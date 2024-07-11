package TestNG;

import org.testng.annotations.Test;

public class Group2 {
	
	@Test(groups = "ad hoc")
	public void d()
	{
		System.out.println("d has been executed");
	}
	
	@Test(groups = "functional")
	public void e()
	{
		System.out.println("e has been executed");
	}
	
	@Test(groups = "integration")
	public void f()
	{
		System.out.println("f has been executed");
	}
}
