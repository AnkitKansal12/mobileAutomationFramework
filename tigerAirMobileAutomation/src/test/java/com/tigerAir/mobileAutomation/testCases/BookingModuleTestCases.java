package com.tigerAir.mobileAutomation.testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
/**
 * @author Ankit.1.Kansal
 */
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;
import com.tigerAir.mobileAutomation.Base.BasePage;
import com.tigerAir.mobileAutomation.pagesObjects.HomePage;
import com.tigerAir.mobileAutomation.pagesObjects.JourneyTypePage;
import com.tigerAir.mobileAutomation.pagesObjects.SearchFlightPage;
import com.tigerAir.mobileAutomation.utils.ExtentReporters;
import com.tigerAir.mobileAutomation.utils.GenericMethods;
import com.tigerAir.mobileAutomation.utils.LoggersUtil;
import com.tigerAir.mobileAutomation.utils.SendEmailUtil;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BookingModuleTestCases extends BasePage {

	Properties prop;
	AndroidDriver<AndroidElement> driver = null;
	BasePage basePage;
	HomePage homePage;
	SearchFlightPage searchPage;
	SoftAssert softAssertion;
	JourneyTypePage journeyTypePage;
	ExtentReporters er;
	GenericMethods genericMethods;
	String screenShotPath;
	SendEmailUtil sendutil;
	String concantenate = ".";

	@BeforeSuite
	public void startReport() {

		er = new ExtentReporters();
	}

	@BeforeMethod
	public void setUP() {
		basePage = new BasePage();
		prop = basePage.ConfigReader();
		if (prop.getProperty("realDevice").equalsIgnoreCase("Yes")) {
			driver = basePage.MobileCapabilitieswithRealDevice();
		} else {
			driver = basePage.MobileCapabilitieswithEmulators();
		}
		homePage = new HomePage(driver);
		softAssertion = new SoftAssert();
		genericMethods = new GenericMethods(driver);
		// er = new ExtentReporters();
		sendutil = new SendEmailUtil();

	}

	// @Test(priority = 1, description = "This Test Case is to validate OneWay
	// Journey with One Adult")
	public void OneAdult_OneWay_Currency_AUD_FareType_Light_FOP_VisaCC() throws Exception {

		test = ExtentReporters.report.startTest("OneAdult_OneWay_Currency_AUD_FareType_Light_FOP_VisaCC");
		test.log(LogStatus.PASS, "Application has been launched successfully");
		LoggersUtil.startTestCase(test.getTest().getName());
		String HomePageText = homePage.getTigerEntainmentText();
		LoggersUtil.info("Getting Text: " + HomePageText);
		try {
			softAssertion.assertEquals(HomePageText, "Tigertainment", "Tigertainment is not there on the HomePage");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(screenShotPath));
		}
		test.log(LogStatus.PASS, "User hass been landed on the HomePage Successfully");
		LoggersUtil.info("User has been landed on the HomePage Successfully");
		try {
			softAssertion.assertTrue(homePage.BookFlightisDisplayed(),
					"Book Flight is not getting displayed on the home Page");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(screenShotPath));
		}
		test.log(LogStatus.PASS, "Book Flight is getting displayed successfully on the Home Page");
		LoggersUtil.info("Book Flight text is getting displayed on the homepage");
		homePage.clickonBookFlightButton();
		test.log(LogStatus.PASS, "User has clicked on the Book Flight button");
		LoggersUtil.info("User has clicked on the Book Flight button");
		genericMethods.SelectFlightFunction("AUD", "AUD", "Return", "One Way", "Sydney", "Melbourne", "28", 1, 0, 0,
				"20", "21");
		genericMethods.selectDepartingflightsFares("LIGHT");
		genericMethods.clickOnPassenger("Adult 1");
		genericMethods.fillPassengerDetails("no", null, null, "no", "no", "no", null);
		// genericMethods.selectionYoungTravelers("Yes");
		genericMethods.selectionSeatforTravellers("No", "Nil");
		genericMethods.fillingContactDetails("14 Villeneuve Street", "DARRAWEIT GUIM", "3756", "Australia",
				"Australian Capital Territory", "+6198718785", "p@a.com", "p@a.com");
		genericMethods.paymentsection("Credit / Debit", "PP Heins", "4444333322221111", "Mar", "2021", "211");
		// genericMethods.pnr_Generation();
		softAssertion.assertAll();
	}

	// @Test(priority = 2, description = "This Test Case is to validate OneWay
	// Journey with One Adult and One Child")
	public void OneAdult_OneChild_OneWay_Currency_AUD_FareType_Light_Cabin_QueueJump_Seat_Upfront_FOP_Visa()
			throws Exception {

		test = ExtentReporters.report.startTest(
				"OneAdult_OneChild_OneWay_Currency_AUD_FareType_Light_Cabin_QueueJump_Seat_Upfront_FOP_Visa");
		test.log(LogStatus.PASS, "Application has been launched successfully");
		LoggersUtil.startTestCase(test.getTest().getName());
		String HomePageText = homePage.getTigerEntainmentText();
		LoggersUtil.info("Getting Text: " + HomePageText);
		try {
			softAssertion.assertEquals(HomePageText, "Tigertainment", "Tigertainment is not there on the HomePage");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(screenShotPath));
		}
		test.log(LogStatus.PASS, "User hass been landed on the HomePage Successfully");
		LoggersUtil.info("User has been landed on the HomePage Successfully");
		try {
			softAssertion.assertTrue(homePage.BookFlightisDisplayed(),
					"Book Flight is not getting displayed on the home Page");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(screenShotPath));
		}
		test.log(LogStatus.PASS, "Book Flight is getting displayed successfully on the Home Page");
		LoggersUtil.info("Book Flight text is getting displayed on the homepage");
		homePage.clickonBookFlightButton();
		test.log(LogStatus.PASS, "User has clicked on the Book Flight button");
		LoggersUtil.info("User has clicked on the Book Flight button");
		genericMethods.SelectFlightFunction("AUD", "AUD", "Return", "One Way", "Sydney", "Melbourne", "28", 1, 1, 0,
				"20", "21");
		genericMethods.selectDepartingflightsFares("LIGHT");
		genericMethods.clickOnPassenger("Adult 1");
		genericMethods.fillPassengerDetails("yes", "7 kg", "00 kg", "yes", "Yes", "No", null);
		// genericMethods.selectionYoungTravelers("Yes");
		genericMethods.selectionSeatforTravellers("No", "Nil");
		genericMethods.fillingContactDetails("14 Villeneuve Street", "DARRAWEIT GUIM", "3756", "Australia",
				"Australian Capital Territory", "+6198718785", "p@a.com", "p@a.com");
		genericMethods.paymentsection("Credit / Debit", "PP Heins", "4005550000000001", "Mar", "2021", "211");
		// genericMethods.pnr_Generation();
		softAssertion.assertAll();
	}

	// @Test(priority = 3, description = "This Test Case is to validate OneWay
	// Journey with One Adult and One Child")
	public void FourAdult_OneWay_Currency_AUD_FareType_Express_Baggage_25kg__QueueJump_1SportsEquipment_Carbon_FOPMASTER_DC() {

		test = ExtentReporters.report.startTest(
				"FourAdult_OneWay_Currency_AUD_FareType_Express_Baggage_25kg__QueueJump_1SportsEquipment_Carbon_FOPMASTER_DC");
		test.log(LogStatus.PASS, "Application has been launched successfully");
		LoggersUtil.startTestCase(test.getTest().getName());
		String HomePageText = homePage.getTigerEntainmentText();
		LoggersUtil.info("Getting Text: " + HomePageText);
		try {
			softAssertion.assertEquals(HomePageText, "Tigertainment", "Tigertainment is not there on the HomePage");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(screenShotPath));
		}
		test.log(LogStatus.PASS, "User hass been landed on the HomePage Successfully");
		LoggersUtil.info("User has been landed on the HomePage Successfully");
		try {
			softAssertion.assertTrue(homePage.BookFlightisDisplayed(),
					"Book Flight is not getting displayed on the home Page");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(screenShotPath));
		}
		test.log(LogStatus.PASS, "Book Flight is getting displayed successfully on the Home Page");
		LoggersUtil.info("Book Flight text is getting displayed on the homepage");
		homePage.clickonBookFlightButton();
		test.log(LogStatus.PASS, "User has clicked on the Book Flight button");
		LoggersUtil.info("User has clicked on the Book Flight button");
		genericMethods.SelectFlightFunction("AUD", "AUD", "Return", "One Way", "Sydney", "Melbourne", "29", 4, 1, 0,
				"20", "21");
		genericMethods.selectDepartingflightsFares("EXPRESS");
		genericMethods.clickOnPassenger("Adult 1");
		genericMethods.fillPassengerDetails("yes", "7 kg", "25 kg", "yes", "Yes", "Yes", "1 Piece");
		// genericMethods.selectionYoungTravelers("Yes");
		genericMethods.selectionSeatforTravellers("No", "Nil");
		genericMethods.fillingContactDetails("14 Villeneuve Street", "DARRAWEIT GUIM", "3756", "Australia",
				"Australian Capital Territory", "+6198718785", "p@a.com", "p@a.com");
		genericMethods.paymentsection("Credit / Debit", "PP Heins", "5217291812876194", "Mar", "2021", "211");
		// genericMethods.pnr_Generation();
		softAssertion.assertAll();
	}

	// @Test(priority = 4, description = "This Test Case is to validate OneWay
	// Journey with One Adult and One Child")
	public void TwoAdult_OneWay_Currency_AUD_FareType_Light_Baggage_20kg__QueueJump_2SportsEquipment_Carbon_FOPPOLI() {

		test = ExtentReporters.report.startTest(
				"TwoAdult_OneWay_Currency_AUD_FareType_Light_Baggage_20kg__QueueJump_2SportsEquipment_Carbon_FOPPOLI");
		test.log(LogStatus.PASS, "Application has been launched successfully");
		LoggersUtil.startTestCase(test.getTest().getName());
		String HomePageText = homePage.getTigerEntainmentText();
		LoggersUtil.info("Getting Text: " + HomePageText);
		try {
			softAssertion.assertEquals(HomePageText, "Tigertainment", "Tigertainment is not there on the HomePage");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(screenShotPath));
		}
		test.log(LogStatus.PASS, "User hass been landed on the HomePage Successfully");
		LoggersUtil.info("User has been landed on the HomePage Successfully");
		try {
			softAssertion.assertTrue(homePage.BookFlightisDisplayed(),
					"Book Flight is not getting displayed on the home Page");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(screenShotPath));
		}
		test.log(LogStatus.PASS, "Book Flight is getting displayed successfully on the Home Page");
		LoggersUtil.info("Book Flight text is getting displayed on the homepage");
		homePage.clickonBookFlightButton();
		test.log(LogStatus.PASS, "User has clicked on the Book Flight button");
		LoggersUtil.info("User has clicked on the Book Flight button");
		genericMethods.SelectFlightFunction("AUD", "AUD", "Return", "One Way", "Sydney", "Melbourne", "20", 2, 0, 0,
				"20", "21");
		genericMethods.selectDepartingflightsFares("LIGHT");
		genericMethods.clickOnPassenger("Adult 1");
		genericMethods.fillPassengerDetails("yes", "7 kg", "20 kg", "yes", "Yes", "Yes", "2 Pieces");
		// genericMethods.selectionYoungTravelers("Yes");
		genericMethods.selectionSeatforTravellers("No", "Nil");
		genericMethods.fillingContactDetails("14 Villeneuve Street", "DARRAWEIT GUIM", "3756", "Australia",
				"Australian Capital Territory", "+6198718785", "p@a.com", "p@a.com");
		genericMethods.paymentsection("Poli", "PP Heins", "5217291812876194", "Mar", "2021", "211");
		// genericMethods.pnr_Generation();
		softAssertion.assertAll();
	}

	// @Test(priority = 5, description = "This Test Case is to validate OneWay
	// Journey with One Adult and One Child")
	public void OneAdult_8Child_OneWay_Currency_NZD_FareType_Light_Cabin_Baggage_30kg_QueueJump_OneSportsEquipment_FOP_MASTER_DC() {

		test = ExtentReporters.report.startTest(
				"OneAdult_8Child_OneWay_Currency_NZD_FareType_Light_Cabin_Baggage_30kg_QueueJump_OneSportsEquipment_FOP_MASTER_DC");
		test.log(LogStatus.PASS, "Application has been launched successfully");
		LoggersUtil.startTestCase(test.getTest().getName());
		String HomePageText = homePage.getTigerEntainmentText();
		LoggersUtil.info("Getting Text: " + HomePageText);
		try {
			softAssertion.assertEquals(HomePageText, "Tigertainment", "Tigertainment is not there on the HomePage");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(screenShotPath));
		}
		test.log(LogStatus.PASS, "User hass been landed on the HomePage Successfully");
		LoggersUtil.info("User has been landed on the HomePage Successfully");
		try {
			softAssertion.assertTrue(homePage.BookFlightisDisplayed(),
					"Book Flight is not getting displayed on the home Page");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(screenShotPath));
		}
		test.log(LogStatus.PASS, "Book Flight is getting displayed successfully on the Home Page");
		LoggersUtil.info("Book Flight text is getting displayed on the homepage");
		homePage.clickonBookFlightButton();
		test.log(LogStatus.PASS, "User has clicked on the Book Flight button");
		LoggersUtil.info("User has clicked on the Book Flight button");
		genericMethods.SelectFlightFunction("AUD", "NZD", "Return", "One Way", "Sydney", "Melbourne", "20", 1, 8, 0,
				"20", "21");
		genericMethods.selectDepartingflightsFares("LIGHT");
		genericMethods.clickOnPassenger("Adult 1");
		genericMethods.fillPassengerDetails("yes", "7 kg", "30 kg", "yes", "No", "Yes", "1 Piece");
		// genericMethods.selectionYoungTravelers("Yes");
		genericMethods.selectionSeatforTravellers("No", "Nil");
		genericMethods.fillingContactDetails("14 Villeneuve Street", "DARRAWEIT GUIM", "3756", "Australia",
				"Australian Capital Territory", "+6198718785", "p@a.com", "p@a.com");
		genericMethods.paymentsection("Credit / Debit", "PP Heins", "5217291812876194", "Mar", "2021", "211");
		// genericMethods.pnr_Generation();
		softAssertion.assertAll();
	}

	// @Test(priority = 6, description = "This Test Case is to validate OneWay
	// Journey with One Adult and One Child")
	public void OneAdult_OneWay_Currency_NZD_FareType_Express_Cabin_Baggage_35kg_QueueJump_3SportsEquipment_FOP_MASTER_CC() {

		test = ExtentReporters.report.startTest(
				"OneAdult_8Child_OneWay_Currency_NZD_FareType_Light_Cabin_Baggage_30kg_QueueJump_OneSportsEquipment_FOP_MASTER_DC");
		test.log(LogStatus.PASS, "Application has been launched successfully");
		LoggersUtil.startTestCase(test.getTest().getName());
		String HomePageText = homePage.getTigerEntainmentText();
		LoggersUtil.info("Getting Text: " + HomePageText);
		try {
			softAssertion.assertEquals(HomePageText, "Tigertainment", "Tigertainment is not there on the HomePage");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(screenShotPath));
		}
		test.log(LogStatus.PASS, "User hass been landed on the HomePage Successfully");
		LoggersUtil.info("User has been landed on the HomePage Successfully");
		try {
			softAssertion.assertTrue(homePage.BookFlightisDisplayed(),
					"Book Flight is not getting displayed on the home Page");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(screenShotPath));
		}
		test.log(LogStatus.PASS, "Book Flight is getting displayed successfully on the Home Page");
		LoggersUtil.info("Book Flight text is getting displayed on the homepage");
		homePage.clickonBookFlightButton();
		test.log(LogStatus.PASS, "User has clicked on the Book Flight button");
		LoggersUtil.info("User has clicked on the Book Flight button");
		genericMethods.SelectFlightFunction("AUD", "NZD", "Return", "One Way", "Sydney", "Melbourne", "20", 1, 0, 0,
				"20", "21");
		genericMethods.selectDepartingflightsFares("EXPRESS");
		genericMethods.clickOnPassenger("Adult 1");
		genericMethods.fillPassengerDetails("yes", "7 kg", "35 kg", "yes", "No", "Yes", "3 Pieces");
		// genericMethods.selectionYoungTravelers("Yes");
		genericMethods.selectionSeatforTravellers("No", "Nil");
		genericMethods.fillingContactDetails("14 Villeneuve Street", "DARRAWEIT GUIM", "3756", "Australia",
				"Australian Capital Territory", "+6198718785", "p@a.com", "p@a.com");
		genericMethods.paymentsection("Credit / Debit", "PP Heins", "5210000010001001", "Mar", "2021", "211");
		// genericMethods.pnr_Generation();
		softAssertion.assertAll();
	}

	//@Test(priority = 7, description = "This Test Case is to validate OneWay Journey with One Adult and One Child")
	public void OneAdult_OneChild_OneWay_Currency_NZD_FareType_Light_Cabin_Carbon_FOP_MASTER_CC() {

		test = ExtentReporters.report.startTest(
				"OneAdult_8Child_OneWay_Currency_NZD_FareType_Light_Cabin_Baggage_30kg_QueueJump_OneSportsEquipment_FOP_MASTER_DC");
		test.log(LogStatus.PASS, "Application has been launched successfully");
		LoggersUtil.startTestCase(test.getTest().getName());
		String HomePageText = homePage.getTigerEntainmentText();
		LoggersUtil.info("Getting Text: " + HomePageText);
		try {
			softAssertion.assertEquals(HomePageText, "Tigertainment", "Tigertainment is not there on the HomePage");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(screenShotPath));
		}
		test.log(LogStatus.PASS, "User hass been landed on the HomePage Successfully");
		LoggersUtil.info("User has been landed on the HomePage Successfully");
		try {
			softAssertion.assertTrue(homePage.BookFlightisDisplayed(),
					"Book Flight is not getting displayed on the home Page");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(screenShotPath));
		}
		test.log(LogStatus.PASS, "Book Flight is getting displayed successfully on the Home Page");
		LoggersUtil.info("Book Flight text is getting displayed on the homepage");
		homePage.clickonBookFlightButton();
		test.log(LogStatus.PASS, "User has clicked on the Book Flight button");
		LoggersUtil.info("User has clicked on the Book Flight button");
		genericMethods.SelectFlightFunction("AUD", "NZD", "Return", "One Way", "Sydney", "Melbourne", "20", 1, 1, 0,
				"20", "21");
		genericMethods.selectDepartingflightsFares("LIGHT");
		genericMethods.clickOnPassenger("Adult 1");
		genericMethods.fillPassengerDetails("yes", "7 kg", "00 kg", "no", "yes", "no", "3 Pieces");
		// genericMethods.selectionYoungTravelers("Yes");
		genericMethods.selectionSeatforTravellers("No", "Nil");
		genericMethods.fillingContactDetails("14 Villeneuve Street", "DARRAWEIT GUIM", "3756", "Australia",
				"Australian Capital Territory", "+6198718785", "p@a.com", "p@a.com");
		genericMethods.paymentsection("Credit / Debit", "PP Heins", "4005550000000001", "Mar", "2021", "211");
		// genericMethods.pnr_Generation();
		softAssertion.assertAll();
	}

	//@Test(priority = 8, description = "This Test Case is to validate OneWay Journey with One Adult and One Child")
	public void OneAdult_Return_Currency_AUD_FareType_Light_FOP_VISA_CC() {

		test = ExtentReporters.report.startTest(
				"OneAdult_8Child_OneWay_Currency_NZD_FareType_Light_Cabin_Baggage_30kg_QueueJump_OneSportsEquipment_FOP_MASTER_DC");
		test.log(LogStatus.PASS, "Application has been launched successfully");
		LoggersUtil.startTestCase(test.getTest().getName());
		String HomePageText = homePage.getTigerEntainmentText();
		LoggersUtil.info("Getting Text: " + HomePageText);
		try {
			softAssertion.assertEquals(HomePageText, "Tigertainment", "Tigertainment is not there on the HomePage");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(screenShotPath));
		}
		test.log(LogStatus.PASS, "User hass been landed on the HomePage Successfully");
		LoggersUtil.info("User has been landed on the HomePage Successfully");
		try {
			softAssertion.assertTrue(homePage.BookFlightisDisplayed(),
					"Book Flight is not getting displayed on the home Page");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(screenShotPath));
		}
		test.log(LogStatus.PASS, "Book Flight is getting displayed successfully on the Home Page");
		LoggersUtil.info("Book Flight text is getting displayed on the homepage");
		homePage.clickonBookFlightButton();
		test.log(LogStatus.PASS, "User has clicked on the Book Flight button");
		LoggersUtil.info("User has clicked on the Book Flight button");
		genericMethods.SelectFlightFunction("AUD", "AUD", "Return", "Return", "Sydney", "Melbourne", "20", 1, 1, 0,
				"20", "21");
		genericMethods.selectDepartingflightsFares("LIGHT");
		genericMethods.clickOnPassenger("Adult 1");
		genericMethods.fillPassengerDetails("yes", "7 kg", "00 kg", "no", "no", "no", "3 Pieces");
		// genericMethods.selectionYoungTravelers("Yes");
		genericMethods.selectionSeatforTravellers("No", "Nil");
		genericMethods.fillingContactDetails("14 Villeneuve Street", "DARRAWEIT GUIM", "3756", "Australia",
				"Australian Capital Territory", "+6198718785", "p@a.com", "p@a.com");
		genericMethods.paymentsection("Credit / Debit", "PP Heins", "4444333322221111", "Mar", "2021", "211");
		// genericMethods.pnr_Generation();
		softAssertion.assertAll();
	}
	
	@Test(priority = 9, description = "This Test Case is to validate OneWay Journey with One Adult and One Child")
	public void OneAdult_OneChild_Return_Currency_AUD_FareType_Light_Cabin_QueueJump_FOP_VISA_DB() {

		test = ExtentReporters.report.startTest(
				"OneAdult_8Child_OneWay_Currency_NZD_FareType_Light_Cabin_Baggage_30kg_QueueJump_OneSportsEquipment_FOP_MASTER_DC");
		test.log(LogStatus.PASS, "Application has been launched successfully");
		LoggersUtil.startTestCase(test.getTest().getName());
		String HomePageText = homePage.getTigerEntainmentText();
		LoggersUtil.info("Getting Text: " + HomePageText);
		try {
			softAssertion.assertEquals(HomePageText, "Tigertainment", "Tigertainment is not there on the HomePage");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(screenShotPath));
		}
		test.log(LogStatus.PASS, "User hass been landed on the HomePage Successfully");
		LoggersUtil.info("User has been landed on the HomePage Successfully");
		try {
			softAssertion.assertTrue(homePage.BookFlightisDisplayed(),
					"Book Flight is not getting displayed on the home Page");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(screenShotPath));
		}
		test.log(LogStatus.PASS, "Book Flight is getting displayed successfully on the Home Page");
		LoggersUtil.info("Book Flight text is getting displayed on the homepage");
		homePage.clickonBookFlightButton();
		test.log(LogStatus.PASS, "User has clicked on the Book Flight button");
		LoggersUtil.info("User has clicked on the Book Flight button");
		genericMethods.SelectFlightFunction("AUD", "AUD", "Return", "Return", "Sydney", "Melbourne", "20", 1, 1, 0,
				"20", "21");
		genericMethods.selectDepartingflightsFares("LIGHT");
		genericMethods.clickOnPassenger("Adult 1");
		genericMethods.fillPassengerDetails("yes", "7 kg", "00 kg", "Yes", "no", "no", "3 Pieces");
		// genericMethods.selectionYoungTravelers("Yes");
		genericMethods.selectionSeatforTravellers("No", "Nil");
		genericMethods.fillingContactDetails("14 Villeneuve Street", "DARRAWEIT GUIM", "3756", "Australia",
				"Australian Capital Territory", "+6198718785", "p@a.com", "p@a.com");
		genericMethods.paymentsection("Credit / Debit", "PP Heins", "4005550000000001", "Mar", "2021", "211");
		// genericMethods.pnr_Generation();
		softAssertion.assertAll();
	}
	
	@Test(priority = 10, description = "This Test Case is to validate OneWay Journey with One Adult and One Child")
	public void FourAdult_Return_Currency_AUD_FareType_Express_Bagage25_Cabin_QueueJump_FOP_VISA_DB() {

		test = ExtentReporters.report.startTest(
				"OneAdult_8Child_OneWay_Currency_NZD_FareType_Light_Cabin_Baggage_30kg_QueueJump_OneSportsEquipment_FOP_MASTER_DC");
		test.log(LogStatus.PASS, "Application has been launched successfully");
		LoggersUtil.startTestCase(test.getTest().getName());
		String HomePageText = homePage.getTigerEntainmentText();
		LoggersUtil.info("Getting Text: " + HomePageText);
		try {
			softAssertion.assertEquals(HomePageText, "Tigertainment", "Tigertainment is not there on the HomePage");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(screenShotPath));
		}
		test.log(LogStatus.PASS, "User hass been landed on the HomePage Successfully");
		LoggersUtil.info("User has been landed on the HomePage Successfully");
		try {
			softAssertion.assertTrue(homePage.BookFlightisDisplayed(),
					"Book Flight is not getting displayed on the home Page");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(screenShotPath));
		}
		test.log(LogStatus.PASS, "Book Flight is getting displayed successfully on the Home Page");
		LoggersUtil.info("Book Flight text is getting displayed on the homepage");
		homePage.clickonBookFlightButton();
		test.log(LogStatus.PASS, "User has clicked on the Book Flight button");
		LoggersUtil.info("User has clicked on the Book Flight button");
		genericMethods.SelectFlightFunction("AUD", "AUD", "Return", "Return", "Sydney", "Melbourne", "20", 1, 1, 0,
				"20", "21");
		genericMethods.selectDepartingflightsFares("LIGHT");
		genericMethods.clickOnPassenger("Adult 1");
		genericMethods.fillPassengerDetails("yes", "7 kg", "00 kg", "Yes", "Yes", "Yes", "1 Piece");
		// genericMethods.selectionYoungTravelers("Yes");
		genericMethods.selectionSeatforTravellers("No", "Nil");
		genericMethods.fillingContactDetails("14 Villeneuve Street", "DARRAWEIT GUIM", "3756", "Australia",
				"Australian Capital Territory", "+6198718785", "p@a.com", "p@a.com");
		genericMethods.paymentsection("Credit / Debit", "PP Heins", "4005550000000001", "Mar", "2021", "211");
		// genericMethods.pnr_Generation();
		softAssertion.assertAll();
	}

	@AfterTest
	public void stopService() {
		// ExtentReporters.report.flush();
		System.out.println("report flush");
		stopServer();
		if (prop.getProperty("sendMail").contains("Yes")) {
			sendutil.sendEmail();
		} else {
			LoggersUtil.info("User doesn't want to send email reports");
		}

		System.out.println("Sending Email");
	}

	@AfterSuite
	public void tearDown() {
		ExtentReporters.report.flush();
	}

	@AfterMethod
	public void reportTearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {

			// to add test name in report
			test.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getName());
			/* test.log(LogStatus.FAIL, details,Mediaentitybuilder.); */

			// to add error or exception in report
			test.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getThrowable());

			screenShotPath = concantenate + getScreenshot(driver, result.getName());
			System.out.println("screenShotPath: " + screenShotPath);
			test.addScreenCapture(screenShotPath); // adding screenshot path
			test.log(LogStatus.FAIL, test.addScreenCapture(screenShotPath));
			System.out.println("screenshot add");
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, "TEST CASE SKIPPED IS " + result.getStatus());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(LogStatus.PASS, "TEST CASE PASSED IS " + result.getStatus());
		}

	}

	public static String getScreenshot(AndroidDriver<AndroidElement> driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new java.util.Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		String destination = ".//Reports//screenshots" + "/screenShot_" + screenshotName + "_" + dateName + ".png";
		File destFile = new File(destination);
		FileUtils.copyFile(source, destFile);
		return destination;

	}

}
