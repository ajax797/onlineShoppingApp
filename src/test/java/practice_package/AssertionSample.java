package practice_package;

import static org.testng.Assert.*;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionSample 
{
	@Test
	public void s11()
	{
		System.out.println("a");
		System.out.println("b");
		assertEquals("a", "b");
		System.out.println("c");
		System.out.println("d");
		System.out.println("e");
	}
	@Test
	public void s12()
	{
		System.out.println("f");
		System.out.println("g");
		String a=null;
		assertNotNull(a, "it is not null");
		System.out.println("h");
		System.out.println("i");
	}
	@Test
	public void s13()
	{
		System.out.println("j");
		SoftAssert sa = new SoftAssert();
		sa.assertEquals("az", "ax");
		System.out.println("k");
		System.out.println("l");
		sa.assertAll();
		System.out.println("m");
	}
	@Test
	public void s14()
	{
		System.out.println("n");
		System.out.println("o");
		System.out.println("p");
		System.out.println("q");
	}
	@Test
	public void s15()
	{
		System.out.println("r");
		System.out.println("s");
		System.out.println("t");
		System.out.println("u");
	}
	
	
}
