package com.javachallenge.urlshortener;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UrlShortenerApplicationTests {

	@Test
	void UrlShortenerForGoogleAliasCorrectCharactersLength()
	{
		int expectedAliasLength = 5;
		String url = "www.google.com";
		UrlShortenerForGoogle urlShortenerForGoogle = new UrlShortenerForGoogle();
		String alias = "";
		int actualAliasLength = 0;
		
		alias = urlShortenerForGoogle.getUrlAlias(url);
		actualAliasLength = alias.length();
		
		assertEquals(expectedAliasLength, actualAliasLength);
	}
	
	@Test
	void UrlShortenerForGoogleAliasOnlyAlphaCharacters()
	{
		String url = "www.google.com";
		UrlShortenerForGoogle urlShortenerForGoogle = new UrlShortenerForGoogle();
		String alias = "";
		boolean expectedOnlyAlphaCharacters = true;
		boolean actualOnlyAlphaCharacters = true;
		
		alias = urlShortenerForGoogle.getUrlAlias(url);
				
		for(int i=0; i < alias.length(); i++) {
			if(!Character.isLetter(alias.charAt(i))) {
				actualOnlyAlphaCharacters = false;
			}
		}
		
		assertEquals(expectedOnlyAlphaCharacters, actualOnlyAlphaCharacters);
	}	

	@Test
	void UrlShortenerForYahooAliasCorrectCharactersLength()
	{
		int expectedAliasLength = 7;
		String url = "www.yahoo.com";
		UrlShortenerForYahoo urlShortenerForYahoo = new UrlShortenerForYahoo();
		String alias = "";
		int actualAliasLength = 0;
		
		alias = urlShortenerForYahoo.getUrlAlias(url);
		actualAliasLength = alias.length();
		
		assertEquals(expectedAliasLength, actualAliasLength);
	}
	
	@Test
	void UrlShortenerForYahooAliasOnlyAlphanumericCharacters()
	{
		String url = "www.yahoo.com";
		UrlShortenerForYahoo urlShortenerForYahoo = new UrlShortenerForYahoo();
		String alias = "";
		boolean expectedOnlyAlphanumericCharacters = true;
		boolean actualOnlyAlphanumericCharacters = true;
		
		alias = urlShortenerForYahoo.getUrlAlias(url);
				
		for(int i=0; i < alias.length(); i++) {
			if(!(Character.isLetter(alias.charAt(i)) || Character.isDigit(alias.charAt(i)))) {
				expectedOnlyAlphanumericCharacters = false;
			}
		}
		
		assertEquals(expectedOnlyAlphanumericCharacters, actualOnlyAlphanumericCharacters);
	}
	
	@Test
	void UrlShortenerForOtherAliasOnlyAlphaCharactersAndNotVowels()
	{
		String url = "www.other.com";
		UrlShortenerForOther urlShortenerForOther = new UrlShortenerForOther();
		String alias = "";
		boolean expectedOnlyAlphanumericCharacters = true;
		boolean actualOnlyAlphanumericCharacters = true;
		String vowels = "aeiou";
		
		alias = urlShortenerForOther.getUrlAlias(url);
				
		for(int i=0; i < alias.length(); i++) {
			if(!(Character.isLetter(alias.charAt(i)) || Character.isDigit(alias.charAt(i)) || !vowels.contains(Character.toString(alias.charAt(i))))) {
				expectedOnlyAlphanumericCharacters = false;
			}
		}
		
		assertEquals(expectedOnlyAlphanumericCharacters, actualOnlyAlphanumericCharacters);
	}	
}
