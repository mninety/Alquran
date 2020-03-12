package PagesRepository;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.TestData;

public class SOC {
	
	
	WebDriver driver;
	
	//Constructor
		public SOC(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//h3[@class='hidden-print']")
		public List<WebElement> hadisID;
		
		@FindBy(xpath="//p[@class='hadith-des2']")
		public List<WebElement> hadisAR;
		
		@FindBy(xpath="//p[@class='narrated-by']")
		public List<WebElement> hadisNarratedby;
		
		@FindBy(xpath="//p[@class='hadith-des']")
		public List<WebElement> hadisBL;
		
		@FindBy(xpath="//span[@class='label validity']")
		public List<WebElement> hadisSonod;
		
		public String gethadisID(int i){

			return hadisID.get(i).getText();
		}
		
		public String gethadisAR(int i){

			return hadisAR.get(i).getText();
		}
		
		public String gethadisNarratedby(int i){

			return hadisNarratedby.get(i).getText();
		}
		
		public String gethadisBL(int i){

			return hadisBL.get(i).getText();
		}
		
		public String gethadisSonod(int i){

			return hadisSonod.get(i).getText();
		}
}

