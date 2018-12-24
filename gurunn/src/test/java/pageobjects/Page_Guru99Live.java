package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.pageObjectsBase;

public class Page_Guru99Live extends pageObjectsBase{
	
	public Page_Guru99Live(WebDriver dr) {
		super(dr);
	}
	@FindBy(xpath="//a[contains(text(),'Mobile')]")
	private WebElement linkMobile;
	
	public void clickMobile() {
		linkMobile.click();
	}

}
