package com.tigerAir.mobileAutomation.pagesObjects;

import org.openqa.selenium.By;



public class PassengersListPage {
	

	
	private static final By titleText=By.id("au.com.tigerair.booking:id/title_view");
	
	private static final By continueButton=By.id("au.com.tigerair.booking:id/continue_button");

	

	public static By PassengerSelection(String text) {
		By fareType = By.xpath("//android.widget.TextView[@resource-id='au.com.tigerair.booking:id/title' and @text='" + text + "']");
		return (fareType);
	}



	public static By getTitletext() {
		return titleText;
	}



	public static By getContinuebutton() {
		return continueButton;
	}



}
