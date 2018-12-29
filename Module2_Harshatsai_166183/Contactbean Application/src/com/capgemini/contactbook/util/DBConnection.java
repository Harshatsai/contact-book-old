package com.capgemini.contactbook.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
	private static Connection conn=null;
	
  	@SuppressWarnings("finally")
	public static Connection getConnection() throws Exception
	
	{
		  System.out.println("success");
		  Properties p=new Properties();
		  File f1=new File("resources/db.Properties");
		FileInputStream fis=null;
		try
		{
			fis=new FileInputStream(f1);
		}
		catch(FileNotFoundException fe)
		{
			
		}
		try
		{
			p.load(fis);
		     String driver=p.getProperty("driver");
		     String url=p.getProperty("url");
		     String username=p.getProperty("username");
		     String password=p.getProperty("password");
		     
		     
		  try
		  {
			  Class.forName(driver);
			  conn=DriverManager.getConnection(url,username,password);
		  }
		  catch(ClassNotFoundException ce)
		  {
			  
		  }
		  catch(SQLException se)
		  {
			  
		  }
		}finally{
			return conn;
		}
		
		
	}
}
