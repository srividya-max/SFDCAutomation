package testcases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import base.BaseTest;
import listeners.TestListeners;
import pages.loginpage;

@Listeners(TestListeners.class)
public class VerifyLoginFunctionality extends BaseTest {
	
	//public loginpage lp = new loginpage(driver);
    public loginpage lp;
	
	@BeforeMethod
	public void CreateReport(Method sTestMethod) {
	test = extent.createTest(sTestMethod.getName());
	}

	@AfterMethod
	public void CloseReport() throws InterruptedException {
		Thread.sleep(1000);
		driver.close();
	}

	/*****************************************Test method 1***************************************************/
	//@Parameters({"BrowserName"})
	//public void VerifyLoginErrorMessage01(String sBrowser) throws IOException{ {
	    @Test()
		public void VerifyLoginErrorMessage01() throws IOException{

		driver = getDriver("chrome");
		lp = new loginpage(driver);
		driver.get(oDataUtils.ReadWebElementProperties("App.URL"));

		sa.assertEquals(driver.getTitle(), "Login | Salesforce");
		test.info("Application is launched");
		
		if (oCommonUtilities.waitForElementVisible(lp.Username))
		oCommonUtilities.enterText(lp.Username, oDataUtils.ReadAccountProperties("prodaccount.name"), "UserName");

		sa.assertNotNull(lp.Username.getText(), "srividya.Mar21@abc.com");
		test.info("Username is Entered");

		
		if (oCommonUtilities.waitForElementVisible(lp.Password)) {
			lp.Password.clear();
			oCommonUtilities.enterText(lp.Password,oDataUtils.ReadAccountProperties("prodaccount.password"), "Password");
			test.info("Password is Empty");
		}

		sa.assertEquals(lp.Password.getText(), "");
		

		if (oCommonUtilities.waitForElementVisible(lp.Login))
			oCommonUtilities.clickonElement(lp.Login, " Login Button");	
		   
		test.info("Clicked on login button"); 
		sa.assertEquals(lp.Errormsg.getText(), oDataUtils.ReadWebElementProperties("login.errormsg"));

		test.info("Error message displayed");
		sa.assertAll();
		
		if (lp.Errormsg.getText().equals(oDataUtils.ReadWebElementProperties("login.errormsg"))) {
			test.pass("PASSED");
		} else {
			//test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail("FAILED");
		}

	}


	/*****************************************Test method 2*****************************************************************/
	//@Parameters({"BrowserName"})
	@Test
	//public void VerifyLoginErrorMessage02(Method mName,String sBrowserName) throws IOException {
	
		public void VerifyLoginErrorMessage02(Method mName) throws IOException {

		driver = getDriver("chrome");
		lp = new loginpage(driver);
		driver.get(oDataUtils.ReadWebElementProperties("App.URL"));

		sa.assertEquals(driver.getTitle(), "Login | Salesforce");

		test.info("Application is launched");

		if (oCommonUtilities.waitForElementVisible(lp.Username))
		oCommonUtilities.enterText(lp.Username, oDataUtils.ReadAccountProperties("prodaccount.name"), "UserName");
        System.out.println("username entered");
		sa.assertNotNull(lp.Username.getText(), "srividya.Mar21@abc.com");
		test.info("Username is Entered");

		//WebElement sPassword = driver.findElement(By.xpath(oDataUtils.ReadWebElementProperties("we.password.xpath")));
		if (oCommonUtilities.waitForElementVisible(lp.Password)) {
			lp.Password.clear();
			oCommonUtilities.enterText(lp.Password, oDataUtils.ReadAccountProperties("prodaccount.password1"), "Password");
		}
		sa.assertEquals(lp.Password.getText(),"Srikar@2011");
		test.info("Password is entered");


		//WebElement sLoginButton = driver.findElement(By.xpath(oDataUtils.ReadWebElementProperties("we.login.xpath")));
		if (oCommonUtilities.waitForElementVisible(lp.Login)) {
			oCommonUtilities.clickonElement(lp.Login, " Login Button");
		}

		sa.assertEquals(driver.getCurrentUrl(), oDataUtils.ReadPageURLproperties("Salesforce.HomePage"));

		
		if (driver.getCurrentUrl().equals(oDataUtils.ReadPageURLproperties("Salesforce.HomePage"))) {

			test.pass(mName.getName()+"PASSED");
		} else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail(mName.getName()+"FAILED");
		}

		sa.assertAll();

	}

}
