package com.tigerAir.mobileAutomation.pagesObjects;

import org.openqa.selenium.By;



public class TermsAndConditionsPage {
	


	private static final By agreementCheckbox = By.id("au.com.tigerair.booking:id/chkterms");
	private static final By continueButton=By.id("au.com.tigerair.booking:id/continue_button");
	public static By getAgreementcheckbox() {
		return agreementCheckbox;
	}
	public static By getContinuebutton() {
		return continueButton;
	}	
	



}
