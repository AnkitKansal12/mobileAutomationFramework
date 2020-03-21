package com.tigerAir.mobileAutomation.pagesObjects;

import org.openqa.selenium.By;

public class PaymentPage {

	private static final By subpriceTotal = By.id("au.com.tigerair.booking:id/subtotal_price");
	private static final By creditCardButton = By.xpath("//android.widget.TextView[@text='Credit / Debit']");
	private static final By poliButton = By.id("au.com.tigerair.booking:id/lloptionpoli");
	private static final By poliHolderText = By.id("au.com.tigerair.booking:id/poliinfo");
	private static final By payButton = By.id("au.com.tigerair.booking:id/pay_button");

	public static By getPoliholdertext() {
		return poliHolderText;
	}

	public static By getPolibutton() {
		return poliButton;
	}

	public static By getSubpricetotal() {
		return subpriceTotal;
	}

	public static By getCreditcardbutton() {
		return creditCardButton;
	}

	public static By getPaybutton() {
		return payButton;
	}

}
