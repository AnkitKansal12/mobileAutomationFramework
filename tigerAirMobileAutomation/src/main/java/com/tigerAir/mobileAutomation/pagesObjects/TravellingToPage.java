package com.tigerAir.mobileAutomation.pagesObjects;

import com.tigerAir.mobileAutomation.utils.ElementUtils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class TravellingToPage {
	

	AndroidDriver<AndroidElement> driver=null;
	ElementUtils elementUtils;	


	public TravellingToPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		elementUtils =new ElementUtils(driver);
		
	}

}
