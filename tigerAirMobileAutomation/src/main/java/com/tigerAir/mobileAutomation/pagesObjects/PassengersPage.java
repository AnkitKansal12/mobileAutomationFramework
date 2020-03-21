package com.tigerAir.mobileAutomation.pagesObjects;

import org.openqa.selenium.By;

import com.tigerAir.mobileAutomation.utils.ElementUtils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class PassengersPage {
	
	AndroidDriver<AndroidElement> driver = null;
	ElementUtils elementUtils;
	
	public By titleText=By.id("au.com.tigerair.booking:id/title_view");
	
	public By continueButton=By.id("au.com.tigerair.booking:id/continue_button");

	

	public By PassengerSelection(String text) {
		By fareType = By.xpath("//android.widget.TextView[@resource-id='au.com.tigerair.booking:id/title' and @text='" + text + "']");
		return (fareType);
	}

	public PassengersPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

}
