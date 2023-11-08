package Components;

import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class components {

	public WebDriver driver;
	public WebDriverWait wait;
	public Actions actions;
	public Alert alert;
	public Random random;

	public components(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public Actions action() {
		actions = new Actions(driver);
		return actions;
	}

	public void scrollBy(int x) {
		JavascriptExecutor JSE = (JavascriptExecutor) driver;
		JSE.executeScript("window.scrollBy(0," + x + ")");
	}

	public void scrollIntoView(WebElement element) {
		JavascriptExecutor JSE = (JavascriptExecutor) driver;
		JSE.executeScript("arguments[0].scrollIntoView();", element);
	}

	public void goBack() {
		driver.navigate().back();
	}

	public void goForward() {
		driver.navigate().forward();
	}

	public void acceptPopUp() {
		alert = driver.switchTo().alert();
		alert.accept();
	}
	
	
    //////   WAITS   \\\\\\	
	public void waitTillVisible(By element, int x) {
		wait = new WebDriverWait(driver, x);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}

}
