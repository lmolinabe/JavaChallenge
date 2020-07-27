package com.javachallenge.urlshortener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UrlShortenerService {
	@Autowired
	private UrlShortenerFactory urlShortenerFactory;
	
	public UrlShortenerService() {

	}
	
	public String CreateAliasForUrl(String url) {
		String alias = "";
		IUrlShortener urlShortener = urlShortenerFactory.getUrlShortener(url);
		UrlAliasRepository urlAliasRepository = UrlAliasRepository.getInstance();
		
		if(urlAliasRepository.existsUrl(url)) {
			alias = urlAliasRepository.getAliasByUrl(url);
		}
		else {
			alias = urlShortener.getUrlAlias(url);
			urlAliasRepository.addAliasByUrl(url, alias);			
		}
		
		return alias;
	}
	
	public String RetrieveUrlFromAlias(String alias){
		String url = "";
		UrlAliasRepository urlAliasRepository = UrlAliasRepository.getInstance();
		
		url = urlAliasRepository.getUrlByAlias(alias);
		
		return url;
	}
	
}
