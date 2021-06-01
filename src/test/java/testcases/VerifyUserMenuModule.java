package testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.UserMenupage;

import base.BaseTest;
import listeners.TestListeners;

@Listeners(TestListeners.class)
public class VerifyUserMenuModule extends BaseTest{

	public UserMenupage um;

	@BeforeMethod
	public void CreateReport(Method sTestMethod) {
		test = extent.createTest(sTestMethod.getName());
	}

	@AfterMethod
	public void CloseReport() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}

	/*****************************************Testmethod1: Select UserMenu***************************************************/
	@SuppressWarnings("static-access")
	@Test(priority=1)
	public void VerifyUserMenu01(Method mName) throws IOException, InterruptedException{

		driver = getDriver("chrome");
		um = new UserMenupage(driver);
		driver.get(oDataUtils.ReadWebElementProperties("App.URL"));

		sa.assertEquals(driver.getTitle(), "Login | Salesforce");
		test.info("Application is launched");

		if (oCommonUtilities.waitForElementVisible(um.Username))
			um.Username.clear();	
		oCommonUtilities.enterText(um.Username, oDataUtils.ReadAccountProperties("prodaccount.name"), "UserName");

		sa.assertNotNull(um.Username.getText(), "karthik.test@abc.com");
		test.info("Username is Entered");


		if (oCommonUtilities.waitForElementVisible(um.Password))
			oCommonUtilities.enterText(um.Password, oDataUtils.ReadAccountProperties("prodaccount.password1"), "Password");

		sa.assertNotNull(um.Password.getText(),"Srinidhi@2017");
		test.info("Password is entered");
		
		if (oCommonUtilities.waitForElementVisible(um.Login)) 
			oCommonUtilities.clickonElement(um.Login, " Login Button");

		sa.assertEquals(driver.getCurrentUrl(), oDataUtils.ReadPageURLproperties("Salesforce.HomePage"));
		test.info("Login clicked");


		if (oCommonUtilities.waitForElementVisible(um.Usermenu)) 
			oCommonUtilities.clickonElement(um.Usermenu, "Clicked on Usermenu");
		test.info("Display the options in UserMenu Tab");
		
		sa.assertAll();

		if(um.Devconsole.getText().equals(oDataUtils.ReadWebElementProperties("UserMenu3"))){
			test.pass("PASSED");
		} else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail("FAILED");
		}
 
	}

	/*****************************************Testmethod2: Developer Console***************************************************/
	@SuppressWarnings("static-access")
	@Test(priority=2)
	public void VerifyUserMenu02(Method mName) throws IOException, InterruptedException{

		driver = getDriver("chrome");
		um = new UserMenupage(driver);
		driver.get(oDataUtils.ReadWebElementProperties("App.URL"));

		sa.assertEquals(driver.getTitle(), "Login | Salesforce");
		test.info("Application is launched");

		if (oCommonUtilities.waitForElementVisible(um.Username))
			um.Username.clear();	
		oCommonUtilities.enterText(um.Username, oDataUtils.ReadAccountProperties("prodaccount.name"), "UserName");

		sa.assertNotNull(um.Username.getText(), "karthik.test@abc.com");
		test.info("Username is Entered");


		if (oCommonUtilities.waitForElementVisible(um.Password))
			oCommonUtilities.enterText(um.Password, oDataUtils.ReadAccountProperties("prodaccount.password1"), "Password");

		sa.assertNotNull(um.Password.getText(),"Srinidhi@2017");
		test.info("Password is entered");
		
		if (oCommonUtilities.waitForElementVisible(um.Login)) 
			oCommonUtilities.clickonElement(um.Login, " Login Button");

		sa.assertEquals(driver.getCurrentUrl(), oDataUtils.ReadPageURLproperties("Salesforce.HomePage"));
		test.info("Login clicked");


		if (oCommonUtilities.waitForElementVisible(um.Usermenu)) 
			oCommonUtilities.clickonElement(um.Usermenu, "Clicked on Usermenu");
		
		test.info("Display the options in UserMenu Tab");
		sa.assertEquals(um.Devconsole.getText(),oDataUtils.ReadWebElementProperties("UserMenu3"));
		
		if (oCommonUtilities.waitForElementVisible(um.Devconsole)) 
			oCommonUtilities.clickonElement(um.Devconsole, "Clicked on Developer Console");
		
		Thread.sleep(3000);
		test.info("Display the Developer Console Window");
		
		String mainWindowHandle = driver.getWindowHandle();		
		Set<String> sWindow = driver.getWindowHandles();
		System.out.println("Child window handle is" + sWindow);
		Iterator<String> it = sWindow.iterator();

		while (it.hasNext()) {
			String ChildWindow = it.next();
			if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				driver.close();
				System.out.println("Child window closed");
			}
		} 
		driver.switchTo().window(mainWindowHandle);

		sa.assertAll();
		
		if(um.Setup.getText().equals(oDataUtils.ReadWebElementProperties("Setup"))){
			test.pass("PASSED");
		} else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail("FAILED");
		}
 
	}

	/*****************************************Testmethod3: Logout***************************************************/
	@SuppressWarnings("static-access")
	@Test(priority=0)
	public void VerifyUserMenu03(Method mName) throws IOException, InterruptedException{

		driver = getDriver("chrome");
		um = new UserMenupage(driver);
		driver.get(oDataUtils.ReadWebElementProperties("App.URL"));
		driver.manage().window().maximize();

		sa.assertEquals(driver.getTitle(), "Login | Salesforce");
		test.info("Application is launched");

		if (oCommonUtilities.waitForElementVisible(um.Username))
			um.Username.clear();	
		oCommonUtilities.enterText(um.Username, oDataUtils.ReadAccountProperties("prodaccount.name"), "UserName");

		sa.assertNotNull(um.Username.getText(), "karthik.test@abc.com");
		test.info("Username is Entered");


		if (oCommonUtilities.waitForElementVisible(um.Password))
			oCommonUtilities.enterText(um.Password, oDataUtils.ReadAccountProperties("prodaccount.password1"), "Password");

		sa.assertNotNull(um.Password.getText(),"Srinidhi@2017");
		test.info("Password is entered");
		
		if (oCommonUtilities.waitForElementVisible(um.Login)) 
			oCommonUtilities.clickonElement(um.Login, " Login Button");

		sa.assertEquals(driver.getCurrentUrl(), oDataUtils.ReadPageURLproperties("Salesforce.HomePage"));
		test.info("Login clicked");


		if (oCommonUtilities.waitForElementVisible(um.Usermenu)) 
			oCommonUtilities.clickonElement(um.Usermenu, "Clicked on Usermenu");
		
		test.info("Display the options in UserMenu Tab");
		sa.assertEquals(um.Devconsole.getText(),oDataUtils.ReadWebElementProperties("UserMenu3"));
		
		if (oCommonUtilities.waitForElementVisible(um.Logout)) 
			oCommonUtilities.clickonElement(um.Logout, "Clicked on Logout");
		
		test.info("Logged out of salesforce");
		

		sa.assertAll();
		
		if(driver.getCurrentUrl().equals(oDataUtils.ReadPageURLproperties("Logout.URL"))){
			test.pass("PASSED");
		} else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail("FAILED");
		}
 
	}

	/*****************************************Testmethod4: MySettings***************************************************/
	@SuppressWarnings("static-access")
	@Test(priority=4)
	public void VerifyUserMenu04(Method mName) throws IOException, InterruptedException{

		driver = getDriver("chrome");
		um = new UserMenupage(driver);
		driver.get(oDataUtils.ReadWebElementProperties("App.URL"));
		driver.manage().window().maximize();

		sa.assertEquals(driver.getTitle(), "Login | Salesforce");
		test.info("Application is launched");

		if (oCommonUtilities.waitForElementVisible(um.Username))
			um.Username.clear();	
		oCommonUtilities.enterText(um.Username, oDataUtils.ReadAccountProperties("prodaccount.name"), "UserName");

		sa.assertNotNull(um.Username.getText(), "karthik.test@abc.com");
		test.info("Username is Entered");


		if (oCommonUtilities.waitForElementVisible(um.Password))
			oCommonUtilities.enterText(um.Password, oDataUtils.ReadAccountProperties("prodaccount.password1"), "Password");

		sa.assertNotNull(um.Password.getText(),"Srinidhi@2017");
		test.info("Password is entered");
		
		if (oCommonUtilities.waitForElementVisible(um.Login)) 
			oCommonUtilities.clickonElement(um.Login, " Login Button");

		sa.assertEquals(driver.getCurrentUrl(), oDataUtils.ReadPageURLproperties("Salesforce.HomePage"));
		test.info("Login clicked");


		if (oCommonUtilities.waitForElementVisible(um.Usermenu)) 
			oCommonUtilities.clickonElement(um.Usermenu, "Clicked on Usermenu");
		
		test.info("Display the options in UserMenu Tab");
		
		if (oCommonUtilities.waitForElementVisible(um.Mysettings)) 
			oCommonUtilities.clickonElement(um.Mysettings, "Clicked on Mysettings");
		
		test.info("Open the Mysettings page");
		sa.assertEquals(driver.getCurrentUrl(), oDataUtils.ReadPageURLproperties("Mysettings.URL"));
		
		
		if (oCommonUtilities.waitForElementVisible(um.Personal)) 
			oCommonUtilities.clickonElement(um.Personal, "Clicked on Personal link");
		
		test.info("Open the Mysettings page");

		if (oCommonUtilities.waitForElementVisible(um.LoginHistory)) 
			oCommonUtilities.clickonElement(um.LoginHistory, "Clicked on Login History");
		
		test.info("Clicked on Login History");
		sa.assertEquals(um.LoginHistory.getText(), oDataUtils.ReadWebElementProperties("loginhistory.header"));
		

		if (oCommonUtilities.waitForElementVisible(um.DisplayandLayout)) 
			oCommonUtilities.clickonElement(um.DisplayandLayout, "Clicked on Display And Layout Link");
		
		test.info("Clicked on Display And Layout Link");
		
		if (oCommonUtilities.waitForElementVisible(um.Customizetab)) 
			oCommonUtilities.clickonElement(um.Customizetab, "Clicked on Customize My Tab");

		test.info("Clicked on Customize My Tab");

		if (oCommonUtilities.waitForElementVisible(um.CustomApp)) 
			oCommonUtilities.clickonElement(um.CustomApp, "Clicked on CustomApp Link");
		
		test.info("Clicked on CustomApp Link");
		sa.assertEquals(driver.getCurrentUrl(), oDataUtils.ReadPageURLproperties("DisplayLayout.URL"));
		
		
		if (oCommonUtilities.waitForElementVisible(um.CustomList)) 
			oCommonUtilities.clickonElement(um.CustomList, "Clicked on Custom List Dropdown");

		test.info("Clicked on Custom List Dropdown");

		if (oCommonUtilities.waitForElementVisible(um.SfChatter)) 
			oCommonUtilities.clickonElement(um.SfChatter, "Selected salesforce Chatter option");

		test.info("Selected salesforce Chatter option");
		sa.assertEquals(um.SfChatter.getText(), oDataUtils.ReadWebElementProperties("customapp.option"));
		

		if (oCommonUtilities.waitForElementVisible(um.Reports)) 
			oCommonUtilities.clickonElement(um.Reports, "Selected Reports option");

		test.info("Selected Reports option");
		sa.assertEquals(um.Reports.getText(), oDataUtils.ReadWebElementProperties("Availabletabs.option"));
		

		if (oCommonUtilities.waitForElementVisible(um.Add)) 
			oCommonUtilities.clickonElement(um.Add, "Added Reports");

		test.info("Clicked on Add");
		
		if (oCommonUtilities.waitForElementVisible(um.Email)) 
			oCommonUtilities.clickonElement(um.Email, "Selected Email");

		test.info("Selected Email option");
		
		if (oCommonUtilities.waitForElementVisible(um.MyEmail)) 
			oCommonUtilities.clickonElement(um.MyEmail, "Selected My Email Settings");

		test.info("Selected My Email Settings option");
		sa.assertEquals(driver.getCurrentUrl(), oDataUtils.ReadPageURLproperties("Emailsettings.page"));
		

		if (oCommonUtilities.waitForElementVisible(um.CalandRem)) 
			oCommonUtilities.clickonElement(um.CalandRem, "Selected calendar and Reminder");

		test.info("Selected calendar and Reminder");
		
		if (oCommonUtilities.waitForElementVisible(um.ActivityReminder)) 
			oCommonUtilities.clickonElement(um.ActivityReminder, "Selected the Activity Reminder option");

		test.info("Selected the Activity Reminder option");
		sa.assertEquals(driver.getCurrentUrl(), oDataUtils.ReadPageURLproperties("CalendernReminder.URL"));
		
		
		if (oCommonUtilities.waitForElementVisible(um.TestRemButton)) 
			oCommonUtilities.clickonElement(um.TestRemButton, "Selected the Activity Reminder option");
		
		test.info("Clicked on Open a Test Reminder button");
		
		Thread.sleep(3000);
		
		String mainWindowHandle = driver.getWindowHandle();		
		Set<String> sWindow = driver.getWindowHandles();
		System.out.println("Child window handle is" + sWindow);
		Iterator<String> it = sWindow.iterator();

		while (it.hasNext()) {
			String ChildWindow = it.next();
			if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				driver.close();
				System.out.println("Child window closed");
			}
		} 
		driver.switchTo().window(mainWindowHandle);
		
		sa.assertAll();
		
		
		if(driver.getCurrentUrl().equals(oDataUtils.ReadPageURLproperties("CalendernReminder.URL"))){
			test.pass("PASSED");
		} else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail("FAILED");
		}
 
	}

}
