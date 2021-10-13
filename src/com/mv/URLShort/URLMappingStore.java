package com.mv.URLShort;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * CLASS TO STORE THE DB DETAILS THAT STORE URLS AND THEIR SHORTENED KEYS.
 * FOR SECURITY REASONS, THIS CLASS IS IMPLEMENTED AS A SINGLETON CLASS.
 * */

public class URLMappingStore
{
	private DataSource ds = ConnPool.getDataSource();
	private Connection connection = ds.getConnection();
	
	public int getSize()
	{
		try
		{
			ResultSet resultSet = connection.createStatement().executeQuery("SELECT COUNT(*) FROM UrlMap;");
			while(resultSet.next())
				return resultSet.getInt(1);	
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return -1;
	}
	
	public void insertURL(String originalURL, String shortenedURL)
	{
		try
		{
			if(!checkIfURLExists(originalURL))
			{
				String sqlQuery = "INSERT INTO UrlMap VALUES ('" + originalURL + "', '" + shortenedURL + "');";
				connection.createStatement().executeUpdate(sqlQuery);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public boolean checkIfURLExists(String originalURL)
	{
		try
		{
			return connection.createStatement().executeQuery("SELECT longURL FROM UrlMap WHERE longURL = '" + originalURL + "';").next();
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
		return false;
	}
	
	public String returnOriginalURL(String shortenedURL)
	{
		String query = "SELECT longURL FROM UrlMap WHERE shortURL = '" + shortenedURL + "';";
		try
		{
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
				return "Retrieved URL for " + shortenedURL + "::: " + rs.getString("longURL");
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "No result found";
	}
	
	//ALL METHODS BEYOND THIS LINE ARE INTENDED TO PROTECT THE SINGLETON PATTERN FROM BEING BROKEN
	
	private static URLMappingStore singleInstance;
	
	private URLMappingStore() throws SQLException, ClassNotFoundException
	{
	}
	
	public synchronized static URLMappingStore getInstance()
	{
		if(singleInstance == null)
			try
			{
				singleInstance = new URLMappingStore();
			}
			catch (ClassNotFoundException | SQLException e)
			{
				e.printStackTrace();
			}
		return singleInstance;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException
	{
		throw new CloneNotSupportedException("This class cannot be cloned");
	}
	
}
