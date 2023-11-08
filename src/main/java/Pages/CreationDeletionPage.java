package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Components.components;

public class CreationDeletionPage extends components {

	public CreationDeletionPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// LOCATORS
	@FindBy(tagName = "b")
		private WebElement accCreatedMsg;
	@FindBy(xpath = "//h2/b")
		private WebElement accDeletedMsg;
	@FindBy(xpath = "//a[@data-qa='continue-button']")
		private WebElement continueBtn;
	
	
	
	// ACTION METHODS
	public String getAccCreationMsg() {
		return accCreatedMsg.getText();
	}
	
	public String getAccDeletionMsg() {
		return accDeletedMsg.getText();
	}
	
	public void clickCtnBtn() {
		continueBtn.click();
	}

}
