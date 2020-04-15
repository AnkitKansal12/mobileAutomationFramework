package com.tigerAir.mobileAutomation.utils;

import java.text.SimpleDateFormat;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporters {

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports report;
	public static ExtentTest test;

	public ExtentReporters() {
		String dateName = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss_a").format(new java.util.Date());
		htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/src/test/resources/Reports/" + dateName + "AutomationReports.html");
		report = new ExtentReports();
		report.attachReporter(htmlReporter);
		report.setSystemInfo("Environment", "UAT");
		report.setSystemInfo("User Name", "Ankit Kansal");
		htmlReporter.config().setDocumentTitle("AutomationReports");
		// Name of the report
		htmlReporter.config().setReportName("MobileTestAutomationReports ");
		// Dark Theme
		htmlReporter.config().setTheme(Theme.STANDARD);

	}

}
