package com.tigerAir.mobileAutomation.utils;

import java.util.Properties;

import org.openqa.selenium.By;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.tigerAir.mobileAutomation.Base.BasePage;
import com.tigerAir.mobileAutomation.pagesObjects.BookingOverviewPage;
import com.tigerAir.mobileAutomation.pagesObjects.ContactDetailsPage;
import com.tigerAir.mobileAutomation.pagesObjects.CreditCardPage;
import com.tigerAir.mobileAutomation.pagesObjects.DepartingBaggagePage;
import com.tigerAir.mobileAutomation.pagesObjects.FlightDetailsPage;
import com.tigerAir.mobileAutomation.pagesObjects.PassengerDetailsPage;
import com.tigerAir.mobileAutomation.pagesObjects.PassengersListPage;
import com.tigerAir.mobileAutomation.pagesObjects.PassengersSelectionPage;
import com.tigerAir.mobileAutomation.pagesObjects.PaymentPage;
import com.tigerAir.mobileAutomation.pagesObjects.PoliPaymentPage;
import com.tigerAir.mobileAutomation.pagesObjects.SearchFlightPage;
import com.tigerAir.mobileAutomation.pagesObjects.SelectCountryPage;
import com.tigerAir.mobileAutomation.pagesObjects.SelectDepartingFlightPage;
import com.tigerAir.mobileAutomation.pagesObjects.SelectSeatPage;
import com.tigerAir.mobileAutomation.pagesObjects.SportsEquipmentPage;
import com.tigerAir.mobileAutomation.pagesObjects.TermsAndConditionsPage;
import com.tigerAir.mobileAutomation.pagesObjects.YoungTravellersPage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class GenericMethods extends BasePage {

	ElementUtils elementUtils = new ElementUtils(driver);
	ExtentTest test;
	Properties prop = new Properties();
	BasePage basePage = new BasePage();
	String fareSelection;
	String journeyType;
	String ReturnfareSelection1;
	String ReturnfareSelection2;

	public By GenericText(String text) {
		By FlightFrom = By.xpath("//android.widget.TextView[@text='" + text + "']");
		return (FlightFrom);
	}

	By loaderPlane = By.id("au.com.tigerair.booking:id/loader_plane");

	public By GenericCurrencyText(String text) {
		By CurrencyText = By.xpath("//android.widget.TextView[@text='" + text + "']");
		return (CurrencyText);
	}

	public By GenericButton(String text) {
		By buttonText = By.xpath("//android.widget.Button[@text='" + text + "']");
		return buttonText;
	}

	public By genericTitleText(String text) {
		By toolBarTitle = By
				.xpath("//android.widget.TextView[@resource-id='au.com.tigerair.booking:id/toolbar_title' and @text='"
						+ text + "']");
		return toolBarTitle;
	}

	public GenericMethods(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
		prop = basePage.ConfigReader();
	}

	public void SelectFlightFunction(String clickonCurrencytext, String selectActualCurrency,
			String clickonReturnButton, String selectJourneyType, String SelectFromWhere, String SelectToWhere,
			String SelectionDate, int noOfAdults, int noOfchilds, int noofInfants, String departureDate,
			String ArrivalDate) {

		try {
			// journeyType = selectJourneyType;
			test = ExtentReporters.test;
			elementUtils.isElementDisplayed(genericTitleText("Search Flights"));
			elementUtils.doClick(GenericText(clickonCurrencytext));
			LoggersUtil.info("User has clicked on the Currency text " + clickonCurrencytext);
			test.log(LogStatus.PASS, "User has clicked the currency successfully :" + clickonCurrencytext);
			elementUtils.doClick(GenericCurrencyText(selectActualCurrency));
			LoggersUtil.info("User has Selected the Currency :" + selectActualCurrency);
			test.log(LogStatus.PASS, "User has selected the actual currency: " + selectActualCurrency);
			elementUtils.doClick(GenericText(clickonReturnButton));
			LoggersUtil.info("User has clicked on the Return Button");
			test.log(LogStatus.PASS, "User has clicked on the Journey Type Button");
			elementUtils.doClick(GenericText(selectJourneyType));
			LoggersUtil.info("User has clicked on the text" + selectJourneyType);
			test.log(LogStatus.PASS, "User has selected the Journey as :" + selectJourneyType);
			elementUtils.doClick(SearchFlightPage.getPassengerselectionbutton());
			adultselection(noOfAdults, noOfchilds, noofInfants);
			elementUtils.doClick(GenericText("From Where?"));
			LoggersUtil.info("User has clicked on the Origin");
			test.log(LogStatus.PASS, "User has clicked on the Origin");
			elementUtils.scrollAndClickByText(SelectFromWhere);
			LoggersUtil.info("User has selected the From Where as :" + SelectFromWhere);
			test.log(LogStatus.PASS, "User has selected the From Where as :" + SelectFromWhere);
			elementUtils.scrollAndClickByText(SelectToWhere);
			LoggersUtil.info("User has selected the To Where as :" + SelectToWhere);
			test.log(LogStatus.PASS, "User has selected the To Where as :" + SelectToWhere);
			elementUtils.doClick(GenericText("Select Date"));
			LoggersUtil.info("User has selected the Date");
			test.log(LogStatus.PASS, "User has selected the Date");
			if (selectJourneyType.equalsIgnoreCase("return")) {
				elementUtils.doClick(GenericText(departureDate));
				// elementUtils.isElementVisible(loaderPlane);
				// elementUtils.isElementDisplayed(loaderPlane);
				elementUtils.doClick(GenericText(ArrivalDate));
				LoggersUtil.info("User has selected the Date as :" + SelectionDate);
				test.log(LogStatus.PASS, "User has selected the Date as :" + SelectionDate);
			} else {
				elementUtils.doClick(GenericText(SelectionDate));
				LoggersUtil.info("User has selected the Date as :" + SelectionDate);
				test.log(LogStatus.PASS, "User has selected the Date as :" + SelectionDate);
			}
			elementUtils.doClick(GenericButton("Continue"));
			LoggersUtil.info("User has clicked on Continue Button");
			test.log(LogStatus.PASS, "User has clicked on Continue Button");
			elementUtils.doClick(GenericButton("Search Flights"));
			LoggersUtil.info("User has clicked on search flights button");
			test.log(LogStatus.PASS, "User has clicked on the search flights button");
			journeyType = selectJourneyType;
		} catch (Exception ex) {
			LoggersUtil.error("User is not able to select the flight function" + ex.getMessage());
			test.log(LogStatus.FAIL, "User is not able to select the flight function");
		}
	}

	public void selectDepartingflightsFares(String expressFare) {
		try {
			test = ExtentReporters.test;
			elementUtils.waitForElementNotPresent(loaderPlane);
			elementUtils.isElementDisplayed(genericTitleText("Select Departing Flight"));
			if (journeyType.equalsIgnoreCase("return")) {
				elementUtils.doClick(SelectDepartingFlightPage.getSlottime());
				elementUtils.doClick(SelectDepartingFlightPage.fareTypeSelection(expressFare));
				LoggersUtil.info("User has selected the first Slot");
				test.log(LogStatus.PASS, "User has selected the first slot");
				LoggersUtil.info("User has selected the express fare as :" + expressFare);
				test.log(LogStatus.PASS, "User has selected the express fare as :" + expressFare);
				ReturnfareSelection1 = expressFare;
				elementUtils.doClick(SelectDepartingFlightPage.getSlottime());
				elementUtils.doClick(SelectDepartingFlightPage.fareTypeSelection(expressFare));
				LoggersUtil.info("User has selected the first Slot");
				test.log(LogStatus.PASS, "User has selected the first slot");
				LoggersUtil.info("User has selected the express fare as :" + expressFare);
				test.log(LogStatus.PASS, "User has selected the express fare as :" + expressFare);
				ReturnfareSelection2 = expressFare;

			} else {
				elementUtils.doClick(SelectDepartingFlightPage.getSlottime());
				elementUtils.doClick(SelectDepartingFlightPage.fareTypeSelection(expressFare));
				LoggersUtil.info("User has selected the first Slot");
				test.log(LogStatus.PASS, "User has selected the first slot");
				LoggersUtil.info("User has selected the express fare as :" + expressFare);
				test.log(LogStatus.PASS, "User has selected the express fare as :" + expressFare);
				fareSelection = expressFare;
			}
			/*
			 * if (elementUtils.isElementDisplayed(SelectDepartingFlightPage.getSlottime()))
			 * { elementUtils.doClick(SelectDepartingFlightPage.getSlottime()); } else if
			 * (elementUtils.doGetText(SelectDepartingFlightPage.getNoflights()).
			 * contains("no flights") &&
			 * elementUtils.isElementDisplayed(SelectDepartingFlightPage.getNoflights())) {
			 * elementUtils.doClick(SelectDepartingFlightPage.getNextflightbutton());
			 * elementUtils.doClick(SelectDepartingFlightPage.getSlottime()); }
			 */

			LoggersUtil.info("User has selected the express fare as :" + expressFare);
			test.log(LogStatus.PASS, "User has selected the express fare as :" + expressFare);
			fareSelection = expressFare;
		} catch (Exception ex) {
			LoggersUtil.error("User has not been able to select flight fare" + ex.getMessage());
		}
	}

	public void clickOnPassenger(String passengerListName) {
		try {
			test = ExtentReporters.test;
			elementUtils.waitForElementNotPresent(loaderPlane);
			elementUtils.isElementDisplayed(genericTitleText("Passengers"));
			elementUtils.doClick(PassengersListPage.PassengerSelection(passengerListName));
			LoggersUtil.info("User has clicked on the Passenger" + passengerListName);
			test.log(LogStatus.PASS, "User has clicked on the passenger" + passengerListName);

		} catch (Exception ex) {
			LoggersUtil.error("User has not been able to click on the passenger" + ex.getMessage());
			test.log(LogStatus.FAIL, "User has not able to click on the passenger");
		}
	}

	public void enterPassengerDetails(String selectCabonBaggageYesorNo, String selectKGforcabin,
			String selectKGforCheckin, String selectQueueJumpYesorNo, String selectCarbonOffsetYesorNo,
			String selectSportsEquipmentYesorNo, String selectSportsEquipmentpiece) {
		test = ExtentReporters.test;
		if (elementUtils.isElementVisible(PassengerDetailsPage.getAdultTextTab())) {
			elementUtils.doClick(PassengerDetailsPage.getSelectdob());
			elementUtils.enterTextByKeyboard(PassengerDetailsPage.getSelectmonth(), "Feb");
			elementUtils.enterTextByKeyboard(PassengerDetailsPage.getSelectday(), "22");
			elementUtils.enterTextByKeyboard(PassengerDetailsPage.getSelectyear(), "9992");
			elementUtils.doClick(PassengerDetailsPage.getOkbutton());
		}
		elementUtils.doClick(PassengerDetailsPage.getSelecttitle());
		elementUtils.doClick(PassengerDetailsPage.getselectFirstElement());
		// elementUtils.doClick(PassengerDetailsPage.selectTitleInitials(Initials));

		elementUtils.doSendKeys(PassengerDetailsPage.getNameenter(), elementUtils.getAlphaNumericString(6));
		elementUtils.doSendKeys(PassengerDetailsPage.getEnterlastname(), elementUtils.getAlphaNumericString(6));
		elementUtils.doClick(PassengerDetailsPage.getSelectdob());

		/*
		 * elementUtils.doSendKeys(passengerDetailsPage.selectMonth, "Feb");
		 * elementUtils.doSendKeys(passengerDetailsPage.selectDay, "6");
		 * elementUtils.doSendKeys(passengerDetailsPage.selectYear, "2007");
		 */
		elementUtils.doClick(PassengerDetailsPage.getOkbutton());
		elementUtils.isElementDisplayed(PassengerDetailsPage.getNameenter());
		if (selectCabonBaggageYesorNo.equalsIgnoreCase("Yes")) {
			elementUtils.scrollAndClickByText("Select Baggage");
			elementUtils.isElementDisplayed(DepartingBaggagePage.getHeadertext());
			elementUtils.scrollAndClickByText(selectKGforcabin);
			elementUtils.scrollAndClickByText(selectKGforCheckin);
			elementUtils.doClick(DepartingBaggagePage.getAddbutton());
			elementUtils.isElementDisplayed(genericTitleText("Passenger Details"));
		}
		if (elementUtils.isElementVisible(FlightDetailsPage.getFlightdetailstext())) {
			elementUtils.doClick(FlightDetailsPage.getClosebutton());
		}
		if (selectSportsEquipmentYesorNo.equalsIgnoreCase("Yes")) {
			selectSportsEquipmentFunc(selectSportsEquipmentpiece);
		}
		if (elementUtils.isElementVisible(FlightDetailsPage.getFlightdetailstext())) {
			elementUtils.doClick(FlightDetailsPage.getClosebutton());
		}
		if (selectQueueJumpYesorNo.equalsIgnoreCase("Yes")) {
			if (fareSelection.equalsIgnoreCase("Express")) {
				elementUtils.verticalSwipeByPercentagesbyLocator(PassengerDetailsPage.getIncludedtext());
				elementUtils.isElementDisplayed(PassengerDetailsPage.getIncludedtext());
			} else {
				selectqueueJump();
			}

		}
		if (elementUtils.isElementVisible(FlightDetailsPage.getFlightdetailstext())) {
			elementUtils.doClick(FlightDetailsPage.getClosebutton());
		}
		if (selectCarbonOffsetYesorNo.equalsIgnoreCase("Yes")) {
			selectcarbonOffset();
		}

	}

	private void selectqueueJump() {
		try {
			// elementUtils.scrollAndClickByText(elementUtils.doGetText(PassengerDetailsPage.getDepartingqueuejumpswitch()));
			elementUtils.verticalSwipeByPercentagesbyLocator(PassengerDetailsPage.getDepartingqueuejumpswitch());
			elementUtils.doClick(PassengerDetailsPage.getDepartingqueuejumpswitch());
		} catch (Exception ex) {
			LoggersUtil.fatal("User has not clicked on the queue jump button" + ex.getMessage());
		}
	}

	private void selectcarbonOffset() {
		try {
			elementUtils.verticalSwipeByPercentagesbyLocator(PassengerDetailsPage.getCarbonoffsetswitchbutton());
			elementUtils.doClick(PassengerDetailsPage.getCarbonoffsetswitchbutton());
		} catch (Exception ex) {
			LoggersUtil.fatal("User has not clicked on the Carbon offset button" + ex.getMessage());
		}
	}

	private void selectSportsEquipmentFunc(String selectSportsEquipment) {
		try {
			elementUtils.verticalSwipeByPercentagesbyLocator(PassengerDetailsPage.getSportsequipmentbutton());
			elementUtils.doClick(PassengerDetailsPage.getSportsequipmentbutton());
			elementUtils.isElementDisplayed(SportsEquipmentPage.getGetheadertext());
			elementUtils.scrollAndClickByText(selectSportsEquipment);
			elementUtils.doClick(SportsEquipmentPage.getAddbutton());
			elementUtils.isElementDisplayed(genericTitleText("Passenger Details"));
		} catch (Exception ex) {
			LoggersUtil.error("User has not selected the Select Sports Equipment" + ex.getMessage());
		}
	}

	public void selectionYoungTravelers(String OptionYesOrNo) {
		elementUtils.doClick(YoungTravellersPage.selectYoungTravelers(OptionYesOrNo));
		elementUtils.doClick(YoungTravellersPage.getAgreebutton());
	}

	public void selectionSeatforTravellers(String selectseatyesOrNo, String SeatNo) {
		try {
			elementUtils.waitForElementNotPresent(loaderPlane);
			elementUtils.isElementDisplayed(PassengersListPage.getTitletext());
			elementUtils.doClick(PassengersListPage.getContinuebutton());
			elementUtils.isElementDisplayed(genericTitleText("Select Seat"));
			if (selectseatyesOrNo.equalsIgnoreCase("Yes")) {
				elementUtils.doClick(SelectSeatPage.getSelectseatbutton());
				elementUtils.waitForElementNotPresent(loaderPlane);
				elementUtils.verticalSwipeByPercentagesbyLocator(SelectSeatPage.selectSeatNo(SeatNo));
				elementUtils.doClick(SelectSeatPage.selectSeatNo(SeatNo));
				elementUtils.waitForElementNotPresent(loaderPlane);
				elementUtils.doClick(SelectSeatPage.getDonebutton());
				elementUtils.doClick(SelectSeatPage.getContinuebutton());
			} else if (selectseatyesOrNo.equalsIgnoreCase("No") && SeatNo.equalsIgnoreCase("NIL")) {
				elementUtils.verticalSwipeByPercentagesbyLocator(SelectSeatPage.getContinuewithoutselectionbutton());
				elementUtils.doClick(SelectSeatPage.getContinuewithoutselectionbutton());
			}
		} catch (Exception ex) {
			LoggersUtil.fatal("Some Exception occured during execution of select seat functionality" + ex.getMessage());
		}
	}

	public void fillingContactDetails(String Address, String City, String PostalCode, String Country, String State,
			String PhoneNumber, String emailAdress, String confirmEmail) {
		elementUtils.waitForElementNotPresent(loaderPlane);
		elementUtils.isElementDisplayed(genericTitleText("Contact Details"));
		elementUtils.doSendKeys(ContactDetailsPage.getAddresstextbox(), Address);
		// elementUtils.isElementDisplayed(contactDetailsPage.cityTextBox);
		elementUtils.enterTextByKeyboard(ContactDetailsPage.getCitytextbox(), City);
		elementUtils.doSendKeys(ContactDetailsPage.getPostalcodetextbox(), PostalCode);
		elementUtils.doClick(ContactDetailsPage.getCountrydropdown());
		elementUtils.doSendKeys(SelectCountryPage.getSelectcountrytextbox(), Country);
		elementUtils.doClick(SelectCountryPage.getNameofcountry());
		elementUtils.doSendKeys(SelectCountryPage.getSelectcountrytextbox(), State);
		elementUtils.doClick(SelectCountryPage.getNameofcountry());
		elementUtils.doSendKeys(ContactDetailsPage.getPhonenumbertextbox(), PhoneNumber);
		elementUtils.doSendKeys(ContactDetailsPage.getEmailaddresstextbox(), emailAdress);
		elementUtils.doSendKeys(ContactDetailsPage.getConfirmemailtextbox(), confirmEmail);
		elementUtils.verticalSwipeByPercentages(0.6, 0.3, 0.5);
		elementUtils.verticalSwipeByPercentages(0.6, 0.3, 0.5);
		elementUtils.scrollAndClickByText("Continue");
		elementUtils.doClick(TermsAndConditionsPage.getAgreementcheckbox());
		elementUtils.verticalSwipeByPercentages(0.6, 0.3, 0.5);
		elementUtils.scrollAndClickByText("Continue to payment");
		// elementUtils.doClick(TermsAndConditionsPage.getContinuebutton());
	}

	public void paymentsection(String PaymentType, String cardHolderName, String cardNumber, String selectMonth,
			String selectYear, String cvvID) {
		elementUtils.waitForElementNotPresent(loaderPlane);
		elementUtils.isElementDisplayed(genericTitleText("Payment"));
		if (PaymentType.equalsIgnoreCase("Credit / Debit")) {
			elementUtils.doClick(PaymentPage.getCreditcardbutton());
			elementUtils.isElementDisplayed(genericTitleText(PaymentType));
			elementUtils.doSendKeys(CreditCardPage.getCardholdernametextbox(), cardHolderName);
			elementUtils.enterTextByKeyboard(CreditCardPage.getCreditcardnumbertextbox(), cardNumber);
			elementUtils.doClick(CreditCardPage.getSelectdatepicker());
			elementUtils.enterTextByKeyboard(CreditCardPage.getSelectmonth(), selectMonth);
			elementUtils.enterTextByKeyboard(CreditCardPage.getSelectyear(), selectYear);
			elementUtils.doClick(CreditCardPage.getOkbutton());
			elementUtils.doSendKeys(CreditCardPage.getCvvtextbox(), cvvID);
			elementUtils.doClick(CreditCardPage.getPaybutton());
			pnr_GenerationforCreditCard();
		} else {
			elementUtils.doClick(PaymentPage.getPolibutton());
			elementUtils.isElementDisplayed(PaymentPage.getPoliholdertext());
			elementUtils.doClick(PaymentPage.getPaybutton());
			// elementUtils.isElementDisplayed(PoliPaymentPage.getBanktext());
			elementUtils.isElementDisplayed(PoliPaymentPage.getContinuebutton());
			elementUtils.doClick(PoliPaymentPage.getContinuebutton());
			elementUtils.isElementDisplayed(PoliPaymentPage.getUsernametext());
			elementUtils.doSendKeys(PoliPaymentPage.getUsernametext(), "DemoShopper");
			elementUtils.doSendKeys(PoliPaymentPage.getPasswordtext(), "DemoShopper");
			elementUtils.doClick(PoliPaymentPage.getLoginbutton());
			elementUtils.isElementDisplayed(PoliPaymentPage.getAccounttext());
			elementUtils.isElementDisplayed(PoliPaymentPage.getSecondcontinuebutton());
			elementUtils.doClick(PoliPaymentPage.getSecondcontinuebutton());
			elementUtils.isElementDisplayed(PoliPaymentPage.getConfirmbutton());
			pnr_GenerationforCreditCard();
		}

	}

	public void pnr_GenerationforCreditCard() {
		try {
			elementUtils.isElementDisplayed(CreditCardPage.getSeemybookingbutton());
			elementUtils.doClick(CreditCardPage.getSeemybookingbutton());
			elementUtils.waitForElementNotPresent(loaderPlane);
			elementUtils.isElementDisplayed(BookingOverviewPage.getPnrtext());
			elementUtils.doGetText(BookingOverviewPage.getPnrtext());
		} catch (Exception ex) {
			LoggersUtil.info("PNR is not getting generated" + ex.getMessage());
		}
	}

	public void pnr_GenerationforPoli() {
		try {
			elementUtils.isElementDisplayed(CreditCardPage.getSeemybookingbutton());
			elementUtils.doClick(CreditCardPage.getSeemybookingbutton());
			elementUtils.waitForElementNotPresent(loaderPlane);
			elementUtils.isElementDisplayed(BookingOverviewPage.getPnrtext());
			elementUtils.doGetText(BookingOverviewPage.getPnrtext());
		} catch (Exception ex) {
			LoggersUtil.info("PNR is not getting generated" + ex.getMessage());
		}
	}

	public void adultselection(int noOfAdults, int noOfchilds, int noofInfants) {
		elementUtils.waitForElementNotPresent(loaderPlane);
		elementUtils.isElementDisplayed(PassengersSelectionPage.getAdultplusbutton());
		for (int i = 0; i < noOfAdults - 1; i++) {
			elementUtils.doClick(PassengersSelectionPage.getAdultplusbutton());
		}
		for (int i = 0; i < noOfchilds; i++) {
			elementUtils.doClick(PassengersSelectionPage.getChildplusbutton());
		}
		for (int i = 0; i < noofInfants; i++) {
			elementUtils.doClick(PassengersSelectionPage.getInfantplusbutton());
		}
		elementUtils.doClick(PassengersSelectionPage.getContinuebutton());
	}

	public void fillPassengerDetails(String selectCabonBaggageYesorNo, String selectKGforcabin,
			String selectKGforCheckin, String selectQueueJumpYesorNo, String selectCarbonOffsetYesorNo,
			String selectSportsEquipmentYesorNo, String selectSportsEquipmentpiece) {
		boolean check = true;
		boolean nextPassengerStatus = false, continueStatus = false;
		enterPassengerDetails(selectCabonBaggageYesorNo, selectKGforcabin, selectKGforCheckin, selectQueueJumpYesorNo,
				selectCarbonOffsetYesorNo, selectSportsEquipmentYesorNo, selectSportsEquipmentpiece);
		while (check) {
			elementUtils.verticalSwipeByPercentagesbyLocator(By.xpath(
					"//android.widget.Button[@text='Next Passenger'] | //android.widget.Button[@text='Continue']"));
			nextPassengerStatus = elementUtils.isElementVisible(PassengerDetailsPage.getNextpassengerbutton());
			if (nextPassengerStatus == true) {
				elementUtils.doClick(PassengerDetailsPage.getNextpassengerbutton());
				enterPassengerDetails(selectCabonBaggageYesorNo, selectKGforcabin, selectKGforCheckin,
						selectQueueJumpYesorNo, selectCarbonOffsetYesorNo, selectSportsEquipmentYesorNo,
						selectSportsEquipmentpiece);
			}
			continueStatus = elementUtils.isElementVisible(PassengerDetailsPage.getContinuebutton());
			if (continueStatus == true) {
				elementUtils.doClick(PassengerDetailsPage.getContinuebutton());
				check = false;
			}

		}

	}

}
