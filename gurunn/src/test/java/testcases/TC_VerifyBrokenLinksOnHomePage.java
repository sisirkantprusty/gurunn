package testcases;

import java.net.HttpURLConnection;
import java.net.URL;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import commonFunctions.commonFunctions;
import pageobjects.Guru99HomePage;

public class TC_VerifyBrokenLinksOnHomePage extends TestBase {
	Guru99HomePage guru99HomePage;
	String[] linksOnGuru99HomePage = null;
	SoftAssert softAssert;
	commonFunctions commonFunctions;

	public void verifyLinkActive(String[] linkUrls) {
		softAssert = new SoftAssert();
		try {
			for (String linkUrl : linkUrls) {
				URL url = new URL(linkUrl);
				HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
				httpURLConnect.setConnectTimeout(3000);
				httpURLConnect.connect();
				softAssert.assertTrue(httpURLConnect.getResponseCode() == 200, linkUrl + "does not 200-OK");
				if (httpURLConnect.getResponseCode() == 200) {
					System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());
				}

				softAssert.assertFalse(httpURLConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND, linkUrl
						+ " - " + httpURLConnect.getResponseMessage() + " - " + HttpURLConnection.HTTP_NOT_FOUND);

				if (httpURLConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
					System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage() + " - "
							+ HttpURLConnection.HTTP_NOT_FOUND);
				}
			}
		} catch (Exception e) {

		}
	}

	@Test
	public void verifyBrokenLinksOnHomePage() {
		logger = extent.createTest("Verify broken links on Guru99 Home Page");
		guru99HomePage = new Guru99HomePage(dr);
		commonFunctions = new commonFunctions();
		commonFunctions.waitForAnElementToBeVisible(guru99HomePage.webElemementLinkMobile(),20);
		linksOnGuru99HomePage = guru99HomePage.getLinksOnHomePage();
		verifyLinkActive(linksOnGuru99HomePage);
		softAssert.assertAll();

	}
}
