package com.tigerAir.mobileAutomation.pagesObjects;

import org.openqa.selenium.By;

public class PassengersPage {
	
	
	
	public By titleText=By.id("au.com.tigerair.booking:id/title_view");
	
	public By continueButton=By.id("au.com.tigerair.booking:id/continue_button");	

	public By PassengerSelection(String text) {
		By fareType = By.xpath("//android.widget.TextView[@resource-id='au.com.tigerair.booking:id/title' and @text='" + text + "']");
		return (fareType);
	}

	

}
