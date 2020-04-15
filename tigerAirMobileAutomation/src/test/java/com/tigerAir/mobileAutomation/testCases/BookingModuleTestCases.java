package com.tigerAir.mobileAutomation.testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.tigerAir.mobileAutomation.Base.BasePage;
import com.tigerAir.mobileAutomation.utils.ExcelUtil;
import com.tigerAir.mobileAutomation.utils.ExtentReporters;
import com.tigerAir.mobileAutomation.utils.GenericMethods;
import com.tigerAir.mobileAutomation.utils.LoggersUtil;
import com.tigerAir.mobileAutomation.utils.SendEmailUtil;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BookingModuleTestCases extends GenericMethods {

	BasePage basePage;
	ExtentReporters er;
	GenericMethods genericMethods;
	// String screenShotPath;
	SendEmailUtil sendutil;
	String concantenate = ".";
	ExcelUtil ex;

	@BeforeSuite
	public void startReport() {

		er = new ExtentReporters();
		genericMethods = new GenericMethods();
		sendutil = new SendEmailUtil();
		ex = new ExcelUtil();
		softAssert = new SoftAssert();

	}

	@BeforeTest
	public void setUP() {
		basePage = new BasePage();
		prop = basePage.ConfigReader();
		if (prop.getProperty("realDevice").equalsIgnoreCase("Yes")) {
			driver = basePage.MobileCapabilitieswithRealDevice();
		} else {
			basePage.MobileCapabilitieswithEmulators();
		}
	}

	@BeforeMethod
	public void appSetup() {
		applauncher();
	}

	@DataProvider(name = "getData")
	public Object[][] testDataForm() {
		Object[][] data = null;
		try {
			data = ex.ReadVariant();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	@Test(description = "This Test Case is to validate OneWay Journey with One Adult", dataProvider = "getData")
	public void OneAdult_OneWay_Currency_AUD_FareType_Light_FOP_VisaCC(String TestCaseName, String CurrencyText,
			String ActualCurrencySelection, String ReturnType, String JourneyTypeSelection, String SelectFromWhere,
			String SelecttoWhere, String SelectionDate, String noOfAdults, String noOfchilds, String noofInfants,
			String departureDate, String ArrivalDate, String expressFare, String passengerListName,
			String selectCabonBaggageYesorNo, String selectKGforcabin, String selectKGforCheckin,
			String selectQueueJumpYesorNo, String selectCarbonOffsetYesorNo, String selectSportsEquipmentYesorNo,
			String selectSportsEquipmentpiece, String selectseatyesOrNo, String SeatNo, String Address, String City,
			String PostalCode, String Country, String State, String PhoneNumber, String emailAdress,
			String confirmEmail, String PaymentType, String cardHolderName, String cardNumber, String selectMonth,
			String selectYear, String cvvID) throws Exception {

		test = ExtentReporters.report.createTest(TestCaseName);
		LoggersUtil.startTestCase(test.getModel().getName());
		genericMethods.SelectFlightFunction(CurrencyText, ActualCurrencySelection, ReturnType, JourneyTypeSelection,
				SelectFromWhere, SelecttoWhere, SelectionDate, noOfAdults, noOfchilds, noofInfants, departureDate,
				ArrivalDate);
		genericMethods.selectDepartingflightsFares(expressFare);
		genericMethods.clickOnPassenger(passengerListName);
		genericMethods.fillPassengerDetails(selectCabonBaggageYesorNo, selectKGforcabin, selectKGforCheckin,
				selectQueueJumpYesorNo, selectCarbonOffsetYesorNo, selectSportsEquipmentYesorNo,
				selectSportsEquipmentpiece);
		genericMethods.selectionSeatforTravellers(selectseatyesOrNo, SeatNo);
		genericMethods.fillingContactDetails(Address, City, PostalCode, Country, State, PhoneNumber, emailAdress,
				confirmEmail);
		genericMethods.paymentsection(PaymentType, cardHolderName, cardNumber, selectMonth, selectYear, cvvID);
		softAssert.assertAll();
	}

	@AfterTest
	public void stopService() {
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
		LoggersUtil.info("Flushing Reports");
	}

	@AfterMethod
	public void reportTearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {

			// to add test name in report
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			/* test.log(Status.FAIL, details,Mediaentitybuilder.); */

			// to add error or exception in report
			test.log(Status.FAIL,
					MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			screenShotPath = concantenate + getScreenshot(result.getName());
			// test.log(Status.FAIL,result.getName(),MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			// System.out.println("screenShotPath: " + screenShotPath);
			test.addScreenCaptureFromPath(screenShotPath); // adding screenshot path
			// test.log(Status.FAIL, (Markup)
			// test.addScreenCaptureFromPath(screenShotPath));
			System.out.println("screenshot add");
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
		}
		driver.quit();

	}

}
