package com.mv.URLShort;

import com.mv.URLShort.URLMappingStore;
import java.util.HashMap;
import java.util.Random;

public class Shortener
{
	//A LIST OF ALL CHARACTERS THAT ARE BEING USED IN URLS
	private String charList = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	URLMappingStore urlMap= URLMappingStore.getInstance();
	
	public String getCharList()
	{
		return charList;
	}
	
	//SHORTEN THE URL TO A STANDARD SIZE SPECIFIED IN THE urlLen VARIABLE
	public String idToShortURL(String longURL, int urlLen)
	{
		//if(urlMap.containsKey(longURL))
			//urlMap.remove(longURL);
		Random rand = new Random();
    //    int urlLen = 6;
        char [] shortURL = new char[urlLen];

        for(int i = 0; i < urlLen; i++ )
            shortURL[i] = getCharList().charAt(rand.nextInt(62));

        StringBuilder sb = new StringBuilder("http://tinyurl.com/");
        sb.append(new String(shortURL));

        urlMap.insertURL(sb.toString(),longURL);
        System.out.println("Size of hash map::: " + urlMap.getSize());
        return sb.toString();
	}

	public String retrieveOriginalURL(String shortUrl)
	{
		return urlMap.returnOriginalURL(shortUrl);
	}
	
	public static void main(String[] args)
	{
		Shortener shortener = new Shortener();
		String URL = "ANOTHER_RANDOM_SEQUENCE_OF_CHARACTERS_TO_SERVE_THE_PURPOSE_oF_URL";
		String shortenedURL = shortener.idToShortURL(URL, 8);
		System.out.println("Shortened URL: " + shortener.idToShortURL(URL,8));
		System.out.println("Original URL:" + shortener.retrieveOriginalURL(shortenedURL));
	}
}
