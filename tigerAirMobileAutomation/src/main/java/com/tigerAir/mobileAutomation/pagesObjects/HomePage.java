package com.tigerAir.mobileAutomation.pagesObjects;

/**
 * This class is for HomePage based on PageObjectPattern
 * @author Ankit.1.Kansal
 * 
 */
import org.openqa.selenium.By;
import com.tigerAir.mobileAutomation.Base.BasePage;
import com.tigerAir.mobileAutomation.utils.ElementUtils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class HomePage extends BasePage {

	AndroidDriver<AndroidElement> driver = null;
	ElementUtils elementUtils;

	By tigerAirEntertainmentButton = By.xpath("//android.widget.Button[@text='Tigertainment']");
	By bookFlightButton = By.xpath(
			"//android.widget.Button[@text='Book Flights' and @resource-id='au.com.tigerair.booking:id/home_book_flight_button']");

	public HomePage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);

	}

	// page actions:
	public void clickonTigerEntertainmentButton() {
		elementUtils.doClick(tigerAirEntertainmentButton);
	}

	public String getTigerEntainmentText() {
		return elementUtils.doGetText(tigerAirEntertainmentButton);
	}

	public Boolean BookFlightisDisplayed() {
		return elementUtils.isElementDisplayed(bookFlightButton);
	}

	public void clickonBookFlightButton() {
		elementUtils.doClick(bookFlightButton);
	}

}
