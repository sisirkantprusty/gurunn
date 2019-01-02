package utilities;

import org.openqa.selenium.WebDriver;

import base.TestBase;

public class Utilities extends TestBase {

	public void goToNewWindow() {
		for (String handle : dr.getWindowHandles()) {
			dr.switchTo().window(handle);
		}
	}
}
