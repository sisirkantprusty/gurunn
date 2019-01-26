package utilities;

import org.openqa.selenium.WebDriver;

import base.TestBase;

public class Utilities extends TestBase {

	public void goToNewWindow() {
		for (String handle : dr.getWindowHandles()) {
			dr.switchTo().window(handle);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
