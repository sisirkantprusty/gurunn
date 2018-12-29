package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pageobjects.Guru99HomePage;

public class TC_VerifyTitleAndSortProducts extends TestBase {

	Guru99HomePage guruHome;

	@Test
	public void verifyTitleAndSortProducts() throws InterruptedException {
		guruHome = new Guru99HomePage(dr);
		System.out.println("this is test");
		System.out.println(dr.getTitle());
		Assert.assertTrue(dr.getTitle().equalsIgnoreCase("Home page"),
				"The page title is not HOME PAGE. Raise a defect");
		guruHome.clickMobile();
		Thread.sleep(2000);
		guruHome.selectValueMobileSorting("Name");
		Assert.assertTrue(guruHome.sortAndComparePhoneNames(),
				"The sequence of phone names are not in aphabetical order");
		System.out.println("verify title is completed");
	}
}
