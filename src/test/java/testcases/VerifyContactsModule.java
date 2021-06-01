package testcases;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.Contactspage;
import utilities.CommonUtilities;
import base.BaseTest;
import listeners.TestListeners;

@Listeners(TestListeners.class)
public class VerifyContactsModule extends BaseTest{

	public Contactspage cp;

	@BeforeMethod
	public void CreateReport(Method sTestMethod) {
		test = extent.createTest(sTestMethod.getName());
	}

	@AfterMethod
	public void CloseReport() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}

	/*****************************************Testmethod1: Create New Contact
	 * @throws AWTException ***************************************************/

	@Test(priority=1)
	public void VerifyContacts01(Method mName) throws IOException, InterruptedException, AWTException{

		driver = getDriver("chrome");
		cp = new Contactspage(driver);
		driver.get(oDataUtils.ReadWebElementProperties("App.URL"));
		driver.manage().window().maximize();


		sa.assertEquals(driver.getTitle(), "Login | Salesforce");
		test.info("Application is launched");

		if (oCommonUtilities.waitForElementVisible(cp.Username))
			oCommonUtilities.enterText(cp.Username, oDataUtils.ReadAccountProperties("prodaccount.name"), "UserName");

		sa.assertNotNull(cp.Username.getText(), "karthik.test@abc.com");
		test.info("Username is Entered");

		if (oCommonUtilities.waitForElementVisible(cp.Password)) 
			oCommonUtilities.enterText(cp.Password, oDataUtils.ReadAccountProperties("prodaccount.password1"), "Password");

		sa.assertNotNull(cp.Password.getText(), "Srinidhi@2017");
		test.info("Password is entered");

		if (oCommonUtilities.waitForElementVisible(cp.Login)) 
			oCommonUtilities.clickonElement(cp.Login, " Login Button");

		sa.assertEquals(driver.getCurrentUrl(), oDataUtils.ReadPageURLproperties("Salesforce.HomePage"));
		test.info("Login clicked");

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		if (oCommonUtilities.waitForElementVisible(cp.Contacts)) 
			oCommonUtilities.clickonElement(cp.Contacts, "Clicked on contacts Tab");		

		sa.assertNotNull(cp.Contacts.getText(), oDataUtils.ReadWebElementProperties("Contacts.tab"));
		test.info("Clicked on Accounts Tab");
		
		if (oCommonUtilities.waitForElementVisible(cp.NewButton)) 
			oCommonUtilities.clickonElement(cp.NewButton, "Clicked on contacts Tab");
		
		sa.assertNotNull(cp.NewContat.getText(), oDataUtils.ReadWebElementProperties("newcontact.header"));
		test.info("Clicked on New");
		
		
		if (oCommonUtilities.waitForElementVisible(cp.LastName)) 
			oCommonUtilities.enterText(cp.LastName, oDataUtils.ReadAccountProperties("prodaccount.lastname"), "LastName");
		test.info("Entered the last name");
		
		if (oCommonUtilities.waitForElementVisible(cp.SaveButton)) 
			oCommonUtilities.clickonElement(cp.SaveButton, "Clicked on save");
		
		sa.assertEquals(cp.Contactheader.getText(),oDataUtils.ReadAccountProperties("prodaccount.lastname"));
		test.info("New Contact created");
		
		sa.assertAll();

		if (cp.Contactheader.getText().equals (oDataUtils.ReadAccountProperties("prodaccount.lastname"))) {

			test.pass(mName.getName()+"PASSED");
		} else {
			test.addScreenCaptureFromPath(CommonUtilities.takeScreenshot());
			test.fail(mName.getName()+"FAILED");
		}
		
   }
	/*****************************************Testmethod2: Create New View
	 * @throws AWTException ***************************************************/

	@Test(priority=1)
	public void VerifyContacts02(Method mName) throws IOException, InterruptedException, AWTException{

		driver = getDriver("chrome");
		cp = new Contactspage(driver);
		driver.get(oDataUtils.ReadWebElementProperties("App.URL"));
		driver.manage().window().maximize();


		sa.assertEquals(driver.getTitle(), "Login | Salesforce");
		test.info("Application is launched");

		if (oCommonUtilities.waitForElementVisible(cp.Username))
			oCommonUtilities.enterText(cp.Username, oDataUtils.ReadAccountProperties("prodaccount.name"), "UserName");

		sa.assertNotNull(cp.Username.getText(), "karthik.test@abc.com");
		test.info("Username is Entered");

		if (oCommonUtilities.waitForElementVisible(cp.Password)) 
			oCommonUtilities.enterText(cp.Password, oDataUtils.ReadAccountProperties("prodaccount.password1"), "Password");

		sa.assertNotNull(cp.Password.getText(), "Srinidhi@2017");
		test.info("Password is entered");

		if (oCommonUtilities.waitForElementVisible(cp.Login)) 
			oCommonUtilities.clickonElement(cp.Login, " Login Button");

		sa.assertEquals(driver.getCurrentUrl(), oDataUtils.ReadPageURLproperties("Salesforce.HomePage"));
		test.info("Login clicked");

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		if (oCommonUtilities.waitForElementVisible(cp.Contacts)) 
			oCommonUtilities.clickonElement(cp.Contacts, "Clicked on contacts Tab");		

		sa.assertNotNull(cp.Contacts.getText(), oDataUtils.ReadWebElementProperties("Contacts.tab"));
		test.info("Clicked on Accounts Tab");
		
		if (oCommonUtilities.waitForElementVisible(cp.CreateNewView)) 
			oCommonUtilities.clickonElement(cp.CreateNewView, "Clicked on contacts Tab");
		
		sa.assertNotNull(cp.ViewHeader.getText(), oDataUtils.ReadWebElementProperties("newview.header"));
		test.info("Clicked on view for Contact");
		
		if (oCommonUtilities.waitForElementVisible(cp.NewView)) 
			oCommonUtilities.enterText(cp.NewView, oDataUtils.ReadAccountProperties("prodaccount.contname"), "contactview");
		test.info("Entered the view name");
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		if (oCommonUtilities.waitForElementVisible(cp.NewUniqueView)) 
			oCommonUtilities.clickonElement(cp.NewUniqueView, "Clicked on contacts Tab");
			//cp.NewUniqueView.clear();
		//
		//	oCommonUtilities.enterText(cp.NewUniqueView, oDataUtils.ReadAccountProperties("prodaccount.contuqname"), "contactuniquename");
		test.info("Entered the unique name");
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		if (oCommonUtilities.waitForElementVisible(cp.Save)) 
			oCommonUtilities.clickonElement(cp.Save, "Clicked on save");
		
		
		sa.assertNotNull(cp.VerifyView.getText(), oDataUtils.ReadWebElementProperties("home.header"));		
		test.info("New View Created");
		
		System.out.println(cp.VerifyView.getText());
		System.out.println((oDataUtils.ReadAccountProperties("prodaccount.contactview")));

		
		sa.assertAll();

		if (cp.VerifyView.getText().equals (oDataUtils.ReadWebElementProperties("home.header"))) {

			test.pass(mName.getName()+"PASSED");
		} else {
			test.addScreenCaptureFromPath(CommonUtilities.takeScreenshot());
			test.fail(mName.getName()+"FAILED");
		}
		
   }
}


