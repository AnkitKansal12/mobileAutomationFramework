package com.tigerAir.mobileAutomation.Base;
/**
 * This is a Base Class used to Initialize driver and Properties File
 * @author Ankit.1.Kansal
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.tigerAir.mobileAutomation.utils.Constants;
import com.tigerAir.mobileAutomation.utils.ExtentReporters;
import com.tigerAir.mobileAutomation.utils.LoggersUtil;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class BasePage extends ExtentReporters {

	public static AndroidDriver<AndroidElement> driver = null;
	public Properties prop = null;
	private AppiumServiceBuilder builder;
	private DesiredCapabilities cap = new DesiredCapabilities();
	public AppiumDriverLocalService service;

	private void startServer(int port) {
		try {
			if (checkIfServerisRunning(port)) {
				LoggersUtil.info("Started on the port::" + port);
			} else {
				builder = new AppiumServiceBuilder();
				builder.withIPAddress("127.0.0.1");
				builder.usingPort(port);
				builder.withCapabilities(cap);
				builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
				builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");
				service = AppiumDriverLocalService.buildService(builder);
				service.start();
				LoggersUtil.info("Re-started on the port::" + port);
			}
		} catch (Exception ex) {
			LoggersUtil.info("Some Exception occured::" + ex.getMessage());
		}

	}

	private boolean checkIfServerisRunning(int port) {
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch (IOException e) {
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}

	private void startEmulator() {
		try {
			Runtime.getRuntime().exec(System.getProperty("user.dir")
					+ "/src/main/java/com/tigerAir/mobileAutomation/emulator/startEmulator.bat");
			LoggersUtil.info("Emulator has started");
			Runtime.getRuntime().exec("adb uninstall io.appium.settings");
			LoggersUtil.info("Appium Settings has been uninstalled succesfully");
		} catch (IOException e) {
			LoggersUtil.info("Some Exception occured::" + e.getMessage());
			LoggersUtil.error("Emulator not started");
		}
	}

	private void endEmulator() {
		try {
			Runtime.getRuntime().exec(System.getProperty("user.dir")
					+ "/src/main/java/com/tigerAir/mobileAutomation/emulator/stopEmulator.bat");
			LoggersUtil.info("Emulator has been ended");
		} catch (IOException e) {
			e.printStackTrace();
			LoggersUtil.info("Some Exception occured::" + e.getMessage());
			LoggersUtil.error("Emulator not ended");
		}
	}

	/**
	 * 
	 * @param ApkFile
	 * @return This returns AndroidDriver
	 */
	public void MobileCapabilitieswithEmulators() {
		try {
			startServer(4723);
			DOMConfigurator.configure(System.getProperty("user.dir") + "/src/test/resources/Log4j.xml");
			//PropertyConfigurator.configure(System.getProperty("user.dir") + "/src/test/resources/Log4j.properties");
			
			cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.EVENT_TIMINGS, true);
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("SamsungAndroidEmulatorName"));
			startEmulator();
			cap.setCapability(AndroidMobileCapabilityType.AVD_READY_TIMEOUT, "1200000");
			cap.setCapability(MobileCapabilityType.FULL_RESET, true);
			cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 50000);
			cap.setCapability(MobileCapabilityType.CLEAR_SYSTEM_FILES, true);
			cap.setCapability("sendKeyStrategy", "setValue");
			cap.setCapability("appPackage", "au.com.tigerair.booking");
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			LoggersUtil.info("Mobile Capabilities has been set successfully");
		} catch (Exception e) {
			LoggersUtil.error("Some Exception has occured::" + e.getMessage());
		}
	}

	public void applauncher() {
		File appDir = new File("src/test/resources/app");
		File app = new File(appDir, prop.getProperty("ApkFile"));
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		cap.setCapability("autoGrantPermissions", true);
		try {
			driver = new AndroidDriver<AndroidElement>(new URL(Constants.CONNECTION_URL), cap);
			LoggersUtil.info("Appium Server has been started");
			LoggersUtil.info("Application has been launched Successfully");

		} catch (MalformedURLException e) {
			LoggersUtil.error("Some Exception has occured::" + e.getMessage());
		}

	}

	public AndroidDriver<AndroidElement> MobileCapabilitieswithRealDevice() {
		try {
			startServer(4724);
			DOMConfigurator.configure(System.getProperty("user.dir") + "/src/test/resources/Log4j.xml");
			File appDir = new File("src/test/resources/app");
			File app = new File(appDir, prop.getProperty("ApkFile"));
			cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.EVENT_TIMINGS, true);
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("deviceName"));
			cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 50000);
			cap.setCapability(AndroidMobileCapabilityType.AVD_READY_TIMEOUT, "1200000");
			cap.setCapability(MobileCapabilityType.FULL_RESET, true);
			cap.setCapability(MobileCapabilityType.CLEAR_SYSTEM_FILES, true);
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, prop.getProperty("androidVersion"));

			// cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
			cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
			cap.setCapability("autoGrantPermissions", true);
			driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4724/wd/hub"), cap);
			LoggersUtil.info("Appium Server has been started");
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return driver;
	}

	/**
	 * 
	 * @return This returns Properties File Object
	 */

	public Properties ConfigReader() {

		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(Constants.CONFIG_PROPERTIES_DIRECTORY);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	public void stopServer() {
		if (service != null) {
			service.stop();
		}
		LoggersUtil.info("Appium Server has been ended");
		endEmulator();
	}

}
