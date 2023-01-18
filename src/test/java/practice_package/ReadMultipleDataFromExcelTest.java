package practice_package;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ReadMultipleDataFromExcelTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis = new FileInputStream("./src/test/java/OSA_TestCommonData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Sheet1");
		System.out.println(sheet.getLastRowNum());
		for(int i=1;i<=sheet.getLastRowNum();i++)
		{
			String cellvalue = sheet.getRow(i).getCell(0).getStringCellValue();
			System.out.println(cellvalue);
		}
		
	}

}
