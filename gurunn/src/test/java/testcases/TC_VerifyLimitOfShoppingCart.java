package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pageobjects.Guru99HomePage;
import pageobjects.Guru99ProductListPage;

public class TC_VerifyLimitOfShoppingCart extends TestBase {

	Guru99HomePage guruHome;
	Guru99ProductListPage guruProdList;

	@Test(description = "Test case to verify that user can not add more than Product available in the store", groups = {"shoppingcart"})
	public void verifyLimitOfShoppingCart() throws InterruptedException {
		
		logger = extent.createTest("Verify limit of articles in shopping cart");
		
		guruHome = new Guru99HomePage(dr);
		guruProdList = new Guru99ProductListPage(dr);
		guruHome.clickMobile();
		// Click on first item on the list
		guruHome.clickFirstItemOnList();
		guruProdList.enterQuantity(1000);
		guruProdList.submitAddtoCart();
		Thread.sleep(1000);
		Assert.assertTrue(guruProdList.verifyMessage("The maximum quantity allowed for purchase is 500"),
				"The message - The maximum quantity allowed for purchase is 500 - does not appear");
		guruProdList.clickLinkCart();
		Thread.sleep(500);
		Assert.assertTrue(guruProdList.verifyEmptyCartMessage("You have no items in your shopping cart."),
				"Cart is not empty");
	}
}
