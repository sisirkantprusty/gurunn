package commonFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;
import pageobjects.Guru99HomePage;

public class commonFunctions extends TestBase{
	Guru99HomePage guru99HomePage;

	public void waitForAnElementToBeVisible(WebElement webEl, int timeOut){
		guru99HomePage = new Guru99HomePage(dr);
		WebDriverWait wait = new WebDriverWait(dr,timeOut);
		//wait.until(ExpectedConditions.visibilityOf(guru99HomePage.webElemementLinkMobile()));
		wait.until(ExpectedConditions.visibilityOf(webEl));
	}
}
