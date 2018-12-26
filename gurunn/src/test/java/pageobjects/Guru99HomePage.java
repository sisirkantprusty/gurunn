package pageobjects;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Guru99HomePage extends pageObjectBase {
	public Guru99HomePage(WebDriver dr) {
		super(dr);
	}

	String[] phoneNames = null;
	int counter = 0;
	
	@FindBy(xpath = "//a[contains(text(),'Mobile')]")
	private WebElement linkMobile;

	@FindBy(xpath = "//a[contains(text(),'TV')]")
	private WebElement linkTv;

	@FindBy(xpath = "//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select")
	private WebElement selectMobileSorting;

	@FindBy(xpath = "//ul[@class='products-grid products-grid--max-4-col first last odd']/li")
	public List<WebElement> listOfPhoneNames;

	@FindBy(xpath = "//ul[@class='products-grid products-grid--max-4-col first last odd']")
	public WebElement listOfPhoneName;
	/*
	 * public Guru99HomePage(WebDriver driver) { this.driver = driver; // This
	 * initElements method will create all WebElements
	 * PageFactory.initElements(driver, this); }
	 */

	public void clickMobile() {
		linkMobile.click();
	}

	public void clickTV() {
		linkTv.click();
	}

	public void selectValueMobileSorting(String sortValue) {
		if (selectMobileSorting.isDisplayed()) {
			System.out.println("dropdown is displayed");
		}
		Select drpMobileSorting = new Select(selectMobileSorting);
		drpMobileSorting.selectByVisibleText(sortValue);
	}

	public void listNoOfElements() {
		System.out.println(listOfPhoneNames.size());
		for (int i = 0; i < listOfPhoneNames.size(); i++) {
			System.out.println(listOfPhoneNames);
		}
	}
	/**
	 * Function checks whether phone names are sorted or not
	 * @return true if the Phone Names are sorted in ascending order
	 */

	public boolean sortAndComparePhoneNames() {
		List<WebElement> list = listOfPhoneName.findElements(By.xpath("//li[@class='item last']/a[1]"));
		System.out.println("list is " + list.size());
		phoneNames = new String[list.size()];
		Iterator<WebElement> iter = list.iterator();
		while (iter.hasNext()) {
			WebElement we = iter.next();
			// System.out.println(we);
			System.out.println(we.getAttribute("title").toString());
			phoneNames[counter] = we.getAttribute("title").toString();
			System.out.println(phoneNames[counter]);
			counter++;
		}
		String[] copyOfPhoneNames = new String[list.size()];
		copyOfPhoneNames = Arrays.copyOf(phoneNames, list.size());
		Arrays.sort(copyOfPhoneNames);
		if (Arrays.equals(phoneNames, copyOfPhoneNames)) {
			return true;
		} else {
			return false;
		}
	}
}
