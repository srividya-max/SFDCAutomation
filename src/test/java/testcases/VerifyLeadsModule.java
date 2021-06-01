package testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import listeners.TestListeners;
import pages.Leadspage;


@Listeners(TestListeners.class)

public class VerifyLeadsModule extends BaseTest {
	
	public Leadspage Lp;
	Logger log = Logger.getLogger(getClass().getSimpleName());

	@BeforeMethod
	public void CreateReport(Method sTestMethod) {
		test = extent.createTest(sTestMethod.getName());
	}

	@AfterMethod
	public void CloseReport() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}

	/*****************************************Testmethod1: Leads Tab***************************************************/
	@SuppressWarnings("static-access")
	@Test()
	public void VerifyLeads01(Method mName) throws IOException, InterruptedException{

		driver = getDriver("chrome");
		Lp = new Leadspage(driver);
		driver.get(oDataUtils.ReadWebElementProperties("App.URL"));
		driver.manage().window().maximize();

		sa.assertEquals(driver.getTitle(), "Login | Salesforce");
		test.info("Application is launched");

		if (oCommonUtilities.waitForElementVisible(Lp.Username))
			Lp.Username.clear();	
		oCommonUtilities.enterText(Lp.Username, oDataUtils.ReadAccountProperties("prodaccount.name"), "UserName");

		sa.assertNotNull(Lp.Username.getText(), "karthik.test@abc.com");
		test.info("Username is Entered");


		if (oCommonUtilities.waitForElementVisible(Lp.Password))
			oCommonUtilities.enterText(Lp.Password, oDataUtils.ReadAccountProperties("prodaccount.password1"), "Password");

		sa.assertNotNull(Lp.Password.getText(),"Srinidhi@2017");
		test.info("Password is entered");

		if (oCommonUtilities.waitForElementVisible(Lp.Login)) 
			oCommonUtilities.clickonElement(Lp.Login, " Login Button");

		sa.assertEquals(driver.getCurrentUrl(), oDataUtils.ReadPageURLproperties("Salesforce.HomePage"));
		test.info("Login clicked");

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		

		if (oCommonUtilities.waitForElementVisible(Lp.Leads)) 
			oCommonUtilities.clickonElement(Lp.Leads, "Clicked on Opportunities Tab");		

		sa.assertEquals(Lp.Leads.getText(), oDataUtils.ReadWebElementProperties("leads.tab"));
		test.info("Clicked on Leads Tab");
		
		sa.assertAll();
		
		if(Lp.Leads.getText().equals(oDataUtils.ReadWebElementProperties("leads.tab"))){
			test.pass("PASSED");
		} else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail("FAILED");
		}

	}

	/*****************************************Testmethod2: Leads Tab***************************************************/
	@SuppressWarnings("static-access")
	@Test()
	public void VerifyLeads02(Method mName) throws IOException, InterruptedException{

		driver = getDriver("chrome");
		Lp = new Leadspage(driver);
		driver.get(oDataUtils.ReadWebElementProperties("App.URL"));
		driver.manage().window().maximize();

		sa.assertEquals(driver.getTitle(), "Login | Salesforce");
		test.info("Application is launched");

		if (oCommonUtilities.waitForElementVisible(Lp.Username))
			Lp.Username.clear();	
		oCommonUtilities.enterText(Lp.Username, oDataUtils.ReadAccountProperties("prodaccount.name"), "UserName");

		sa.assertNotNull(Lp.Username.getText(), "karthik.test@abc.com");
		test.info("Username is Entered");

		if (oCommonUtilities.waitForElementVisible(Lp.Password))
			oCommonUtilities.enterText(Lp.Password, oDataUtils.ReadAccountProperties("prodaccount.password1"), "Password");

		sa.assertNotNull(Lp.Password.getText(),"Srinidhi@2017");
		test.info("Password is entered");

		if (oCommonUtilities.waitForElementVisible(Lp.Login)) 
			oCommonUtilities.clickonElement(Lp.Login, " Login Button");

		sa.assertEquals(driver.getCurrentUrl(), oDataUtils.ReadPageURLproperties("Salesforce.HomePage"));
		test.info("Login clicked");

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		

		if (oCommonUtilities.waitForElementVisible(Lp.Leads)) 
			oCommonUtilities.clickonElement(Lp.Leads, "Clicked on Opportunities Tab");		

		sa.assertEquals(Lp.Leads.getText(), oDataUtils.ReadWebElementProperties("leads.tab"));
		test.info("Clicked on Leads Tab");
		
		if (oCommonUtilities.waitForElementVisible(Lp.LeadsView)) 
			oCommonUtilities.clickonElement(Lp.LeadsView, "Clicked on Opportunities Tab");		
		
		sa.assertEquals(Lp.Home.getText(), oDataUtils.ReadWebElementProperties("leads.verify"));
		test.info("Clicked on Leads view");
		
		sa.assertAll();
		
		if(Lp.Home.getText().equals(oDataUtils.ReadWebElementProperties("leads.verify"))){
			test.pass("PASSED");
		} else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail("FAILED");
		}
	}
	
	/*****************************************Testmethod3: Leads View***************************************************/
	@SuppressWarnings("static-access")
	@Test()
	public void VerifyLeads03(Method mName) throws IOException, InterruptedException{

		driver = getDriver("chrome");
		Lp = new Leadspage(driver);
		driver.get(oDataUtils.ReadWebElementProperties("App.URL"));
		driver.manage().window().maximize();

		sa.assertEquals(driver.getTitle(), "Login | Salesforce");
		test.info("Application is launched");

		if (oCommonUtilities.waitForElementVisible(Lp.Username))
			Lp.Username.clear();	
		oCommonUtilities.enterText(Lp.Username, oDataUtils.ReadAccountProperties("prodaccount.name"), "UserName");

		sa.assertNotNull(Lp.Username.getText(), "karthik.test@abc.com");
		test.info("Username is Entered");

		if (oCommonUtilities.waitForElementVisible(Lp.Password))
			oCommonUtilities.enterText(Lp.Password, oDataUtils.ReadAccountProperties("prodaccount.password1"), "Password");

		sa.assertNotNull(Lp.Password.getText(),"Srinidhi@2017");
		test.info("Password is entered");

		if (oCommonUtilities.waitForElementVisible(Lp.Login)) 
			oCommonUtilities.clickonElement(Lp.Login, " Login Button");

		sa.assertEquals(driver.getCurrentUrl(), oDataUtils.ReadPageURLproperties("Salesforce.HomePage"));
		test.info("Login clicked");

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		if (oCommonUtilities.waitForElementVisible(Lp.Leads)) 
			oCommonUtilities.clickonElement(Lp.Leads, "Clicked on Opportunities Tab");		

		sa.assertEquals(Lp.Leads.getText(), oDataUtils.ReadWebElementProperties("leads.tab"));
		test.info("Clicked on Leads Tab");
		
		
		if (oCommonUtilities.waitForElementVisible(Lp.Todayoption)) 
			oCommonUtilities.clickonElement(Lp.Todayoption, "Clicked on Opportunities Tab");

		test.info("selected the Today'sLead option");
		sa.assertAll();
		
		if(Lp.Todayoption.getText().equals(oDataUtils.ReadWebElementProperties("leads.view"))){
			test.pass("PASSED");
		} else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail("FAILED");
		}
	}
	
	/*****************************************Testmethod4: default View***************************************************/
	@SuppressWarnings("static-access")
	@Test()
	public void VerifyLeads04(Method mName) throws IOException, InterruptedException{

		driver = getDriver("chrome");
		Lp = new Leadspage(driver);
		driver.get(oDataUtils.ReadWebElementProperties("App.URL"));
		driver.manage().window().maximize();

		sa.assertEquals(driver.getTitle(), "Login | Salesforce");
		test.info("Application is launched");

		if (oCommonUtilities.waitForElementVisible(Lp.Username))
			Lp.Username.clear();	
		oCommonUtilities.enterText(Lp.Username, oDataUtils.ReadAccountProperties("prodaccount.name"), "UserName");

		sa.assertNotNull(Lp.Username.getText(), "karthik.test@abc.com");
		test.info("Username is Entered");

		if (oCommonUtilities.waitForElementVisible(Lp.Password))
			oCommonUtilities.enterText(Lp.Password, oDataUtils.ReadAccountProperties("prodaccount.password1"), "Password");

		sa.assertNotNull(Lp.Password.getText(),"Srinidhi@2017");
		test.info("Password is entered");

		if (oCommonUtilities.waitForElementVisible(Lp.Login)) 
			oCommonUtilities.clickonElement(Lp.Login, " Login Button");

		sa.assertEquals(driver.getCurrentUrl(), oDataUtils.ReadPageURLproperties("Salesforce.HomePage"));
		test.info("Login clicked");

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		if (oCommonUtilities.waitForElementVisible(Lp.Leads)) 
			oCommonUtilities.clickonElement(Lp.Leads, "Clicked on Opportunities Tab");		

		sa.assertEquals(Lp.Leads.getText(), oDataUtils.ReadWebElementProperties("leads.tab"));
		test.info("Clicked on Leads Tab");
		
		
		if (oCommonUtilities.waitForElementVisible(Lp.UnreadLeads)) 
			oCommonUtilities.clickonElement(Lp.UnreadLeads, "Clicked on Opportunities Tab");

		test.info("selected the Today'sLead option");
		
		if (oCommonUtilities.waitForElementVisible(Lp.Logout))
		Lp.Logout.click();
		
		System.out.println("logout successful");
		
		sa.assertAll();
		
		if(Lp.Todayoption.getText().equals(oDataUtils.ReadWebElementProperties("leads.view"))){
			test.pass("PASSED");
		} else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail("FAILED");
		}
	}
	
	/*****************************************Testmethod5: Today's Leads***************************************************/
	@SuppressWarnings("static-access")
	@Test()
	public void VerifyLeads05(Method mName) throws IOException, InterruptedException{

		driver = getDriver("chrome");
		Lp = new Leadspage(driver);
		driver.get(oDataUtils.ReadWebElementProperties("App.URL"));
		driver.manage().window().maximize();

		sa.assertEquals(driver.getTitle(), "Login | Salesforce");
		test.info("Application is launched");

		if (oCommonUtilities.waitForElementVisible(Lp.Username))
			Lp.Username.clear();	
		oCommonUtilities.enterText(Lp.Username, oDataUtils.ReadAccountProperties("prodaccount.name"), "UserName");

		sa.assertNotNull(Lp.Username.getText(), "karthik.test@abc.com");
		test.info("Username is Entered");

		if (oCommonUtilities.waitForElementVisible(Lp.Password))
			oCommonUtilities.enterText(Lp.Password, oDataUtils.ReadAccountProperties("prodaccount.password1"), "Password");

		sa.assertNotNull(Lp.Password.getText(),"Srinidhi@2017");
		test.info("Password is entered");

		if (oCommonUtilities.waitForElementVisible(Lp.Login)) 
			oCommonUtilities.clickonElement(Lp.Login, " Login Button");

		sa.assertEquals(driver.getCurrentUrl(), oDataUtils.ReadPageURLproperties("Salesforce.HomePage"));
		test.info("Login clicked");

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		if (oCommonUtilities.waitForElementVisible(Lp.Leads)) 
			oCommonUtilities.clickonElement(Lp.Leads, "Clicked on Opportunities Tab");		

		sa.assertEquals(Lp.Leads.getText(), oDataUtils.ReadWebElementProperties("leads.tab"));
		test.info("Clicked on Leads Tab");
		
		
		if (oCommonUtilities.waitForElementVisible(Lp.Todayoption)) 
			oCommonUtilities.clickonElement(Lp.Todayoption, "Clicked on Opportunities Tab");

		test.info("selected the Today'sLead option");
		sa.assertAll();
		
		if(Lp.Todayoption.getText().equals(oDataUtils.ReadWebElementProperties("leads.view"))){
			test.pass("PASSED");
		} else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail("FAILED");
		}
	}
	/*****************************************Testmethod6: New Lead**************************************************/
	@SuppressWarnings("static-access")
	@Test()
	public void VerifyLeads06(Method mName) throws IOException, InterruptedException{

		driver = getDriver("chrome");
		Lp = new Leadspage(driver);
		driver.get(oDataUtils.ReadWebElementProperties("App.URL"));
		driver.manage().window().maximize();

		sa.assertEquals(driver.getTitle(), "Login | Salesforce");
		test.info("Application is launched");

		if (oCommonUtilities.waitForElementVisible(Lp.Username))
			Lp.Username.clear();	
		oCommonUtilities.enterText(Lp.Username, oDataUtils.ReadAccountProperties("prodaccount.name"), "UserName");

		sa.assertNotNull(Lp.Username.getText(), "karthik.test@abc.com");
		test.info("Username is Entered");

		if (oCommonUtilities.waitForElementVisible(Lp.Password))
			oCommonUtilities.enterText(Lp.Password, oDataUtils.ReadAccountProperties("prodaccount.password1"), "Password");

		sa.assertNotNull(Lp.Password.getText(),"Srinidhi@2017");
		test.info("Password is entered");

		if (oCommonUtilities.waitForElementVisible(Lp.Login)) 
			oCommonUtilities.clickonElement(Lp.Login, " Login Button");

		sa.assertEquals(driver.getCurrentUrl(), oDataUtils.ReadPageURLproperties("Salesforce.HomePage"));
		test.info("Login clicked");

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		if (oCommonUtilities.waitForElementVisible(Lp.Leads)) 
			oCommonUtilities.clickonElement(Lp.Leads, "Clicked on Leads Tab");		

		sa.assertEquals(Lp.Leads.getText(), oDataUtils.ReadWebElementProperties("leads.tab"));
		test.info("Clicked on Leads Tab");
		
		if (oCommonUtilities.waitForElementVisible(Lp.newLead)) 
			oCommonUtilities.clickonElement(Lp.newLead, "Clicked on new Lead");
		test.info("clicked on new lead");
		
		if (oCommonUtilities.waitForElementVisible(Lp.lastName)) 
			oCommonUtilities.enterText(Lp.lastName, oDataUtils.ReadAccountProperties("prodaccount.LastName"), "lastname");
		test.info("last name entered successfully");
		
		if (oCommonUtilities.waitForElementVisible(Lp.company)) 
			oCommonUtilities.enterText(Lp.company, oDataUtils.ReadAccountProperties("prodaccount.company"), "lastname");
		test.info("comapny name entered successfully");
		
		if (oCommonUtilities.waitForElementVisible(Lp.save)) 
			oCommonUtilities.clickonElement(Lp.save, "Clicked on save");
		
		sa.assertEquals(Lp.header.getText(), oDataUtils.ReadAccountProperties("prodaccount.LastName"));
		test.info("the new lead is created");

		sa.assertAll();
		
		if(Lp.header.getText().equals(oDataUtils.ReadAccountProperties("prodaccount.LastName"))){
			test.pass("PASSED");
		} else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail("FAILED");
		}
	}
}
