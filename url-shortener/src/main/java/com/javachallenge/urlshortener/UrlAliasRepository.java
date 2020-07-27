package com.javachallenge.urlshortener;

import java.util.HashMap;
import java.util.Map;

/*Singleton AliasRepository*/
public class UrlAliasRepository {
	private static UrlAliasRepository instance = null;
	private Map<String, String> urlAliasMap = new HashMap<String, String>();
	
	private UrlAliasRepository() {
		
	}
	
    public static UrlAliasRepository getInstance() 
    { 
        if (instance == null) {
        	instance = new UrlAliasRepository();
        }
        
        return instance; 
    }
    
    public boolean existsUrl(String url) {
    	boolean exists = false;
    	
    	if(urlAliasMap.containsKey(url)) {
    		exists = true;
    	}
    	
    	return exists;
    }
    
    public void addAliasByUrl(String url, String alias) {
    	urlAliasMap.put(url, alias);	
    }
    
    public String getUrlByAlias(String alias) {
    	String url = "";
    	
    	url = urlAliasMap.keySet()
    			.stream()
				.filter(key -> alias.equals(urlAliasMap.get(key)))
				.findFirst().get();
    	
    	return url;
    }
    
    public String getAliasByUrl(String url) {
    	String alias = "";
    	
    	alias = urlAliasMap.get(url);
    	
    	return alias;
    }
}
