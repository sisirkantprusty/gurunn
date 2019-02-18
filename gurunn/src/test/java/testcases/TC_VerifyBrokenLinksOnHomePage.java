package testcases;

import java.net.HttpURLConnection;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.TestBase;
import pageobjects.Guru99HomePage;

public class TC_VerifyBrokenLinksOnHomePage extends TestBase {
	Guru99HomePage guru99HomePage;
	String[] linksOnGuru99HomePage;

	public void verifyLinkActive(String[] linkUrls) {
		try {
			for (String linkUrl : linkUrls) {
				URL url = new URL(linkUrl);
				HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
				httpURLConnect.setConnectTimeout(3000);
				httpURLConnect.connect();
				if (httpURLConnect.getResponseCode() == 200) {
					System.out.println(linkUrls + " - " + httpURLConnect.getResponseMessage());
				}
				if (httpURLConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
					System.out.println(linkUrls + " - " + httpURLConnect.getResponseMessage() + " - "
							+ HttpURLConnection.HTTP_NOT_FOUND);
				}
			}
		} catch (Exception e) {

		}

	}

	@Test
	public void verifyBrokenLinksOnHomePage() {
		guru99HomePage = new Guru99HomePage(dr);
		linksOnGuru99HomePage=guru99HomePage.getLinksOnHomePage();
		verifyLinkActive(linksOnGuru99HomePage);

	}
}
