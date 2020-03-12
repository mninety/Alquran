package PagesRepository;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.TestData;

public class CreateTripPage {
	
	
	WebDriver driver;
	
	//Constructor
		public CreateTripPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
	//Page constants
	@FindBy(xpath = "//button")	
	public WebElement pickupdate;
	
	@FindBy(xpath = "//div[@class='btn-light bg-primary text-white ng-star-inserted']")
	public WebElement currentdate;
	
	@FindBy(xpath = "//input[@class='ngb-tp-input form-control']")	
	public List<WebElement> pickuptime;
	
	
	
	public void pickupdatemethod(int i){

		pickuptime.get(i).click();
	}
	
	public void pickuptimeset(int i, String time){

		pickuptime.get(i).sendKeys(time);
	}
	

	
}

