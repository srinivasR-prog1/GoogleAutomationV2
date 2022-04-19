package com.docker.testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.docker.pageObjects.GoogleHomePage;

public class TC_GoogleHomeTest extends BaseClass {
	@Parameters({"keyword","Value"})
	@Test
	public void homeTest(String keywordname,String valueName)
	{
		GoogleHomePage gp= new GoogleHomePage(driver);
		gp.searchText(keywordname);
		By locatorElement=By.xpath("//ul[@jsname='bw4e9b']/li");
		explicitWait(locatorElement, 30);
		gp.clickSuggestionByValue(valueName);		
		Assert.assertTrue(true);
		
		
	}

}
