package com.javachallenge.urlshortener;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UrlShortenerController {
	private UrlShortenerService urlShortenerService;
	
	public UrlShortenerController(UrlShortenerService urlShortenerService) {
		this.urlShortenerService = urlShortenerService;
	}
	
	@PostMapping()
	public UrlResponse CreateAlias(@RequestBody UrlRequest urlRequest) {
		UrlResponse urlResponse = new UrlResponse();
		
		urlResponse.setAlias(urlShortenerService.CreateAliasForUrl(urlRequest.getUrl()));
		
		return urlResponse; 
	}
	
	@GetMapping(path="/{alias}")
	public ModelAndView RetrieveUrl(@PathVariable String alias, HttpServletResponse response) throws IOException {
		String url = "";
		String externalUrl = "";
		
		url = urlShortenerService.RetrieveUrlFromAlias(alias);
		
		if(url.contains("http")) {
			externalUrl = String.format("%s%s", "redirect:", url);
		}
		else {
			externalUrl = String.format("%s%s", "redirect://", url);
		}
		
		return new ModelAndView(externalUrl, HttpStatus.FOUND);
	}
	
}
