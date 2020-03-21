package com.tigerAir.mobileAutomation.pagesObjects;

import org.openqa.selenium.By;

public class SelectDepartingFlightPage {

	private static final By slotTime = By
			.xpath("//android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.RelativeLayout");

	public static By fareTypeSelection(String text) {
		By fareType = By.xpath("//*[@resource-id='au.com.tigerair.booking:id/fare_type' and @text='" + text + "']");
		return (fareType);
	}

	private static final By noFlights = By
			.xpath("//android.support.v7.widget.RecyclerView/android.widget.RelativeLayout/android.widget.TextView");
	private static final By nextFlightButton = By
			.xpath("//android.widget.LinearLayout[3]/android.widget.RelativeLayout/android.widget.LinearLayout");

	public static By getNextflightbutton() {
		return nextFlightButton;
	}

	public static By getNoflights() {
		return noFlights;
	}

	public static By getSlottime() {
		return slotTime;
	}

}
