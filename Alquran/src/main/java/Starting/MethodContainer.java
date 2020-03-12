package Starting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class MethodContainer {

	//public static Connection conn = null;
    public static Connection MysqlConnection()
    {
	    Connection conn1 = null;
	    try {
	        // STEP 2: Register JDBC driver
	        Class.forName("com.mysql.jdbc.Driver");

	        // STEP 3: Open a connection
	        //System.out.print("\nConnecting to database...");
	        
	        //conn1 = DriverManager.getConnection("jdbc:mysql://104.152.168.38/dailyqur_alquran", "dailyqur", "3e8yf7GOx7");
	        conn1 = DriverManager.getConnection("jdbc:mysql://localhost/alquran", "root", "Ninety02#");
	        //writingLog(" Database Connected!\n");
	    }catch(SQLException se) {
	        se.printStackTrace();
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	    System.out.print("\nDatabase Connected!");
	    System.out.print("\nConnection"+conn1+"\n");
		return conn1;
    }
    
	public static void MysqlConnectionActionUpdate(String Myquery, Connection con)
	{
		System.out.println("Query: "+Myquery);

	    java.sql.Statement stmt = null;
		    
	    try {
	    	//conn=MysqlConnection();
	        stmt = con.createStatement();
	        stmt.executeUpdate(Myquery);

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
	
	
	public static void MysqlInsertData(String word, int ayatid, Connection con)
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

		        sql = "INSERT INTO ayatword (awAyatID,awWord_ar)" +
			            " VALUES ("+ayatid+",'"+word+"');";
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
	
	
	public static void InsertDatatoAyatHistory(int ahSubjectID, int ahSuraID, int ayatid, Connection con)
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

		        sql = "INSERT INTO ayathistory (ahSubjectID,ahSuraID,ahAyatID)" +
			            " VALUES ("+ahSubjectID+","+ahSuraID+","+ayatid+")";
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
	
}
