package com.javachallenge.urlshortener;

import java.util.Random;

public class UrlShortenerForGoogle implements IUrlShortener {
	public String getUrlAlias(String url) {
		String alphaCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int alphaCharactersLength = alphaCharacters.length();
		int aliasMaxLength = 5;
		Random random = new Random();
		StringBuilder alias = new StringBuilder();
		int iteration = 0;
		
		while(iteration < aliasMaxLength) {
			alias.append(alphaCharacters.charAt(random.nextInt(alphaCharactersLength)));
			iteration ++;
		}
		
		return alias.toString();
	};
}
