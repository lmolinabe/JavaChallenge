package com.javachallenge.urlshortener;

public class UrlShortenerFactory {
	public IUrlShortener getUrlShortener(String url) {
		
		IUrlShortener UrlShortener;
		
		if(url.toLowerCase().contains("google")) {
			UrlShortener = new UrlShortenerForGoogle();
		}
		else if(url.toLowerCase().contains("yahoo")){
			UrlShortener = new UrlShortenerForYahoo();
		}
		else {
			UrlShortener = new UrlShortenerForOther();
		}
		
		return UrlShortener;
	}
}
