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
import jdk.internal.org.jline.utils.Log;
import listeners.TestListeners;
import pages.loginpage;

@Listeners(TestListeners.class)
public class VerifyLoginModule extends BaseTest {

	public loginpage lp;

	@BeforeMethod
	public void CreateReport(Method sTestMethod) throws Exception {
		test = extent.createTest(sTestMethod.getName());
		//oCommonUtilities.loadLog4jProperty();
		
	}

	@AfterMethod
	public void CloseReport() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}

	/*****************************************Testmethod1:ForgotPassword
	 * @throws Exception ***************************************************/
	@SuppressWarnings({ "static-access", "restriction", "restriction" })
	//@Parameters({"BrowserName"})
	//public void VerifyLoginErrorMessage01(String sBrowser) throws IOException{ {
	@Test(priority=2)
	public void VerifyLoginErrorMessage01() throws Exception{
		
		driver = getDriver("chrome");
		lp = new loginpage(driver);
		
		driver.get(oDataUtils.ReadWebElementProperties("App.URL"));

		sa.assertEquals(driver.getTitle(), "Login | Salesforce");
		test.info("Application is launched");
		

		if (oCommonUtilities.waitForElementVisible(lp.Username))
			oCommonUtilities.enterText(lp.Username, oDataUtils.ReadAccountProperties("prodaccount.name"), "UserName");
		
		sa.assertNotNull(lp.Username.getText(), "karthik.test@abc.com");
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
		//Log.info("Error message displayed");
		sa.assertAll();

		if (lp.Errormsg.getText().equals(oDataUtils.ReadWebElementProperties("login.errormsg"))) {
			test.pass("PASSED");
		} else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail("FAILED");
		}

	}


	/*****************************************TestMethod2:Successful login*****************************************************************/
	@SuppressWarnings("static-access")
	@Test(priority=1)
	public void VerifyLoginErrorMessage02(Method mName) throws IOException {

		driver = getDriver("chrome");
		lp = new loginpage(driver);
		driver.get(oDataUtils.ReadWebElementProperties("App.URL"));

		sa.assertEquals(driver.getTitle(), "Login | Salesforce");
		test.info("Application is launched");

		if (oCommonUtilities.waitForElementVisible(lp.Username))
			oCommonUtilities.enterText(lp.Username, oDataUtils.ReadAccountProperties("prodaccount.name"), "UserName");

		sa.assertNotNull(lp.Username.getText(), "karthik.test@abc.com");
		test.info("Username is Entered");

		if (oCommonUtilities.waitForElementVisible(lp.Password)) 
			oCommonUtilities.enterText(lp.Password, oDataUtils.ReadAccountProperties("prodaccount.password1"), "Password");

		sa.assertNotNull(lp.Password.getText(), "Srinidhi@2017");
		test.info("Password is entered");

		if (oCommonUtilities.waitForElementVisible(lp.Login)) 
			oCommonUtilities.clickonElement(lp.Login, " Login Button");

		sa.assertEquals(driver.getCurrentUrl(), oDataUtils.ReadPageURLproperties("Salesforce.HomePage"));
		test.info("Login clicked");

		sa.assertAll();

		if (driver.getCurrentUrl().equals(oDataUtils.ReadPageURLproperties("Salesforce.HomePage"))) {
			test.pass(mName.getName()+"PASSED");
		} else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail(mName.getName()+"FAILED");
		}

	}

	/*****************************************TestMethod3:Remember Me
	 * @throws InterruptedException *****************************************************************/
	@SuppressWarnings("static-access")
	@Test(priority=3)
	public void VerifyLoginErrorMessage03(Method mName) throws IOException, InterruptedException{

		driver = getDriver("chrome");
		lp = new loginpage(driver);
		driver.get(oDataUtils.ReadWebElementProperties("App.URL"));

		sa.assertEquals(driver.getTitle(), "Login | Salesforce");
		test.info("Application is launched");

		if (oCommonUtilities.waitForElementVisible(lp.Username))
			lp.Username.clear();	
		oCommonUtilities.enterText(lp.Username, oDataUtils.ReadAccountProperties("prodaccount.name"), "UserName");

		sa.assertNotNull(lp.Username.getText(), "karthik.test@abc.com");
		test.info("Username is Entered");


		if (oCommonUtilities.waitForElementVisible(lp.Password))
			oCommonUtilities.enterText(lp.Password, oDataUtils.ReadAccountProperties("prodaccount.password1"), "Password");

		sa.assertNotNull(lp.Password.getText(),"Srinidhi@2017");
		test.info("Password is entered");

		if (oCommonUtilities.waitForElementVisible(lp.RememberMe))
			oCommonUtilities.clickonElement(lp.RememberMe, "Remember me checkbox");
		test.info("Remember me checked");


		if (oCommonUtilities.waitForElementVisible(lp.Login)) 
			oCommonUtilities.clickonElement(lp.Login, " Login Button");

		sa.assertEquals(driver.getCurrentUrl(), oDataUtils.ReadPageURLproperties("Salesforce.HomePage"));
		test.info("Login clicked");

		if (oCommonUtilities.waitForElementVisible(lp.Usermenu)) 
			oCommonUtilities.clickonElement(lp.Usermenu, "Clicked on Usermenu");
		test.info("Display the options in UserMenu Tab");

		if (oCommonUtilities.waitForElementVisible(lp.Logout)) 
			oCommonUtilities.clickonElement(lp.Logout, "Clicked on LogOut");

		sa.assertEquals(driver.getCurrentUrl(), oDataUtils.ReadPageURLproperties("Logout.Page"));
		test.info("Click on the logout button");

		sa.assertAll();

		if (driver.getCurrentUrl().equals(oDataUtils.ReadPageURLproperties("Logout.Page"))) {
			test.pass(mName.getName()+"PASSED");
		} else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail(mName.getName()+"FAILED");
		}

	}

	/**************************************Testmethod4 Wrong password**********************************************/
	@SuppressWarnings("static-access")
	@Test(priority=4)
	public void VerifyLoginErrorMessage04(Method mMethod) throws IOException{

		driver = getDriver("chrome");
		lp = new loginpage(driver);
		driver.get(oDataUtils.ReadWebElementProperties("App.URL"));

		sa.assertEquals(driver.getTitle(), "Login | Salesforce");
		test.info("Application is launched");

		if (oCommonUtilities.waitForElementVisible(lp.Username))
			oCommonUtilities.enterText(lp.Username, oDataUtils.ReadAccountProperties("prodaccount.name"), "UserName");

		sa.assertNotNull(lp.Username.getText(), "karthik.test@abc.com");
		test.info("Username is Entered");


		if (oCommonUtilities.waitForElementVisible(lp.Password)) 
			oCommonUtilities.enterText(lp.Password,oDataUtils.ReadAccountProperties("prodaccount.password2"), "Password");
		test.info("Password is Wrong");


		if (oCommonUtilities.waitForElementVisible(lp.Login))
			oCommonUtilities.clickonElement(lp.Login, " Login Button");	

		test.info("Clicked on login button"); 
		sa.assertEquals(lp.Errormsg.getText(), oDataUtils.ReadWebElementProperties("wrongpwd.errormsg"));

		test.info("Error message displayed");
		sa.assertAll();

		if (lp.Errormsg.getText().equals(oDataUtils.ReadWebElementProperties("wrongpwd.errormsg"))) {
			test.pass("PASSED");
		} else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail("FAILED");
		}

	}

	/**************************************Testmethod5 Forgot password**********************************************/
	@SuppressWarnings("static-access")
	@Test(priority=5)
	public void VerifyLoginErrorMessage05(Method mName) throws IOException{

		driver = getDriver("chrome");
		lp = new loginpage(driver);
		driver.get(oDataUtils.ReadWebElementProperties("App.URL"));

		sa.assertEquals(driver.getTitle(), "Login | Salesforce");
		test.info("Application is launched");

		if (oCommonUtilities.waitForElementVisible(lp.Username))
			oCommonUtilities.enterText(lp.Username, oDataUtils.ReadAccountProperties("prodaccount.name"), "UserName");

		sa.assertNotNull(lp.Username.getText(), "karthik.test@abc.com");
		test.info("Username is Entered");

		if (oCommonUtilities.waitForElementVisible(lp.ForgotPwd))
			oCommonUtilities.clickonElement(lp.ForgotPwd, " Forgot password link");
		
		sa.assertEquals(lp.ForgotPwdHeader.getText(), oDataUtils.ReadWebElementProperties("Forgotpwd.header"));
		test.info("Clicked on Forgot password link"); 
		
		if (oCommonUtilities.waitForElementVisible(lp.ForgotPwdUser))
			oCommonUtilities.enterText(lp.ForgotPwdUser, oDataUtils.ReadAccountProperties("prodaccount.name"), "UserName1");

		sa.assertNotNull(lp.ForgotPwdUser.getText(), "karthik.test@abc.com");
		test.info("Username is Re Entered");
		

		if (oCommonUtilities.waitForElementVisible(lp.Continue))
			oCommonUtilities.clickonElement(lp.Continue, " Clicked on continue button");

		test.info("Check your Email"); 
		sa.assertAll();
		
		if (driver.getCurrentUrl().equals(oDataUtils.ReadPageURLproperties("Forgotpwd.Page"))) {
			test.pass(mName.getName()+"PASSED");
		} else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail(mName.getName()+"FAILED");
		}

	}
}
