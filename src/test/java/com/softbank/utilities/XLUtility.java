package com.softbank.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtility {
	public static FileInputStream fis;
	public static XSSFWorkbook wk;
	public static XSSFSheet ws;
	public static XSSFRow wr;
	public static XSSFCell wc;
	
	public static Object[][] readExcel(String fileName, String SheetName, int dataStartRow) {
		
		
		File fl = new File(System.getProperty("user.dir")+"/testdata/"+fileName+".xlsx");
		
				try {
					fis=new FileInputStream(fl);
					wk = new XSSFWorkbook(fis);
					
					} catch (FileNotFoundException e) {
					e.printStackTrace();
				}catch (IOException e) {
					e.printStackTrace();
				}
				
				ws = wk.getSheet(SheetName);
				wr = ws.getRow(0);
				
				int rowCount = ws.getLastRowNum();
				int colCount = wr.getLastCellNum();
				Object[][] o= new Object[rowCount+(1-dataStartRow)][colCount];
				int c =0;
				for(int a=dataStartRow; a<=rowCount; a++) {
					
					wr= ws.getRow(a);
					
					for(int b=0; b<colCount; b++) {
						
						o[c][b]=wr.getCell(b);
						
					}
					c++;
				}
				
				return o;
				
		
	}
	
}
