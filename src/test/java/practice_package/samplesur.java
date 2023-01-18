package practice_package;

import static org.testng.Assert.fail;

import org.testng.annotations.Test;

public class samplesur
{
	@Test(retryAnalyzer = com.ecomm.OSA.genericUtilities.RetryAnalyzerImplementationClass.class)
	public void suresh()
	{
		System.out.println(1);
		fail();
		System.out.println(2);
	}

}
