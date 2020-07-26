package com.javachallenge.urlshortener;

import java.util.Random;

public class UrlShortenerForYahoo implements IUrlShortener{
	public String getUrlAlias(String url) {
		String alphaNumericCharacters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int alphaNumericCharactersLength = alphaNumericCharacters.length();
		int aliasMaxLength = 7;
		Random random = new Random();
		StringBuilder alias = new StringBuilder();
		int iteration = 0;
		
		while(iteration < aliasMaxLength) {
			alias.append(alphaNumericCharacters.charAt(random.nextInt(alphaNumericCharactersLength)));
			iteration ++;
		}
		
		return alias.toString();
	};
}
