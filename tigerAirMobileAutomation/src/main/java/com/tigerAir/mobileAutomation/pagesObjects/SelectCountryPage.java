package com.tigerAir.mobileAutomation.pagesObjects;

import org.openqa.selenium.By;



public class SelectCountryPage {


	private static final By selectCountryTextBox = By.id("au.com.tigerair.booking:id/search");
	private static final By cancelButton=By.id("au.com.tigerair.booking:id/cancel_button");
	private static final By nameofCountry=By.id("au.com.tigerair.booking:id/name");
	public static By getSelectcountrytextbox() {
		return selectCountryTextBox;
	}
	public static By getCancelbutton() {
		return cancelButton;
	}
	public static By getNameofcountry() {
		return nameofCountry;
	}
	



}
