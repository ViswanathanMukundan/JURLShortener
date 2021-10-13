package com.mv.URLShort;

import java.time.Duration;
import java.time.Instant;

/*TEST CLASS*/
public class MainClass
{
	static int SHORTURL_LENGTH = 8;
	
	public static void addURL(Shortener shortener, String URL)
	{
		 shortener.idToShortURL(URL, SHORTURL_LENGTH);
	}
	public static void main(String[] args)
	{
		//new Shortener().idToShortURL("abcdefghijklmnopqrstuvwxyz", 8);
			new ThreadClass("qwertyuiopasdfghjklzxcvbnm").start();
			/*new ThreadClass2("abcdefghijklmnopqrstuvwxyz").start();
			new ThreadClass("abcdefghijklmnopqrstuvwxyzABCD").start();
			new ThreadClass2("abcdefghijklmnopqrstuvwxyzEFGH").start();
			
			try
			{
				Thread.sleep(10000);
			}
			catch(InterruptedException e)
			{
			e.printStackTrace();
			}*/
			new Shortener();
			System.out.println("Final hashmap size::: " + Shortener.urlMap.getSize());
		//System.out.println(shortener.urlMap.getUrlMap());
		
		

		//assert (URL2.hashCode() == shortener.retrieveOriginalURL(shortenedURL2).hashCode());
	}
}
