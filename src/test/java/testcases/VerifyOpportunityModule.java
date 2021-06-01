package testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import listeners.TestListeners;
import pages.Opportunitypage;

@Listeners(TestListeners.class)
public class VerifyOpportunityModule extends BaseTest{
	public Opportunitypage op;

	@BeforeMethod
	public void CreateReport(Method sTestMethod) {
		test = extent.createTest(sTestMethod.getName());
	}

	@AfterMethod
	public void CloseReport() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}

	/*****************************************Testmethod1: Select Opportunity tab***************************************************/
	@SuppressWarnings("static-access")
	@Test()
	public void VerifyOpportunity01(Method mName) throws IOException, InterruptedException{

		driver = getDriver("chrome");
		op = new Opportunitypage(driver);
		driver.get(oDataUtils.ReadWebElementProperties("App.URL"));
		driver.manage().window().maximize();

		sa.assertEquals(driver.getTitle(), "Login | Salesforce");
		test.info("Application is launched");

		if (oCommonUtilities.waitForElementVisible(op.Username))
			op.Username.clear();	
		oCommonUtilities.enterText(op.Username, oDataUtils.ReadAccountProperties("prodaccount.name"), "UserName");

		sa.assertNotNull(op.Username.getText(), "karthik.test@abc.com");
		test.info("Username is Entered");


		if (oCommonUtilities.waitForElementVisible(op.Password))
			oCommonUtilities.enterText(op.Password, oDataUtils.ReadAccountProperties("prodaccount.password1"), "Password");

		sa.assertNotNull(op.Password.getText(),"Srinidhi@2017");
		test.info("Password is entered");

		if (oCommonUtilities.waitForElementVisible(op.Login)) 
			oCommonUtilities.clickonElement(op.Login, " Login Button");

		sa.assertEquals(driver.getCurrentUrl(), oDataUtils.ReadPageURLproperties("Salesforce.HomePage"));
		test.info("Login clicked");

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		if (oCommonUtilities.waitForElementVisible(op.Opportunity)) 
			oCommonUtilities.clickonElement(op.Opportunity, "Clicked on Opportunities Tab");		

		sa.assertEquals(op.Opportunity.getText(), oDataUtils.ReadWebElementProperties("Opportunities.tab"));
		test.info("Clicked on Opportuities Tab");

		if (oCommonUtilities.waitForElementVisible(op.AllOpportunities)) 
			oCommonUtilities.clickonElement(op.AllOpportunities, "Clicked on Opportunities Tab");

		sa.assertAll();

		if(op.Opportunity.getText().equals(oDataUtils.ReadWebElementProperties("Opportunities.options"))){
			test.pass("PASSED");
		} else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail("FAILED");
		}

	}

	/*****************************************Testmethod2: Select Create opportunity***************************************************/
	@SuppressWarnings("static-access")
	@Test()
	public void VerifyOpportunity02(Method mName) throws IOException, InterruptedException{

		driver = getDriver("chrome");
		op = new Opportunitypage(driver);
		driver.get(oDataUtils.ReadWebElementProperties("App.URL"));
		driver.manage().window().maximize();

		sa.assertEquals(driver.getTitle(), "Login | Salesforce");
		test.info("Application is launched");

		if (oCommonUtilities.waitForElementVisible(op.Username))
			op.Username.clear();	
		oCommonUtilities.enterText(op.Username, oDataUtils.ReadAccountProperties("prodaccount.name"), "UserName");

		sa.assertNotNull(op.Username.getText(), "karthik.test@abc.com");
		test.info("Username is Entered");


		if (oCommonUtilities.waitForElementVisible(op.Password))
			oCommonUtilities.enterText(op.Password, oDataUtils.ReadAccountProperties("prodaccount.password1"), "Password");

		sa.assertNotNull(op.Password.getText(),"Srinidhi@2017");
		test.info("Password is entered");

		if (oCommonUtilities.waitForElementVisible(op.Login)) 
			oCommonUtilities.clickonElement(op.Login, " Login Button");

		sa.assertEquals(driver.getCurrentUrl(), oDataUtils.ReadPageURLproperties("Salesforce.HomePage"));
		test.info("Login clicked");

		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Thread.sleep(3000);

		if (oCommonUtilities.waitForElementVisible(op.Opportunity)) 
			oCommonUtilities.clickonElement(op.Opportunity, "Clicked on Opportunities Tab");		

		sa.assertEquals(op.Opportunity.getText(), oDataUtils.ReadWebElementProperties("Opportunities.tab"));
		test.info("Clicked on Opportuities Tab");

		Thread.sleep(3000);

		if (oCommonUtilities.waitForElementVisible(op.NewOpportunity)) 
			oCommonUtilities.clickonElement(op.NewOpportunity, "Clicked on New button");

		if (oCommonUtilities.waitForElementVisible(op.Opportunityheader))
			sa.assertEquals(op.Opportunityheader.getText(), oDataUtils.ReadWebElementProperties("Opportunity.header"));
		test.info("New Opportunity is clicked");

		if (oCommonUtilities.waitForElementVisible(op.OpportunityName))
			oCommonUtilities.enterText(op.OpportunityName, oDataUtils.ReadAccountProperties("prodaccount.Oppname"), "oppname");

		test.info("Entered Opportunity Name");

		if (oCommonUtilities.waitForElementVisible(op.AccountName))
			oCommonUtilities.enterText(op.AccountName, oDataUtils.ReadAccountProperties("prodaccount.OppAccountname"), "Accountname");

		//sa.assertEquals(op.AccountName.getText(), oDataUtils.ReadAccountProperties("prodaccount.OppAccountname"));
		test.info("Entered AccountName");

		if (oCommonUtilities.waitForElementVisible(op.Stage)) 
			oCommonUtilities.clickonElement(op.Stage, "Clicked on stage");

		if (oCommonUtilities.waitForElementVisible(op.StageOption)) 
			oCommonUtilities.clickonElement(op.StageOption, "Clicked on stage");

		sa.assertEquals(op.StageOption.getText(), oDataUtils.ReadWebElementProperties("Stage.name"));
		test.info("Qualification option is chosen");

		if (oCommonUtilities.waitForElementVisible(op.CloseDate)) 
			oCommonUtilities.enterText(op.CloseDate, oDataUtils.ReadWebElementProperties("opp.closedate"), "closedate");

		test.info("closedate is entered");
		if (oCommonUtilities.waitForElementVisible(op.LeadSource)) 
			oCommonUtilities.clickonElement(op.LeadSource, "Selected the Lead Source");

		if (oCommonUtilities.waitForElementVisible(op.WebOption)) 
			oCommonUtilities.clickonElement(op.WebOption, "Selected the Web Option");

		sa.assertEquals(op.WebOption.getText(), oDataUtils.ReadWebElementProperties("Leadsorce.option"));
		test.info("Web option is chosen");

		if (oCommonUtilities.waitForElementVisible(op.SaveButton)) 
			oCommonUtilities.clickonElement(op.SaveButton, "Selected the save");


		sa.assertAll();

		if(op.Header.getText().equals(oDataUtils.ReadAccountProperties("prodaccount.Oppname"))){
			test.pass("PASSED");
		} else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail("FAILED");
		}

	}
	/*****************************************Testmethod3: Opportunity pipeline***************************************************/
	@SuppressWarnings("static-access")
	@Test()
	public void VerifyOpportunity03(Method mName) throws IOException, InterruptedException{

		driver = getDriver("chrome");
		op = new Opportunitypage(driver);
		driver.get(oDataUtils.ReadWebElementProperties("App.URL"));
		driver.manage().window().maximize();

		sa.assertEquals(driver.getTitle(), "Login | Salesforce");
		test.info("Application is launched");

		if (oCommonUtilities.waitForElementVisible(op.Username))
			op.Username.clear();	
		oCommonUtilities.enterText(op.Username, oDataUtils.ReadAccountProperties("prodaccount.name"), "UserName");

		sa.assertNotNull(op.Username.getText(), "karthik.test@abc.com");
		test.info("Username is Entered");


		if (oCommonUtilities.waitForElementVisible(op.Password))
			oCommonUtilities.enterText(op.Password, oDataUtils.ReadAccountProperties("prodaccount.password1"), "Password");

		sa.assertNotNull(op.Password.getText(),"Srinidhi@2017");
		test.info("Password is entered");

		if (oCommonUtilities.waitForElementVisible(op.Login)) 
			oCommonUtilities.clickonElement(op.Login, " Login Button");

		sa.assertEquals(driver.getCurrentUrl(), oDataUtils.ReadPageURLproperties("Salesforce.HomePage"));
		test.info("Login clicked");

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);


		if (oCommonUtilities.waitForElementVisible(op.Opportunity)) 
			oCommonUtilities.clickonElement(op.Opportunity, "Clicked on Opportunities Tab");		

		sa.assertEquals(op.Opportunity.getText(), oDataUtils.ReadWebElementProperties("Opportunities.tab"));
		test.info("Clicked on Opportuities Tab");
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		if (oCommonUtilities.waitForElementVisible(op.Opportunitypipeline)) 
			oCommonUtilities.clickonElement(op.Opportunitypipeline, "Clicked on Opportunities pipeline link");		
		
		sa.assertEquals(op.pipelineHeader.getText(), oDataUtils.ReadWebElementProperties("pipeline.header"));
		test.info("opened opportunity pipeline report");
		
		sa.assertAll();
		
		if(op.pipelineHeader.getText().equals(oDataUtils.ReadWebElementProperties("pipeline.header"))){
			test.pass("PASSED");
		} else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail("FAILED");
		}

	}
	/*****************************************Testmethod3: Quarterly Summary***************************************************/
	@SuppressWarnings("static-access")
	@Test()
	public void VerifyOpportunity04(Method mName) throws IOException, InterruptedException{

		driver = getDriver("chrome");
		op = new Opportunitypage(driver);
		driver.get(oDataUtils.ReadWebElementProperties("App.URL"));
		driver.manage().window().maximize();

		sa.assertEquals(driver.getTitle(), "Login | Salesforce");
		test.info("Application is launched");

		if (oCommonUtilities.waitForElementVisible(op.Username))
			op.Username.clear();	
		oCommonUtilities.enterText(op.Username, oDataUtils.ReadAccountProperties("prodaccount.name"), "UserName");

		sa.assertNotNull(op.Username.getText(), "karthik.test@abc.com");
		test.info("Username is Entered");

		if (oCommonUtilities.waitForElementVisible(op.Password))
			oCommonUtilities.enterText(op.Password, oDataUtils.ReadAccountProperties("prodaccount.password1"), "Password");

		sa.assertNotNull(op.Password.getText(),"Srinidhi@2017");
		test.info("Password is entered");

		if (oCommonUtilities.waitForElementVisible(op.Login)) 
			oCommonUtilities.clickonElement(op.Login, " Login Button");

		sa.assertEquals(driver.getCurrentUrl(), oDataUtils.ReadPageURLproperties("Salesforce.HomePage"));
		test.info("Login clicked");

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		if (oCommonUtilities.waitForElementVisible(op.Opportunity)) 
			oCommonUtilities.clickonElement(op.Opportunity, "Clicked on Opportunities Tab");		

		sa.assertEquals(op.Opportunity.getText(), oDataUtils.ReadWebElementProperties("Opportunities.tab"));
		test.info("Clicked on Opportuities Tab");
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		if (oCommonUtilities.waitForElementVisible(op.NextFQ)) 
			oCommonUtilities.clickonElement(op.NextFQ, "Selected the NextFQ option");	
		
		test.info("Clicked On interval option");

		if (oCommonUtilities.waitForElementVisible(op.OpenOpportunity)) 
			oCommonUtilities.clickonElement(op.OpenOpportunity, "Selected the Open opp option");	
		
		test.info("Selected the open opp option");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		if (oCommonUtilities.waitForElementVisible(op.RunReport)) 
			oCommonUtilities.clickonElement(op.RunReport, "Selected the Open opp option");	
		
		sa.assertEquals(op.Quarterlyrepheader.getText(), oDataUtils.ReadWebElementProperties("oppQuarterlyrep.header"));
		test.info("Quarterly Report page is opened");

		sa.assertAll();
		
		if(op.Quarterlyrepheader.getText().equals(oDataUtils.ReadWebElementProperties("oppQuarterlyrep.header"))){
			test.pass("PASSED");
		} else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail("FAILED");
		}

	}
}
