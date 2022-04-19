package com.docker.testCases;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {

	protected WebDriver driver;
	public WebDriverWait wait;

	@Parameters("browser")
	@BeforeTest
	public void setUp(String BROWSER) throws IOException, InterruptedException {
	
		String host = "selenium-hub";

		DesiredCapabilities dc = new DesiredCapabilities();

		if ((BROWSER != null) && (BROWSER.equalsIgnoreCase("chrome"))) {
			dc.setBrowserName(BrowserType.CHROME);

		} else if ((BROWSER != null) && (BROWSER.equalsIgnoreCase("firefox"))) {

			dc.setBrowserName(BrowserType.FIREFOX);

		}

		String completeURL = "http://" + host + ":4444/wd/hub";

		driver = new RemoteWebDriver(new URL(completeURL), dc);

		
		 /* if (BROWSER.equals("chrome")) {
		  WebDriverManager.chromedriver().setup(); driver = new ChromeDriver();
		  } else if (BROWSER.equals("firefox")) {
		  WebDriverManager.firefoxdriver().setup(); driver = new
		  FirefoxDriver(); }*/
		 

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();

	}

	@AfterTest()
	public void tearDown() throws IOException, InterruptedException {
		driver.quit();

	}

	public List<WebElement> explicitWait(By locator, int sec) {
		wait = new WebDriverWait(driver, sec);
		List<WebElement> waitALLElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		return waitALLElements;

	}

	public boolean isDisplayed(By locator, int sec) {

		wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return true;

	}

	/*
	 * public static String captureScreenShotRobo(String screenShotName) throws
	 * IOException, HeadlessException, AWTException { String df = new
	 * SimpleDateFormat("yyyyMMddhhss").format(new Date()); String path =
	 * System.getProperty("user.dir") +
	 * "\\Screenshot\\" + screenShotName + df + ".png"; BufferedImage image =
	 * new Robot() .createScreenCapture(new
	 * Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
	 * ImageIO.write(image, "png", new File(path)); return path; }
	 */

	public static String captureScreenshot(String screenShotName, WebDriver driver) throws IOException {
		String df = new SimpleDateFormat("yyyyMMddhhss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);

		String path = System.getProperty("user.dir") + "\\Screenshot\\" + screenShotName + df + ".png";

		File targetFile = new File(path);

		FileUtils.copyFile(src, targetFile);

		return path;

	}

}
