package com.docker.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage {

	public WebDriver driver;

	public GoogleHomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.NAME, using = "q")
	@CacheLookup
	WebElement searchBox;
	
	@FindBy(how = How.XPATH, using = "//ul[@jsname='bw4e9b']/li")
	@CacheLookup
	List<WebElement> searchSuggestion;

	public void searchText(String searchKey) {
		searchBox.clear();
		searchBox.sendKeys(searchKey);

	}
	
	public void clickSuggestionByValue(String Value)
	{
		
		for(int i=0;i<searchSuggestion.size();i++)
		{
			
			
			String text=searchSuggestion.get(i).getText();
			
			if(text.contains(Value))
			{
				
				searchSuggestion.get(i).click();
				break;
				
			}
			
			
		}
		
		
	}
	
	

}
