package com.mv.URLShort;

import java.util.HashMap;

/*
 * CLASS TO STORE THE HASHMAP THAT MAPS THE URLS TO THEIR SHORTENED KEYS.
 * FOR SECURITY REASONS, THIS CLASS SHOULD BE IMPLEMENTED AS A SINGLETON CLASS.
 * */

public class URLMappingStore
{
	private HashMap<String, String> urlMap = new HashMap<String, String>();
	
	public int getSize()
	{
		return urlMap.size();
	}
	
	public void insertURL(String originalURL, String shortenedURL)
	{
		urlMap.put(originalURL, shortenedURL);
	}
	
	public String returnOriginalURL(String shortenedURL)
	{
		return urlMap.get(shortenedURL);
	}
	
	private static class ClassLoader
	{
		private static final URLMappingStore singleInstance = new URLMappingStore();
	}
	
	private URLMappingStore() 
	{
		if(ClassLoader.singleInstance != null)
		{
			throw new IllegalStateException("Already instantiated");
		}
	}
	
	public static synchronized URLMappingStore getInstance()
	{
		return ClassLoader.singleInstance;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException
	{
		throw new CloneNotSupportedException("This class cannot be cloned");
	}
	
}
