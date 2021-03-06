package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pageobjects.Guru99HomePage;
import pageobjects.Guru99ProductListPage;

public class TC_VerifyPriceOfProductInPdpPage extends TestBase {
	Guru99HomePage guruHome;
	Guru99ProductListPage guruProdList;

	@Test(groups = "productlist")
	public void VerifyPriceOfProductInPdpPage() throws InterruptedException {
		logger = extent.createTest("Verify Price of Product in PDP");
		guruHome = new Guru99HomePage(dr);
		guruProdList = new Guru99ProductListPage(dr);
		guruHome.clickMobile();
		Assert.assertTrue(guruHome.comparePriceInListAndPdp(),
				"Price in home page and product listing page are not equal");
	}
}
