package com.tigerAir.mobileAutomation.pagesObjects;

import org.openqa.selenium.By;



public class ContactDetailsPage {

	

	private static final By addressTextBox = By.xpath(
			"//android.widget.LinearLayout[@resource-id='au.com.tigerair.booking:id/address']//android.widget.EditText");
	private static final By cityTextBox = By.xpath(
			"//android.widget.LinearLayout[@resource-id='au.com.tigerair.booking:id/city']//android.widget.EditText[@resource-id='au.com.tigerair.booking:id/input_text_view']");

	private static final By postalCodeTextBox = By.xpath(
			"//android.widget.LinearLayout[@resource-id='au.com.tigerair.booking:id/postal_code']//android.widget.EditText");
	private static final By countryDropDown = By.xpath(
			"//android.widget.LinearLayout[@resource-id='au.com.tigerair.booking:id/country']//android.widget.TextView[@resource-id='au.com.tigerair.booking:id/compound_text_view']");
	
	private static final By phoneNumberTextBox=By.xpath("//android.widget.LinearLayout[@resource-id='au.com.tigerair.booking:id/phone_number']//android.widget.EditText");
	
	private static final By emailAddressTextBox=By.xpath("//android.widget.LinearLayout[@resource-id='au.com.tigerair.booking:id/email']//android.widget.EditText");
	
	private static final By confirmEmailTextBox=By.xpath("//android.widget.LinearLayout[@resource-id='au.com.tigerair.booking:id/confirm_email']//android.widget.EditText");

	public static By getAddresstextbox() {
		return addressTextBox;
	}

	public static By getCitytextbox() {
		return cityTextBox;
	}

	public static By getPostalcodetextbox() {
		return postalCodeTextBox;
	}

	public static By getCountrydropdown() {
		return countryDropDown;
	}

	public static By getPhonenumbertextbox() {
		return phoneNumberTextBox;
	}

	public static By getEmailaddresstextbox() {
		return emailAddressTextBox;
	}

	public static By getConfirmemailtextbox() {
		return confirmEmailTextBox;
	}

	

}
