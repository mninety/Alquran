package Starting;

import java.io.IOException;

import org.apache.log4j.Logger;

import Firebug.FirebugModule;
import MyAction.ActionModule;
import MyVariable.VariableModule;
import utils.TestData;

public class MySQLPINGModule extends Thread {
	static Logger logMySQLPINGModule = Logger.getLogger(MySQLPINGModule.class.getName());
	TestData testdata;
	VariableModule variabledo;
	 //int sum=0;
	@SuppressWarnings("null")
	@Override
    public void run() {
    	while(true) {
			try {
				testdata = new TestData();
				String Post = testdata.properties.getProperty("Post");
				String PostID = testdata.properties.getProperty("PostID");
				
				//VariableModule.Post = VariableModule.readVariable("Post",1);
				//VariableModule.PostID = VariableModule.readVariable("PostID",1);
				
				if(!Post.equals(""))
				{
					String hourTime=ActionModule.getCurrentHour();
					System.out.println("Current Hour: "+hourTime);
					logMySQLPINGModule.debug("Current Hour: "+hourTime);
					PostAction();
					/*
					if(VariableModule.isSchedule.equals("0"))
					{
						System.out.println("Instant Posting");
						PostAction();
					}
					else
					{
						System.out.println("Schedule Posting");
						if(VariableModule.ScheduleDate.equals(hourTime))
						{
							PostAction();
						}
						else
						{
							try {
								Thread.sleep(10000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
					}
					*/
					

				}

				//Thread.sleep(300000);

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				logMySQLPINGModule.debug("MySQL Connection Exception3: "+e1);
			}

			try {
				Thread.sleep(300000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
    	}
    }
    
	public void PostAction() throws IOException
	{
		
		testdata = new TestData();
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
			String hisData=ActionModule.MysqlConnectionAction(checkHistory, variabledo.Ownconn, ",");
			if(hisData.equals(""))
			{
			
				String Myquery="select atAyatMeaning_bl from ayat where atSuraID="+postArray[0]+" and atSuraAyatID between "+ayatArray[0]+" and "+ayatArray[1];
				System.out.println("Select SQL: "+Myquery);
				String dbData=ActionModule.MysqlConnectionAction(Myquery, variabledo.Ownconn, ",");
				dbData=dbData.substring(0, dbData.length()-1);
				//System.out.println("Data: "+dbData);
				String SuraName=ActionModule.MysqlConnectionAction("select snName_bl from suraname where snSuraID="+postArray[0], variabledo.Ownconn, ",");
				SuraName=SuraName.substring(0, SuraName.length()-1);
				System.out.println("Data: "+"\""+dbData+"\""+" ---[সুরা "+SuraName+" "+ActionModule.unicodeMaker(postArray[0])+":"+ActionModule.unicodeMaker(ayatArray[0])+"-"+ActionModule.unicodeMaker(ayatArray[1])+"]");
				//FirebugModule.FacebookLogin("\""+dbData+"\""+" ---[সুরা "+SuraName+" "+ActionModule.unicodeMaker(postArray[0])+":"+ActionModule.unicodeMaker(ayatArray[0])+"-"+ActionModule.unicodeMaker(ayatArray[1])+"]");
				
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
			String hisData=ActionModule.MysqlConnectionAction(checkHistory, variabledo.Ownconn, ",");
			if(hisData.equals(""))
			{
			
				String Myquery="select atAyatMeaning_bl from ayat where atSuraID="+postArray[0]+" and atSuraAyatID="+postArray[1];
				System.out.println("Select SQL: "+Myquery);
				String dbData=ActionModule.MysqlConnectionAction(Myquery, variabledo.Ownconn, ",");
				dbData=dbData.substring(0, dbData.length()-1);
				//System.out.println("Data: "+dbData);
				String SuraName=ActionModule.MysqlConnectionAction("select snName_bl from suraname where snSuraID="+postArray[0], variabledo.Ownconn, ",");
				SuraName=SuraName.substring(0, SuraName.length()-1);
				System.out.println("Data: "+"\""+dbData+"\""+" ---[সুরা "+SuraName+" "+ActionModule.unicodeMaker(postArray[0])+":"+ActionModule.unicodeMaker(postArray[1])+"]");
				//FirebugModule.FacebookLogin("\""+dbData+"\""+" ---[সুরা "+SuraName+" "+ActionModule.unicodeMaker(postArray[0])+":"+ActionModule.unicodeMaker(postArray[1])+"]");
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

}