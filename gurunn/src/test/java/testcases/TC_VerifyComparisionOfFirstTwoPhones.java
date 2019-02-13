package testcases;

import org.testng.annotations.Test;

import base.TestBase;
import pageobjects.Guru99ComparePage;
import pageobjects.Guru99HomePage;
import utilities.Utilities;

public class TC_VerifyComparisionOfFirstTwoPhones extends TestBase {
	
	Guru99HomePage guruHome =null;
	Utilities util = null;
	Guru99ComparePage guruComparePhones=null;
	@Test
	public void VerifyComparisionOfFirstTwoPhones() {
		logger = extent.createTest("Verify Comparision of First 2 phones");
		guruHome = new Guru99HomePage(dr);
		util = new Utilities();
		guruComparePhones= new Guru99ComparePage(dr);
		
		//Click on Mobile link 
		guruHome.clickMobile();
		//Click on Add to compare for first phone 
		guruHome.clickFirstPhone();		
		//Click on Add to compare for the second phone 
		guruHome.clickSecondPhone();
		//Click on Compare button 
		guruHome.clickCompare();
		//Go to Pop up window
		util.goToNewWindow();
		//Close the window and return to main browser 
		guruComparePhones.closeWindow();
		//Go to main browser 
		util.goToNewWindow();
		
		
		
	}
}
