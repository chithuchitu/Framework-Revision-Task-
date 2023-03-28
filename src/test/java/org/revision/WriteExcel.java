package org.revision;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {

	public static void main(String[] args) throws IOException {
		Workbook book = new XSSFWorkbook();
		 Sheet sh = book.createSheet("student");
		 sh.createRow(0);
		 sh.getRow(0).createCell(0).setCellValue("username");
		 sh.getRow(0).createCell(1).setCellValue("password");
		 
		 sh.createRow(1);
		 sh.getRow(1).createCell(0).setCellValue("chithra@gmail.com");
		 sh.getRow(1).createCell(1).setCellValue("1234");
		 
		 sh.createRow(2);
		 sh.getRow(2).createCell(0).setCellValue("chithra@yahoo.com");
		 sh.getRow(2).createCell(1).setCellValue("12344444");
		 		 		 		
		  File f = new File("C:\\Users\\KEERTHI\\eclipse-workspace\\Revision_Frameworks\\Excel\\ipt.xlsx");
		  FileOutputStream fos = new FileOutputStream(f);
		  book.write(fos);
		  System.out.println("Success");
		  
 
		  
 
		 
		
		 
	}

}
