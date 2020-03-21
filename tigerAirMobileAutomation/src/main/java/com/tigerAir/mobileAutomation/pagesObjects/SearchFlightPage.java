package com.tigerAir.mobileAutomation.pagesObjects;
/**
 * This class is for SearchPage based on PageObjectPattern
 * @author Ankit.1.Kansal
 */

import org.openqa.selenium.By;

public class SearchFlightPage{
	
	private static final By journeytypeButton=By.id("au.com.tigerair.booking:id/journeytype");	
	private static final By currencyTypeButton=By.id("au.com.tigerair.booking:id/curtype");
	private static final By passengerSelectionButton=By.id("au.com.tigerair.booking:id/paxcount");
	public static By getPassengerselectionbutton() {
		return passengerSelectionButton;
	}
	public static By getJourneytypebutton() {
		return journeytypeButton;
	}
	public static By getCurrencytypebutton() {
		return currencyTypeButton;
	}



	
	
	

}
