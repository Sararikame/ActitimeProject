package com.Actitime.GenericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author SARA
 *
 */
public class FileLibrary {
	/**
	 * this method is a genric method which is used to read data from property file
	 * @param Key
	 * @return
	 * @throws IOException
	 */
public String readdataFromPropertyFile(String Key) throws IOException {
	FileInputStream fis = new FileInputStream("./Testdata/commondata.property");
	Properties p =new Properties();
	p.load(fis);
	 String value = p.getProperty(Key);
	 return value;
	     
}
/**
 * This method is a genric method which is used to read data from excel sheet
 * @param sheetname
 * @param row
 * @param cell
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public String readDataFromExcel(String sheetname,int row,int cell) throws EncryptedDocumentException, IOException{
	FileInputStream fis =new FileInputStream("./TestData/Testdata1.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
    String data = wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
	return data;

}}
