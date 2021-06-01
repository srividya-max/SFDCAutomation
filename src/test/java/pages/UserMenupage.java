package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class UserMenupage{
	
	public UserMenupage(WebDriver driver) {
		
		if(driver!=null){
		PageFactory.initElements(BaseTest.driver,this);
		
		}
	}
	
/************Object Repository*************/

	
	@FindBy(xpath = "//*[@id='username']")
	public WebElement Username;
	
	@FindBy(xpath = "//*[@id='password']")
	public WebElement Password;
	
	@FindBy(xpath = "//*[@id='Login']")
	public WebElement Login;
	
	@FindBy(xpath = "//*[@id='userNavLabel']")
	public WebElement Usermenu;
	
	@FindBy(xpath = "//*[@id='userNav-menuItems']/a[2]")
	public WebElement Mysettings;
	
	@FindBy(xpath = "//*[@id='userNav-menuItems']/a[3]")
	public WebElement Devconsole;
	
	@FindBy(xpath = "//*[@id='userNav-menuItems']/a[5]")
	public WebElement Logout;

	@FindBy(id = "setupLink")
	public WebElement Setup;
	
	@FindBy(xpath = "//*[@id='PersonalInfo']")
	public WebElement Personal;
	
	@FindBy(id = "LoginHistory_font") //*[@id="LoginHistory_font"]
	public WebElement LoginHistory;
	
	@FindBy(xpath = "/*[@id='bodyCell']/div[1]/div[1]/div[1]/h1") 
	public WebElement LoginHistoryPage;

	@FindBy(id="DisplayAndLayout")
	public WebElement DisplayandLayout;
	
	@FindBy(id="CustomizeTabs_font") 	//*[@id="CustomizeTabs_font"]
	public WebElement Customizetab;
	
	@FindBy(xpath="//*[@id='ep']/div[2]/div[2]/table/tbody/tr[1]/td/label")
	public WebElement CustomApp;
	
	@FindBy(xpath="//*[@id='p4']")
	public WebElement CustomList;

	@FindBy(xpath="//*[@id='p4']/option[9]")
	public WebElement SfChatter ;
	
	@FindBy(xpath="//*[@id='duel_select_0']/option[72]")
	public WebElement Reports ;

	@FindBy(xpath="//*[@id='duel_select_0_right']")
	public WebElement Add;
	
	@FindBy(xpath="//*[@id='EmailSetup']/a")
	public WebElement Email;
	
	@FindBy(id="EmailSettings_font")
	public WebElement MyEmail;
	
	
	@FindBy(xpath="//*[@id='CalendarAndReminders']/a")
	public WebElement CalandRem;
	
	@FindBy(id="Reminders_font")
	public WebElement ActivityReminder;
	
	@FindBy(xpath="//*[@id='testbtn']")
	public WebElement TestRemButton;
	
	//*[@id="p4"] --drop down
	//*[@id="p4"]/option[9] -- Salesforce Chatter 
	//*[@id='duel_select_0']/option[72]
	//*[@id="duel_select_1"]/option[4]


	

	
	

}

