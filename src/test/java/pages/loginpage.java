package pages;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;

    import org.openqa.selenium.support.PageFactory;

    import base.BaseTest;

	public class loginpage{
		
		public loginpage(WebDriver driver) {
			
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
		
		@FindBy(xpath = "//*[@id='error']")
		public WebElement Errormsg;
		
		@FindBy(xpath = "//*[@id='rememberUn']")
		public WebElement RememberMe;
		
		@FindBy(xpath = "//*[@id='userNavLabel']")
		public WebElement Usermenu;
		
		@FindBy(xpath = "//*[@id='userNav-menuItems']/a[5]")
		public WebElement Logout;

		@FindBy(xpath = "/html/body/iframe")
		public WebElement iframe;
		
		@FindBy(xpath = "//*[@id='idcard-identity']")
		public WebElement Username1;
		
		@FindBy(id = "forgot_password_link")
		public WebElement ForgotPwd;

		@FindBy(xpath = "//*[@id='content']/p")
		public WebElement ForgotPwdHeader;

		@FindBy(xpath = "//*[@id='un']")
		public WebElement ForgotPwdUser;
		
		@FindBy(id = "continue")
		public WebElement Continue;
		

		
	}

