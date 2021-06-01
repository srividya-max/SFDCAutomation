package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class Leadspage {

	public Leadspage(WebDriver driver) {
		
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
	
	@FindBy(xpath = "//*[@id='Lead_Tab']/a")
	public WebElement Leads;
	
	@FindBy(xpath = "//*[@id='fcf']")
	public WebElement LeadsView;
	
	@FindBy(xpath = "//*[@id='bodyCell']/div[1]/div[1]/div[1]/h2")
	public WebElement Home;
	
	@FindBy(xpath = "//*[@id='fcf']/option[4]")
	public WebElement Todayoption;
	
	@FindBy(xpath = "//*[@id='fcf']/option[2]")
	public WebElement UnreadLeads;
	
	@FindBy(xpath = "//*[@id='userNav-menuItems']/a[5]")
	public WebElement Logout;
	
	@FindBy(xpath = "//*[@id='hotlist']/table/tbody/tr/td[2]/input")
	public WebElement newLead;
	
	@FindBy(xpath ="//*[@id='name_lastlea2']")
	public WebElement lastName;
	
	@FindBy(xpath ="//*[@id='lea3']")
	public WebElement company;
	
	@FindBy(xpath ="//*[@id='topButtonRow']/input[1]")
    public WebElement save;
	
	//verify
	@FindBy(xpath ="//*[@id='contactHeaderRow']/div[2]/h2")
	public WebElement header;
	
}
