package com.mv.URLShort;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

public class ConnPoolDemo
{
	public static void main(String[] args)
	{
		ConnPoolDemo demo = new ConnPoolDemo();
		demo.display();
	}
	
	private void display()
	{
		Connection connection = null;
		String query = "SELECT * FROM UrlMap;";
		PreparedStatement preparedStatement = null;
		try
		{
			DataSource ds = ConnPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) 
			{
				System.out.println("OriginalURL::: " + rs.getString("longURL"));
				System.out.println("ShortenedURL::: " + rs.getString("shortURL"));
				System.out.println("__________________________");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection != null)
			{
				try
				{
					connection.close();
				}
				catch(SQLException e)
				{
					e.getStackTrace();
				}
			}
		}		
	}
}
