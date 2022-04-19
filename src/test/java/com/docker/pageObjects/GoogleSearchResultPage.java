package com.docker.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchResultPage {

	public WebDriver driver;

	public GoogleSearchResultPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//a[text()='News']")
	@CacheLookup
	WebElement newLink;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Burn')]")
	@CacheLookup
	WebElement burnLink;

	public void clickLink() {

		newLink.click();

	}
	
	
	
	

}
