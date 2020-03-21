package com.tigerAir.mobileAutomation.pagesObjects;

import org.openqa.selenium.By;



public class YoungTravellersPage {



	private static final By agreeButton = By.id("au.com.tigerair.booking:id/btnclose");
	private static final By noThanksButton = By.id("au.com.tigerair.booking:id/btnexit");

	public static By selectYoungTravelers(String text) {
		By selectTitleini = By.xpath(
				"//android.widget.TextView[@resource-id='au.com.tigerair.booking:id/on_state_text_view' and @text='"
						+ text + "']");
		return (selectTitleini);
	}

	public static By getAgreebutton() {
		return agreeButton;
	}

	public static By getNothanksbutton() {
		return noThanksButton;
	}



}
