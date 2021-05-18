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

		
		@FindBy(id = "username")
		public WebElement Username;
		
		@FindBy(id = "password")
		public WebElement Password;
		
		@FindBy(xpath = "//*[@id='Login']")
		public WebElement Login;
		
//		@FindBy(id = "rem")
//		public WebElement RememberMe;
		
		@FindBy(xpath = "//*[@id='error']")
		public WebElement Errormsg;
		

	}

