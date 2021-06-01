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

import pages.Accountspage;

import base.BaseTest;
import listeners.TestListeners;

@Listeners(TestListeners.class)
public class VerifyAccountsModule extends BaseTest{

	public Accountspage ac;

	@BeforeMethod
	public void CreateReport(Method sTestMethod) {
		test = extent.createTest(sTestMethod.getName());
	}

	@AfterMethod
	public void CloseReport() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}

	/*****************************************Testmethod1: Create New Account
	 * @throws AWTException ***************************************************/
	@SuppressWarnings("static-access")
	@Test(priority=1)
	public void VerifyAccounts01(Method mName) throws IOException, InterruptedException, AWTException{

		driver = getDriver("chrome");
		ac = new Accountspage(driver);
		driver.get(oDataUtils.ReadWebElementProperties("App.URL"));
		driver.manage().window().maximize();


		sa.assertEquals(driver.getTitle(), "Login | Salesforce");
		test.info("Application is launched");

		if (oCommonUtilities.waitForElementVisible(ac.Username))
			oCommonUtilities.enterText(ac.Username, oDataUtils.ReadAccountProperties("prodaccount.name"), "UserName");

		sa.assertNotNull(ac.Username.getText(), "karthik.test@abc.com");
		test.info("Username is Entered");

		if (oCommonUtilities.waitForElementVisible(ac.Password)) 
			oCommonUtilities.enterText(ac.Password, oDataUtils.ReadAccountProperties("prodaccount.password1"), "Password");

		sa.assertNotNull(ac.Password.getText(), "Srinidhi@2017");
		test.info("Password is entered");

		if (oCommonUtilities.waitForElementVisible(ac.Login)) 
			oCommonUtilities.clickonElement(ac.Login, " Login Button");

		sa.assertEquals(driver.getCurrentUrl(), oDataUtils.ReadPageURLproperties("Salesforce.HomePage"));
		test.info("Login clicked");

		Thread.sleep(3000);

		if (oCommonUtilities.waitForElementVisible(ac.Accounts)) 
			oCommonUtilities.clickonElement(ac.Accounts, "Clicked on Accounts Tab");		


		sa.assertNotNull(ac.Accounts.getText(), oDataUtils.ReadWebElementProperties("Account.tab"));
		test.info("Clicked on Accounts Tab");


		if (oCommonUtilities.waitForElementVisible(ac.NewButton)) 
			oCommonUtilities.clickonElement(ac.NewButton, "Clicked on New Button");

		test.info("Clicked on New Button");

		if (oCommonUtilities.waitForElementVisible(ac.AccountName)) 
			oCommonUtilities.enterText(ac.AccountName, oDataUtils.ReadAccountProperties("prodaccount.AccountName"), "AccountName");

		test.info("Entered AccountName");

		if (oCommonUtilities.waitForElementVisible(ac.Type)) 
			oCommonUtilities.clickonElement(ac.Type, "Clicked on Type");

		test.info("Clicked on Type");


		if (oCommonUtilities.waitForElementVisible(ac.TechnologyPartner)) 
			oCommonUtilities.clickonElement(ac.TechnologyPartner, "Clicked on Type");

		sa.assertEquals(ac.TechnologyPartner.getText(),oDataUtils.ReadWebElementProperties("Type.option"));
		test.info("Clicked on Type");

		Thread.sleep(3000);

		if (oCommonUtilities.waitForElementVisible(ac.SaveButton)) 
			oCommonUtilities.clickonElement(ac.SaveButton, "Clicked on Save Button");

		//sa.assertEquals(ac.myact.getText(),oDataUtils.ReadAccountProperties("prodaccount.AccountName"));
		test.info("Clicked on Save Button");


		sa.assertAll();

		if (ac.myact.getText().equals(oDataUtils.ReadAccountProperties("prodaccount.AccountName"))) {
			test.pass(mName.getName()+"PASSED");
		} else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail(mName.getName()+"FAILED");
		}
	}


	/*****************************************Testmethod2: Create New View
	 * @throws AWTException ***************************************************/
	@SuppressWarnings("static-access")
	@Test(priority=2)
	public void VerifyAccounts02(Method mName) throws IOException, InterruptedException, AWTException{

		driver = getDriver("chrome");
		ac = new Accountspage(driver);
		driver.get(oDataUtils.ReadWebElementProperties("App.URL"));
		driver.manage().window().maximize();


		sa.assertEquals(driver.getTitle(), "Login | Salesforce");
		test.info("Application is launched");

		if (oCommonUtilities.waitForElementVisible(ac.Username))
			oCommonUtilities.enterText(ac.Username, oDataUtils.ReadAccountProperties("prodaccount.name"), "UserName");

		sa.assertNotNull(ac.Username.getText(), "karthik.test@abc.com");
		test.info("Username is Entered");

		if (oCommonUtilities.waitForElementVisible(ac.Password)) 
			oCommonUtilities.enterText(ac.Password, oDataUtils.ReadAccountProperties("prodaccount.password1"), "Password");

		sa.assertNotNull(ac.Password.getText(), "Srinidhi@2017");
		test.info("Password is entered");

		if (oCommonUtilities.waitForElementVisible(ac.Login)) 
			oCommonUtilities.clickonElement(ac.Login, " Login Button");

		sa.assertEquals(driver.getCurrentUrl(), oDataUtils.ReadPageURLproperties("Salesforce.HomePage"));
		test.info("Login clicked");

		Thread.sleep(3000);

		if (oCommonUtilities.waitForElementVisible(ac.Accounts)) 
			oCommonUtilities.clickonElement(ac.Accounts, "Clicked on Accounts Tab");		


		sa.assertNotNull(ac.Accounts.getText(), oDataUtils.ReadWebElementProperties("Account.tab"));
		test.info("Clicked on Accounts Tab");


		if (oCommonUtilities.waitForElementVisible(ac.CreateNewView))
			oCommonUtilities.clickonElement(ac.CreateNewView, "Clicked on create new View");

		sa.assertEquals(ac.Accountheader.getText(), oDataUtils.ReadWebElementProperties("Newview.header"));
		test.info("Clicked on create new View");


		if (oCommonUtilities.waitForElementVisible(ac.NewView))
			oCommonUtilities.enterText(ac.NewView, oDataUtils.ReadAccountProperties("prodaccount.ViewName"), "ViewName");

		test.info("Entered new View name");


		if (oCommonUtilities.waitForElementVisible(ac.NewUniqueView)) 
			oCommonUtilities.clickonElement(ac.NewUniqueView, "Clicked on create new uq View");
		Thread.sleep(1000);
		ac.NewUniqueView.clear();
		oCommonUtilities.enterText(ac.NewUniqueView, oDataUtils.ReadAccountProperties("prodaccount.ViewUniqueName"), "ViewUqName");

		test.info("Unique name populated");

		Thread.sleep(2000);

		if (oCommonUtilities.waitForElementVisible(ac.Save)) 
			oCommonUtilities.clickonElement(ac.Save, "Clicked on save");

		sa.assertEquals(ac.VerifyView.getText(),oDataUtils.ReadWebElementProperties("Accounts.verify"));


		sa.assertAll();

		if (ac.VerifyView.getText().equals(oDataUtils.ReadWebElementProperties("Accounts.verify"))) {

			test.pass(mName.getName()+"PASSED");
		} else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail(mName.getName()+"FAILED");
		}


	}

	/*****************************************Testmethod3: Edit View
	 * @throws AWTException ***************************************************/
	@SuppressWarnings("static-access")
	@Test(priority=3)
	public void VerifyAccounts03(Method mName) throws IOException, InterruptedException, AWTException{

		driver = getDriver("chrome");
		ac = new Accountspage(driver);
		driver.get(oDataUtils.ReadWebElementProperties("App.URL"));
		driver.manage().window().maximize();


		sa.assertEquals(driver.getTitle(), "Login | Salesforce");
		test.info("Application is launched");

		if (oCommonUtilities.waitForElementVisible(ac.Username))
			oCommonUtilities.enterText(ac.Username, oDataUtils.ReadAccountProperties("prodaccount.name"), "UserName");

		sa.assertNotNull(ac.Username.getText(), "karthik.test@abc.com");
		test.info("Username is Entered");

		if (oCommonUtilities.waitForElementVisible(ac.Password)) 
			oCommonUtilities.enterText(ac.Password, oDataUtils.ReadAccountProperties("prodaccount.password1"), "Password");

		sa.assertNotNull(ac.Password.getText(), "Srinidhi@2017");
		test.info("Password is entered");

		if (oCommonUtilities.waitForElementVisible(ac.Login)) 
			oCommonUtilities.clickonElement(ac.Login, " Login Button");

		sa.assertEquals(driver.getCurrentUrl(), oDataUtils.ReadPageURLproperties("Salesforce.HomePage"));
		test.info("Login clicked");

		Thread.sleep(3000);

		if (oCommonUtilities.waitForElementVisible(ac.Accounts)) 
			oCommonUtilities.clickonElement(ac.Accounts, "Clicked on Accounts Tab");		

		sa.assertNotNull(ac.Accounts.getText(), oDataUtils.ReadWebElementProperties("Account.tab"));
		test.info("Clicked on Accounts Tab");

		Thread.sleep(3000);
		if (oCommonUtilities.waitForElementVisible(ac.EditView))
			oCommonUtilities.clickonElement(ac.EditView, "Clicked on Edit View");

		test.info("Clicked on Edit");


		if (oCommonUtilities.waitForElementVisible(ac.NewView))
			ac.NewView.clear();
		oCommonUtilities.enterText(ac.NewView, oDataUtils.ReadAccountProperties("prodaccount.NewViewName"), "NewViewName");

		test.info("Entered new View name");

		if (oCommonUtilities.waitForElementVisible(ac.NewUniqueView))
			//ac.NewUniqueView.clear();
			oCommonUtilities.clickonElement(ac.NewUniqueView, "Clicked on create new uq View");

		Thread.sleep(2000);

		if (oCommonUtilities.waitForElementVisible(ac.Field))
			oCommonUtilities.clickonElement(ac.Field, "Select the field option");

		test.info("Selected Account Name option");

		if (oCommonUtilities.waitForElementVisible(ac.Operator))
			oCommonUtilities.clickonElement(ac.Operator, "Select the operator option");


		//sa.assertEquals(ac.Operator.getText(),oDataUtils.ReadWebElementProperties("Operator.value"));
		test.info("Selected the operator");

		if (oCommonUtilities.waitForElementVisible(ac.Contains))
			ac.Contains.clear();
		oCommonUtilities.enterText(ac.Contains, oDataUtils.ReadWebElementProperties("contains.value"), "contains");

		test.info("Entered the value 'a'");



		if (oCommonUtilities.waitForElementVisible(ac.Save)) 
			oCommonUtilities.clickonElement(ac.Save, "Clicked on save");

		sa.assertEquals(ac.VerifyView.getText(),oDataUtils.ReadWebElementProperties("Accounts.verify"));


		sa.assertAll();

		if (ac.VerifyView.getText().equals(oDataUtils.ReadWebElementProperties("Accounts.verify"))) {

			test.pass(mName.getName()+"PASSED");
		} else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail(mName.getName()+"FAILED");
		}


	}

	/*****************************************Testmethod4: Merge Accounts
	 * @throws AWTException ***************************************************/
	@SuppressWarnings("static-access")
	@Test(priority=4)
	public void VerifyAccounts04(Method mName) throws IOException, InterruptedException, AWTException{

		driver = getDriver("chrome");
		ac = new Accountspage(driver);
		driver.get(oDataUtils.ReadWebElementProperties("App.URL"));
		driver.manage().window().maximize();


		sa.assertEquals(driver.getTitle(), "Login | Salesforce");
		test.info("Application is launched");

		if (oCommonUtilities.waitForElementVisible(ac.Username))
			oCommonUtilities.enterText(ac.Username, oDataUtils.ReadAccountProperties("prodaccount.name"), "UserName");

		sa.assertNotNull(ac.Username.getText(), "karthik.test@abc.com");
		test.info("Username is Entered");

		if (oCommonUtilities.waitForElementVisible(ac.Password)) 
			oCommonUtilities.enterText(ac.Password, oDataUtils.ReadAccountProperties("prodaccount.password1"), "Password");

		sa.assertNotNull(ac.Password.getText(), "Srinidhi@2017");
		test.info("Password is entered");

		if (oCommonUtilities.waitForElementVisible(ac.Login)) 
			oCommonUtilities.clickonElement(ac.Login, " Login Button");

		sa.assertEquals(driver.getCurrentUrl(), oDataUtils.ReadPageURLproperties("Salesforce.HomePage"));
		test.info("Login clicked");

		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Thread.sleep(3000);
		if (oCommonUtilities.waitForElementVisible(ac.Accounts)) 
			oCommonUtilities.clickonElement(ac.Accounts, "Clicked on Accounts Tab");		

		sa.assertNotNull(ac.Accounts.getText(), oDataUtils.ReadWebElementProperties("Account.tab"));
		test.info("Clicked on Accounts Tab");



		if (oCommonUtilities.waitForElementVisible(ac.Tools)) {
			System.out.println(ac.Tools.getText());
			System.out.println(oDataUtils.ReadWebElementProperties("Accountstools.header"));
		}
		oCommonUtilities.clickonElement(ac.Tools, "Clicked on Tools Merge accounts Link");

		sa.assertEquals(ac.MergeAccountsHeader.getText(),oDataUtils.ReadWebElementProperties("Mergeraccounts.header"));
		test.info("Merge Accounts Link Selected");

		if (oCommonUtilities.waitForElementVisible(ac.SearchTextbox))
			oCommonUtilities.enterText(ac.SearchTextbox, oDataUtils.ReadAccountProperties("prodaccount.mergeActname"), "AccountName");

		test.info("Entered the Account name");

		if (oCommonUtilities.waitForElementVisible(ac.FindAccountBtn))
			oCommonUtilities.clickonElement(ac.FindAccountBtn, "Clicked on search button");

		test.info("Clicked on the Find Account Button");

		if (oCommonUtilities.waitForElementVisible(ac.NextBtn))
			oCommonUtilities.clickonElement(ac.NextBtn, "Next Button Clicked");

		test.info("Click on the Next Button");

		if (oCommonUtilities.waitForElementVisible(ac.MergeAccount))
			oCommonUtilities.clickonElement(ac.MergeAccount, "Merge Account selected");

		test.info("Merge option selected");

		Thread.sleep(3000);

		Alert alert = driver.switchTo().alert();
		alert.accept();

		if (oCommonUtilities.waitForElementVisible(ac.AccountValue))
			sa.assertEquals(ac.AccountValue.getText(), oDataUtils.ReadWebElementProperties("Mergedaccount.list"));

		test.info("Account merged successfully");
		sa.assertAll();

		if (ac.AccountValue.getText().equals(oDataUtils.ReadWebElementProperties("Mergedaccount.list"))) {

			test.pass(mName.getName()+"PASSED");
		} else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail(mName.getName()+"FAILED");
		}

	}
	
	/*****************************************Testmethod5: Run report
	 * @throws AWTException ***************************************************/
	@SuppressWarnings("static-access")
	@Test(priority=5)
	public void VerifyAccounts05(Method mName) throws IOException, InterruptedException, AWTException{

		driver = getDriver("chrome");
		ac = new Accountspage(driver);
		driver.get(oDataUtils.ReadWebElementProperties("App.URL"));
		driver.manage().window().maximize();
		
		Robot r= new Robot();


		sa.assertEquals(driver.getTitle(), "Login | Salesforce");
		test.info("Application is launched");

		if (oCommonUtilities.waitForElementVisible(ac.Username))
			oCommonUtilities.enterText(ac.Username, oDataUtils.ReadAccountProperties("prodaccount.name"), "UserName");

		sa.assertNotNull(ac.Username.getText(), "karthik.test@abc.com");
		test.info("Username is Entered");

		if (oCommonUtilities.waitForElementVisible(ac.Password)) 
			oCommonUtilities.enterText(ac.Password, oDataUtils.ReadAccountProperties("prodaccount.password1"), "Password");

		sa.assertNotNull(ac.Password.getText(), "Srinidhi@2017");
		test.info("Password is entered");

		if (oCommonUtilities.waitForElementVisible(ac.Login)) 
			oCommonUtilities.clickonElement(ac.Login, " Login Button");

		sa.assertEquals(driver.getCurrentUrl(), oDataUtils.ReadPageURLproperties("Salesforce.HomePage"));
		test.info("Login clicked");

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		if (oCommonUtilities.waitForElementVisible(ac.Accounts)) 
			oCommonUtilities.clickonElement(ac.Accounts, "Clicked on Accounts Tab");		

		sa.assertNotNull(ac.Accounts.getText(), oDataUtils.ReadWebElementProperties("Account.tab"));
		test.info("Clicked on Accounts Tab");



    	if (oCommonUtilities.waitForElementVisible(ac.LastActivity)) 
		oCommonUtilities.clickonElement(ac.LastActivity, "Clicked on Last Activity Link");
    	
    	
		sa.assertEquals(ac.UnsavedRep.getText(), "Unsaved Report");
		test.info("Unsaved Report page");

		if (oCommonUtilities.waitForElementVisible(ac.DateField))
			oCommonUtilities.clickonElement(ac.DateField, "Clicked Date field");

		test.info("Clicked on Date Field");

		if (oCommonUtilities.waitForElementVisible(ac.CreatedDate))
			oCommonUtilities.clickonElement(ac.CreatedDate, "Selected Created Date option");

		test.info("Clicked on the Find Account Button");
		
		Thread.sleep(1000);

		if (oCommonUtilities.waitForElementVisible(ac.FromDt))
			oCommonUtilities.clickonElement(ac.FromDt, "Clicked on from date");

		test.info("Click on From");

		if (oCommonUtilities.waitForElementVisible(ac.FromToday))
			oCommonUtilities.clickonElement(ac.FromToday, "click on today");

		test.info("Selected Today option");

		if (oCommonUtilities.waitForElementVisible(ac.Savebtn))
			oCommonUtilities.clickonElement(ac.Savebtn, "click on SaveButton");
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		if (oCommonUtilities.waitForElementVisible(ac.ReportName))
		oCommonUtilities.enterText(ac.ReportName, oDataUtils.ReadAccountProperties("prodaccount.ReportName"), "ReportName");
		oCommonUtilities.clickonElement(ac.ReportName, "click on ReportName");
		test.info("ReportName Enetered");
		
	
		r.keyPress(KeyEvent.VK_TAB);
		
		
	
		if (oCommonUtilities.waitForElementVisible(ac.SavenRunRep))
			oCommonUtilities.clickonElement(ac.SavenRunRep, "click on Save and Run reportButton");

		
		sa.assertAll();
//
//		if (ac.AccountValue.getText().equals(oDataUtils.ReadWebElementProperties("Mergedaccount.list"))) {
//
//			test.pass(mName.getName()+"PASSED");
//		} else {
//			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
//			test.fail(mName.getName()+"FAILED");
//		}

	}
}


