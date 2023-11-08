package Tests;

import org.testng.annotations.Test;

import BaseTest.baseTest;

public class registerUserTest extends baseTest{

	@Test
	public void registerUser_Test()	{
		softAssert.assertTrue(homePage.verifyHomePageIsVisible());
		homePage.clickSignUpLoginBtn();
		softAssert.assertTrue(signupLoginPage.verifynewUserSignupIsVisible());
		signupLoginPage.enterName("John Adams");
		signupLoginPage.enterEmail("JohnAdams3@gmail.com");
		signupLoginPage.clickSignupBtn();
		signupAccInfoPage.selectTitle("mr");
		signupAccInfoPage.enterPassword("12345633");
		signupAccInfoPage.enterDOB("22", "June", "1911");
		signupAccInfoPage.checkNewsletterBox();
		signupAccInfoPage.checkOptinBox();
		signupAccInfoPage.enterAddressInfo("John", "Adams", "Nike", "1414 Neverland Rd.", "United States", "Texas", "Houston", "22302", "7379927548");
		signupAccInfoPage.clickCreateAccBtn();
		softAssert.assertEquals(creationDeletionPage.getAccCreationMsg(), "ACCOUNT CREATED!");
		creationDeletionPage.clickCtnBtn();
		signupAccInfoPage.killPopup();
		softAssert.assertEquals(homePage.verifyLoggedInAsUser(), "Logged in as John Adams");		
		homePage.clickDeleteAccBtn();
		softAssert.assertEquals(creationDeletionPage.getAccDeletionMsg(), "ACCOUNT DELETED!");
		creationDeletionPage.clickCtnBtn();
		
		softAssert.assertAll();
		driver.close();
	}
	
}
