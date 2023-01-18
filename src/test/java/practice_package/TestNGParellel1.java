package practice_package;

import org.testng.annotations.Test;

public class TestNGParellel1 
{
	@Test
	public void sample1() throws InterruptedException
	{
		Thread.sleep(5000);
		System.out.println("T 1");
	}
	@Test
	public void sample2() throws InterruptedException
	{
		Thread.sleep(5000);
		System.out.println("T 2");
	}
}
