package com.mv.URLShort;

public class MainClass
{
	public static void main(String[] args)
	{
		Shortener shortener = new Shortener();
		
		String URL1 = "ANOTHER_RANDOM_SEQUENCE_OF_CHARACTERS_TO_SERVE_THE_PURPOSE_oF_URL";
		String URL2 = "123asdASD456fghFGH789jklJKLqwertyuiopzxcvbnm";
		String URL3 = "qwertyuiopasdfghjklzxcvbnm,.0123456789!)@(#*$&%^";
		
		String shortenedURL1 = shortener.idToShortURL(URL1, 8);
		String shortenedURL2 = shortener.idToShortURL(URL2, 8);
		String shortenedURL3 = shortener.idToShortURL(URL3, 8);
		
		System.out.println(URL1 + " mapped to " + shortenedURL1);
		System.out.println(URL2 + " mapped to " + shortenedURL2);
		System.out.println(URL3 + " mapped to " + shortenedURL3);

		//assert (URL2.hashCode() == shortener.retrieveOriginalURL(shortenedURL2).hashCode());
	}
}
