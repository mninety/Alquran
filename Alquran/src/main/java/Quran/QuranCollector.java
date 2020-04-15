package Quran;

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

public class QuranCollector {
	
	VariableModule variabledo;
	ActionModule actiondo;
	public int temp=0;
	public int ayatIndex=31;

	public void WordbyWordCollector(String url, Connection conn)
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

			
			for(int i=11;i<=11;i++)
			{
				driver.get(url+i);
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(i==11)
				{
					driver.findElement(By.id("bywordSwtich")).click();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				

				String totalAyat=ActionModule.MysqlConnectionAction("select snAyat from suraname where snSuraID="+i, conn, ",");
				totalAyat=totalAyat.substring(0, totalAyat.length()-1);
				
				System.out.println("totalAyat: "+totalAyat);
					try {
						for(int j=29;j<=29;j++) //Integer.parseInt(totalAyat)
						{
							String index=driver.findElement(By.xpath("//div["+ayatIndex+"]//div[1]//div[2]//span")).getText();
							String[] indexArray= index.split(":");
							if(j==Integer.parseInt(indexArray[1]))
							{
								System.out.println("Sura: "+i);
								System.out.println("Ayat Index: "+indexArray[1]);
								String ayatID=ActionModule.MysqlConnectionAction("select atAyatID from ayat where atSuraID="+i+" and atSuraAyatID="+j, conn, ",");
								ayatID=ayatID.substring(0, ayatID.length()-1);
								System.out.println("AyatID: "+ayatID);
								//System.out.println("SQL: "+"select awWord_ar,awWordMeaning_bl from ayatword where awAyatID="+ayatID+" and awWordMeaning_bl is null");
								String nullWords=ActionModule.MysqlConnectionAction("select awWord_ar,awWordMeaning_bl from ayatword where awAyatID="+ayatID+" and awWordMeaning_bl is null", conn, ",");
								//nullWords=nullWords.substring(0, nullWords.length()-1);
								//System.out.println("Null Found: "+nullWords);
								if(!nullWords.equals(""))
								{
								String missingWords=ActionModule.MysqlConnectionAction("select awWord_ar,awWordMeaning_bl from ayatword where awAyatID="+ayatID, conn, ",");
								//aSystem.out.println("missingWords: "+missingWords);
								if(!missingWords.equals("")	)
								{
									missingWords=missingWords.substring(0, missingWords.length()-1);
									String[] totalword= missingWords.split("\n");
									//System.out.println("Total Words: "+totalword.length);
									for(int k=0;k<=totalword.length;k++)
									{
										String wordIndexAR=driver.findElement(By.xpath("//div["+ayatIndex+"]//div[1]//div[2]//div[1]//div["+(k+1)+"]//p[1]")).getText();
										String wordIndexBL=driver.findElement(By.xpath("//div["+ayatIndex+"]//div[1]//div[2]//div[1]//div["+(k+1)+"]//p[2]")).getText();
										wordIndexBL=wordIndexBL.replace("'", "");
										//System.out.println("Word Arabic: "+wordIndexAR);
										//System.out.println("Word Bangla: "+wordIndexBL);
										
										//System.out.println("totalword: "+totalword[k]);
										
										String[] wordsplitter= totalword[k].split(",");
										//System.out.println("wordsplitter[0]: "+wordsplitter[0]);
										//System.out.println("wordsplitter[1]: "+wordsplitter[1]);
										if(!wordsplitter[0].equals("وَيَا"))
										{

											if(wordsplitter.length==1)
											{
												String updatesql="update ayatword set awWordMeaning_bl='"+wordIndexBL+"' where awAyatID="+ayatID+" and awWord_ar='"+wordsplitter[0]+"'";
												System.out.println("Updated SQL: "+updatesql);
												//ActionModule.MysqlConnectionActionUpdate(updatesql, conn);
											}
										}

										
										
										
									}
									
								}

								}
								
								
								
								
							}
							ayatIndex++;
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				ayatIndex=3;
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
	
	public void MissingWordbyWordCollector(String url, Connection conn)
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

			
			for(int i=4;i<=77;i++)
			{
				driver.get(url+i);
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(i==4)
				{
					driver.findElement(By.id("bywordSwtich")).click();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				

				String totalAyat=ActionModule.MysqlConnectionAction("select snAyat from suraname where snSuraID="+i, conn, ",");
				totalAyat=totalAyat.substring(0, totalAyat.length()-1);
				
				System.out.println("totalAyat: "+totalAyat);
					try {
						for(int j=1;j<=1;j++) //Integer.parseInt(totalAyat)
						{
							String index=driver.findElement(By.xpath("//div["+ayatIndex+"]//div[1]//div[2]//span")).getText();
							String[] indexArray= index.split(":");
							if(j==Integer.parseInt(indexArray[1]))
							{
								System.out.println("Sura: "+i);
								System.out.println("Ayat Index: "+indexArray[1]);
								String ayatID=ActionModule.MysqlConnectionAction("select atAyatID from ayat where atSuraID="+i+" and atSuraAyatID="+j, conn, ",");
								ayatID=ayatID.substring(0, ayatID.length()-1);
								System.out.println("AyatID: "+ayatID);
								//System.out.println("SQL: "+"select awWord_ar,awWordMeaning_bl from ayatword where awAyatID="+ayatID+" and awWordMeaning_bl is null");
								String nullWords=ActionModule.MysqlConnectionAction("select awWord_ar,awWordMeaning_bl from ayatword where awAyatID="+ayatID+" and awWordMeaning_bl is null", conn, ",");
								//nullWords=nullWords.substring(0, nullWords.length()-1);
								//System.out.println("Null Found: "+nullWords);
								if(!nullWords.equals(""))
								{
								String missingWords=ActionModule.MysqlConnectionAction("select awWord_ar,awWordMeaning_bl from ayatword where awAyatID="+ayatID, conn, ",");
								//aSystem.out.println("missingWords: "+missingWords);
								if(!missingWords.equals("")	)
								{
									missingWords=missingWords.substring(0, missingWords.length()-1);
									String[] totalword= missingWords.split("\n");
									//System.out.println("Total Words: "+totalword.length);
									for(int k=4;k<totalword.length;k++)
									{
										String wordIndexAR=driver.findElement(By.xpath("//div["+ayatIndex+"]//div[1]//div[2]//div[1]//div["+(k-3)+"]//p[1]")).getText();
										String wordIndexBL=driver.findElement(By.xpath("//div["+ayatIndex+"]//div[1]//div[2]//div[1]//div["+(k-3)+"]//p[2]")).getText();
										wordIndexBL=wordIndexBL.replace("'", "");
										//System.out.println("Word Arabic: "+wordIndexAR);
										//System.out.println("Word Bangla: "+wordIndexBL);
										
										//System.out.println("totalword: "+totalword[k]);
										
										String[] wordsplitter= totalword[k].split(",");
										//System.out.println("wordsplitter[0]: "+wordsplitter[0]);
										//System.out.println("wordsplitter[1]: "+wordsplitter[1]);
										if(wordsplitter[0].equals("وَيَا"))
										{
											break;
										}
										else
										{
											if(wordsplitter.length==1)
											{
												String updatesql="update ayatword set awWordMeaning_bl='"+wordIndexBL+"' where awAyatID="+ayatID+" and awWord_ar='"+wordsplitter[0]+"'";
												System.out.println("Updated SQL: "+updatesql);
												ActionModule.MysqlConnectionActionUpdate(updatesql, conn);
											}
										}
										
										
										
									}
									
								}

								}
								
								
								
								
							}
							ayatIndex++;
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				ayatIndex=3;
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
	
}
