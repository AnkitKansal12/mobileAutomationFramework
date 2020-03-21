package com.tigerAir.mobileAutomation.pagesObjects;

import org.openqa.selenium.By;

public class SelectSeatPage {

	private static final By continuewithoutSelectionButton = By
			.id("au.com.tigerair.booking:id/continue_without_selection_button");
	private static final By selectSeatButton = By.xpath("//*[@resource-id='au.com.tigerair.booking:id/row_pick']");
	private static final By doneButton = By.xpath("//*[@resource-id='au.com.tigerair.booking:id/done_button']");
	private static final By continueButton=By.xpath("//*[@resource-id='au.com.tigerair.booking:id/continue_button']");

	public static By getContinuebutton() {
		return continueButton;
	}

	public static By getDonebutton() {
		return doneButton;
	}

	public static By getSelectseatbutton() {
		return selectSeatButton;
	}

	public static By getContinuewithoutselectionbutton() {
		return continuewithoutSelectionButton;
	}

	public static By selectupFronSeat(String SeatNo) {
		return (By.xpath(
				"//*[@text='Up Front']//following::android.widget.Button[@resource-id='au.com.tigerair.booking:id/btnseat' and @text='"
						+ SeatNo + "']"));

	}

	public static By selectSeatNo(String seatNo) {
		return (By.xpath("//*[@resource-id='au.com.tigerair.booking:id/rvseats']//*[@text='" + seatNo + "']"));

	}

}
