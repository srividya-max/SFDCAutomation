package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import base.BaseTest;

public class CommonUtilities  {
	
//	Properties prop = new Properties();
//	FileInputStream fileIn = null;
//	Logger log = Logger.getLogger(getClass().getSimpleName());
//	
//	public  void loadLog4jProperty() throws Exception{
//		
//		fileIn = new FileInputStream(System.getProperty("user.dir")+"/resources/config/log4j.properties");
//		prop.load(fileIn);
//		PropertyConfigurator.configure(prop);
//	}


	public void enterText(WebElement element, String textToEnter, String elementName) {
		if (element.isDisplayed()) {
			element.sendKeys(textToEnter);
			BaseTest.test.log(Status.INFO, elementName + " is entered");
		} else
			BaseTest.test.log(Status.FAIL, elementName + " is not displayed");
	}

	public void clickonElement(WebElement element, String elementName) {
		element.click();
		BaseTest.test.log(Status.INFO, elementName + " is clicked");
	}

	public void verifyText(String ActualText, String ExpectedText, String msg) throws IOException {
		if (ActualText.equals(ExpectedText)) {
			BaseTest.test.pass(msg + "is verified successfully");
		} else {
			BaseTest.test.fail(msg + " verification is failed");
			//			BaseTest.test.addScreenCaptureFromPath(takeScreenshot());
		}
	}

	public boolean waitForElementVisible(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(BaseTest.driver, 50);
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static String takeScreenshot() throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) BaseTest.driver;
		String addDate = new SimpleDateFormat("yyyymmddhhmm").format(new Date());
		String destinationPath = System.getProperty("user.dir")+"\\Reports\\Screenshots\\" + addDate + ".PNG";
		File srcfile = screenshot.getScreenshotAs(OutputType.FILE);
		File dstfile = new File(destinationPath);
		FileUtils.copyFile(srcfile, dstfile);
		return destinationPath;
	}

	public void verifyUsermenu(String ElementXapth) throws IOException {
		List<WebElement> userMenuItems = BaseTest.driver.findElements(By.xpath(ElementXapth));
		String[] ExpectedmenuItems = { "My Profile", "My Settings", "Developer Console",
				"Switch to Lightning Experience", "Logout" };

		for (int i = 0; i < userMenuItems.size(); i++) {
			Assert.assertEquals(userMenuItems.get(i).getText(), ExpectedmenuItems[i]);
			BaseTest.test.log(Status.INFO, ExpectedmenuItems[i] + " is Verified");
		}
	}
	


}