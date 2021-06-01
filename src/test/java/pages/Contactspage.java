package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;


import base.BaseTest;

public class Contactspage{
	
	public Contactspage(WebDriver driver) {
		
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
	
	@FindBy(xpath = "//*[@id='Contact_Tab']/a")
	public WebElement Contacts;
	
	@FindBy(xpath = "//*[@id='hotlist']/table/tbody/tr/td[2]/input")
	public WebElement NewButton;
	
	@FindBy(xpath = "//*[@id='bodyCell']/div[1]/div[1]/div[1]/h2")
	public WebElement NewContat;
	
	@FindBy(id = "name_lastcon2")
	public WebElement LastName;
	
	@FindBy(xpath = "//*[@id='topButtonRow']/input[1]")
	public WebElement SaveButton;
	
	@FindBy(xpath = "//*[@id='contactHeaderRow']/div[2]/h2") 
	public WebElement Contactheader;
	
	@FindBy(xpath ="//*[@id='filter_element']/div/span/span[2]/a[2]")
	public WebElement CreateNewView;
	
	@FindBy(xpath ="//*[@id='bodyCell']/div[1]/div[1]/div[1]/h2")
	public WebElement ViewHeader;
	
	@FindBy(id="fname")
	public WebElement NewView;
	
	@FindBy(id="devname")
	public WebElement NewUniqueView;
	
	@FindBy(xpath ="//*[@id='editPage']/div[1]/table/tbody/tr/td[2]/input[1]")
	public WebElement Save;
	
	@FindBy(xpath ="//*[@id='bodyCell']/div[1]/div[1]/div[1]/h2")
	public WebElement VerifyView;
	
	@FindBy(xpath ="//*[@id='filter_element']/div/span/span[2]/a[1]")//*[@id='00B5e0000060Yrb_filterLinks']/a[1]//*[@id="filter_element"]/div/span/span[2]/a[1]
	public WebElement EditView;
	
	//*[@id='hotlist_mode']/option[1]
	
	@FindBy(xpath ="//*[@id=\"hotlist_mode\"]/option[1]")
	public WebElement RecentlyCreated;
	
	@FindBy(xpath ="//div[contains(text(),'My Contacts')]")//*[@id='00B5e0000032Yuu_listSelect']/option[16]
	public WebElement MyContacts;
	
	@FindBy(xpath ="//*[@id=\"bodyCell\"]/div[3]/div[1]/div/div[2]/table/tbody/tr[2]/th/a")
	public WebElement RecentContact;
	
	@FindBy(xpath ="//*[@id='editPage']/div[2]/div[1]/div[2]/table/tbody/tr[1]/td[2]/div/div[2]")
	public WebElement Errormsg;
	
	@FindBy(xpath="//*[@id='filter_element']/div/span/span[2]/a[2]")
	public WebElement CreateNewuniqView;
	
	@FindBy(xpath="//*[@id='bodyCell']/div[1]/div[1]/div[1]/h2")
	public WebElement NewViewHeader;
	
	@FindBy(xpath="//*[@id='editPage']/div[1]/table/tbody/tr/td[2]/input[2]")
	public WebElement Cancel;
	
	@FindBy(xpath="//*[@id='con4']")
	public WebElement AccountName;	
	
	//validation
	@FindBy(xpath="//*[@id='topButtonRow']/input[2]")
	public WebElement SavenNew;
	
	@FindBy(xpath="//span[contains(text(),'Indian3')]")
	public WebElement RecentItems;
	
	@FindBy(xpath="//option[contains(text(),'Recent')]")
	public WebElement AccountValue;
	
	@FindBy(xpath="//*[@id='toolsContent']/tbody/tr/td[1]/div/div/div[1]/ul/li[2]/a")
	public WebElement LastActivity;
	
	@FindBy(xpath="//*[@id='thePage:sectionHeader']/div/div/div[1]/h2")
	public WebElement UnsavedRep;
	
	@FindBy(id ="ext-gen148")
	public WebElement DateField;
	
    @FindBy(xpath="//div[contains(text(),'Created Date')]")
    public WebElement CreatedDate;
    
    @FindBy(id ="ext-gen152")
    public WebElement FromDt;
    
    @FindBy(xpath="//em/button[contains(text(),'Today')]")
    public WebElement FromToday;
    
    @FindBy(id ="ext-gen154")
    public WebElement ToDt;
    
    @FindBy(id ="ext-gen318")
    public WebElement ToToday;
    
    @FindBy(id="ext-gen49")
    public WebElement Savebtn;
    
    @FindBy(id="saveReportDlg_reportNameField")
    public WebElement ReportName;
    
    @FindBy(id="saveReportDlg_DeveloperName")
    public WebElement ReportuniqueName;
    
   
    
    @FindBy(id="ext-gen299")
    public WebElement SavenRunRep;
    
//    @FindBy(xpath="//em/button[contains(text(),'Save and Run Report')]")
//    public WebElement SavenRunRep;
    
    @FindBy(xpath="//*[@id='noTableContainer']/div/div[1]/div[1]/div[1]/h1")
    public WebElement ReportHeader;   
  
    
    
    
	
	
	
	
	


}
