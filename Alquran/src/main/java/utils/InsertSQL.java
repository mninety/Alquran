package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class InsertSQL {
	    
	    public Properties properties = new Properties();
	    File file = new File("InsertSQL");

	    public InsertSQL(String sql) throws IOException {
	    	OutputStream output = new FileOutputStream(file);
	    	properties.setProperty("", sql);
	        properties.store(output,null);
	        output.close();
	        
	    }
	    

	}
