package practice_package;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ReadMultipleRowDataFromExcelTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis = new FileInputStream("./src/test/java/OSA_TestCommonData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Sheet1");
		int rcount = sheet.getLastRowNum();
		for(int i=0;i<=rcount;i++)
		{
			Row row = sheet.getRow(i);
				for(int j=0;j<row.getLastCellNum();j++)
					{
						String cellvalue = row.getCell(j).getStringCellValue();
						System.out.print(cellvalue+"  ");
					}
			System.out.println();
		}
	}

}
