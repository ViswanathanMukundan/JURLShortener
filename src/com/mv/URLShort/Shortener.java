package com.mv.URLShort;

import java.util.Random;

public class Shortener
{
	//A LIST OF ALL CHARACTERS THAT ARE BEING USED IN URLS
	private String charList = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	static URLMappingStore urlMap= URLMappingStore.getInstance();
	
	public String getCharList()
	{
		return charList;
	}
	
	//SHORTEN THE URL TO A STANDARD SIZE SPECIFIED IN THE urlLen VARIABLE
	public String idToShortURL(String longURL, int urlLen)
	{
		Random rand = new Random();
        char [] shortURL = new char[urlLen];

	//GENERATE THE SHORTENED URL WITHIN THE SPECIFIED LENGTH BY PICKING UP RANDOM CHARACTERS
        for(int i = 0; i < urlLen; i++ )
            shortURL[i] = getCharList().charAt(rand.nextInt(62));

        StringBuilder sb = new StringBuilder("http://urlRoot.com/");
        sb.append(new String(shortURL));

        urlMap.insertURL(longURL, sb.toString());
        System.out.println("Size of hash map::: " + urlMap.getSize());
        return sb.toString();
	}

	public String retrieveOriginalURL(String shortUrl)
	{
		return urlMap.returnOriginalURL(shortUrl);
	}
	
	
}
