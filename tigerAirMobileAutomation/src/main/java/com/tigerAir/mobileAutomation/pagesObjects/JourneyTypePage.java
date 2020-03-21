package com.tigerAir.mobileAutomation.pagesObjects;

import org.openqa.selenium.By;


public class JourneyTypePage {

	

	
	private static final By journeyTypeOneWayButton=By.xpath("//android.widget.TextView[@text='One Way']");
	private static final By journeyTypeReturnTypeButton=By.xpath("//android.widget.TextView[@text='Return']");
	public static By getJourneytypeonewaybutton() {
		return journeyTypeOneWayButton;
	}
	public static By getJourneytypereturntypebutton() {
		return journeyTypeReturnTypeButton;
	}



	
	
	
	

}
