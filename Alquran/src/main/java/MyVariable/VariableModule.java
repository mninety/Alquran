package MyVariable;

import MyAction.ActionModule;
import PagesRepository.SOC;
import Quran.QuranCollector;
import Starting.MySQLPINGModule;
import utils.TestData;

import org.apache.log4j.Logger;
import java.awt.TrayIcon;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.swing.SwingUtilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Firebug.FirebugModule;
import Hadis.HadisCollector;

//import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil.ToStringAdapter;



public class VariableModule {
	TestData  testdata;
	//ActionModule actiondo = new ActionModule();
	//static Logger logVariableModule = Logger.getLogger(VariableModule.class.getName());
	ActionModule actiondo;
	//log.info("Error in: " + this.getClass.getName() + "at line #"+ this.getClass.getActualLine());
	
	MySQLPINGModule ThreadMysqlPingdo;

	//public Static String file_name="E:/Automation/Logs/Output.txt";
	public static String driverlog="D:/Configuration/DreamProject"; // linux=/home/dailyqur/DreamProject // Windows=D:/Configuration/DreamProject
	//public static String isWindows=readVariable("isWindows",1); //1 for windows, 2 for linux
	//public static String isGUI=readVariable("isGUI",1); // 1 for GUI, 2 for non GUI

	/*
	public static String Url = readVariable("Url",1);
	public static String FBuserName = readVariable("FBuserName",1);
	public static String FBpwd = readVariable("FBpwd",1);
	*/
	
	public VariableModule()
	{
		
	}
	public  Connection Ownconn=null;
	
	//public static String mysqlurl = readVariable("mysqlurl",1);
	
	/*
	public static String MySQLIP = readVariable("MySQLIP",1);
	public static String DBName = readVariable("DBName",1);
	public static String dbusername = readVariable("dbusername",1);
	public static String dbpassword = readVariable("dbpassword",1);
	*/
	public String chromedriver = "";
	
	//public static String isSchedule = readVariable("isSchedule",1);
	//public static String ScheduleDate = readVariable("ScheduleDate",1);
	
	/*
	public String Post = "";
	public String Tracking = "";
    public String PostID = "";
    */
    public static int totalcases=0;
    public static int totalfailedcases=0;
    public static String[] UnicodeArray= {"09E6","09E7","09E8","09E9","09EA","09EB","09EC","09ED","09EE","09EF"};
    public static String[] UnicodeEngArray= {"0030","0031","0032","0033","0034","0035","0036","0037","0038","0039"};

    
    public void StartModule()
    {

    	try {
    		/*
        	if(isWindows.equals("1"))
        	{
        		chromedriver = driverlog+"/chromedriver_new.exe";
        	}
        	else
        	{
        		chromedriver = driverlog+"/chromedriver";
        	}
        	*/
    		CommonThread();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
    }

    public void CommonThread() throws IOException
    {
    	FirebugModule fire = new FirebugModule();

    	//System.out.println("Current Thread: "+Thread.currentThread().getName());
    	
    	//actiondo.MysqlConnectOwn(Ownconn);
    	//System.out.println("Connection: "+actiondo.MysqlConnectionOwn());
    	
    	testdata= new TestData();
    	HadisCollector hadiscollector = new HadisCollector();
    	QuranCollector qurancollector = new QuranCollector();
    	String MySQLIP = testdata.properties.getProperty("MySQLIP");
    	String DBName = testdata.properties.getProperty("DBName");
    	String dbusername = testdata.properties.getProperty("dbusername");
    	String dbpassword = testdata.properties.getProperty("dbpassword");
    	
    	//Connection connt;
	    try {
	        // STEP 2: Register JDBC driver
	        Class.forName("com.mysql.jdbc.Driver");


	        Ownconn=DriverManager.getConnection("jdbc:mysql://"+MySQLIP+"/"+DBName+"?useUnicode=yes&characterEncoding=UTF-8", dbusername, dbpassword);
	        System.out.println("Connection: "+Ownconn);
	        //hadiscollector.InsertHadis(163, "http://ihadis.com/books/sahih-hadise-kudsi", Ownconn);
	        //Missingfindout(4341,Ownconn);
	        //qurancollector.BanglaTranslationCollector("http://www.quranmazid.com/view/sura/", Ownconn);
	        FBPost(Ownconn);
	        //fire.FacebookPOST("Test");
	    }catch(Exception e) {
	        e.printStackTrace();
	    }
	    
    	
    	
    	//************atIsMemorize Find out************
/*    	System.out.println("List:\n");
    	for(int t=1;t<115;t++)
    	{
	    	String hcID=ActionModule.MysqlConnectionAction("select atSuraAyatID from ayat where atIsMemorize=1 and atSuraID="+t, VariableModule.Ownconn, ",");
	    	//hcID=hcID.substring(0, hcID.length()-1);
	    	if(hcID.equals(""))
	    	{
	    		System.out.println("SuraID: "+t+" -=> 0\n");
	    	}
	    	else
	    	{
	    		hcID=hcID.replaceAll("\n", ",");
	    		hcID=hcID.substring(0, hcID.length()-1);
	    		System.out.println("SuraID: "+t+" -=> "+hcID+"\n");
	    	}

    	}*/
    	
    	//*************Chapter Insert************
	    //HadisCollector.ChapterCollectorAction("http://ihadis.com/books/ibn-majah");
    	
    	
    	//***************Hadis Insert****************
/*    	for(int t=8;t<48;t++)
    	{
	    	String hcID=ActionModule.MysqlConnectionAction("select hcTotalHadis,hcMaxID from hadischapter where hcBookID=5 and hcChapterID="+t, VariableModule.Ownconn, ",");
	    	hcID=hcID.substring(0, hcID.length()-1);
	    	String[] totalMaxArray = hcID.split(",");
	    	HadisCollector.HadisCollectorAction("http://ihadis.com/books/tirmidi/chapter/"+String.valueOf(t),Integer.parseInt(totalMaxArray[0]),t,Integer.parseInt(totalMaxArray[1]));
    	}
    	System.out.println("The End!!!");*/
    }



    public void Missingfindout(int max,Connection Ownconn)
    {
    	VariableModule variablemodule = new VariableModule();
    	HadisCollector hadiscollector = new HadisCollector();
		String checkHistory="select hdHadisID from hadisdetails where hdBookID=6";
		//System.out.println("Select SQL: "+checkHistory);
		String hadisID=ActionModule.MysqlConnectionAction(checkHistory, Ownconn, ",");
		//System.out.println("HadisID: "+hadisID);
		String[] hadisIDArray = hadisID.split("\n");
		//String[] hadisIDArray= {"2","3","6","8","9"};
		//System.out.println("HadisID Lenght: "+hadisIDArray.length);
		//int[] missinghadisArray = new int[5000];
		List<Integer> missinghadisArray = new ArrayList<>();
		int count=0;
		int bak=0;
    	for(int i=1;i<max;i++)
    	{
    			
    			//System.out.println("I:"+i);
    		if(bak<hadisIDArray.length)
    		{
    			
    		
        		if(i==Integer.parseInt(hadisIDArray[bak]))
        		{
        			//System.out.println("Matching: "+Integer.parseInt(hadisIDArray[bak]));
        			bak++;
        			//System.out.println("BAK:"+bak);
        			continue;
        		}
        		else if(i<Integer.parseInt(hadisIDArray[bak]))
        		{
        			missinghadisArray.add(count, i);
        			System.out.println("Missing ID: "+missinghadisArray.get(count));
        			count++;
        		}
    		}
        	else
        		{
        			missinghadisArray.add(count, i);
        			System.out.println("Missing ID: "+missinghadisArray.get(count));
        			count++;
        		}
        		
    	}
    	
    		System.out.println("Missing ID Total: "+count);
	    	hadiscollector.MissingHadisCollector(missinghadisArray, "http://ihadis.com/books/ibn-majah", Ownconn);
	 
    	
    }

    
    public void PostAction(Connection Ownconn) throws IOException
	{
		
		testdata = new TestData();
		FirebugModule facebook = new FirebugModule();
		String Post = testdata.properties.getProperty("Post");
		String PostID = testdata.properties.getProperty("PostID");
		System.out.println("Post: "+Post);
		String postID="";
		

		
		if(PostID.equals(""))
		{
			postID=Integer.toString(1);
		}
		else
		{
			postID=Integer.toString((Integer.parseInt(PostID)+1));
		}
		
		@SuppressWarnings("unused")
		boolean flag;
		String[] postArray = Post.split(":");
		
		System.out.println("Sura: "+postArray[0]);
		System.out.println("Ayat: "+postArray[1]);
		String[] ayatArray = null;
		if(postArray[1].indexOf("-") != -1)
		{
			flag=true;
			ayatArray = postArray[1].split("-");
		}
		else
		{
			flag=false;
			//ayatArray=postArray[1];
		}
		System.out.println("Flag: "+flag);
		if(flag)
		{
			
			String checkHistory="select * from facebookhistory where fhSuraID="+postArray[0]+" and fhSuraAyatID between "+ayatArray[0]+" and "+ayatArray[1];
			System.out.println("Select SQL: "+checkHistory);
			String hisData=ActionModule.MysqlConnectionAction(checkHistory, Ownconn, ",");
			if(hisData.equals(""))
			{
			
				String Myquery="select atAyatMeaning_bl from ayat where atSuraID="+postArray[0]+" and atSuraAyatID between "+ayatArray[0]+" and "+ayatArray[1];
				System.out.println("Select SQL: "+Myquery);
				String dbData=ActionModule.MysqlConnectionAction(Myquery, Ownconn, ",");
				dbData=dbData.substring(0, dbData.length()-1);
				//System.out.println("Data: "+dbData);
				String SuraName=ActionModule.MysqlConnectionAction("select snName_bl from suraname where snSuraID="+postArray[0], Ownconn, ",");
				SuraName=SuraName.substring(0, SuraName.length()-1);
				System.out.println("Data: "+"\""+dbData+"\""+" ---[সুরা "+SuraName+" "+ActionModule.unicodeMaker(postArray[0])+":"+ActionModule.unicodeMaker(ayatArray[0])+"-"+ActionModule.unicodeMaker(ayatArray[1])+"]");
				facebook.FacebookLogin("\""+dbData+"\""+" ---[সুরা "+SuraName+" "+ActionModule.unicodeMaker(postArray[0])+":"+ActionModule.unicodeMaker(ayatArray[0])+"-"+ActionModule.unicodeMaker(ayatArray[1])+"]");
				
				/*
				for(int i=Integer.parseInt(ayatArray[0]);i<=Integer.parseInt(ayatArray[1]);i++)
				{
					ActionModule.MysqlFBHInsertData(Integer.parseInt(postArray[0]),i,"",Integer.parseInt(postID),VariableModule.Ownconn);
				}
				ActionModule.writinginFile("Post=","");
				ActionModule.writinginFile("Tracking=",Post);
				ActionModule.writinginFile("PostID=",postID);
				*/
			}
			else
			{
				System.out.println("Already Posted");
			}
		}
		else
		{
			
			String checkHistory="select * from facebookhistory where fhSuraID="+postArray[0]+" and fhSuraAyatID="+postArray[1];
			System.out.println("Select SQL: "+checkHistory);
			String hisData=ActionModule.MysqlConnectionAction(checkHistory, Ownconn, ",");
			if(hisData.equals(""))
			{
			
				String Myquery="select atAyatMeaning_bl from ayat where atSuraID="+postArray[0]+" and atSuraAyatID="+postArray[1];
				System.out.println("Select SQL: "+Myquery);
				String dbData=ActionModule.MysqlConnectionAction(Myquery, Ownconn, ",");
				dbData=dbData.substring(0, dbData.length()-1);
				//System.out.println("Data: "+dbData);
				String SuraName=ActionModule.MysqlConnectionAction("select snName_bl from suraname where snSuraID="+postArray[0], Ownconn, ",");
				SuraName=SuraName.substring(0, SuraName.length()-1);
				System.out.println("Data: "+"\""+dbData+"\""+" ---[সুরা "+SuraName+" "+ActionModule.unicodeMaker(postArray[0])+":"+ActionModule.unicodeMaker(postArray[1])+"]");
				facebook.FacebookLogin("\""+dbData+"\""+" ---[সুরা "+SuraName+" "+ActionModule.unicodeMaker(postArray[0])+":"+ActionModule.unicodeMaker(postArray[1])+"]");
				/*
				ActionModule.MysqlFBHInsertData(Integer.parseInt(postArray[0]),Integer.parseInt(postArray[1]),"",Integer.parseInt(postID),VariableModule.Ownconn);
				ActionModule.writinginFile("Post=","");
				ActionModule.writinginFile("Tracking=",Post);
				ActionModule.writinginFile("PostID=",postID);
				*/
			}
			else
			{
				System.out.println("Already Posted");
			}
		}
	}

    public void FBPost(Connection Ownconn) throws IOException
	{
		
		testdata = new TestData();
		FirebugModule facebook = new FirebugModule();
		String Post = testdata.properties.getProperty("Post");
		//String PostID = testdata.properties.getProperty("PostID");
		System.out.println("Post: "+Post);
		//String postID="";
		
		@SuppressWarnings("unused")
		boolean flag;
		String[] postArray = Post.split(":");
		
		System.out.println("Sura: "+postArray[0]);
		System.out.println("Ayat: "+postArray[1]);
		String[] ayatArray = null;
		if(postArray[1].indexOf("-") != -1)
		{
			flag=true;
			ayatArray = postArray[1].split("-");
		}
		else
		{
			flag=false;
			//ayatArray=postArray[1];
		}
		System.out.println("Flag: "+flag);
		if(flag)
		{
			

				String Myquery="select atAyatMeaning_bl from ayat where atSuraID="+postArray[0]+" and atSuraAyatID between "+ayatArray[0]+" and "+ayatArray[1];
				//System.out.println("Select SQL: "+Myquery);
				String dbData=ActionModule.MysqlConnectionAction(Myquery, Ownconn, ",");
				dbData=dbData.substring(0, dbData.length()-1);
				//System.out.println("Data: "+dbData);
				String SuraName=ActionModule.MysqlConnectionAction("select snName_bl from suraname where snSuraID="+postArray[0], Ownconn, ",");
				SuraName=SuraName.substring(0, SuraName.length()-1);
				System.out.println("Data: "+"\""+dbData+"\""+" ---[সূরা "+SuraName+" "+ActionModule.unicodeMaker(postArray[0])+":"+ActionModule.unicodeMaker(ayatArray[0])+"-"+ActionModule.unicodeMaker(ayatArray[1])+"]");
				//facebook.FacebookLogin("\""+dbData+"\""+" ---[সুরা "+SuraName+" "+ActionModule.unicodeMaker(postArray[0])+":"+ActionModule.unicodeMaker(ayatArray[0])+"-"+ActionModule.unicodeMaker(ayatArray[1])+"]");
				
		}
		else
		{
			
				String Myquery="select atAyatMeaning_bl from ayat where atSuraID="+postArray[0]+" and atSuraAyatID="+postArray[1];
				//System.out.println("Select SQL: "+Myquery);
				String BanglaData=ActionModule.MysqlConnectionAction(Myquery, Ownconn, ",");
				BanglaData=BanglaData.substring(0, BanglaData.length()-1);
				//System.out.println("Data: "+BanglaData);
				
				String SuraName=ActionModule.MysqlConnectionAction("select snName_bl from suraname where snSuraID="+postArray[0], Ownconn, ",");
				SuraName=SuraName.substring(0, SuraName.length()-1);
				System.out.println("Data: "+"\""+BanglaData+"\""+" ---[সূরা "+SuraName+" "+ActionModule.unicodeMaker(postArray[0])+":"+ActionModule.unicodeMaker(postArray[1])+"]");
				//facebook.FacebookLogin("\""+BanglaData+"\""+" ---[সুরা "+SuraName+" "+ActionModule.unicodeMaker(postArray[0])+":"+ActionModule.unicodeMaker(postArray[1])+"]");
				
		}
	}

	
    /*
	public static String readVariable(String var, int configflag)
	{
		int flag=0;
		int gotvar=0;
		Character ch = new Character('a');
		StringBuilder Test = new StringBuilder("");
		StringBuilder tempvar = new StringBuilder("");
		String path = null;
		int data;
		try {
			if(configflag==1)
			{
				path=driverlog+"/Config.txt";
			}
			Reader fileReader = new FileReader(path);
			data = fileReader.read();
			while(data != -1) {
				ch=(char)data;
				//System.out.println("String: "+ch+flag+gotvar);
				if(flag==0 && ch!='=') {
					Test.append(ch);
				}
				else if(flag==1 && gotvar==1) {
					if(ch!='=' && ch!=';') {
						tempvar.append(ch);
						
					}
				}
				if(ch=='\n') {
					flag=0;
					Test = new StringBuilder("");
				}
				else if(ch=='='){
					flag=1;
					String Test1=Test.toString();
					//System.out.println("Flag:"+Test1);
					//System.out.println("Actual:"+var);
					if(Test1.equals(var))
					{
						//System.out.println("Match Equal"+Test);
						gotvar=1;
					}
				}
				else if(ch==';' && gotvar==1) {
					//System.out.println("Variable Found:"+tempvar);
					break;
				}

				data = fileReader.read();
			  //System.out.println((char)data);
			}
			//String tempvar1=tempvar.toString();
			
			fileReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempvar.toString();
	}
	*/


	
}
