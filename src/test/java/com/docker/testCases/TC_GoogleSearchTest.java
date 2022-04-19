package com.docker.testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.docker.pageObjects.GoogleHomePage;
import com.docker.pageObjects.GoogleSearchResultPage;

public class TC_GoogleSearchTest extends BaseClass {

	@Parameters({ "keyword", "Value" })
	@Test
	public void searchTest(String keywordName, String valueName) throws InterruptedException	
	{
		GoogleHomePage gp = new GoogleHomePage(driver);
		GoogleSearchResultPage gsp = new GoogleSearchResultPage(driver);
		gp.searchText(keywordName);		
		By locatorElement = By.xpath("//ul[@jsname='bw4e9b']/li");
		explicitWait(locatorElement, 30);
		gp.clickSuggestionByValue(valueName);		
		Assert.assertTrue(true);
		gsp.clickLink();
		By ImageElement = By.xpath("//div[text()='More']");
		boolean displayed = isDisplayed(ImageElement, 30);
		Assert.assertEquals(displayed, true);

	}

}
