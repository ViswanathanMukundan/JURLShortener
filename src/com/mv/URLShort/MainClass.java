package com.mv.URLShort;

import java.time.Duration;
import java.time.Instant;

/*
CLASS TO IMPLEMENT THE MAIN METHOD FOR THE PROJECT
*/

public class MainClass
{
	static int SHORTURL_LENGTH = 8;
	
	public static void addURL(Shortener shortener, String URL)
	{
		 shortener.idToShortURL(URL, SHORTURL_LENGTH);
	}
	public static void main(String[] args)
	{
			new ThreadClass("qwertyuiopasdfghjklzxcvbnm").start();
			new ThreadClass2("abcdefghijklmnopqrstuvwxyz").start();
			new ThreadClass("abcdefghijklmnopqrstuvwxyzABCD").start();
			new ThreadClass2("abcdefghijklmnopqrstuvwxyzEFGH").start();
			
			try
			{
				Thread.sleep(10000);
			}
			catch(InterruptedException e)
			{
			e.printStackTrace();
			}
			new Shortener();
			System.out.println("Final hashmap size::: " + Shortener.urlMap.getSize());
		//System.out.println(shortener.urlMap.getUrlMap());
		
		

		//assert (URL2.hashCode() == shortener.retrieveOriginalURL(shortenedURL2).hashCode());
	}
}
