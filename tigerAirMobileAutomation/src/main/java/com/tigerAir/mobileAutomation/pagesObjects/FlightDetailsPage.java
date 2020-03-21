package com.tigerAir.mobileAutomation.pagesObjects;

import org.openqa.selenium.By;

public class FlightDetailsPage {

	private static final By FlightDetailsText = By.xpath("//android.widget.TextView[@text='Flight Details']");
	private static final By closeButton = By.xpath("//*[@resource-id='au.com.tigerair.booking:id/close']");

	public static By getFlightdetailstext() {
		return FlightDetailsText;
	}

	public static By getClosebutton() {
		return closeButton;
	}

}
