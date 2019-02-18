package pageobjects;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;

public class Guru99HomePage extends pageObjectBase {
	// Guru99ProductListPage guruProdList;

	public Guru99HomePage(WebDriver dr) {
		super(dr);
	}

	String[] phoneNames = null;
	int counter = 0;
	boolean flag = false;
	WebElement productName, productPrice;
	String prodPrice;
	String[] linksOnGuru99HomePage = null;

	@FindBys({ @FindBy(tagName = "a") })
	protected List<WebElement> linksOnHomePage;

	@FindBy(xpath = "//a[contains(text(),'Mobile')]")
	private WebElement linkMobile;

	@FindBy(xpath = "//a[contains(text(),'TV')]")
	private WebElement linkTv;

	@FindBy(xpath = "//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select")
	private WebElement selectMobileSorting;

	@FindBy(xpath = "//ul[@class='products-grid products-grid--max-4-col first last odd']")
	public WebElement listOfPhoneName;
	/*
	 * public Guru99HomePage(WebDriver driver) { this.driver = driver; // This
	 * initElements method will create all WebElements
	 * PageFactory.initElements(driver, this); }
	 */

	// Following is used to find the elements which is stored in specialPrice
	@FindBys({ @FindBy(xpath = "//span[contains(text(),'Special Price')]") })
	protected List<WebElement> specialPrice;

	@FindBy(xpath = "//span[@class='price']")
	protected WebElement labelPrice;

	@FindBy(xpath = "//p[@class='special-price']//span[@class='price']")
	protected WebElement specialPriceInProdListPage;

	@FindBy(id = "product-collection-image-1")
	protected WebElement firstItemInList;

	@FindBy(xpath = "//div[@class='category-products']//li[1]//li[2]")
	protected WebElement lnkFirstPhone;

	@FindBy(xpath = "//div[@class='category-products']//li[2]//li[2]")
	protected WebElement lnkSecondPhone;

	@FindBy(xpath = "//li[@class='success-msg']")
	protected WebElement lblSuccessMessage;

	@FindBy(xpath = "//button[@title='Compare']")
	protected WebElement btnCompare;

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

	/**
	 * Function checks whether phone names are sorted or not
	 * 
	 * @return true if the Phone Names are sorted in ascending order
	 */

	public boolean sortAndComparePhoneNames() {
		List<WebElement> list = listOfPhoneName.findElements(By.xpath("//li[@class='item last']/a[1]"));
		System.out.println("list is " + list.size());
		int noOfPhones = list.size();
		phoneNames = new String[noOfPhones];
		Iterator<WebElement> iter = list.iterator();
		while (iter.hasNext()) {
			WebElement we = iter.next();
			System.out.println(we.getAttribute("title").toString());
			phoneNames[counter] = we.getAttribute("title").toString();
			System.out.println(phoneNames[counter]);
			counter++;
		}
		String[] copyOfPhoneNames = new String[noOfPhones];
		copyOfPhoneNames = Arrays.copyOf(phoneNames, noOfPhones);
		Arrays.sort(copyOfPhoneNames);
		if (Arrays.equals(phoneNames, copyOfPhoneNames)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean comparePriceInListAndPdp() throws InterruptedException {
		List<WebElement> list = listOfPhoneName.findElements(By.xpath("//li[@class='item last']/a[1]"));
		System.out.println("list is " + list.size());
		int noOfPhones = list.size();

		for (int i = 0; i < noOfPhones; i++) {
			productPrice = listOfPhoneName.findElement(By.xpath("//span[@id='product-price-" + (i + 1) + "']"));
			prodPrice = productPrice.getText();
			System.out.println("prod price is " + prodPrice);
			productName = listOfPhoneName
					.findElement(By.xpath("//img[@id='product-collection-image-" + (i + 1) + "']"));
			productName.click();
			Thread.sleep(3000);
			if (specialPrice.size() != 0) {
				if (prodPrice.equalsIgnoreCase(specialPriceInProdListPage.getText().toString())) {
					System.out.println("Special Price is not null - Both prices are equal");
					flag = true;
				} else {
					System.out.println("Special Price is not null - Both prices are not equal");
					flag = false;
				}
			} else {
				if (prodPrice.equalsIgnoreCase(labelPrice.getText().toString())) {
					System.out.println("Special Price null - Both prices are equal");
					flag = true;
				} else {
					System.out.println("Special Price null - Both prices are not equal");
					flag = false;
				}
			}
			clickMobile();
		}
		return flag;
	}

	public void clickFirstItemOnList() {
		firstItemInList.click();
	}

	public void clickFirstPhone() {
		lnkFirstPhone.click();
	}

	public void clickSecondPhone() {
		lnkSecondPhone.click();
	}

	public String getPhoneName() {
		String msg = lblSuccessMessage.getText().toString();
		return msg;
	}

	public void clickCompare() {
		btnCompare.click();
	}

	public String[] getLinksOnHomePage() {
		for (int i = 0; i < linksOnHomePage.size(); i++) {
			WebElement ele = linksOnHomePage.get(i);
			linksOnGuru99HomePage[i] = ele.getAttribute("href");
		}
		return linksOnGuru99HomePage;
	}

}
