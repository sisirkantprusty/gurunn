package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HMStartPage extends pageObjectBase{

	public HMStartPage(WebDriver dr) {
		super(dr);
		// TODO Auto-generated constructor stub
	}

	@FindBy (xpath=("//button[@class='modalclose icon-close-black']"))
	protected WebElement btnModalClose;
	
	@FindBy (xpath=("//button[@type='button']"))
	protected WebElement btnCookiePopUp;
	
	public void clickOnBtnModalClose(){
		btnModalClose.click();
	}
	
	public void clickOnBtnCookiePopUp(){
		btnCookiePopUp.click();
	}
	
	
	
	
}
