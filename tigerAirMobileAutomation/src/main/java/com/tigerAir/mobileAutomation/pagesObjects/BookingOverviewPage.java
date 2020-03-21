package com.tigerAir.mobileAutomation.pagesObjects;

import org.openqa.selenium.By;

public class BookingOverviewPage {
	
	private static final By pnrText=By.id("au.com.tigerair.booking:id/booking_number");
	private static final By continuetoHomeButton=By.id("au.com.tigerair.booking:id/confirmation_finish_button");
	public static By getPnrtext() {
		return pnrText;
	}
	public static By getContinuetohomebutton() {
		return continuetoHomeButton;
	}

}
