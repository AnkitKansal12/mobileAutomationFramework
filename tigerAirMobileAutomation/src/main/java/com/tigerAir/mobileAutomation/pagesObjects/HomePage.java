package com.tigerAir.mobileAutomation.pagesObjects;

/**
 * This class is for HomePage based on PageObjectPattern
 * @author Ankit.1.Kansal
 * 
 */
import org.openqa.selenium.By;

public class HomePage {



	private static final By tigerAirEntertainmentButton = By.xpath("//android.widget.Button[@text='Tigertainment']");
	private static final By bookFlightButton = By.xpath(
			"//android.widget.Button[@text='Book Flights' and @resource-id='au.com.tigerair.booking:id/home_book_flight_button']");
	public static By getTigerairentertainmentbutton() {
		return tigerAirEntertainmentButton;
	}
	public static By getBookflightbutton() {
		return bookFlightButton;
	}

	

}
