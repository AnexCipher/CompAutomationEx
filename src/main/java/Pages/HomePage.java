package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Components.components;

public class HomePage extends components {

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	// LOCATORS
	@FindBy(xpath = "//img[@alt='Website for automation practice']")
		private WebElement homePageLogo;
	@FindBy(xpath = "//a[text()=' Signup / Login']")
		private WebElement signUp_logIn_Btn;
	@FindBy(xpath = "//a[text()=' Logged in as ']")
		private WebElement loggedInAsUser;
	@FindBy(xpath = "//a[@href='/delete_account']")
		private WebElement deleteAccBtn;
	
	
	
	// ACTION METHODS
	public boolean verifyHomePageIsVisible() {
		return homePageLogo.isDisplayed();
	}
	
	public void clickSignUpLoginBtn() {
		signUp_logIn_Btn.click();
	}
	
	public String verifyLoggedInAsUser() {
		return loggedInAsUser.getText();
	}
	
	public void clickDeleteAccBtn() {
		deleteAccBtn.click();
	}

}
