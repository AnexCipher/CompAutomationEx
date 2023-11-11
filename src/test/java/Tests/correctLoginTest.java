package Tests;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseTest.baseTest;
import Library.DatabaseManager;

public class correctLoginTest extends baseTest {
	
	@Test(dataProvider = "loginInfo")
	public void correctLogin_Test(Map<String, String> loginInfo) throws SQLException {
		softAssert.assertTrue(homePage.verifyHomePageIsVisible());
		homePage.clickSignUpLoginBtn();
		signupLoginPage.verifyLoginToYourAccountIsVisible();
		signupLoginPage.enterLoginCredentials(loginInfo.get("username"), loginInfo.get("password"));
		signupLoginPage.clickLoginBtn();
		softAssert.assertEquals(homePage.verifyLoggedInAsUser(), "Logged in as John Adams");
		
		softAssert.assertAll();
		driver.close();
		
	}
	
	
	
	
	
	@DataProvider(name = "loginInfo")
	public Object[][] getData() throws SQLException {
		Map<String, String> map = new HashMap<>();
		
		ResultSet resultSet = DatabaseManager.executeQuery("complautoex",
				"SELECT username, password FROM login_Info WHERE name = 'John Smith';");
		
		while (resultSet.next()) {
			map.put("username", resultSet.getString("username"));
			map.put("password", resultSet.getString("password"));
		}

		return new Object[][] {{map}};

	}

}
