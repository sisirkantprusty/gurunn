package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class pageObjectBase {
	protected WebDriver dr;	
	public pageObjectBase(WebDriver dr) {
		 TestBase.dr = dr;
		PageFactory.initElements(dr, this);
	}
}
