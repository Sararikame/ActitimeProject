package com.Actitime.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Taskpage {
	
	
@FindBy(xpath="//div[.='Add New']")
private WebElement addnewcust;

@FindBy(xpath="//div[.='+ New Customer']")
private WebElement newcust;

@FindBy(xpath="(//input[@placeholder='Enter Customer Name'])[2]")
private WebElement custname;

@FindBy(xpath="//textarea[@placeholder='Enter Customer Description']")
private WebElement custdes;
@FindBy(xpath="//div[.='Create Customer']")
private WebElement createcust;
//initilization
public Taskpage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}


public WebElement getAddnewcust() {
	return addnewcust;
}
public WebElement getNewcust() {
	return newcust;
}
public WebElement getCustname() {
	return custname;
}
public WebElement getCustdes() {
	return custdes;
}
public WebElement getCreatecust() {
	return createcust;
}


}
