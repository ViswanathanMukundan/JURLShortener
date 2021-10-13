package com.mv.URLShort;

/*CONNECTION POOL IS USED TO CACHE THE DB CONNECTION PARAMETERS IN ORDER TO AVOID WASTING TIME IN
 * INITIATING A NEW CONNECTION EVERY TIME THE DB IS QUERIED. IT'S ADVANTAGES CAN BE OBSERVED
 * MORE DURING LONG-TERM USE OF THE SAME DB*/

//CREATING A BASIC DATA SOURCE USING DBCP

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource; 

public class ConnPool
{
	private static BasicDataSource basicDS;
	static
	{
		try
		{
			basicDS = new BasicDataSource();
			basicDS.setDriverClassName("com.mysql.cj.jdbc.Driver");
			basicDS.setUrl("jdbc:mysql://localhost:3306/DB-NAME"); //ENTER THE DATABASE URL TO CONNECT
			basicDS.setUsername("MYSQL-USERNAME"); //MYSQL USERNAME TO BE FILLED HERE
			basicDS.setPassword("MYSQL-PASSWORD"); //MYSQL PASSWORD TO BE FILLED HERE
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static DataSource getDataSource()
	{
		return basicDS;
	}
}
