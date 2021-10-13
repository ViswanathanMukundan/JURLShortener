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
			//Properties properties = new Properties();
			//InputStream inputStream = ConnPool.class.getClassLoader().getResourceAsStream("db.properties");
			//if(inputStream == null)
				//throw new IOException("File not found");
			//properties.load(inputStream);
			//basicDS.setDriverClassName(properties.getProperty("DB.DRIVER_CLASS"));
			basicDS.setDriverClassName("com.mysql.cj.jdbc.Driver");
			//basicDS.setUrl(properties.getProperty("DB.DB_URL"));
			basicDS.setUrl("jdbc:mysql://localhost:3306/URLMapDB");
			//basicDS.setUsername(properties.getProperty("DB.DB_USER"));
			basicDS.setUsername("root");
			//basicDS.setPassword(properties.getProperty("DB.DB_PASSWORD"));
			basicDS.setPassword("vishy");
			//basicDS.setInitialSize(Integer.parseInt(properties.getProperty("DB.MAX_POOL_SIZE")));
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
