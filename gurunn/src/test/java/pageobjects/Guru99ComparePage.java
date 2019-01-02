package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Guru99ComparePage extends pageObjectBase {

	public Guru99ComparePage(WebDriver dr) {
		// TODO Auto-generated constructor stub
		super(dr);
	}

	@FindBy(xpath = "//button[@title='Close Window']")
	protected WebElement btnCloseWindow;

	public void closeWindow() {
		btnCloseWindow.click();
	}
}
