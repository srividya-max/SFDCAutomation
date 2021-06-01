package base;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.Accountspage;
import pages.Contactspage;
import pages.Leadspage;
import pages.Opportunitypage;
import pages.UserMenupage;
import pages.loginpage;
import utilities.AppConstants;
import utilities.CommonUtilities;
import utilities.DataUtilities;

public class BaseTest {
	
	public static WebDriver driver=null;

	public static ExtentReports extent = null;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentTest test = null; //logger

	public static String sReportTime;
	public static Properties sProperties;
	private String sBrowserName;
	
	public static CommonUtilities oCommonUtilities = new CommonUtilities();
	public DataUtilities oDataUtils = new DataUtilities();
	public loginpage lp =  new loginpage(driver);
	public UserMenupage um =  new UserMenupage(driver);
	public Accountspage ac = new Accountspage(driver);
	public Opportunitypage op = new Opportunitypage(driver);
	public Leadspage Lp = new Leadspage(driver);
	public Contactspage cp = new Contactspage(driver);
	public SoftAssert sa = new SoftAssert();
	
	
	
	@BeforeTest
	public void setup() {
		Initializereports();
	}
	
	@AfterTest
	public void tearDown() {
		extent.flush();
	}

	public void Initializereports() {
		sReportTime = new SimpleDateFormat("yyyymmddhhmm").format(new Date());
		extent = new ExtentReports();
		htmlReporter = new ExtentHtmlReporter(AppConstants.EXTENT_HTML_REPORT_PATH +"\\"+sReportTime +".html");
		extent.attachReporter(htmlReporter);
	}
	

	public WebDriver getDriver(String BrowserName) {

		sBrowserName = BrowserName.toLowerCase();
		switch (sBrowserName) {

		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "ie":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			driver = null;

		}
		
		cp=new Contactspage(driver);
		return driver;

	}

	

}
