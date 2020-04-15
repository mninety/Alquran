package Hadis;

import java.sql.Connection;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import MyAction.ActionModule;
import MyVariable.VariableModule;
import PagesRepository.SOC;

public class HadisCollector {
	
	VariableModule variabledo;
	ActionModule actiondo;
	public int temp=0;
	public int chapter=1;
	public void HadisCollectorAction(String url,int total,int hdChapterID, int MaxID)
	{
		String testcollector="";
		String testcollector1="";
		String testcollector2="";
		String testcollector3="";
		String testcollector4="";
		int k=3;
		int maxFound=0;
		//int n=37;
		//int flag = 2;
		WebDriver driver = actiondo.ChromedriverAction();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Total Hadis: "+total);
		int r=1;

		for(int i=0;i<total;i++)//total
		{
			try
			{
				System.out.println("I: "+i);
				if(i==0)
				{
					try {
						testcollector=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div[3]/div/div[1]/div[1]/h3")).getText();
						
						testcollector1=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div[3]/div/div[1]/div[1]/p[1]")).getText();
						testcollector2=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div[3]/div/div[1]/div[1]/p[2]")).getText();
						testcollector3=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div[3]/div/div[1]/div[1]/p[3]")).getText();
						testcollector4=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div[3]/div/div[3]/div[1]/span")).getText();
						
						testcollector1=testcollector1.replaceAll("'", "");
						testcollector2=testcollector2.replaceAll("'", "");
						testcollector3=testcollector3.replaceAll("'", "");
						
						System.out.println("Test: "+ActionModule.unicodeEngMaker(testcollector));
						maxFound=Integer.parseInt(testcollector);
					} catch (Exception e) {
						System.out.println("Hadis 1st Element not found");
						testcollector=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div[5]/div/div[1]/div[1]/h3")).getText();
						testcollector1=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div[5]/div/div[1]/div[1]/p[1]")).getText();
						testcollector2=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div[5]/div/div[1]/div[1]/p[2]")).getText();
						testcollector3=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div[5]/div/div[1]/div[1]/p[3]")).getText();
						testcollector4=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div[5]/div/div[3]/div[1]/span")).getText();
						
						testcollector1=testcollector1.replaceAll("'", "");
						testcollector2=testcollector2.replaceAll("'", "");
						testcollector3=testcollector3.replaceAll("'", "");
						
						System.out.println("Test: "+ActionModule.unicodeEngMaker(testcollector));
						maxFound=Integer.parseInt(testcollector);
					}

				}
				else if(i==(total-1))
				{
					System.out.println("Last Hadis");
					testcollector=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div["+k+"]/div/div[1]/div[1]/h3")).getText();
					testcollector1=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div["+k+"]/div/div[1]/div[1]/p[1]")).getText();
					testcollector2=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div["+k+"]/div/div[1]/div[1]/p[2]")).getText();
					testcollector3=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div["+k+"]/div/div[1]/div[1]/p[3]")).getText();
					testcollector4=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div["+k+"]/div/div[3]/div[1]/span")).getText();

					testcollector1=testcollector1.replaceAll("'", "");
					testcollector2=testcollector2.replaceAll("'", "");
					testcollector3=testcollector3.replaceAll("'", "");
					
					System.out.println("Test: "+ActionModule.unicodeEngMaker(testcollector));
					maxFound=Integer.parseInt(testcollector);
/*					System.out.println("Arbi: "+testcollector1);
					System.out.println("Arbi Lenght: "+testcollector1.length());
					System.out.println("Test2: "+testcollector2);
					System.out.println("Test2 Lenght: "+testcollector2.length());
					System.out.println("Bangla: "+testcollector3);
					System.out.println("Bangla Lenght: "+testcollector3.length());
					System.out.println("Test4: "+testcollector4);*/
				}
				else
				{
					testcollector=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div["+k+"]/div/div[1]/div[1]/h3")).getText();
					testcollector1=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div["+k+"]/div/div[1]/div[1]/p[1]")).getText();
					testcollector2=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div["+k+"]/div/div[1]/div[1]/p[2]")).getText();
					testcollector3=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div["+k+"]/div/div[1]/div[1]/p[3]")).getText();
					testcollector4=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div["+k+"]/div/div[2]/div[1]/span")).getText();
					
/*					int count = StringUtils.countMatches(testcollector3, "'");
					
					if(testcollector3.indexOf("'") != -1)
					{
						System.out.println("Calprit Found: "+count);
					}*/
					testcollector1=testcollector1.replaceAll("'", "");
					testcollector2=testcollector2.replaceAll("'", "");
					testcollector3=testcollector3.replaceAll("'", "");

					System.out.println("Test: "+ActionModule.unicodeEngMaker(testcollector));
					maxFound=Integer.parseInt(testcollector);
				}
				actiondo.MysqlHadisInsertData(Integer.parseInt(ActionModule.unicodeEngMaker(testcollector)), hdChapterID, testcollector1, testcollector2, testcollector3, testcollector4, variabledo.Ownconn);
				r++;
				if(r>=total)
				{
					break;
				}
			}catch (Exception e) {
	            System.out.println("Hadis Element not found");
	            //flag=1;
	        }
			
/*			if(flag==1)
			{*/
				int p=2;
				for(int j=0;j<10;j++)
				{
					try {
						testcollector=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div["+k+"]/div["+p+"]/div[1]/div[1]/h3")).getText();
						testcollector1=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div["+k+"]/div["+p+"]/div[1]/div[1]/p[1]")).getText();
						testcollector2=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div["+k+"]/div["+p+"]/div[1]/div[1]/p[2]")).getText();
						testcollector3=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div["+k+"]/div["+p+"]/div[1]/div[1]/p[3]")).getText();
						testcollector4=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div["+k+"]/div["+p+"]/div[2]/div[1]/span")).getText();
						
						testcollector1=testcollector1.replaceAll("'", "");
						testcollector2=testcollector2.replaceAll("'", "");
						testcollector3=testcollector3.replaceAll("'", "");
						
						System.out.println("Test: "+ActionModule.unicodeEngMaker(testcollector));
						maxFound=Integer.parseInt(testcollector);
						actiondo.MysqlHadisInsertData(Integer.parseInt(ActionModule.unicodeEngMaker(testcollector)), hdChapterID, testcollector1, testcollector2, testcollector3, testcollector4, variabledo.Ownconn);
						r++;
						if(r>=total)
						{
							break;
						}
					} catch (Exception e) {
						System.out.println("Hadis SUB Element not found");
						break;
					}
					p++;
				}
				
			//}
			
			k=k+2;

			if(r>=total)
			{
				break;
			}
		}
		driver.quit();
	}
	

    public void InsertHadis(int max, String url, Connection Ownconn)
    {
    	VariableModule variablemodule = new VariableModule();
    	ActionModule actiondo = new ActionModule();
		WebDriver driver = actiondo.setUp();
		try {
			String testcollector="";
			String testcollector1="";
			String testcollector2="";
			String testcollector3="";
			String testcollector4="";
			
			SOC soc = new SOC(driver);
			String hcID=ActionModule.MysqlConnectionAction("select hcChapterID,hcMaxID,hcTotalHadis from hadischapter where hcBookID=7", Ownconn, ",");
			hcID=hcID.substring(0, hcID.length()-1);
			String[] totalMaxArray = hcID.split("\n");
			//String[] MaxArray = hcID.split(",");

			for(int i=0; i<totalMaxArray.length;i++)
			{
				String[] MaxArray = totalMaxArray[i].split(",");
				//System.out.println("Max ID: "+MaxArray[0]+" : "+MaxArray[1]);
				
				System.out.println("Chapter: "+MaxArray[0]);
				driver.get(url+"/chapter/"+MaxArray[0]);

			    	for(int j=0;j<Integer.parseInt(MaxArray[2]);j++)
			    	{
			    		
			    		testcollector=actiondo.unicodeEngMaker(soc.gethadisID(j));
			    		//System.out.println("HadisID: "+testcollector);
			    			//System.out.println("Equal J: "+j);
			    			//System.out.println("HadisID Found: "+testcollector);
			    			//System.out.println("Missing: "+MissinghadisIDArray.get(t));
							testcollector1=soc.gethadisAR(j);
							testcollector2=soc.gethadisNarratedby(j);
							testcollector3=soc.gethadisBL(j);
							testcollector4=soc.gethadisSonod(j);
							
							testcollector1=testcollector1.replaceAll("'", "");
							testcollector2=testcollector2.replaceAll("'", "");
							testcollector3=testcollector3.replaceAll("'", "");
							//System.out.println("Chapter: "+(i+1)+", HadisID1 : "+testcollector);
							//System.out.println("HadisAR : "+testcollector1);
							//System.out.println("HadisNB : "+testcollector2);
							//System.out.println("HadisBL : "+testcollector3);
							//System.out.println("HadisSonod : "+testcollector4);
							actiondo.MysqlHadisInsertData(Integer.parseInt(testcollector), Integer.parseInt(MaxArray[0]), testcollector1, testcollector2, testcollector3, testcollector4, Ownconn);

			    	}

				
				//http://ihadis.com/books/bukhari/chapter/97
			}
			System.out.println("****END****");
			
			//driver.quit();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			   //Statements to be executed
			driver.quit();
		}
    	
    }
	
	
	public void MissingHadisCollector(List<Integer> MissinghadisIDArray, String url, Connection conn)
	{
		ActionModule actiondo = new ActionModule();
		WebDriver driver = actiondo.setUp();
		try {
			String testcollector="";
			String testcollector1="";
			String testcollector2="";
			String testcollector3="";
			String testcollector4="";
			
			//VariableModule variablemodule = new VariableModule();
			
			//WebDriver driver = actiondo.setUp();
			SOC soc = new SOC(driver);
			for(int t=0;t<MissinghadisIDArray.size();t++)//MissinghadisIDArray.size()
			{
			//driver.get(url);
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//System.out.println("Missing ID: "+MissinghadisIDArray.get(t));
			System.out.println("Missing Hadis ID: "+MissinghadisIDArray.get(t));
			String hcID=ActionModule.MysqlConnectionAction("select hcChapterID,hcMaxID from hadischapter where hcBookID=6", conn, ",");
			hcID=hcID.substring(0, hcID.length()-1);
			String[] totalMaxArray = hcID.split("\n");
			//String[] MaxArray = hcID.split(",");

			for(int i=0; i<totalMaxArray.length;i++)
			{
				String[] MaxArray = totalMaxArray[i].split(",");
				//System.out.println("Max ID: "+MaxArray[0]+" : "+MaxArray[1]);
				
				if(chapter>=Integer.parseInt(MaxArray[0]))
				{
					//System.out.println("Test ME Equal!!!");
					//continue;
				}
				else
				{
					//System.out.println("Test ME  Not Equal!!!");
					chapter=Integer.parseInt(MaxArray[0]);
					temp=0;
				}
				
				if(MissinghadisIDArray.get(t)<=Integer.parseInt(MaxArray[1]))
				{
					
					System.out.println("Chapter: "+MaxArray[0]);
					driver.get(url+"/chapter/"+MaxArray[0]);
					//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					
					String sql="select hcTotalHadis from hadischapter where hcBookID=6 and hcChapterID="+MaxArray[0];
					//System.out.println("SQL: "+sql);
			    	String total=ActionModule.MysqlConnectionAction(sql, conn, ",");
			    	total=total.substring(0, total.length()-1);
			    	//System.out.println("Total Chapterwise hadis: "+total);
			    	//String[] totalArray = total.split("\n");
			    	//System.out.println("Before Temp: "+temp);
			    	for(int j=temp;j<Integer.parseInt(total)-1;j++)
			    	{
			    		
			    		testcollector=actiondo.unicodeEngMaker(soc.gethadisID(j));
			    		//System.out.println("HadisID: "+testcollector);
			    		if(MissinghadisIDArray.get(t)==Integer.parseInt(testcollector))
			    		{
			    			//System.out.println("Equal J: "+j);
			    			//System.out.println("HadisID Found: "+testcollector);
			    			//System.out.println("Missing: "+MissinghadisIDArray.get(t));
							testcollector1=soc.gethadisAR(j);
							testcollector2=soc.gethadisNarratedby(j);
							testcollector3=soc.gethadisBL(j);
							testcollector4=soc.gethadisSonod(j);
							
							testcollector1=testcollector1.replaceAll("'", "");
							testcollector2=testcollector2.replaceAll("'", "");
							testcollector3=testcollector3.replaceAll("'", "");
							//System.out.println("Chapter: "+(i+1)+", HadisID1 : "+testcollector);
							//System.out.println("HadisAR : "+testcollector1);
							//System.out.println("HadisNB : "+testcollector2);
							//System.out.println("HadisBL : "+testcollector3);
							//System.out.println("HadisSonod : "+testcollector4);
							actiondo.MysqlHadisInsertData(MissinghadisIDArray.get(t), Integer.parseInt(MaxArray[0]), testcollector1, testcollector2, testcollector3, testcollector4, conn);
			    			temp=j;
			    			//System.out.println("Equal Temp: "+temp);
							break;
			    		}
			    		else if(MissinghadisIDArray.get(t)<Integer.parseInt(testcollector))
			    		{
			    			break;
			    		}
			    		else
			    		{
			    			continue;
			    		}
			    	}
					
					break;
				}
				else
				{
					continue;
				}
				
				//http://ihadis.com/books/bukhari/chapter/97
			}
			
			//actiondo.MysqlHadisInsertData(Integer.parseInt(ActionModule.unicodeEngMaker(testcollector)), hdChapterID, testcollector1, testcollector2, testcollector3, testcollector4, variabledo.Ownconn);
			}
			System.out.println("****END****");
			
			//driver.quit();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			   //Statements to be executed
			driver.quit();
		}
	}
	
	public void ChapterCollectorAction(String url)
	{
		String testcollector="";
		String testcollector1="";
		int total=0;
		WebDriver driver = actiondo.ChromedriverAction();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//System.out.println("Total Hadis: ");

				for(int j=1;j<39;j++)
				{
					try {
						testcollector=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div[2]/table["+j+"]/tbody/tr/th[2]/a")).getText();
						testcollector1=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div[2]/table["+j+"]/tbody/tr/th[3]")).getText();
						testcollector=testcollector.replaceAll("'", "");
						
						//System.out.println("Test: "+actiondo.unicodeEngMaker(testcollector));
						System.out.println("Chapter Index: "+j);
						System.out.println("Chapter Name: "+testcollector);
						//System.out.println("Chapter Lenght: "+testcollector1);
						
						testcollector1 = testcollector1.replaceAll("\\s+", "");
						//System.out.println("Chapter Lenght: "+testcollector1);
						String[] chapdurArray=null;
						if(testcollector1.contains("-"))
						{
							chapdurArray = testcollector1.split("-");
						}
						else
						{
							chapdurArray = testcollector1.split("–");
						}
						//String[] chapdurArray = testcollector1.split("–");//–
						total=Integer.valueOf(ActionModule.unicodeEngMaker(chapdurArray[1]))-Integer.valueOf(ActionModule.unicodeEngMaker(chapdurArray[0]));
						System.out.println("Chapter Duration: "+total);
						int max=Integer.valueOf(ActionModule.unicodeEngMaker(chapdurArray[1]));
						ActionModule.MysqlChapterInsertData(j, testcollector, (total+1), max, variabledo.Ownconn);
					} catch (Exception e) {
						System.out.println("Chapter not found");
						
					}

				}
				driver.quit();
		}
		
	
	
	public int Sonod(String sonod)
	{
		int sonodID = 0;
		if(sonod.equals("সহিহ হাদিস"))
		{
			sonodID=1;
		}
		else if(sonod.equals("হাসান সহিহ"))
		{
			sonodID=2;
		}
		else if(sonod.equals("দুর্বল হাদিস"))
		{
			sonodID=3;
		}
		else if(sonod.equals("খুবই দুর্বল"))
		{
			sonodID=4;
		}
		else if(sonod.equals("শায"))
		{
			sonodID=5;
		}
		else if(sonod.equals("জাল হাদিস"))
		{
			sonodID=6;
		}
		else if(sonod.equals("অন্যান্য"))
		{
			sonodID=7;
		}
		else if(sonod.equals("নির্ণীত নয়"))
		{
			sonodID=8;
		}
		else
		{
			sonodID=9;
		}
		
		return sonodID;
	}

}
