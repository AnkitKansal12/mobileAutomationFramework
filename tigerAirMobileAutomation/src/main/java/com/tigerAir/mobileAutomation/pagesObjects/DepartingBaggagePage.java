package com.tigerAir.mobileAutomation.pagesObjects;

import org.openqa.selenium.By;

public class DepartingBaggagePage {

	private static final By addButton = By.xpath("//*[@resource-id='au.com.tigerair.booking:id/select_button']");
	private static final By journeyTypeReturnTypeButton = By.xpath("//android.widget.TextView[@text='Return']");
	private static final By headerText = By
			.xpath("//*[@resource-id='au.com.tigerair.booking:id/headertext' and @text='Departing Baggage']");

	public static final By getCabinBaggage(String selectKG) {
		return (By
				.xpath("//*[@resource-id='au.com.tigerair.booking:id/rv_cabinbaggage']//*[@text='" + selectKG + "']"));

	}

	public static final By getcheckinBaggage(String selectKG) {
		return (By.xpath(
				"//*[@resource-id='au.com.tigerair.booking:id/rv_checkinbaggage']//*[@text='" + selectKG + "']"));
	}

	public static By getAddbutton() {
		return addButton;
	}

	public static By getJourneytypereturntypebutton() {
		return journeyTypeReturnTypeButton;
	}

	public static By getHeadertext() {
		return headerText;
	}

}
