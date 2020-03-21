package com.tigerAir.mobileAutomation.pagesObjects;

import org.openqa.selenium.By;

public class PassengersSelectionPage {

	private static final By adultplusButton = By.id("au.com.tigerair.booking:id/ibadultplus");

	private static final By childplusButton = By.id("au.com.tigerair.booking:id/ibchildplus");

	private static final By infantplusButton = By.id("au.com.tigerair.booking:id/ibinfantplus");

	private static final By continueButton = By.id("au.com.tigerair.booking:id/paxNumberPickerSelectButton");

	public static By getAdultplusbutton() {
		return adultplusButton;
	}

	public static By getChildplusbutton() {
		return childplusButton;
	}

	public static By getInfantplusbutton() {
		return infantplusButton;
	}

	public static By getContinuebutton() {
		return continueButton;
	}	

}
