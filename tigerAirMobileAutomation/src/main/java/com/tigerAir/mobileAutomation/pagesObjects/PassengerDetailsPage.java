package com.tigerAir.mobileAutomation.pagesObjects;

import org.openqa.selenium.By;

public class PassengerDetailsPage {

	private static final By selectTitle = By
			.xpath("//android.widget.TextView[@resource-id='au.com.tigerair.booking:id/input_text_view']");
	private static final By nameEnter = By.xpath(
			"//android.widget.LinearLayout[@resource-id='au.com.tigerair.booking:id/name']//android.widget.EditText[@resource-id='au.com.tigerair.booking:id/input_text_view']");
	private static final By enterLastName = By.xpath(
			"//android.widget.LinearLayout[@resource-id='au.com.tigerair.booking:id/last_name']//android.widget.EditText[@resource-id='au.com.tigerair.booking:id/input_text_view']");

	private static final By dobSelectionWindow = By
			.xpath("//android.widget.TextView[@resource-id='android:id/alertTitle']");

	private static final By selectDOB = By
			.xpath("//android.widget.TextView[@resource-id='au.com.tigerair.booking:id/compound_text_view']");

	private static final By selectDay = By.xpath(
			"//android.widget.LinearLayout[@resource-id='android:id/pickers']//android.widget.NumberPicker[1]//android.widget.EditText");

	private static final By selectMonth = By.xpath(
			"//android.widget.LinearLayout[@resource-id='android:id/pickers']//android.widget.NumberPicker[2]//android.widget.EditText");

	private static final By selectYear = By.xpath(
			"//android.widget.LinearLayout[@resource-id='android:id/pickers']//android.widget.NumberPicker[3]//android.widget.EditText");

	private static final By selectFirstElement = By.xpath(
			"//android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView");

	private static final By OKButton = By.id("android:id/button1");
	private static final By passengerBlocks = By
			.xpath("//*[@resource-id='au.com.tigerair.booking:id/sliding_tab_layout']//android.widget.TextView");
	
	public static By getPassengerblocks() {
		return passengerBlocks;
	}

	private static final By CancelButton = By.id("android:id/button2");
	private static final By PaxDetailsContinueButton = By.id("au.com.tigerair.booking:id/pax_edit_continue_button");
	private static final By Layout = By.id("au.com.tigerair.booking:id/root_inner_layout");
	private static final By DepartureBaggageSelection = By.xpath(
			"//*[@resource-id='au.com.tigerair.booking:id/baggage_element_block']//*[@resource-id='au.com.tigerair.booking:id/llselectBaggage']");
	private static final By DepartingSportsEquipmentSelection = By
			.xpath("//android.widget.LinearLayout/android.widget.LinearLayout[1]//*[@text='Add Sports Equipment']");
	private static final By DepartingQueueJumpSwitch = By.xpath(
			"//*[@resource-id='au.com.tigerair.booking:id/qjump_items_block']//*[@resource-id='au.com.tigerair.booking:id/queue_jump_element_switch']");
	private static final By ReturningQueueJumpSwitch = By.xpath(
			"//android.widget.LinearLayout[2]/android.widget.FrameLayout[2]//android.widget.TextView[@resource-id='au.com.tigerair.booking:id/queue_jump_element_switch']");
	private static final By carbonoffSetSwitchButton = By.xpath(
			"//*[@resource-id='au.com.tigerair.booking:id/co_block']//*[@resource-id='au.com.tigerair.booking:id/queue_jump_element_switch']");

	private static final By headerText = By.xpath("//*[@resource-id='au.com.tigerair.booking:id/headertext']");
	private static final By sportsEquipmentButton=By.xpath("//*[@resource-id='au.com.tigerair.booking:id/sports_element_block']//*[@text='Add Sports Equipment']");
	private static final By includedText=By.xpath("//*[@resource-id='au.com.tigerair.booking:id/queue_jump_element_status']");
	

	public static By getIncludedtext() {
		return includedText;
	}

	public static By getSportsequipmentbutton() {
		return sportsEquipmentButton;
	}

	public static By getCarbonoffsetswitchbutton() {
		return carbonoffSetSwitchButton;
	}

	public static By getHeadertext() {
		return headerText;
	}

	private static final By continueButton = By.xpath("//android.widget.Button[@text='Continue']");
	private static final By nextPassengerButton = By.xpath("//android.widget.Button[@text='Next Passenger']");

	public static By selectTitleInitials(String text) {
		By selectTitleini = By
				.xpath("//android.widget.TextView[@resource-id='au.com.tigerair.booking:id/input_text_view' and @text='"
						+ text + "']");
		return (selectTitleini);
	}

	public static By getSelectfirstelement() {
		return selectFirstElement;
	}

	public static By getDeparturebaggageselection() {
		return DepartureBaggageSelection;
	}

	public static By getDepartingsportsequipmentselection() {
		return DepartingSportsEquipmentSelection;
	}

	public static By getDepartingqueuejumpswitch() {
		return DepartingQueueJumpSwitch;
	}

	public static By getReturningqueuejumpswitch() {
		return ReturningQueueJumpSwitch;
	}

	public static By getContinuebutton() {
		return continueButton;
	}

	public static By getNextpassengerbutton() {
		return nextPassengerButton;
	}

	public static By getAdulttexttab() {
		return adultTextTab;
	}

	public static By getAdultheader() {
		return AdultHeader;
	}

	private static final By adultTextTab = By
			.xpath("//*[@resource-id='au.com.tigerair.booking:id/sliding_tab_layout']//*[contains(@text,'Adult')]");

	private static final By AdultHeader = By.xpath("");

	public static By getselectFirstElement() {
		return selectFirstElement;
	}

	public static By getAdultTextTab() {
		return adultTextTab;
	}

	public static By getSelecttitle() {
		return selectTitle;
	}

	public static By getNameenter() {
		return nameEnter;
	}

	public static By getEnterlastname() {
		return enterLastName;
	}

	public static By getDobselectionwindow() {
		return dobSelectionWindow;
	}

	public static By getSelectdob() {
		return selectDOB;
	}

	public static By getSelectday() {
		return selectDay;
	}

	public static By getSelectmonth() {
		return selectMonth;
	}

	public static By getSelectyear() {
		return selectYear;
	}

	public static By getOkbutton() {
		return OKButton;
	}

	public static By getCancelbutton() {
		return CancelButton;
	}

	public static By getPaxdetailscontinuebutton() {
		return PaxDetailsContinueButton;
	}

	public static By getLayout() {
		return Layout;
	}

}
