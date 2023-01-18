package practice_package;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class WriteDataFromExcelTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis = new FileInputStream("./src/test/java/OSA_TestCommonData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		book.getSheet("Sheet2").createRow(0).createCell(1).setCellValue("sample entry");
		FileOutputStream fout = new FileOutputStream("./src/test/java/OSA_TestCommonData.xlsx");
		book.write(fout);
		
	}

}
