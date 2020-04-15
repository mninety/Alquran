package Firebug;

import java.io.IOException;
//import org.openqa.selenium.webdriver.common.action_chains;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import MyAction.ActionModule;
import MyVariable.VariableModule;
import Starting.MySQLPINGModule;
import utils.TestData;



public class FirebugModule {
	static Logger logFirebugModule = Logger.getLogger(FirebugModule.class.getName());
	ActionModule actiondo= new ActionModule();
    public void FacebookLogin(String post) throws IOException {

        //WebDriver driver = new FirefoxDriver();
    	TestData testdata= new TestData();
    	WebDriver driver = actiondo.setUp();
        //WebDriver driver = ActionModule.HtmlUnitDriver();
       
        //driver.manage().window().maximize();
    	//String MySQLIP = testdata.properties.getProperty("Url");
        driver.get(testdata.properties.getProperty("Url"));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.name("email")).sendKeys(testdata.properties.getProperty("FBuserName"));
        driver.findElement(By.name("pass")).sendKeys(testdata.properties.getProperty("FBpwd"));
        driver.findElement(By.xpath("//input[contains(@value,'Log In')]")).click();
        
        try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}                
        System.out.println("logged in successfully");
        //logFirebugModule.debug("logged in successfully"); 
        
        driver.findElement(By.xpath("//div[@class='_3nd0']/div[@role='presentation']")).click();
        //driver.findElement(By.className("_1mf _1mj")).sendKeys("Test");
        WebElement elem=driver.findElement(By.cssSelector("._1mf._1mj"));
        //driver.findElement(By.xpath("//*[@class='_1mf _1mj']")).sendKeys("Test");
        Actions builder = new Actions(driver);
        builder.moveToElement(elem);
        builder.click();
        builder.sendKeys(post);//post
        builder.perform();
        driver.findElement(By.className("_6c0o")).click();
        try {
            Thread.sleep(10000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Post Successful");
        logFirebugModule.debug("Post Successful");
        driver.quit();

    }
}
