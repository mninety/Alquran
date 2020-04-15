package MyAction;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.Statement;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.StandardOpenOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;


import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.text.AbstractDocument.Content;


import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFBorderFormatting;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.sun.javafx.geom.transform.GeneralTransform3D;
/*import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeBodyPart;
import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeMultipart;
import com.sun.xml.internal.ws.wsdl.writer.document.Message;*/

import Hadis.HadisCollector;
import MyVariable.VariableModule;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import javafx.scene.control.Cell;
/*import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.rmi.transport.Transport;*/
import net.bytebuddy.dynamic.loading.ClassInjector;
import utils.InsertSQL;
import utils.TestData;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.IOException;
 

public class ActionModule {
	TestData testdata;
	//static Logger logActionModule = Logger.getLogger(ActionModule.class.getName());
	VariableModule variabledo;
	HadisCollector hadiscollector = new HadisCollector();
	static int RowCount=1;
	
	
/*	public static void EmailAction() {
		

	}*/
	
	public static String unicodeMaker(String text)
	{
		String unicode="";
		char[] cArray = text.toCharArray();
		for(int i=0;i<cArray.length;i++)
		{
			unicode=unicode.concat(String.valueOf(Character.toChars(Integer.parseInt(VariableModule.UnicodeArray[Character.getNumericValue(cArray[i])], 16))));
		}
		
		return unicode;
	}
	
	public static String unicodeEngMaker(String text)
	{
		String unicode="";
		char[] cArray = text.toCharArray();
		for(int i=0;i<cArray.length;i++)
		{
			unicode=unicode.concat(String.valueOf(Character.toChars(Integer.parseInt(VariableModule.UnicodeEngArray[Character.getNumericValue(cArray[i])], 16))));
		}
		
		return unicode;
	}
	
    public static String getCurrentHour() {
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat dateobject = new SimpleDateFormat("HH");
        return dateobject.format(date);
    }
    
	
	public static void MysqlFBHInsertData(int suraid, int ayatid, String FBID, int postID, Connection con)
	{
		String sql=null;
	    //Connection conn = null;
	    java.sql.Statement stmt = null;

	    try {
	    	//conn=MysqlConnection();


	        // STEP 5: Excute query
	    	//log.debug("\\nInserting records into table...");
	        System.out.print("\nInserting records into table...");
	        stmt = con.createStatement();

		        sql = "INSERT INTO FacebookHistory (fhSuraID,fhSuraAyatID,fhPostID,fhFBID)" +
			            " VALUES ("+suraid+","+ayatid+","+postID+",'"+FBID+"');";
		        //log.debug("SQL: "+sql);
		        System.out.println("SQL: "+sql);

	        stmt.executeUpdate(sql);
	        //log.debug(" SUCCESS!\\n");
	        System.out.println(" SUCCESS!\n");

	    } catch(SQLException se) {
	        se.printStackTrace();
	        //log.debug("E1: "+se);
	    } catch(Exception e) {
	        e.printStackTrace();
	        //log.debug("E2: "+e);
	    }
	    //log.debug("Thank you for your patronage!");
	    System.out.println("Thank you for your patronage!");
	    
	}
	
	public void MysqlHadisInsertData(int hdHadisID, int hdChapterID, String hdHadis_ar, String hdHadisNarratedBy, String hdHadis_bl, String hdHadisSonod, Connection con)
	{
		String sql=null;
	    //Connection conn = null;
		
	    java.sql.Statement stmt = null;

	    try {
	    	//conn=MysqlConnection();


	        //System.out.print("\nInserting records into table...");
	        stmt = con.createStatement();

		        sql = "INSERT INTO hadisdetails (hdHadisID,hdChapterID,hdHadis_ar,hdHadisNarratedBy,hdHadis_bl,hdHadisSonod,hdHadisSonod_bl)" +
			            " VALUES ("+hdHadisID+","+hdChapterID+",'"+hdHadis_ar+"','"+hdHadisNarratedBy+"','"+hdHadis_bl+"',"+hadiscollector.Sonod(hdHadisSonod)+",'"+hdHadisSonod+"');";
		        //logActionModule.debug(sql+"\n");
		        //InsertSQL insertsql = new InsertSQL(sql);
		        
		        System.out.println(sql);
		        
		        stmt.executeUpdate(sql);
		        System.out.println(" SUCCESS!\n");

	    } catch(SQLException se) {
	        se.printStackTrace();
	        //log.debug("E1: "+se);
	    } catch(Exception e) {
	        e.printStackTrace();
	        //log.debug("E2: "+e);
	    }
	    //log.debug("Thank you for your patronage!");
	    //System.out.println("Thank you for your patronage!");
	    
	}
	
	public static void MysqlChapterInsertData(int hcChapterID, String hcName_bl, int total, int max, Connection con)
	{
		String sql=null;
	    //Connection conn = null;
	    java.sql.Statement stmt = null;

	    try {
	    	//conn=MysqlConnection();


	        //System.out.print("\nInserting records into table...");
	        stmt = con.createStatement();

		        sql = "INSERT INTO hadischapter (hcChapterID,hcName_bl,hcTotalHadis,hcMaxID)" +
			            " VALUES ("+hcChapterID+",'"+hcName_bl+"',"+total+","+max+");";
		        //log.debug("SQL: "+sql);
		        System.out.println("SQL: "+sql);

	        stmt.executeUpdate(sql);
	        //log.debug(" SUCCESS!\\n");
	        System.out.println(" SUCCESS!\n");

	    } catch(SQLException se) {
	        se.printStackTrace();
	        //log.debug("E1: "+se);
	    } catch(Exception e) {
	        e.printStackTrace();
	        //log.debug("E2: "+e);
	    }
	    //log.debug("Thank you for your patronage!");
	    //System.out.println("Thank you for your patronage!");
	    
	}
	
	
	public static void MysqlConnectionActionUpdate(String Myquery, Connection conn)
	{

	    java.sql.Statement stmt = null;
		    
	    try {
	    	//CommonOSModule.conn=MysqlConnection();
	        stmt = conn.createStatement();
	        stmt.executeUpdate(Myquery);
	        //ConsolPrint("User is updated");
		    stmt.close();
		    //connection.close();
	} catch (SQLException e) {
	    throw new IllegalStateException("Cannot connect the database!", e);
	}
	    
	}
	

	public static String MysqlConnectionAction(String Myquery, Connection conn, String character)
	{

		String columnValue1="";
		String columnValue="";
		String[] URL=null;
	    //Connection connection = null;
	    java.sql.Statement stmt = null;
		    
	    try {
	    	//connection=CommonOSModule.MysqlConnection();
	    	stmt = conn.createStatement();
		    ResultSet rs=stmt.executeQuery(Myquery);
		    ResultSetMetaData rsmd = rs.getMetaData();
		    int columnsNumber = rsmd.getColumnCount();
		    int i;
		    while (rs.next()) {

		        for (i = 1; i <= columnsNumber; i++) {
		            //if (i > 1) System.out.print("\n");
		            columnValue = rs.getString(i);
		            if(columnValue==null)
		            {
		            	columnValue="";
		            }
		            if(columnValue.equals("NULL"))
		            {
		            	//System.out.print("NULL found:");
		            	columnValue="";
		            }
		            //DBValues[i]=columnValue;
		            //System.out.print("Test:"+columnValue);
		            //System.out.print(columnValue + " " + rsmd.getColumnName(i));
		            if(i<columnsNumber)
		            {
		            	columnValue1=columnValue1.concat(columnValue+character);
		            }
		            else
		            {

		            	columnValue1=columnValue1.concat(columnValue);

		            }
		        }
		        i=1;
		        if(!columnValue1.equals(""))
		        {
		        	columnValue1=columnValue1.concat("\n");
		        }
		    }
		    //System.out.print("Test:"+columnValue1);
		    stmt.close();
		    //connection.close();
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
		return columnValue1;
	}
	
    public void MysqlConnectOwn(Connection connect) throws IOException
    {

    		//variabledo.Ownconn=MysqlConnectionOwn();
    		System.out.println("Mysql Connection is getting: "+variabledo.Ownconn);
    		writing("Mysql Connection is getting: "+variabledo.Ownconn);
/*	    	if(VariableModule.Ownconn==null)
	    	{
	    		try {
					EmailModule.sendEmailWithAttachments("nafiul@revesoft.com", "MySQL connection is null", "Dear Team,\n\n"+VariableModule.server_IP+" server MySQL connection is getting null.\nPlease fix the MySQL connection issue otherwise Mail thread will be failed to send SQA mail.","5");
				} catch (AddressException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (javax.mail.MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}*/
    	
    }
    
    
    public void MysqlConnectionOwn() throws IOException
    {
    	//long startTime = System.currentTimeMillis();
    	testdata= new TestData();
    	String MySQLIP = testdata.properties.getProperty("MySQLIP");
    	String DBName = testdata.properties.getProperty("DBName");
    	String dbusername = testdata.properties.getProperty("dbusername");
    	String dbpassword = testdata.properties.getProperty("dbpassword");
    	
    	//Connection connt;
	    try {
	        // STEP 2: Register JDBC driver
	        Class.forName("com.mysql.jdbc.Driver");


	        Connection connt=DriverManager.getConnection("jdbc:mysql://"+MySQLIP+"/"+DBName, dbusername, dbpassword);
	        System.out.println("Connection: "+connt);
	        //writing(" Own Database Connected!\n");
	    }catch(Exception e) {
	        e.printStackTrace();
	    }

	    
/*	    public void close() throws SQLException {
	        databaseConnection.close();
	    }*/
	    //CommonAction.ExecuteTimeMeasure(startTime,"ProcessParserforCPU");
		//return connt;
    }
    

    


	public WebDriver ChromedriverAction() {
		System.setProperty("webdriver.chrome.driver",variabledo.chromedriver);
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
		WebDriver driver = new ChromeDriver(options);
		
	    
	    //WebDriver driver = new ChromeDriver();
	    return driver;
	}

	public WebDriver setupChrome()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
	
	public WebDriver setupFirefox()
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		//driver.manage().window().maximize();
		return driver;
	}
	
	
	public WebDriver setUp() 
	{
		WebDriver driver = null;
		try {
			//WebDriver driver;
			TestData testdata = new TestData();
			String browserName = testdata.properties.getProperty("browserName");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			//Create a instance of ChromeOptions class
			ChromeOptions options = new ChromeOptions();

			//Add chrome switch to disable notification - "**--disable-notifications**"
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		else if(browserName.equalsIgnoreCase("headless")) {
			ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--headless");
			chromeOptions.addArguments("--window-size=1920,1080");
			chromeOptions.addArguments("--start-maximized");
		    chromeOptions.addArguments("--allow-running-insecure-content");
		    //chromeOptions.addArguments("--remote-debugging-port=9222");
		    chromeOptions.addArguments("--whitelisted-ips"); 
		    //chromeOptions.setBinary("/usr/bin/google-chrome");
		    chromeOptions.addArguments("--disable-extensions"); // disabling extensions
		    chromeOptions.addArguments("--disable-gpu"); // applicable to windows os only
		    chromeOptions.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
		    chromeOptions.addArguments("--no-sandbox"); // Bypass OS security model
		    chromeOptions.addArguments("--disable-browser-side-navigation");
		    chromeOptions.addArguments("--always-authorize-plugins"); //Prevent render printing
		    //chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
			driver = new ChromeDriver(chromeOptions);

			
		}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;
	}

	
    public static void writing(String wget) {
        try {
            //Whatever the file path is.
        	File WFile = new File(VariableModule.driverlog+"/Output.txt");
        	//File WFile = new File(file_name);
        	FileWriter fw = new FileWriter(WFile,true);
/*            FileOutputStream is = new FileOutputStream(WFile);
            OutputStreamWriter osw = new OutputStreamWriter(is);    
            Writer w = new BufferedWriter(osw);*/
        	
        	if(wget!=null)
        	{
        	fw.write("\n"+wget+"\n");
        	}
            //fw.write(wget);
            //fw.write("\n");
            fw.close();
        } catch (IOException e) {
            System.err.println("Problem writing to the file Output.txt");
        }
    }
    
    
    
    public static void writinginFile(String replaceWith, String newthreshold) {
        try {
            // input the file content to the StringBuffer "input"
            BufferedReader file = new BufferedReader(new FileReader(VariableModule.driverlog+"/Config.txt"));
            String line;
            StringBuffer inputBuffer = new StringBuffer();
            String matchstr = null;
            while ((line = file.readLine()) != null) {
                if (line.contains(replaceWith)) {
                    matchstr=line;
                    
                }
                inputBuffer.append(line);
                inputBuffer.append('\n');
            }
            String inputStr = inputBuffer.toString();

            file.close();

            //System.out.println("Replace Threshold: \n"+inputStr); // check that it's inputted right

            // this if structure determines whether or not to replace "0" or "1"
            
            //System.out.printf("%.2f",newthreshold);
            //newthreshold = String.format("%.2f");
            if (inputStr.contains(replaceWith)) {
                inputStr = inputStr.replace(matchstr, replaceWith+newthreshold+";"); 
                //ActionModule.ConsolPrint("Date is updated with "+newthreshold,"");
                ActionModule.writing("Date Value is updated with "+newthreshold);
            }

            
            // check if the new input is right
            //System.out.println("----------------------------------\n"  + inputStr);

            // write the new String with the replaced line OVER the same file
            FileOutputStream fileOut = new FileOutputStream(VariableModule.driverlog+"/Config.txt");
            fileOut.write(inputStr.getBytes());
            fileOut.close();

        } catch (Exception e) {
            System.out.println("Problem reading file.");
        }
    }
    /*
    public static void ConsolPrint(String wget, String testresult) {

    	if(VariableModule.isWindows.equals("1"))
    	{
    	System.out.println(wget+"\n");
    	}
    }
    */
	
	public static String[] TokenizerAction(String splitString) //http://crunchify.com/java-stringtokenizer-and-string-split-example/
	{
		
		String delims = "=|,|:";
		//String delims = "[=+]";
		String[] tokens=splitString.split(delims);
/*	    for (int i=0; i< tokens.length; i++){
	      System.out.println("StringTokenizer Output: " +tokens[i]);
	    }*/
	    //System.out.println("StringTokenizer: " +tokens[3]);
	    return tokens;
	}
	
	


}
