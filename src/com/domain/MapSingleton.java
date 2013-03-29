package com.domain;

public class MapSingleton {

	String lat;
	String log;
	private static MapSingleton uniqueInstance;

	public static MapSingleton getInstance() {
		if(uniqueInstance == null) {
			uniqueInstance = new MapSingleton();
		}
		return uniqueInstance;
	}
	public String getlat()
	{
		return lat;
	}
	public void setlat(String s)
	{
		lat=s;

	}
	public String getlog()
	{
		return log;
	}
	public void setlog(String s)
	{
		log=s;

	}

}
