package testcases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;

public class VerifyLoginFunctionality extends BaseTest {
	
		@BeforeMethod
		public void CreateReport(Method sTestMethod) {
			test = extent.createTest(sTestMethod.getName());
		}

		@AfterMethod
		public void CloseReport() throws InterruptedException {
			Thread.sleep(1000);
			driver.close();
		}
		
		@Test()
		public void VerifyLoginErrorMessage01() throws IOException {
			driver = getDriver("Chrome");
			driver.get(oDataUtils.ReadWebElementProperties("App.URL"));

			sa.assertEquals(driver.getTitle(), "Login | Salesforce");

			test.info("Application is launched");

		WebElement sUserName = driver.findElement(By.xpath(oDataUtils.ReadWebElementProperties("we.username.xpath")));
			if (oCommonUtilities.waitForElementVisible(sUserName))
				oCommonUtilities.enterText(sUserName, oDataUtils.ReadAccountProperties("prodaccount.name"), "UserName");
			sa.assertNotNull(sUserName.getText(), "srividya.Mar21@abc.com");
			test.info("Username is Entered");

			WebElement sPassword = driver.findElement(By.xpath(oDataUtils.ReadWebElementProperties("we.password.xpath")));
			if (oCommonUtilities.waitForElementVisible(sPassword)) {
				sPassword.clear();
				test.info("Password is Empty");
			}

			sa.assertEquals(sPassword.getText(), "");

			WebElement sLoginButton = driver.findElement(By.xpath(oDataUtils.ReadWebElementProperties("we.login.xpath")));

			if (oCommonUtilities.waitForElementVisible(sLoginButton))
				oCommonUtilities.clickonElement(sLoginButton, " Login Button");

			WebElement sErrorMsg = driver.findElement(By.xpath(oDataUtils.ReadWebElementProperties("we.errormsg.xpath")));

			sa.assertEquals(sErrorMsg.getText(), oDataUtils.ReadWebElementProperties("login.errormsg"));

			sa.assertAll();
			if (sErrorMsg.getText().equals(oDataUtils.ReadWebElementProperties("login.errormsg"))) {

				test.pass("TC01 Passed");
			} else {
				test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
				test.fail("TC01 FAILED");
			}

		}

}
