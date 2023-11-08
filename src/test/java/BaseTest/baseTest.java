package BaseTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import Pages.CreationDeletionPage;
import Pages.HomePage;
import Pages.SignupAccInfoPage;
import Pages.SignupLoginPage;

public class baseTest {
	
	public WebDriver driver; 
	public SoftAssert softAssert;
	public HomePage homePage;
	public SignupLoginPage signupLoginPage;
	public SignupAccInfoPage signupAccInfoPage;
	public CreationDeletionPage creationDeletionPage;
	
	public WebDriver initialiseDriver() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;
	}
	
	@BeforeSuite
	public void setUp() {
		driver = initialiseDriver();
	}
	
	@BeforeTest
	public void initialiseObjects() {
		softAssert = new SoftAssert();
		homePage = new HomePage(driver);
		signupLoginPage = new SignupLoginPage(driver);
		signupAccInfoPage = new SignupAccInfoPage(driver);
		creationDeletionPage = new CreationDeletionPage(driver);
		
		
		driver.get("https://www.automationexercise.com/");
	}

}
