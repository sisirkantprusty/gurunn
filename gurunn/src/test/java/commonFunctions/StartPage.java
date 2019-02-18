package commonFunctions;

import base.TestBase;
import pageobjects.HMStartPage;

public class StartPage extends TestBase{
	HMStartPage hmStartPage;
	public void closePopUps() {
		try {
			hmStartPage = new HMStartPage(dr);
			hmStartPage.clickOnBtnModalClose();
			hmStartPage.clickOnBtnCookiePopUp();
		} catch (Exception e) {

		}
	}

}
