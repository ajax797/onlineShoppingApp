package practice_package;

import org.testng.annotations.Test;

public class TestNGParellel4 {
	@Test
	public void sample7() throws InterruptedException
	{
		Thread.sleep(5000);
		System.out.println("T 7");
	}
	@Test
	public void sample8() throws InterruptedException
	{
		Thread.sleep(5000);
		System.out.println("T 8");
	}
}
