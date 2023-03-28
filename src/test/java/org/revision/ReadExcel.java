package org.revision;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public static void main(String[] args) throws IOException {
		//		File Path
		File f = new File("C:\\Users\\KEERTHI\\eclipse-workspace\\Revision_Frameworks\\Excel\\Student.xlsx");

		//		 Read Excel File 
		FileInputStream  f1 = new FileInputStream(f);

		//		 Get XSS Excel Sheet
		Workbook book = new XSSFWorkbook(f1);
		Sheet sh = book.getSheetAt(0);
		Row r = sh.getRow(0);
		int rowNum = r.getLastCellNum();
		int colNum = sh.getLastRowNum();
		System.out.println("No of rows"+rowNum);
		System.out.println("No of columns"+colNum);



		// 		// To fetch Row
		// 		 for (int i = 0; i < sh.getPhysicalNumberOfRows(); i++) {
		// 			 
		// 		  Row r = sh.getRow(i);
		// 		  
		// 			//  To fetch the cell value
		// 			  for (int j = 0; j <r.getPhysicalNumberOfCells(); j++) {
		// 			  Cell c = r.getCell(j);
		// 			//	  To Fetch Cell Type
		// 			  int cellType = c.getCellType();
		// 			  if (cellType==1) {
		// 					  System.out.println(output);
		// 					 
		//  					 


	}	 



}







