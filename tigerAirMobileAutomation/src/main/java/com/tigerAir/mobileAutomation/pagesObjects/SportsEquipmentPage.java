package com.tigerAir.mobileAutomation.pagesObjects;

import org.openqa.selenium.By;

public class SportsEquipmentPage {

	private static final By getHeaderText = By
			.xpath("//*[@resource-id='au.com.tigerair.booking:id/headertext' and @text='Sports Equipment']");
	private static final By addButton = By.xpath("//*[@resource-id='au.com.tigerair.booking:id/select_button']");

	public static By getGetheadertext() {
		return getHeaderText;
	}

	public static By getAddbutton() {
		return addButton;
	}

}
