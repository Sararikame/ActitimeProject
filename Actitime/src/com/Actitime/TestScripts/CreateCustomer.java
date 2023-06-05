package com.Actitime.TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Actitime.GenericLibrary.BaseClass;
import com.Actitime.GenericLibrary.FileLibrary;
import com.Actitime.Pom.Homepage;
import com.Actitime.Pom.Taskpage;

public class CreateCustomer extends BaseClass{
@Test
public void createcustomer() throws EncryptedDocumentException, IOException, InterruptedException {
	Homepage hp=new Homepage(driver);
	hp.getTasktab().click();
	Taskpage tp= new Taskpage(driver);
	System.out.println("HI");
	tp.getAddnewcust().click();
	System.out.println("HI");
	tp.getNewcust().click();
	FileLibrary f1= new FileLibrary();
	Thread.sleep(4000);
	String customer = f1.readDataFromExcel("Data", 5, 1);
	System.out.println(customer);
	tp.getCustname().sendKeys(customer);
	String description = f1.readDataFromExcel("Data", 3, 2);
	tp.getCustdes().sendKeys(description);
	tp.getCreatecust().click();
	String expectedresult = customer;
	 String actualresult = driver.findElement(By.xpath("(//div[.='"+customer+"'])[2]")).getText();
	SoftAssert s= new SoftAssert();
	s.assertEquals(actualresult, expectedresult);
} 
}