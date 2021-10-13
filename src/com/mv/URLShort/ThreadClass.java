package com.mv.URLShort;

public class ThreadClass extends Thread
{
	
	private String URL;
	public ThreadClass(String URL)
	{
		this.URL = URL;
	}
	@Override
	public void run()
	{
		Shortener shortener = new Shortener();
		try
		{
			shortener.idToShortURL(this.URL, 8);
			System.out.println("Size of hashmap from thread1::: " + shortener.urlMap.getSize());
			//Thread.sleep(1000);
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
		
		
	}

}
