package practice_package;

import org.testng.annotations.Test;

public class TestNGParellel3 {
	@Test
	public void sample5() throws InterruptedException
	{
		Thread.sleep(5000);
		System.out.println("T 5");
	}
	@Test
	public void sample6() throws InterruptedException
	{
		Thread.sleep(5000);
		System.out.println("T 6");
	}
}
