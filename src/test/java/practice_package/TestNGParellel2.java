package practice_package;

import org.testng.annotations.Test;

public class TestNGParellel2 {
	@Test
	public void sample3() throws InterruptedException
	{
		Thread.sleep(5000);
		System.out.println("T 3");
	}
	@Test
	public void sample4() throws InterruptedException
	{
		Thread.sleep(5000);
		System.out.println("T 4");
	}
}
