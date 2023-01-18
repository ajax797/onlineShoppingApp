package practice_package;

import org.testng.annotations.DataProvider;

import com.ecomm.OSA.genericUtilities.ExcelUtility;

public class dataprovide
{
	@DataProvider
	public Object[][] data()
	{
		Object[][] obarr = new Object[3][3];
		obarr[0][0]= "Mobile";
		obarr[0][1]= "brand";
		obarr[0][2]= "price";
		
		obarr[1][0]= "Mobile1";
		obarr[1][1]= "brand1";
		obarr[1][2]= "price1";
		
		obarr[2][0]= "Mobile2";
		obarr[2][1]= "brand2";
		obarr[2][2]= "price2";
		
		return obarr;
	}
	
	@DataProvider(name="FromExcel")
	public Object[][] readSetofDataFromExcel()
	{
		ExcelUtility eLib = new ExcelUtility();
		Object[][] obj = eLib.readFromExcelToDP("Places");
		return obj;
	}

}
