package com.tigerAir.mobileAutomation.pagesObjects;

import org.openqa.selenium.By;



public class CreditCardPage {
	

	private static final By cardHolderNameTextBox = By.xpath(
			"//android.widget.LinearLayout[@resource-id='au.com.tigerair.booking:id/card_details_name']//android.widget.EditText");
	private static final By creditCardNumberTextBox = By.xpath(
			"//android.widget.LinearLayout[@resource-id='au.com.tigerair.booking:id/card_details_number']//android.widget.EditText");

	private static final By setExpiryText = By.xpath("//android.widget.TextView[@text='Set expiry date']");

	private static final By selectMonth = By.xpath(
			"//android.widget.LinearLayout[@resource-id='android:id/pickers']//android.widget.NumberPicker[1]/android.widget.EditText");

	private static final By selectYear = By.xpath(
			"//android.widget.LinearLayout[@resource-id='android:id/pickers']//android.widget.NumberPicker[2]/android.widget.EditText");

	private static final By selectDatePicker = By.id("au.com.tigerair.booking:id/card_details_expiry_date");
	private static final By cvvTextbox = By.xpath(
			"//android.widget.LinearLayout[@resource-id='au.com.tigerair.booking:id/card_details_cvv']//android.widget.EditText");
	
	private static final By payButton=By.id("au.com.tigerair.booking:id/pay_button");
	
	private static final By okButton=By.id("android:id/button1");
	
	private static final By seeMyBookingButton=By.id("au.com.tigerair.booking:id/btngotonextstep");

	public static By getCardholdernametextbox() {
		return cardHolderNameTextBox;
	}

	public static By getCreditcardnumbertextbox() {
		return creditCardNumberTextBox;
	}

	public static By getSetexpirytext() {
		return setExpiryText;
	}

	public static By getSelectmonth() {
		return selectMonth;
	}

	public static By getSelectyear() {
		return selectYear;
	}

	public static By getSelectdatepicker() {
		return selectDatePicker;
	}

	public static By getCvvtextbox() {
		return cvvTextbox;
	}

	public static By getPaybutton() {
		return payButton;
	}

	public static By getOkbutton() {
		return okButton;
	}

	public static By getSeemybookingbutton() {
		return seeMyBookingButton;
	}


}
