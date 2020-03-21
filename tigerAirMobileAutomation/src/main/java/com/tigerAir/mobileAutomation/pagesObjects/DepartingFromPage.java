package com.tigerAir.mobileAutomation.pagesObjects;

import org.openqa.selenium.By;



public class DepartingFromPage {


	public static By flightFromText(String text) {
		By FlightFrom = By.xpath("//android.widget.TextView[@text='" + text + "']");
		return (FlightFrom);
	}



}
