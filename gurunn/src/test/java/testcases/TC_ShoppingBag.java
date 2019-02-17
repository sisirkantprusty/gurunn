package testcases;

import org.testng.annotations.Test;

import base.TestBase;
import commonFunctions.StartPage;

public class TC_ShoppingBag extends TestBase{
	StartPage hmStartPage;
	

	@Test
	public void VerifyAddItemCompareInShoppingBag() {
		hmStartPage = new StartPage();
		hmStartPage.closePopUps();
	}
}
