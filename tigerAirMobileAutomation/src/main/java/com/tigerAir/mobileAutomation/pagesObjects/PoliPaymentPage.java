package com.tigerAir.mobileAutomation.pagesObjects;

import org.openqa.selenium.By;

public class PoliPaymentPage {

	private static final By BankText = By.id("selectYourBankLabel");
	private static final By continueButton = By.xpath("//*[@resource-id='proceed-button']");
	private static final By userNameText = By.xpath("//*[@resource-id='stepContainer']//android.widget.EditText[1]");
	private static final By passwordText = By.xpath("//*[@resource-id='stepContainer']//android.widget.EditText[2]");
	private static final By loginButton = By.xpath("//*[@resource-id='footerButtonsRight']//android.widget.Button[1]");
	private static final By confirmButton = By
			.xpath("//*[@resource-id='footerButtonsRight']//android.widget.Button[@text='Confirm']");
	private static final By accountText = By.xpath("//android.view.View[@text='Account']");
	private static final By secondContinueButton = By.xpath("//android.widget.Button[@text='Continue']");

	public static By getAccounttext() {
		return accountText;
	}

	public static By getSecondcontinuebutton() {
		return secondContinueButton;
	}

	public static By getBanktext() {
		return BankText;
	}

	public static By getContinuebutton() {
		return continueButton;
	}

	public static By getUsernametext() {
		return userNameText;
	}

	public static By getConfirmbutton() {
		return confirmButton;
	}

	public static By getPasswordtext() {
		return passwordText;
	}

	public static By getLoginbutton() {
		return loginButton;
	}

}
