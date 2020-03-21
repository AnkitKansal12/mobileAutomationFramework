package com.tigerAir.mobileAutomation.utils;


import java.text.SimpleDateFormat;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


/*import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;*/

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ExtentReporters {

	ExtentReports extent;
	static AndroidDriver<AndroidElement> driver = null;
	public static ExtentReports report;
	public static ExtentTest test;

	public ExtentReporters() {
		String dateName = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new java.util.Date());
		report = new ExtentReports(
				System.getProperty("user.dir") + "//Reports" + "/Reports_" + dateName + "ExtentReportResults.html");
	}
}
