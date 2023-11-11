package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Components.components;

public class SignupLoginPage extends components{

	public SignupLoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	// LOCATORS
	@FindBy(xpath = "//h2[text()='Login to your account']")
		private WebElement loginToYourAccountTitle;
	@FindBy(xpath = "//input[@data-qa='login-email']")
		private WebElement loginEmailAddress;
	@FindBy(name = "password")
		private WebElement password;
	@FindBy(xpath = "//button[@data-qa='login-button']")
		private WebElement loginBtn;
	
	@FindBy(xpath = "//h2[text()='New User Signup!']")
		private WebElement newUserSignupTitle;
	@FindBy(name = "name")
		private WebElement name;
	@FindBy(xpath = "//input[@data-qa='signup-email']")
		private WebElement signupEmailAddress;
	@FindBy(xpath = "//button[@data-qa='signup-button']")
		private WebElement signupBtn;
	
	
	
	// ACTION METHODS
	public boolean verifyLoginToYourAccountIsVisible() {
		return loginToYourAccountTitle.isDisplayed();
	}
	
	public void enterLoginCredentials(String usersEmail, String usersPassword) {
		loginEmailAddress.sendKeys(usersEmail);
		password.sendKeys(usersPassword);
	}
	
	public void clickLoginBtn() {
		loginBtn.click();
	}
	
	                    /////
	
	public boolean verifynewUserSignupIsVisible() {
		return newUserSignupTitle.isDisplayed();
	}
	
	public void enterName(String usersName) {
		name.sendKeys(usersName);
	}
	
	public void enterSignUpEmail(String usersEmail) {
		signupEmailAddress.sendKeys(usersEmail);
	}
	
	public void clickSignupBtn() {
		signupBtn.click();
	}
	
}
