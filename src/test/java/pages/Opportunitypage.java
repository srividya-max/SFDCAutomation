package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class Opportunitypage {
	
	public Opportunitypage(WebDriver driver) {
		
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
	
	@FindBy(xpath = "//*[@id='Opportunity_Tab']/a")
	public WebElement Opportunity;
	
	@FindBy(id = "//*[@id='fcf']/option[2]")
	public WebElement AllOpportunities;
	
	@FindBy(xpath="//*[@id='hotlist']/table/tbody/tr/td[2]/input")
	public WebElement NewOpportunity;
	
	@FindBy(xpath="//*[@id=bodyCell']/div[1]/div[1]/div[1]/h2")
	public WebElement Opportunityheader;
	
	@FindBy(xpath="//*[@id='opp3']")
	public WebElement OpportunityName;

	@FindBy(id="opp4")
	public WebElement AccountName;

	@FindBy(xpath="//*[@id='opp11']")
	public WebElement Stage;

	@FindBy(xpath="//*[@id='opp11']/option[3]")
	public WebElement StageOption;

	@FindBy(id="opp6")
	public WebElement LeadSource;

	@FindBy(xpath="//*[@id='opp6']/option[2]")
	public WebElement WebOption;

	@FindBy(id="opp9")
	public WebElement CloseDate;
	
	@FindBy(xpath="//*[@id='bottomButtonRow']/input[1]")
	public WebElement SaveButton;
	
	@FindBy(xpath="//*[@id='bodyCell']/div[1]/div[1]/div[1]/h2")
	public WebElement Header;
	
	@FindBy(xpath="//*[@id='toolsContent']/tbody/tr/td[1]/div/div[1]/div[1]/ul/li[1]/a")
	public WebElement Opportunitypipeline;
	
	@FindBy(xpath="//*[@id='noTableContainer']/div/div[1]/div[1]/div[1]/h1")
	public WebElement pipelineHeader;

	@FindBy(xpath="//*[@id='toolsContent']/tbody/tr/td[1]/div/div[1]/div[1]/ul/li[2]/a")
	public WebElement stuckOpportunity;
	
	@FindBy(xpath="//*[@id='noTableContainer']/div/div[1]/div[1]/div[1]/h1")
	public WebElement stuckOppHeader;
	
	@FindBy(id="quarter_q")
	public WebElement interval;
	
	@FindBy(xpath="//*[@id='quarter_q']/option[3]")
	public WebElement NextFQ;
	
	@FindBy(xpath="//*[@id='open']")//*[@id="quarter_q"]/option[3]
	public WebElement include;
	
	@FindBy(xpath="//*[@id='open']/option[2]")
	public WebElement OpenOpportunity;
	
	@FindBy(xpath="//*[@id='lead_summary']/table/tbody/tr[3]/td/input")
	public WebElement RunReport;
	
	@FindBy(xpath="//*[@id='noTableContainer']/div/div[1]/div[1]/div[1]/h1")
	public WebElement Quarterlyrepheader;
}
