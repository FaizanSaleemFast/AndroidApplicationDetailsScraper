package com.faizansaleem.mainpackage;

public class main {
	public static void main(String[] args) {
		AndroidDetailsScraper androidDetailsScraper = new AndroidDetailsScraper();
		
		androidDetailsScraper.scrap("https://play.google.com/store/apps/details?id=com.pinka.classicbubbles&hl=en");
	}

}
