package com.buffalocart.Utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtilities {
	public static Object[][] getdatafromExcel(String filepath,String SheetName) throws Exception{
		Object[][]data;
		FileInputStream inputstream=new FileInputStream(new File(filepath));
		Workbook wb=WorkbookFactory.create(inputstream);
		Sheet s=wb.getSheet(SheetName);
		int rowCount=s.getLastRowNum();
		int colCount=s.getRow(0).getLastCellNum();
		data=new Object[rowCount][colCount];
		for(int i=1;i<=rowCount;i++)
		{
			for(int j=0;j<=colCount-1;j++) {
				if(!getCellvalue(s,0,j).equals("")) {
					data[i-1][j]=getCellvalue(s,i,j);
					
				}
			}
		}
		return data;
	}
	private static String getCellvalue(Sheet sheet, int row, int col) {
	String value="";
	if(sheet.getRow(row).getCell(col)==null) {
		value="";
		
	}
	else if(sheet.getRow(row).getCell(col).getCellType()==Cell.CELL_TYPE_STRING) {
		value=sheet.getRow(row).getCell(col).getStringCellValue();

	}else {
		sheet.getRow(row).getCell(col).setCellType(Cell.CELL_TYPE_STRING);
		value=sheet.getRow(row).getCell(col).getStringCellValue();
	}
		return value;
	}

}
