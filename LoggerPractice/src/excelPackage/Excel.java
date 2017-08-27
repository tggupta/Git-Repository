package excelPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

	XSSFWorkbook workbook=null;
	XSSFSheet sheet=null;
	XSSFRow row= null;
	XSSFCell cell=null;
	//sample
	//updating from remote
	//updating again from remote
	//2nd commit
	public String readExcel(int rownum, int cellnum) throws IOException
	{
		File file=new File("C:\\Users\\Tarun\\workspace\\LoggerPractice\\Utility\\SearchItem.xlsx");
		 FileInputStream fis=new FileInputStream(file);
		 
		 workbook=new XSSFWorkbook(fis);
		 sheet=workbook.getSheetAt(0);
		 
		row=sheet.getRow(rownum);
		cell=row.getCell(cellnum);
		//updating it from local to remote
		//now updating back from remote to local
		return(cell.getStringCellValue());
	}

	
}
