package com.tigerAir.mobileAutomation.utils;

import org.openqa.selenium.By;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.tigerAir.mobileAutomation.pagesObjects.BookingOverviewPage;
import com.tigerAir.mobileAutomation.pagesObjects.ContactDetailsPage;
import com.tigerAir.mobileAutomation.pagesObjects.CreditCardPage;
import com.tigerAir.mobileAutomation.pagesObjects.DepartingBaggagePage;
import com.tigerAir.mobileAutomation.pagesObjects.FlightDetailsPage;
import com.tigerAir.mobileAutomation.pagesObjects.HomePage;
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

public class GenericMethods extends ElementUtils {

	ElementUtils elementUtils = new ElementUtils();
	String fareSelection;
	String journeyType;
	String ReturnfareSelection1;
	String ReturnfareSelection2;
	ExcelUtil excelUtil = new ExcelUtil();

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

	public void SelectFlightFunction(String clickonCurrencytext, String selectActualCurrency,
			String clickonReturnButton, String selectJourneyType, String SelectFromWhere, String SelectToWhere,
			String SelectionDate, String noOfAdults, String noOfchilds, String noofInfants, String departureDate,
			String ArrivalDate) {

		try {
			elementUtils.waitForElementNotVisible(loaderPlane);
			// SoftAssertionsonText(HomePage.getBookflightbutton(), "Book Flights");
			elementUtils.doClick(HomePage.getBookflightbutton());
			test.log(Status.PASS,
					MarkupHelper.createLabel("User has clicked on the Book Flights Button", ExtentColor.GREEN));
			elementUtils.isElementDisplayed(genericTitleText("Search Flights"));
			elementUtils.doClick(GenericText(clickonCurrencytext));
			LoggersUtil.info("User has clicked on the Currency text " + clickonCurrencytext);
			elementUtils.doClick(GenericCurrencyText(selectActualCurrency));
			LoggersUtil.info("User has Selected the Currency :" + selectActualCurrency);
			test.log(Status.PASS, MarkupHelper.createLabel(
					"User has selected the actual currency as : " + selectActualCurrency, ExtentColor.GREEN));
			elementUtils.doClick(GenericText(clickonReturnButton));
			LoggersUtil.info("User has clicked on the Return Button");
			elementUtils.doClick(GenericText(selectJourneyType));
			LoggersUtil.info("User has clicked on the text" + selectJourneyType);
			test.log(Status.PASS, MarkupHelper
					.createLabel("User has selected the Journey Type as :  " + selectJourneyType, ExtentColor.GREEN));
			elementUtils.doClick(SearchFlightPage.getPassengerselectionbutton());
			adultselection(noOfAdults, noOfchilds, noofInfants);
			elementUtils.doClick(GenericText("From Where?"));
			LoggersUtil.info("User has clicked on the Origin");
			elementUtils.scrollAndClickByText(SelectFromWhere);
			LoggersUtil.info("User has selected the From Where as :" + SelectFromWhere);
			test.log(Status.PASS,
					MarkupHelper.createLabel("User has selected from where as :" + SelectFromWhere, ExtentColor.GREEN));
			elementUtils.scrollAndClickByText(SelectToWhere);
			LoggersUtil.info("User has selected To Where as :" + SelectToWhere);
			test.log(Status.PASS,
					MarkupHelper.createLabel("User has selected to where as :" + SelectToWhere, ExtentColor.GREEN));
			elementUtils.doClick(GenericText("Select Date"));
			LoggersUtil.info("User has clicked on the Select Date");
			if (selectJourneyType.equalsIgnoreCase("return")) {
				elementUtils.doClick(GenericText(departureDate));
				// elementUtils.isElementVisible(loaderPlane);
				// elementUtils.isElementDisplayed(loaderPlane);
				elementUtils.doClick(GenericText(ArrivalDate));
				LoggersUtil.info("User has selected the departure date as :" + departureDate);
				test.log(Status.PASS, MarkupHelper.createLabel("User has selected Departure Date :" + departureDate,
						ExtentColor.GREEN));
				LoggersUtil.info("User has selected the arrival date as :" + ArrivalDate);
				test.log(Status.PASS,
						MarkupHelper.createLabel("User has selecte arrival Date :" + ArrivalDate, ExtentColor.GREEN));

			} else {
				elementUtils.doClick(GenericText(SelectionDate));
				LoggersUtil.info("User has selected the Date as :" + SelectionDate);
				test.log(Status.PASS, MarkupHelper.createLabel("User has selected the date as : " + SelectionDate,
						ExtentColor.GREEN));
			}
			elementUtils.doClick(GenericButton("Continue"));
			LoggersUtil.info("User has clicked on Continue Button");
			elementUtils.doClick(GenericButton("Search Flights"));
			LoggersUtil.info("User has clicked on search flights button");
			test.log(Status.PASS,
					MarkupHelper.createLabel("User has clicked on Search Flights Button", ExtentColor.GREEN));
			journeyType = selectJourneyType;
		} catch (Exception ex) {
			LoggersUtil.error("User is not able to select the flight function" + ex);
			test.log(Status.FAIL,
					MarkupHelper.createLabel("User is getting some error while selecting Flights", ExtentColor.RED));
		}

	}

	public void selectDepartingflightsFares(String expressFare) {
		try {
			elementUtils.waitForElementNotVisible(loaderPlane);
			elementUtils.isElementDisplayed(genericTitleText("Select Departing Flight"));
			if (journeyType.equalsIgnoreCase("return")) {
				elementUtils.doClick(SelectDepartingFlightPage.getSlottime());
				elementUtils.doClick(SelectDepartingFlightPage.fareTypeSelection(expressFare));
				LoggersUtil.info("User has selected the first Slot");
				LoggersUtil.info("User has selected the express fare as :" + expressFare);
				test.log(Status.PASS, MarkupHelper.createLabel(
						"User has selected the departure Fare Type as :" + expressFare, ExtentColor.GREEN));
				ReturnfareSelection1 = expressFare;
				elementUtils.doClick(SelectDepartingFlightPage.getSlottime());
				elementUtils.doClick(SelectDepartingFlightPage.fareTypeSelection(expressFare));
				LoggersUtil.info("User has selected the first Slot");
				LoggersUtil.info("User has selected the express fare as :" + expressFare);
				test.log(Status.PASS, MarkupHelper
						.createLabel("User has selected the arrival Fare Type as :" + expressFare, ExtentColor.GREEN));
				ReturnfareSelection2 = expressFare;

			} else {
				// elementUtils.scrollAndClickByText("TT 282");
				elementUtils.doClick(SelectDepartingFlightPage.getSlottime());
				elementUtils.doClick(SelectDepartingFlightPage.fareTypeSelection(expressFare));
				LoggersUtil.info("User has selected the fare Type as " + expressFare);
				test.log(Status.PASS, MarkupHelper.createLabel("User has selected the Fare Type as :" + expressFare,
						ExtentColor.GREEN));
				fareSelection = expressFare;
			}
			fareSelection = expressFare;
		} catch (Exception ex) {
			LoggersUtil.error("User has not been able to select flight fare" + ex.getMessage());
			test.log(Status.FAIL,
					MarkupHelper.createLabel("User is getting some error while selecting FareType ", ExtentColor.RED));
		}
	}

	public void clickOnPassenger(String passengerListName) {
		try {

			elementUtils.waitForElementNotVisible(loaderPlane);
			elementUtils.isElementDisplayed(genericTitleText("Passengers"));
			elementUtils.doClick(PassengersListPage.PassengerSelection(passengerListName));
			LoggersUtil.info("User has clicked on the Passenger" + passengerListName);
			test.log(Status.PASS, MarkupHelper.createLabel(
					"User has clicked on the Passenger List Name as :" + passengerListName, ExtentColor.GREEN));
		} catch (Exception ex) {
			LoggersUtil.error("User has not been able to click on the passenger" + ex);
			test.log(Status.FAIL, MarkupHelper.createLabel(
					"User is getting some error while selecting passenger Name" + passengerListName, ExtentColor.RED));
		}
	}

	public void enterPassengerDetails(String selectCabonBaggageYesorNo, String selectKGforcabin,
			String selectKGforCheckin, String selectQueueJumpYesorNo, String selectCarbonOffsetYesorNo,
			String selectSportsEquipmentYesorNo, String selectSportsEquipmentpiece) {
		// if (elementUtils.isElementVisible(PassengerDetailsPage.getAdultTextTab())) {
		elementUtils.doClick(PassengerDetailsPage.getSelectdob());
		LoggersUtil.info("User has clicked on the date picker ");
		elementUtils.enterTextByKeyboard(PassengerDetailsPage.getSelectmonth(), "Feb");
		LoggersUtil.info("User has selected the Month");
		elementUtils.enterTextByKeyboard(PassengerDetailsPage.getSelectday(), "22");
		LoggersUtil.info("User has selected the Day");
		elementUtils.enterTextByKeyboard(PassengerDetailsPage.getSelectyear(), "9992");
		LoggersUtil.info("User has selected Year");
		elementUtils.doClick(PassengerDetailsPage.getOkbutton());
		LoggersUtil.info("User has clicked on the OK Button");

		elementUtils.doClick(PassengerDetailsPage.getSelecttitle());
		LoggersUtil.info("User has clicked the Select Title");
		elementUtils.doClick(PassengerDetailsPage.getselectFirstElement());
		LoggersUtil.info("User has selected the First Element");
		elementUtils.doSendKeys(PassengerDetailsPage.getNameenter(), elementUtils.getAlphaNumericString(6));
		LoggersUtil.info("User has entered First Name");
		elementUtils.doSendKeys(PassengerDetailsPage.getEnterlastname(), elementUtils.getAlphaNumericString(6));
		LoggersUtil.info("User has entered the Last Name");
		/*
		 * elementUtils.doClick(PassengerDetailsPage.getOkbutton());
		 * LoggersUtil.info("User has clicked on the OK Button");
		 */
		// elementUtils.isElementDisplayed(PassengerDetailsPage.getNameenter());
		if (selectCabonBaggageYesorNo.equalsIgnoreCase("Yes")) {
			if (elementUtils.isElementVisible(DepartingBaggagePage.getSelectbaggagetext())) {
				elementUtils.doClick(DepartingBaggagePage.getSelectbaggagetext());
			} else {
				elementUtils.verticalSwipeByPercentagesbyLocator(DepartingBaggagePage.getSelectbaggagetext());
			}
			LoggersUtil.info("User has clicked for Baggage Selection");
			test.log(Status.PASS, MarkupHelper.createLabel("User has selected the Bagagge", ExtentColor.GREEN));
			elementUtils.isElementDisplayed(DepartingBaggagePage.getHeadertext());
			elementUtils.scrollAndClickByText(selectKGforcabin);
			LoggersUtil.info("User has selected the Cabin amount as :" + selectKGforcabin);
			test.log(Status.PASS,
					MarkupHelper.createLabel("User has selected the Cabin as :" + selectKGforcabin, ExtentColor.GREEN));
			elementUtils.scrollAndClickByText(selectKGforCheckin);
			LoggersUtil.info("User has selected the Cabin amount as :" + selectKGforcabin);
			test.log(Status.PASS,
					MarkupHelper.createLabel("User has selected the Cabin as :" + selectKGforcabin, ExtentColor.GREEN));
			elementUtils.doClick(DepartingBaggagePage.getAddbutton());
			LoggersUtil.info("User has clicked on the Add button");
			elementUtils.isElementDisplayed(genericTitleText("Passenger Details"));
		}
		if (elementUtils.isElementVisible(FlightDetailsPage.getFlightdetailstext())) {
			elementUtils.doClick(FlightDetailsPage.getClosebutton());
			LoggersUtil.info("User has clicked on the Close button");
		}
		if (selectSportsEquipmentYesorNo.equalsIgnoreCase("Yes")) {
			selectSportsEquipmentFunc(selectSportsEquipmentpiece);
		}
		if (elementUtils.isElementVisible(FlightDetailsPage.getFlightdetailstext())) {
			elementUtils.doClick(FlightDetailsPage.getClosebutton());
			LoggersUtil.info("User has clicked on the Close button");
		}
		if (selectQueueJumpYesorNo.equalsIgnoreCase("Yes")) {
			if (fareSelection.equalsIgnoreCase("Express")) {
				elementUtils.verticalSwipeByPercentagesbyLocator(PassengerDetailsPage.getIncludedtext());
				elementUtils.isElementDisplayed(PassengerDetailsPage.getIncludedtext());
				LoggersUtil.info("User should be able to view the Express Tag ");
				test.log(Status.PASS, MarkupHelper.createLabel("User is able to view the express feature enabled",
						ExtentColor.GREEN));
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
			test.log(Status.PASS, MarkupHelper.createLabel("User has selected Queue Jump", ExtentColor.GREEN));
		} catch (Exception ex) {
			LoggersUtil.fatal("User has not clicked on the queue jump button" + ex.getMessage());
			test.log(Status.FAIL,
					MarkupHelper.createLabel("User is not able to select queue Jump" + ex, ExtentColor.RED));
		}
	}

	private void selectcarbonOffset() {
		try {

			elementUtils.verticalSwipeByPercentagesbyLocator(PassengerDetailsPage.getCarbonoffsetswitchbutton());
			if (elementUtils.isElementVisible(FlightDetailsPage.getFlightdetailstext())) {
				elementUtils.doClick(FlightDetailsPage.getClosebutton());
			}
			elementUtils.doClick(PassengerDetailsPage.getCarbonoffsetswitchbutton());
			LoggersUtil.info("User has selected Carbon Offset");
			test.log(Status.PASS, MarkupHelper.createLabel("User has selected Carbon Offset", ExtentColor.GREEN));
		} catch (Exception ex) {
			LoggersUtil.fatal("User has not clicked on the Carbon offset button" + ex.getMessage());
			test.log(Status.FAIL,
					MarkupHelper.createLabel("User is not able to select Carbon Offset" + ex, ExtentColor.RED));
		}
	}

	private void selectSportsEquipmentFunc(String selectSportsEquipment) {
		try {

			elementUtils.verticalSwipeByPercentagesbyLocator(PassengerDetailsPage.getSportsequipmentbutton());
			elementUtils.doClick(PassengerDetailsPage.getSportsequipmentbutton());
			LoggersUtil.info("User has clicked on the Sports Equipment");
			elementUtils.isElementDisplayed(SportsEquipmentPage.getGetheadertext());
			test.log(Status.PASS,
					MarkupHelper.createLabel("User has clicked on the Sports Equipment", ExtentColor.GREEN));
			elementUtils.scrollAndClickByText(selectSportsEquipment);
			LoggersUtil.info("User has selected the Sport Equipment as :" + selectSportsEquipment);
			test.log(Status.PASS, MarkupHelper.createLabel(
					"User has selected the SportsEquipment as:" + selectSportsEquipment, ExtentColor.GREEN));
			elementUtils.doClick(SportsEquipmentPage.getAddbutton());
			LoggersUtil.info("User has clicked on the Add Button");
			elementUtils.isElementDisplayed(genericTitleText("Passenger Details"));
		} catch (Exception ex) {
			LoggersUtil.error("User has not selected the Select Sports Equipment" + ex.getMessage());
			test.log(Status.FAIL,
					MarkupHelper.createLabel("User has not able to select Sports Equipments" + ex, ExtentColor.RED));
		}
	}

	public void selectionYoungTravelers(String OptionYesOrNo) {
		elementUtils.doClick(YoungTravellersPage.selectYoungTravelers(OptionYesOrNo));
		elementUtils.doClick(YoungTravellersPage.getAgreebutton());
	}

	public void selectionSeatforTravellers(String selectseatyesOrNo, String SeatNo) {
		try {
			elementUtils.waitForElementNotVisible(loaderPlane);
			elementUtils.isElementDisplayed(PassengersListPage.getTitletext());
			elementUtils.doClick(PassengersListPage.getContinuebutton());
			LoggersUtil.info("User has clicked on the Continue Button");
			elementUtils.isElementDisplayed(genericTitleText("Select Seat"));
			if (selectseatyesOrNo.equalsIgnoreCase("Yes")) {
				elementUtils.doClick(SelectSeatPage.getSelectseatbutton());
				elementUtils.waitForElementNotVisible(loaderPlane);
				elementUtils.verticalSwipeByPercentagesbyLocator(SelectSeatPage.selectSeatNo(SeatNo));
				elementUtils.doClick(SelectSeatPage.selectSeatNo(SeatNo));
				elementUtils.waitForElementNotVisible(loaderPlane);
				elementUtils.doClick(SelectSeatPage.getDonebutton());
				elementUtils.doClick(SelectSeatPage.getContinuebutton());
			} else if (selectseatyesOrNo.equalsIgnoreCase("No")) {
				LoggersUtil.info("User has selected No Seat Selection");
				elementUtils.verticalSwipeByPercentagesbyLocator(SelectSeatPage.getContinuewithoutselectionbutton());
				elementUtils.doClick(SelectSeatPage.getContinuewithoutselectionbutton());
				test.log(Status.PASS,
						MarkupHelper.createLabel("User has selected for No Seat Selection", ExtentColor.GREEN));
			}
		} catch (Exception ex) {
			LoggersUtil.fatal("Some Exception occured during execution of select seat functionality" + ex.getMessage());
			test.log(Status.FAIL,
					MarkupHelper.createLabel("There are some exceptionsduring seat selection" + ex, ExtentColor.RED));
		}
	}

	public void fillingContactDetails(String Address, String City, String PostalCode, String Country, String State,
			String PhoneNumber, String emailAdress, String confirmEmail) {
		elementUtils.waitForElementNotVisible(loaderPlane);
		elementUtils.isElementDisplayed(genericTitleText("Contact Details"));
		elementUtils.doSendKeys(ContactDetailsPage.getAddresstextbox(), Address);
		LoggersUtil.info("User has entered the address as:" + Address);
		test.log(Status.PASS, MarkupHelper.createLabel("User has entered Address as:" + Address, ExtentColor.GREEN));
		// elementUtils.isElementDisplayed(contactDetailsPage.cityTextBox);
		elementUtils.enterTextByKeyboard(ContactDetailsPage.getCitytextbox(), City);
		LoggersUtil.info("User has entered the city as:" + City);
		test.log(Status.PASS, MarkupHelper.createLabel("User has entered City as:" + City, ExtentColor.GREEN));
		elementUtils.doSendKeys(ContactDetailsPage.getPostalcodetextbox(), PostalCode);
		LoggersUtil.info("User has entered the PostalCode as:" + PostalCode);
		test.log(Status.PASS,
				MarkupHelper.createLabel("User has entered PostalCode as:" + PostalCode, ExtentColor.GREEN));
		elementUtils.doClick(ContactDetailsPage.getCountrydropdown());
		elementUtils.doSendKeys(SelectCountryPage.getSelectcountrytextbox(), Country);
		LoggersUtil.info("User has entered the Country as:" + Country);
		test.log(Status.PASS, MarkupHelper.createLabel("User has entered Country as:" + Country, ExtentColor.GREEN));
		elementUtils.doClick(SelectCountryPage.getNameofcountry());
		elementUtils.doSendKeys(SelectCountryPage.getSelectcountrytextbox(), State);
		LoggersUtil.info("User has entered the State as:" + State);
		test.log(Status.PASS, MarkupHelper.createLabel("User has entered State as:" + State, ExtentColor.GREEN));
		elementUtils.doClick(SelectCountryPage.getNameofcountry());
		elementUtils.doSendKeys(ContactDetailsPage.getPhonenumbertextbox(), PhoneNumber);
		LoggersUtil.info("User has entered the Phone Number as:" + PhoneNumber);
		test.log(Status.PASS,
				MarkupHelper.createLabel("User has entered Phone Number as:" + PhoneNumber, ExtentColor.GREEN));
		elementUtils.doSendKeys(ContactDetailsPage.getEmailaddresstextbox(), emailAdress);
		LoggersUtil.info("User has entered the Email Address as:" + emailAdress);
		test.log(Status.PASS,
				MarkupHelper.createLabel("User has entered Email Address as:" + emailAdress, ExtentColor.GREEN));
		elementUtils.doSendKeys(ContactDetailsPage.getConfirmemailtextbox(), confirmEmail);
		LoggersUtil.info("User has entered the confirm email address as:" + confirmEmail);
		test.log(Status.PASS, MarkupHelper.createLabel("User has entered confirm email address as:" + confirmEmail,
				ExtentColor.GREEN));
		elementUtils.verticalSwipeByPercentages(0.6, 0.3, 0.5);
		elementUtils.verticalSwipeByPercentages(0.6, 0.3, 0.5);
		elementUtils.scrollAndClickByText("Continue");
		LoggersUtil.info("User has clicked on the Continue Button");
		test.log(Status.PASS, MarkupHelper.createLabel("User has clicked on the Continue Button", ExtentColor.GREEN));
		elementUtils.doClick(TermsAndConditionsPage.getAgreementcheckbox());
		LoggersUtil.info("User has clicked on the Agreement CheckBox");
		test.log(Status.PASS,
				MarkupHelper.createLabel("User has clicked on the Agreement Checkbox ", ExtentColor.GREEN));
		elementUtils.verticalSwipeByPercentages(0.6, 0.3, 0.5);
		elementUtils.scrollAndClickByText("Continue to payment");
		LoggersUtil.info("User has clicked on the Continue to Payment");

		// elementUtils.doClick(TermsAndConditionsPage.getContinuebutton());
	}

	public void paymentsection(String PaymentType, String cardHolderName, String cardNumber, String selectMonth,
			String selectYear, String cvvID) {
		elementUtils.waitForElementNotVisible(loaderPlane);
		elementUtils.isElementDisplayed(genericTitleText("Payment"));
		if (PaymentType.equalsIgnoreCase("Credit / Debit")) {
			elementUtils.doClick(PaymentPage.getCreditcardbutton());
			LoggersUtil.info("User has selected Credit / Debit Card Selection");
			test.log(Status.PASS, MarkupHelper.createLabel("User has selected Credit/Debit Cards", ExtentColor.GREEN));
			elementUtils.isElementDisplayed(genericTitleText(PaymentType));
			elementUtils.doSendKeys(CreditCardPage.getCardholdernametextbox(), cardHolderName);
			LoggersUtil.info("User has entered Card Holder Name as:" + cardHolderName);
			test.log(Status.PASS, MarkupHelper.createLabel("User has entered Card Holder Name as:" + cardHolderName,
					ExtentColor.GREEN));
			elementUtils.enterTextByKeyboard(CreditCardPage.getCreditcardnumbertextbox(), cardNumber);
			LoggersUtil.info("User has entered Credit Card Number as:" + cardNumber);
			test.log(Status.PASS,
					MarkupHelper.createLabel("User has entered Card Number as:" + cardNumber, ExtentColor.GREEN));
			elementUtils.doClick(CreditCardPage.getSelectdatepicker());
			LoggersUtil.info("User has selected Date Picker");
			elementUtils.enterTextByKeyboard(CreditCardPage.getSelectmonth(), selectMonth);
			LoggersUtil.info("User has entered Month as:" + selectMonth);
			elementUtils.enterTextByKeyboard(CreditCardPage.getSelectyear(), selectYear);
			LoggersUtil.info("User has entered Year as:" + selectYear);
			elementUtils.doClick(CreditCardPage.getOkbutton());
			LoggersUtil.info("User has clicked on the OK Button");
			elementUtils.doSendKeys(CreditCardPage.getCvvtextbox(), cvvID);
			LoggersUtil.info("User has entered CVV ID as:" + cvvID);
			elementUtils.doClick(CreditCardPage.getPaybutton());
			LoggersUtil.info("User has clicked on the Pay Button");
			test.log(Status.PASS, MarkupHelper.createLabel("User has clicked on the Pay Button", ExtentColor.GREEN));
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
			LoggersUtil.info("User has clicked on the See My Booking Button");
			elementUtils.waitForElementNotVisible(loaderPlane);
			elementUtils.isElementDisplayed(BookingOverviewPage.getPnrtext());
			elementUtils.doGetText(BookingOverviewPage.getPnrtext());
			LoggersUtil.info(
					"PNR Number has been generated as:" + elementUtils.doGetText(BookingOverviewPage.getPnrtext()));
			test.log(Status.PASS,
					MarkupHelper.createLabel(
							"User has generated PNR as:" + elementUtils.doGetText(BookingOverviewPage.getPnrtext()),
							ExtentColor.GREEN));
			excelUtil.setCellData("PNR", "PNR_Number", elementUtils.doGetText(BookingOverviewPage.getPnrtext()));
			// excelUtil.writeExcel("PNR",elementUtils.doGetText(BookingOverviewPage.getPnrtext());
		} catch (Exception ex) {
			LoggersUtil.info("PNR is not getting generated" + ex.getMessage());
			test.log(Status.FAIL,
					MarkupHelper.createLabel("User got some issues during PNR Genrartion" + ex, ExtentColor.RED));
		}
	}

	public void pnr_GenerationforPoli() {
		try {
			elementUtils.isElementDisplayed(CreditCardPage.getSeemybookingbutton());
			elementUtils.doClick(CreditCardPage.getSeemybookingbutton());
			elementUtils.waitForElementNotVisible(loaderPlane);
			elementUtils.isElementDisplayed(BookingOverviewPage.getPnrtext());
			elementUtils.doGetText(BookingOverviewPage.getPnrtext());
		} catch (Exception ex) {
			LoggersUtil.info("PNR is not getting generated" + ex.getMessage());
		}
	}

	private void adultselection(String noOfAdultsstr, String noOfchildsstr, String noofInfantsstr) {
		int noOfAdults = Integer.parseInt(noOfAdultsstr), noOfchilds = Integer.parseInt(noOfchildsstr),
				noofInfants = Integer.parseInt(noofInfantsstr);
		elementUtils.waitForElementNotVisible(loaderPlane);
		elementUtils.isElementDisplayed(PassengersSelectionPage.getAdultplusbutton());
		for (int i = 0; i < noOfAdults - 1; i++) {
			elementUtils.doClick(PassengersSelectionPage.getAdultplusbutton());
			LoggersUtil.info("User has selected Adults as : " + noOfAdults);
			test.log(Status.PASS,
					MarkupHelper.createLabel("User has selected Adults as :" + noOfAdults, ExtentColor.GREEN));
		}
		for (int i = 0; i < noOfchilds; i++) {
			elementUtils.doClick(PassengersSelectionPage.getChildplusbutton());
			LoggersUtil.info("User has selected Child as : " + noOfchilds);
			test.log(Status.PASS,
					MarkupHelper.createLabel("User has selected Child as :" + noOfchilds, ExtentColor.GREEN));
		}
		for (int i = 0; i < noofInfants; i++) {
			elementUtils.doClick(PassengersSelectionPage.getInfantplusbutton());
			LoggersUtil.info("User has selected Infants as " + noofInfants);
			test.log(Status.PASS,
					MarkupHelper.createLabel("User has selected Infants as :" + noofInfants, ExtentColor.GREEN));
		}
		elementUtils.doClick(PassengersSelectionPage.getContinuebutton());
		LoggersUtil.info("User has clicked on the Continue button");
		test.log(Status.PASS, MarkupHelper.createLabel("USer has clicked on the Continue Button", ExtentColor.GREEN));
		// SoftAssertionsonText(SearchFlightPage.getPromocodetext(), "Got a promo
		// code?");
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
				LoggersUtil.info("User has clicked on the Next Passenger Button");
				test.log(Status.PASS,
						MarkupHelper.createLabel("User has clicked on the Next Passenger Button", ExtentColor.GREEN));
				enterPassengerDetails(selectCabonBaggageYesorNo, selectKGforcabin, selectKGforCheckin,
						selectQueueJumpYesorNo, selectCarbonOffsetYesorNo, selectSportsEquipmentYesorNo,
						selectSportsEquipmentpiece);
			}
			continueStatus = elementUtils.isElementVisible(PassengerDetailsPage.getContinuebutton());
			if (continueStatus == true) {
				elementUtils.doClick(PassengerDetailsPage.getContinuebutton());
				LoggersUtil.info("User has clicked on the Continue Button");
				test.log(Status.PASS,
						MarkupHelper.createLabel("User has clicked on the Continue Button", ExtentColor.GREEN));
				check = false;
			}

		}

	}

}
