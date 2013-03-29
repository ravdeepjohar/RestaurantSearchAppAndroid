package com.domain;

public class SearchSingleton {

	 String ch;
	 private static SearchSingleton uniqueInstance;
	    
	    public static SearchSingleton getInstance() {
	        if(uniqueInstance == null) {
	            uniqueInstance = new SearchSingleton();
	        }
	        return uniqueInstance;
}
	    public String getter()
	    {
	    	return ch;
	    }
	    public void setter(String s)
	    {
	    	ch=s;
	    	
	    }
}