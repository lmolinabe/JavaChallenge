package com.javachallenge.urlshortener;

public class UrlShortenerForOther implements IUrlShortener{
	public String getUrlAlias(String url) {
		int iteration = 0;
		String vowels = "aeiou";
		StringBuilder alias = new StringBuilder();
		
		while (iteration < url.length())
		{
			char character = url.charAt(iteration);
			
			if(Character.isLetter(character) && !vowels.contains(Character.toString(character)))
			{
				alias.append(character);
			}
			
			iteration++;
		}
		
		return alias.toString();
	};
}
