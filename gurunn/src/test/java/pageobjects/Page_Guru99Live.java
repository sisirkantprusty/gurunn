package pageobjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Page_Guru99Live extends pageObjectBase {	

	@FindBy(xpath = "//img[@class='large']")
	private WebElement linkMobile;
	
	public Page_Guru99Live(WebDriver dr) {
		super(dr);
	}

	public void getTitles(){
		System.out.println("Title of the page is " + dr.getTitle().toString());
	}
	public void clickMobile()  {
		getTitles();
		
		try{
			linkMobile.click();
		}catch (NoSuchElementException e){
		System.out.println(e.toString());
		}
			
		System.out.println("Click on link Mobile - DONE");
	}

}
