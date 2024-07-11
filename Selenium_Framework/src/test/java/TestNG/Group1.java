package TestNG;

import org.testng.annotations.Test;

public class Group1 {
@Test(groups = "functional")
	public void a()
	{
		System.out.println("a has been executed");
	}
	
@Test(groups = "integration")
public void b()
	{
		System.out.println("b has been executed");
	}
	
@Test(groups = "smoke")
public void c()
	{
		System.out.println("c has been executed");
	}
}
