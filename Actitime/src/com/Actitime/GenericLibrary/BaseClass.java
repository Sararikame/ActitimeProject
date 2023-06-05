package com.Actitime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Actitime.Pom.LoginPage;

public class BaseClass {
	static {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	FileLibrary fl = new FileLibrary();
	public WebDriver driver ;
@BeforeSuite
public void databaseconnection() {
	Reporter.log(" database connected",true);
	
}
@BeforeClass
public void LauchBrowser() throws IOException {
	 driver =new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	String actitimeurl = fl.readdataFromPropertyFile("url");
	driver.get(actitimeurl);
	Reporter.log(" Browser Lauched ",true);
	
}

@BeforeMethod
public void Login() throws IOException {
	LoginPage lp= new LoginPage(driver);
	   String un = fl.readdataFromPropertyFile("username");
	   String pw = fl.readdataFromPropertyFile("password");
	
	lp.getUnbtx().sendKeys(un);
	lp.getPwbtx().sendKeys(pw);
	lp.getLgbtn().click();
	Reporter.log(" Login in to actitime",true);
}
@AfterMethod
public void Logout() {;
	driver.findElement(By.id("logoutLink")).click();
	Reporter.log(" logged out sucessfully",true);
}
 @AfterClass
public void  ClosedBrowser() {
	driver.close();
	Reporter.log(" Close the browser",true);
}
 @AfterSuite
 public void DatabaseDisconnected() {
	 Reporter.log("Database Disconnected",true);
	 
 }

}
