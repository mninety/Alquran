package utils;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class DriverData {

	TestData testdata;
	
    public WebDriver DriverSelection(String flag)
    {
    	WebDriver driver = null;
    	if(flag.equals("1"))
    	{
			/*
			 * System.setProperty("webdriver.firefox.marionette",driverlog+
			 * "/geckodriver_new.exe"); DesiredCapabilities capabilities =
			 * DesiredCapabilities.firefox(); capabilities.setCapability("marionette",true);
			 * //DesiredCapabilities capability = DesiredCapabilities.firefox(); driver =
			 * new FirefoxDriver();
			 */
    		 
    	        System.setProperty("webdriver.gecko.driver", testdata.properties.getProperty("driverlog")+"/geckodriver_new.exe");
    	        DesiredCapabilities cap = DesiredCapabilities.firefox();
    	        cap.setCapability("marionette", true);
    	        driver = new FirefoxDriver(cap);
    	}
    	else if(flag.equals("2"))
    	{
    		System.setProperty("webdriver.chrome.driver","D:/Incruiter/chromedriver_new.exe");
    		//DesiredCapabilities capability = DesiredCapabilities.firefox();
    		 //driver = new ChromeDriver();
    		 
    			//Create prefs map to store all preferences 
    			Map<String, Object> prefs = new HashMap<String, Object>();

    			//Put this into prefs map to switch off browser notification
    			prefs.put("profile.default_content_setting_values.notifications", 2);

    			//Create chrome options to set this prefs
    			ChromeOptions options = new ChromeOptions();
    			options.setExperimentalOption("prefs", prefs);

    			/*
    			if(VariableModule.isGUI.equals("2"))
    			{
    				options.addArguments("--headless");
    			}
    			*/
    			//Now initialize chrome driver with chrome options which will switch off this browser notification on the chrome browser
    			driver = new ChromeDriver(options);
    	}

    	return driver;
    }
    
    public String getCurrentDate() {
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat dateobject = new SimpleDateFormat("ddMMyyyy-HHmmss");
        return dateobject.format(date);
    }
    
	public String RandomStringGen(int len)
	{
		
		final String AB = "abcdefghijklmnopqrstuvwxyz";
		SecureRandom rnd = new SecureRandom();

		
		   StringBuilder sb = new StringBuilder( len );
		   for( int i = 0; i < len; i++ ) 
		      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		   
		   return sb.toString();
		
	}
	
	public String RandomNumberGen(int len)
	{
		
		final String AB = "0123456789";
		SecureRandom rnd = new SecureRandom();

		
		   StringBuilder sb = new StringBuilder( len );
		   for( int i = 0; i < len; i++ ) 
		      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		   
		   return sb.toString();
		
	}
	

}
