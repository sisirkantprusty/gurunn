package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pageobjects.Guru99HomePage;

public class TC_VerifyTitleAndSortProducts extends TestBase {

	Guru99HomePage guruhome;

	@Test
	public void verifyTitleAndSortProducts() {
		guruhome = new Guru99HomePage(dr);
		System.out.println("this is test");
		System.out.println(dr.getTitle());
		Assert.assertTrue(dr.getTitle().equalsIgnoreCase("Home page"),
				"The page title is not HOME PAGE. Raise a defect");
		guruhome.clickMobile();
		System.out.println("verify title is completed");
	}

	@Test
	public void verifyTitle() {
		guruhome = new Guru99HomePage(dr);
		guruhome.clickTV();

	}
}
