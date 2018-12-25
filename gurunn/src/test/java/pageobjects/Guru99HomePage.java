package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Guru99HomePage extends pageObjectBase {
	public Guru99HomePage(WebDriver dr) {
		super(dr);
	}

	// WebDriver driver;

	@FindBy(xpath = "//a[contains(text(),'Mobile')]")
	private WebElement linkMobile;
	
	@FindBy(xpath = "//a[contains(text(),'TV')]")
	private WebElement linkTv;

	/*
	 * public Guru99HomePage(WebDriver driver) { this.driver = driver; // This
	 * initElements method will create all WebElements
	 * PageFactory.initElements(driver, this); }
	 */

	public void clickMobile() {
		linkMobile.click();
	}
	
	public void clickTV(){
		linkTv.click();
	}

}
