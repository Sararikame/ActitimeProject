package com.Actitime.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
@FindBy(id="username")
private WebElement unbtx;

@FindBy(name="pwd")
private WebElement pwbtx;

@FindBy(xpath="//div[.='Login ']")
private WebElement lgbtn;

public LoginPage(WebDriver driver)// constructer
{
	PageFactory.initElements( driver, this);
	 
}

public WebElement getUnbtx() {
	return unbtx;
}

public WebElement getPwbtx() {
	return pwbtx;
}

public WebElement getLgbtn() {
	return lgbtn;
}
}