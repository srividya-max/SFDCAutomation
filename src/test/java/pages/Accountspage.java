package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;


import base.BaseTest;

public class Accountspage{
	
	public Accountspage(WebDriver driver) {
		
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
	
	@FindBy(xpath = "//*[@id='Account_Tab']/a")
	public WebElement Accounts;
	
	@FindBy(xpath = "//*[@id='hotlist']/table/tbody/tr/td[2]/input")
	public WebElement NewButton;
	
	@FindBy(xpath = "//*[@id='acc2']")
	public WebElement AccountName;
	
	@FindBy(xpath = "//*[@id='acc6']")
	public WebElement Type;
	
	@FindBy(xpath = "//*[@id='acc6']/option[7]")
	public WebElement TechnologyPartner;
	
	@FindBy(xpath = "//*[@id='bottomButtonRow']/input[1]")
	public WebElement SaveButton;
	
	@FindBy(xpath = "//*[@id='contactHeaderRow']/div[2]/h2")
	public WebElement myact;
	
	@FindBy(xpath ="//*[@id='filter_element']/div/span/span[2]/a[2]")
	public WebElement CreateNewView;
	
	@FindBy(xpath ="//*[@id='bodyCell']/div[1]/div[1]/div[1]/h2")
	public WebElement Accountheader;
	
	@FindBy(id="fname")
	public WebElement NewView;
	
	@FindBy(id="devname")
	public WebElement NewUniqueView;
	
	@FindBy(xpath ="//*[@id='editPage']/div[1]/table/tbody/tr/td[2]/input[1]")
	public WebElement Save;
	
	@FindBy(xpath ="//*[@id='ext-gen16']/div/table/thead/tr/td[5]/div")
	public WebElement VerifyView;
	
	@FindBy(xpath ="//*[@id='filter_element']/div/span/span[2]/a[1]")//*[@id='00B5e0000060Yrb_filterLinks']/a[1]//*[@id="filter_element"]/div/span/span[2]/a[1]
	public WebElement EditView;
	
	@FindBy(xpath ="//*[@id='fcol1']/option[2]")
	public WebElement Field;
	
	@FindBy(xpath ="//*[@id='fop1']/option[4]")
	public WebElement Operator;
	
	@FindBy(xpath ="//*[@id='fval1']")
	public WebElement Contains;
	
	@FindBy(xpath ="//*[@id='toolsContent']/tbody/tr/td[2]/div/div/div/ul/li[4]/span/a")
	public WebElement Tools;
	
	@FindBy(id="srch")
	public WebElement SearchTextbox;
	
	@FindBy(xpath="//*[@id='stageForm']/div/div[2]/div[4]/input[2]")
	public WebElement FindAccountBtn;
	
	@FindBy(xpath="//*[@id='stageForm']/div/div[2]/div[5]/div/input[1]")
	public WebElement NextBtn;
	
	@FindBy(xpath="//*[@id='stageForm']/div/div[2]/div[5]/div/input[2]")
	public WebElement MergeAccount;	
	
	//validation
	@FindBy(xpath="//*[@id='stageForm']/div/div[1]/h2")
	public WebElement MergeAccountsHeader;
	
	@FindBy(xpath="//*[@id='bodyCell']/div[3]/div[1]/div/div[2]/table/tbody/tr[2]/th/a")
	public WebElement RecentlyViewdAccount;
	
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
