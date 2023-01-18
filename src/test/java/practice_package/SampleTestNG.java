package practice_package;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SampleTestNG
{
//	@Test(priority = 0, invocationCount = 1 ,enabled = true  )
//	public void createCategory()
//	{
//		System.out.println("Category Created");
//	}
//	
//	@Test(priority = 1, invocationCount = 2 ,dependsOnMethods ="createCategory",enabled = true )
//	public void createSubcategory()
//	{
//		System.out.println("Subcategory Created");
//	}
	@Test(priority = 2, invocationCount = 0, /* dependsOnMethods ={"createCategory", "createSubcategory"}, */ dataProvider = "ajax",/*dataProviderClass = dataprovide.class,*/enabled = true )
	public void insertProduct(String pn, String br, String pr)
	{
		System.out.println("Product is inserted and its "+pn+" of "+br+" with "+pr);
	}
//	@Test(priority = 3, invocationCount = 3,dependsOnMethods ="insertProduct",enabled = true  )
//	public void manageProduct()
//	{
//		System.out.println("Produt details is edited");
//	}
//	
//	@Test(priority = 4, invocationCount = 2,dependsOnMethods ="insertProduct" ,enabled = true )
//	public void purchaseProduct()
//	{
//		System.out.println("Product is been purchased");
//	}
//	@Test(priority = 5, invocationCount = 1,dependsOnMethods ="purchaseProduct" ,enabled = true )
//	public void manageOrder()
//	{
//		System.out.println("Purchase has been managed");
//		
//	}
//	
//	@Test(dataProvider = "FromExcel",dataProviderClass = dataprovide.class, priority = -1,enabled = true)
//	public void toReadFromExcel(String from,String to)
//	{
//		System.out.println(from +" -------> "+to);
//	}
	
	
	@DataProvider(name="ajax")
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
	@DataProvider
	public String[][] arry()
	{
		String arr[][]= {{"aaaa","ssss"},{"qqqqq","aaaa"},{"eeee","cccc"}};
		return arr;
	}
	
	
//	@BeforeMethod
//	public void configBM()
//	{
//		System.out.println("3. Login to OSA app");
//	}
//	@AfterMethod
//	public void configAM()
//	{
//		System.out.println("5. Logout from OSA app");
//	}
//	@BeforeClass
//	public void configBC()
//	{
//		System.out.println("2. Launch the browser");
//	}
//	@AfterClass
//	public void configAC()
//	{
//		System.out.println("6. Close the browser");
//	}
//	@BeforeSuite
//	public void configBS()
//	{
//		System.out.println("1. Connect to Database");
//	}
//	@AfterSuite
//	public void configAS()
//	{
//		System.out.println("7. Disconnect from Database");
//	}
	
}
