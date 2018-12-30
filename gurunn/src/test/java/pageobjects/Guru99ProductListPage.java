package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class Guru99ProductListPage extends pageObjectBase {

	public Guru99ProductListPage(WebDriver dr) {
		super(dr);
		// TODO Auto-generated constructor stub
	}

	@FindBys({ @FindBy(xpath = "//span[contains(text(),'Special Price')]") })
	protected List<WebElement> specialPrice;

	@FindBy(xpath = "//span[@class='price']")
	protected WebElement labelPrice;

	@FindBy(xpath = "//input[@id='qty']")
	protected WebElement txtQuantity;

	@FindBy(xpath = "//span[contains(text(),'Add to Cart')]")
	protected WebElement btnAddToCart;

	@FindBy(xpath = "//li[@class='error-msg']//span")
	protected WebElement lblErrorMessage;

	@FindBy(xpath = "//p[@class='empty']")
	protected WebElement lblEmptyCartMessage;
	
	
	@FindBy(xpath = "//span[@class='label'][contains(text(),'Cart')]")
	protected WebElement lnkCart;
	

	

	public boolean isLableSpecialPriceAvailable() {
		if (specialPrice.size() != 0)
			return true;
		else
			return false;
	}

	public void enterQuantity(int noOfQty) {
		txtQuantity.clear();
		txtQuantity.sendKeys(Integer.toString(noOfQty));
	}

	public void submitAddtoCart() {
		btnAddToCart.click();
	}

	public boolean verifyMessage(String errorMessage) {
		if (lblErrorMessage.getText().contains(errorMessage)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyEmptyCartMessage(String emptyCartMessage) {
		if (lblEmptyCartMessage.getText().equalsIgnoreCase(emptyCartMessage))
			return true;
		else
			return false;
	}
	
	public void clickLinkCart(){
		lnkCart.click();
	}
}
