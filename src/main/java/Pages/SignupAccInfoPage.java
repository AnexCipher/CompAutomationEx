package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Components.components;

public class SignupAccInfoPage extends components{

	public SignupAccInfoPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	// LOCATORS
	@FindBy(id = "id_gender1")
		private WebElement mr;
	@FindBy(id = "id_gender2")
		private WebElement mrs;
	@FindBy(name = "password")
		private WebElement passwordBox;
	@FindBy(id = "days")
		private WebElement dobDayDropdown;
	@FindBy(id = "months")
		private WebElement dobMonthDropdown;
	@FindBy(id = "years")
		private WebElement dobYearDropdown;
	@FindBy(id = "newsletter")
		private WebElement newsletterCheckBox;
	@FindBy(id = "optin")
		private WebElement optinCheckBox;
	@FindBy(id = "first_name")
		private WebElement firstNameBox;
	@FindBy(id = "last_name")
		private WebElement lastNameBox;
	@FindBy(id = "company")
		private WebElement companyNameBox;
	@FindBy(id = "address1")
		private WebElement addressBox;
	@FindBy(id = "country")
		private WebElement countryDropdown;
	@FindBy(id = "state")
		private WebElement stateBox;
	@FindBy(id = "city")
		private WebElement cityBox;
	@FindBy(id = "zipcode")
		private WebElement zipcodeBox;
	@FindBy(id = "mobile_number")
		private WebElement mobileNumberBox;
	@FindBy(xpath = "//button[@data-qa='create-account']")
		private WebElement createAccBtn;
	
//	@FindBy(tagName = "b")
//		private WebElement accCreatedMsg;
//	@FindBy(xpath = "//a[@data-qa='continue-button']")
//		private WebElement accCreatedContinueBtn;
	
	@FindBy(id = "aswift_1")
		private WebElement popupIframe;
	@FindBy(id = "ad_iframe")
		private WebElement popupAd;
	@FindBy(xpath = "//span[text()='Close']")
		private WebElement popupCloseBtn;
	@FindBy(xpath = "//div[@id=\'dismiss-button\']/div")
		private WebElement popupXBtn;
	
	
	
	// ACTION METHODS
	public void selectTitle(String title) {
		if(title == "mr") {
			mr.click();
		} else if(title == "mrs") {
			mrs.click();
		}
	}
	
	public void enterPassword(String password) {
		passwordBox.sendKeys(password);
	}
	
	public void enterDOB(String day, String month, String year) {
		// DOB DAY SELECTION
		List<WebElement> dobDaysOptions = dobDayDropdown.findElements(By.tagName("option"));
		for(WebElement i : dobDaysOptions) {
			String item = i.getText();
			if(item.equals(day)) {
				i.click();
				break;
			}
		}
		// DOB MONTH SELECTION
		List<WebElement> dobMonthsOptions = dobMonthDropdown.findElements(By.tagName("option"));
		for(WebElement i : dobMonthsOptions) {
			String item = i.getText();
			if(item.equals(month)) {
				i.click();
				break;
			}
		}
		// DOB YEAR SELECTION
		List<WebElement> dobYearsOptions = dobYearDropdown.findElements(By.tagName("option"));
		for(WebElement i : dobYearsOptions) {
			String item = i.getText();
			if(item.equals(year)) {
				i.click();
				break;
			}
		}
	}
	
	public void checkNewsletterBox() {
		newsletterCheckBox.click();
	}
	
	public void checkOptinBox() {
		optinCheckBox.click();
	}
	
	public void enterAddressInfo(String firstName, String lastName, String company, String address, String country, String state, String city, String zipcode, String mobileNumber) {
		firstNameBox.sendKeys(firstName);
		lastNameBox.sendKeys(lastName);
		companyNameBox.sendKeys(company);
		addressBox.sendKeys(address);
		
		List<WebElement> countryOptions = countryDropdown.findElements(By.tagName("option"));
		for(WebElement i : countryOptions) {
			String item = i.getText();
			if(item.equals(country)) {
				i.click();
				break;
			}
		}
		
		stateBox.sendKeys(state);
		cityBox.sendKeys(city);
		zipcodeBox.sendKeys(zipcode);
		mobileNumberBox.sendKeys(mobileNumber);
	}
	
	public void clickCreateAccBtn() {
		createAccBtn.click();
	}
	
//	public String getAccCreationMsg() {
//		return accCreatedMsg.getText();
//	}
//	
//	public void clickCtnBtn() {
//		accCreatedContinueBtn.click();
//	}
	
	public void killPopup() {
		driver.switchTo().frame(popupIframe);
		driver.switchTo().frame(popupAd);
		
		if(popupCloseBtn.isDisplayed()) {
			popupCloseBtn.click();
		} else if (popupXBtn.isDisplayed()) {
			popupXBtn.click();
		}
		
		driver.switchTo().parentFrame();
	}

}
