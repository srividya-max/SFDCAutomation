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
	/*****************************************Testmethod3: Check Recent Contact
	 * @throws AWTException ***************************************************/

	@Test(priority=1)
	public void VerifyContacts03(Method mName) throws IOException, InterruptedException, AWTException{

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
		
		if (oCommonUtilities.waitForElementVisible(cp.RecentlyCreated))
			oCommonUtilities.clickonElement(cp.RecentlyCreated, "Select Recently Created");
		
		sa.assertNotNull(cp.RecentlyCreated.getText(), oDataUtils.ReadWebElementProperties("option.value"));
		test.info("Selected the Recently Created from drop down");
		
		sa.assertAll();

		if (cp.RecentlyCreated.getText().equals (oDataUtils.ReadWebElementProperties("option.value"))) {

			test.pass(mName.getName()+"PASSED");
		} else {
			test.addScreenCaptureFromPath(CommonUtilities.takeScreenshot());
			test.fail(mName.getName()+"FAILED");
		}
		
   }
	/*****************************************Testmethod4: My Contacts Option
	 * @throws AWTException ***************************************************/

	@Test(priority=1)
	public void VerifyContacts04(Method mName) throws IOException, InterruptedException, AWTException{

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
		
		if (oCommonUtilities.waitForElementVisible(cp.MyContacts))
			oCommonUtilities.clickonElement(cp.MyContacts, "Select MyContacts");
		
		sa.assertNotNull(cp.RecentlyCreated.getText(), oDataUtils.ReadWebElementProperties("option.mycontacts"));
		test.info("Selected MyContacts from drop down");
		
		sa.assertAll();

		if (cp.RecentlyCreated.getText().equals (oDataUtils.ReadWebElementProperties("option.mycontacts"))) {

			test.pass(mName.getName()+"PASSED");
		} else {
			test.addScreenCaptureFromPath(CommonUtilities.takeScreenshot());
			test.fail(mName.getName()+"FAILED");
		}
		
  }
	/*****************************************Testmethod5: Recent Contact
	 * @throws AWTException ***************************************************/

	@Test(priority=1)
	public void VerifyContacts05(Method mName) throws IOException, InterruptedException, AWTException{

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
		
		if (oCommonUtilities.waitForElementVisible(cp.RecentContact))
			oCommonUtilities.clickonElement(cp.RecentContact, "Select MyContacts");
		
		sa.assertEquals(driver.getCurrentUrl(), oDataUtils.ReadPageURLproperties("Contacts.Recentlycreated"));
		test.info("Selected MyContacts from drop down");
		
		sa.assertAll();

		if (driver.getCurrentUrl().equals (oDataUtils.ReadPageURLproperties("Contacts.Recentlycreated"))) {

			test.pass(mName.getName()+"PASSED");
		} else {
			test.addScreenCaptureFromPath(CommonUtilities.takeScreenshot());
			test.fail(mName.getName()+"FAILED");
		}
		
  }
	/*****************************************Testmethod6: CreateView Error Message
	 * @throws AWTException ***************************************************/

	@Test(priority=1)
	public void VerifyContacts06(Method mName) throws IOException, InterruptedException, AWTException{

		driver = getDriver("chrome");
		cp = new Contactspage(driver);
		driver.get(oDataUtils.ReadWebElementProperties("App.URL"));
		driver.manage().window().maximize();
		
		Robot r = new Robot();


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
		
		if (oCommonUtilities.waitForElementVisible(cp.CreateNewuniqView))
			oCommonUtilities.clickonElement(cp.CreateNewuniqView, "click on create view link");
		
		//sa.assertNotNull(cp.CreateNewuniqView.getText(), oDataUtils.ReadWebElementProperties("newview.header"));
		test.info("clicked on create new view");
		
		if (oCommonUtilities.waitForElementVisible(cp.NewView))
			oCommonUtilities.enterText(cp.NewView, oDataUtils.ReadAccountProperties("prodaccount.view"), "view unique");
		
		
//		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		if (oCommonUtilities.waitForElementVisible(cp.NewUniqueView))
			oCommonUtilities.enterText(cp.NewUniqueView, oDataUtils.ReadAccountProperties("prodaccount.viewuniquename"), "view unique");
		test.info("Entered the unique name");
		
		if (oCommonUtilities.waitForElementVisible(cp.Save))
			oCommonUtilities.clickonElement(cp.Save, "click on save");
		
		sa.assertNotNull(cp.Errormsg.getText(), oDataUtils.ReadWebElementProperties("error.msg"));
		test.info("triggered the error msg");
		
		sa.assertAll();

		if (cp.Errormsg.getText().equals (oDataUtils.ReadWebElementProperties("error.msg"))) {

			test.pass(mName.getName()+"PASSED");
		} else {
			test.addScreenCaptureFromPath(CommonUtilities.takeScreenshot());
			test.fail(mName.getName()+"FAILED");
		}
	}		
		/*****************************************Testmethod7: Cancel functionality
		 * @throws AWTException ***************************************************/

		@Test(priority=1)
		public void VerifyContacts07(Method mName) throws IOException, InterruptedException, AWTException{

			driver = getDriver("chrome");
			cp = new Contactspage(driver);
			driver.get(oDataUtils.ReadWebElementProperties("App.URL"));
			driver.manage().window().maximize();
			
			Robot r = new Robot();


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
			
			if (oCommonUtilities.waitForElementVisible(cp.CreateNewuniqView))
				oCommonUtilities.clickonElement(cp.CreateNewuniqView, "click on create view link");
			
			//sa.assertNotNull(cp.CreateNewuniqView.getText(), oDataUtils.ReadWebElementProperties("newview.header"));
			test.info("clicked on create new view");
			
			if (oCommonUtilities.waitForElementVisible(cp.NewView))
				oCommonUtilities.enterText(cp.NewView, oDataUtils.ReadAccountProperties("prodaccount.viewcancel"), "view unique");
			
			
//			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			
			if (oCommonUtilities.waitForElementVisible(cp.NewUniqueView))
				cp.NewUniqueView.clear();
				oCommonUtilities.enterText(cp.NewUniqueView, oDataUtils.ReadAccountProperties("prodaccount.viewuniquename"), "view unique");
			test.info("Entered the unique name");
			
			if (oCommonUtilities.waitForElementVisible(cp.Cancel))
				oCommonUtilities.clickonElement(cp.Cancel, "click on save");
			
			sa.assertNotNull(cp.VerifyView.getText(), oDataUtils.ReadWebElementProperties("home.header"));
			test.info("Action is successfully cancelled");
			
			sa.assertAll();

			if (cp.VerifyView.getText().equals (oDataUtils.ReadWebElementProperties("home.header"))) {

				test.pass(mName.getName()+"PASSED");
			} else {
				test.addScreenCaptureFromPath(CommonUtilities.takeScreenshot());
				test.fail(mName.getName()+"FAILED");
			}	
  }
		/*****************************************Testmethod8: new contact save
		 * @throws AWTException ***************************************************/

		@Test(priority=1)
		public void VerifyContacts08(Method mName) throws IOException, InterruptedException, AWTException{

			driver = getDriver("chrome");
			cp = new Contactspage(driver);
			driver.get(oDataUtils.ReadWebElementProperties("App.URL"));
			driver.manage().window().maximize();
			
			Robot r = new Robot();


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
				oCommonUtilities.enterText(cp.LastName, oDataUtils.ReadAccountProperties("prodaccount.contactlastname"), "LastName");
			test.info("Entered the last name");

			if (oCommonUtilities.waitForElementVisible(cp.AccountName)) 
				oCommonUtilities.enterText(cp.AccountName, oDataUtils.ReadAccountProperties("prodaccount.acntname"), "AccountName");
			test.info("Entered the Account name");
			
			
			if (oCommonUtilities.waitForElementVisible(cp.SavenNew)) 
				oCommonUtilities.clickonElement(cp.SavenNew, "Clicked on save n new");
			
			sa.assertEquals(cp.RecentItems.getText(),oDataUtils.ReadAccountProperties("prodaccount.Recentitemname"));
			test.info("New Contact created");
			
			sa.assertAll();

			if (cp.RecentItems.getText().equals (oDataUtils.ReadAccountProperties("prodaccount.Recentitemname"))) {

				test.pass(mName.getName()+"PASSED");
			} else {
				test.addScreenCaptureFromPath(CommonUtilities.takeScreenshot());
				test.fail(mName.getName()+"FAILED");
			}
		}
}


