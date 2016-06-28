package com.faizansaleem.mainpackage;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class AndroidDetailsScraper {

	public void scrap(String url) {
		
		ApplicationDetails applicationDetails = new ApplicationDetails();
		
		try {
			Document doc = Jsoup.connect(url)
					  .userAgent("Mozilla")
					  .timeout(3000)
					  .post();
			
			Elements appTitleElement = doc.getElementsByClass("id-app-title");
			Elements hyperLinks = doc.getElementsByTag("a");
			applicationDetails.setAppTitle(appTitleElement.get(0).text());
			
			for (Element element : hyperLinks) {
				if(element.className().equals("document-subtitle primary")) {
					applicationDetails.setAppDeveloper(element.text());
					break;
				}
				
			}
			
			Elements appDescriptionElement = doc.getElementsByAttributeValue("itemprop", "description");

			applicationDetails.setAppDescription(appDescriptionElement.get(0).text());
			
			System.out.println("Title:" + applicationDetails.getAppTitle());
			System.out.println("Developer:" + applicationDetails.getAppDeveloper());
			System.out.println("Description:" + applicationDetails.getAppDescription());
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
}
