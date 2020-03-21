package com.tigerAir.mobileAutomation.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

public class LoggersUtil {

	private static Logger Log = Logger.getLogger(LoggersUtil.class.getSimpleName());
	
	/**
	 * This Method starts the Test Case
	 * @param sTestCaseName
	 */
	
	static{
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    System.setProperty("current.date", dateFormat.format(new Date()));
	}

	public static void startTestCase(String sTestCaseName) {

		Log.info("****************************************************************************************");

		Log.info("****************************************************************************************");

		Log.info("$$$$$$$$$$$$$$$$$$$$$                 " + sTestCaseName + "       $$$$$$$$$$$$$$$$$$$$$$$$$");

		Log.info("****************************************************************************************");

		Log.info("****************************************************************************************");

	}

	/**
	 * This Method ends the test case
	 * @param sTestCaseName
	 */

	public static void endTestCase(String sTestCaseName) {

		Log.info("XXXXXXXXXXXXXXXXXXXXXXX             " + "-E---N---D-" + "             XXXXXXXXXXXXXXXXXXXXXX");

		Log.info("X");

		Log.info("X");

		Log.info("X");

		Log.info("X");

	}

	/**
	 * This Method gets the info
	 * @param message
	 */

	public static void info(String message) {

		Log.info(message);

	}
	
	/**
	 * This Method gets warning 
	 * @param message
	 */

	public static void warn(String message) {

		Log.warn(message);

	}
	
	/**
	 * This Method gets the Error 
	 * @param message
	 */

	public static void error(String message) {

		Log.error(message);

	}
	
	/**
	 * This Method gets the Fatal
	 * @param message
	 */

	public static void fatal(String message) {

		Log.fatal(message);

	}
	
	/**
	 * This Method gets the debug
	 * @param message
	 */

	public static void debug(String message) {

		Log.debug(message);

	}

}
