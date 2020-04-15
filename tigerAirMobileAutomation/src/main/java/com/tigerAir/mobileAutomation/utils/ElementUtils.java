package com.tigerAir.mobileAutomation.utils;
/**
 * This class is used for Element Extensions
 * @author Ankit.1.Kansal
 */

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.tigerAir.mobileAutomation.Base.BasePage;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class ElementUtils extends BasePage {

	AndroidElement element = null;
	public String screenShotPath;
	public SoftAssert softAssert;

	/**
	 * 
	 * @param locator
	 * @return This returns AndroidElement
	 */
	public AndroidElement getElement(By locator) {
		waitForElementPresent(locator);
		try {
			element = driver.findElement(locator);
		} catch (Exception e) {
			LoggersUtil.error("Some exception occurred while creating webelement " + locator + e);
		}
		return element;
	}

	public AndroidElement getElementbyLocator(By locator) {
		waitForElementVisibility(locator);
		element = null;
		try {
			element = driver.findElement(locator);
		} catch (Exception e) {
			LoggersUtil.error("Some exception occurred while creating webelement " + locator + e);
		}
		return element;
	}

	/**
	 * 
	 * @param locator
	 * @return This is to wait for the element to present on the page
	 */

	public void waitForElementPresent(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (Exception e) {
			LoggersUtil.error("Some exception has occured during wait for an element" + e.getMessage());
		}
	}

	public void waitForElementVisibility(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 1);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			LoggersUtil
					.error("Some exception has occured during wait for an element for the visibility" + e.getMessage());
		}
	}

	/**
	 * 
	 * @param locator
	 * @return This clicks on the AndroidElement
	 */
	public void doClick(By locator) {
		try {
			getElement(locator).click();
		} catch (Exception e) {
			LoggersUtil.error("Some exception occurred while clicking on webelement " + locator);
		}
	}

	/**
	 * 
	 * @param locator
	 * @param value
	 * @return This enters the values in the AndroidElement present on the page.
	 */

	public void doSendKeys(By locator, String value) {
		try {
			getElement(locator).clear();
			getElement(locator).sendKeys(value);
		} catch (Exception e) {
			LoggersUtil.error("Some exception occurred while sending to webelement " + locator);
		}
	}

	/**
	 * 
	 * @param locator
	 * @return This is to get the text of the AndroidElement
	 */
	public String doGetText(By locator) {
		String text = null;
		try {
			text = getElement(locator).getText();
			LoggersUtil.info("Inner Text is:" + text);
		} catch (Exception e) {
			LoggersUtil.error("Some exception occurred while sending to webelement " + locator);
		}
		return text;
	}

	/**
	 * 
	 * @param title
	 * @return Waits for the Page Title
	 */

	public String waitForPageTitle(String title) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}

	/**
	 * 
	 * @param locator
	 * @return Waits for the element to be displayed
	 */

	public boolean isElementDisplayed(By locator) {
		try {
			return getElement(locator).isDisplayed();
		} catch (Exception e) {
			LoggersUtil.error("Some exception occurred while checking webelement displayed " + locator);
			return false;
		}
	}

	public boolean isElementVisible(By locator) {
		try {
			return getElementbyLocator(locator).isDisplayed();
		} catch (Exception e) {
			LoggersUtil.error(locator + "locator is not displayed on screen.");
			return false;
		}
	}

	public void elementdoClickonElement(By Locator, String text) {
		List<AndroidElement> me = getElements(Locator);
		for (int i = 0; i < me.size(); i++) {
			System.out.println(me.get(i).getText());
			if (me.get(i).getText().equals(text)) {
				me.get(i).click();
				LoggersUtil.info("User has clicked on the text" + me.get(i).getText());
			}
		}
	}

	public void scrollAndClickByText(String visibleText) {
		try {

			driver.findElementByAndroidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
							+ visibleText + "\").instance(0))")
					.click();
		} catch (Exception e) {
			LoggersUtil.error("User is not able to click" + e.getMessage());

		}
	}

	public List<AndroidElement> getElements(By locator) {
		waitForElementPresent(locator);
		List<AndroidElement> element = null;
		try {
			element = driver.findElements(locator);
		} catch (Exception e) {
			LoggersUtil.error("Some exception occurred while creating webelement " + locator);
		}
		return element;
	}

	public String displaylistofElements(By locator) {
		waitForElementPresent(locator);
		String str = "";
		List<AndroidElement> element = null;
		try {
			element = driver.findElements(locator);
			for (int i = 0; i < element.size(); i++) {
				str = element.get(i).getText();
			}
		} catch (Exception e) {
			LoggersUtil.error("Some exception occurred while creating webelement " + locator);
		}
		return str;
	}

	public String[] displaylistofElements1(By locator) {
		waitForElementPresent(locator);
		List<AndroidElement> element = new LinkedList<AndroidElement>();
		String[] str = new String[element.size()];
		// List<AndroidElement> element = null;
		try {
			element = driver.findElements(locator);
			for (int i = 0; i < element.size(); i++) {
				str[i] = element.get(i).getText();
				LoggersUtil.info(str[i]);
			}
		} catch (Exception e) {
			LoggersUtil.error("Some exception occurred while creating webelement " + locator);
		}
		return str;
	}

	public void verticalSwipeByPercentages(double startPercentage, double endPercentage, double anchorPercentage) {
		try {
			Dimension size = driver.manage().window().getSize();
			int anchor = (int) (size.width * anchorPercentage);
			int startPoint = (int) (size.height * startPercentage);
			int endPoint = (int) (size.height * endPercentage);

			new TouchAction(driver).press(point(anchor, startPoint)).waitAction(waitOptions(ofMillis(1000)))
					.moveTo(point(anchor, endPoint)).release().perform();

		} catch (Exception ex) {
			LoggersUtil.error("Some Exception has been occured" + ex);
		}
	}

	/*
	 * void a() { boolean flag = true; while (flag) {
	 * 
	 * if (flag) { verticalSwipeByPercentages(0.6, 0.3, 0.5); if
	 * (isElementDisplayed(By.xpath("//*[@text='Continue']"))) { flag = false;
	 * break; } }
	 * 
	 * } }
	 */

	public void waitForElementNotVisible(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 200000);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		} catch (Exception ex) {
			LoggersUtil.error("Some Exception occured while wating for an element" + ex);
		}

	}

	public void enterTextByKeyboard(By locator, String text) {
		try {
			doClick(locator);
			driver.getKeyboard().sendKeys(text);
		} catch (Exception ex) {
			LoggersUtil.error("Some exception ocurred while entering text" + ex);
		}
	}

	/*
	 * public void verticalSwipeByPercentagesbyLocator(By locator) { boolean flag =
	 * true; while (flag) { if(flag) if (isElementVisible(locator)) {
	 * 
	 * verticalSwipeByPercentages(0.6, 0.3, 0.5); doClick(locator); flag = false; }
	 * verticalSwipeByPercentages(0.6, 0.3, 0.5); } }
	 */

	public void verticalSwipeByPercentagesbyLocator(By locator) {
		boolean flag = true;
		while (flag) {
			if (isElementVisible(locator)) {
				boolean status = isElementVisible(By.xpath(
						"//android.widget.Button[@text='Next Passenger'] | //android.widget.Button[@text='Continue']"));
				if (status) {

					// verticalSwipeByPercentages(0.5, 0.3, 0.5);
					scrollDown();
					/*
					 * if (isElementVisible(FlightDetailsPage.getFlightdetailstext())) {
					 * doClick(FlightDetailsPage.getClosebutton()); }
					 */
				}
				flag = false;
			} else {
				// verticalSwipeByPercentages(0.5, 0.3, 0.5);
				scrollDown();
				/*
				 * if (isElementVisible(FlightDetailsPage.getFlightdetailstext())) {
				 * doClick(FlightDetailsPage.getClosebutton()); }
				 */
				boolean btnStatus = isElementVisible(locator);
				// btnStatus = isElementVisible(By.xpath("//*[@text='Next Passenger']"));
				if (btnStatus) {
					// verticalSwipeByPercentages(0.5, 0.3, 0.5);
					scrollDown();
					flag = false;
					// break;
				}
			}
			// verticalSwipeByPercentages(0.6, 0.3, 0.5);

		}
	}

	public String getAlphaNumericString(int n) {

		int lowerLimit = 97;
		int upperLimit = 122;
		Random random = new Random();
		StringBuffer r = new StringBuffer(n);
		for (int i = 0; i < n; i++) {

			int nextRandomChar = lowerLimit + (int) (random.nextFloat() * (upperLimit - lowerLimit + 1));
			r.append((char) nextRandomChar);
		}
		return r.toString();
	}

	public void scrollDown() {
		Dimension dimension = driver.manage().window().getSize();
		int scrollStart = (int) (dimension.getHeight() * 0.5);
		int scrollEnd = (int) (dimension.getHeight() * 0.2);

		new TouchAction((PerformsTouchActions) driver).press(PointOption.point(0, scrollStart))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(0, scrollEnd))
				.release().perform();

	}

	public void SoftAssertionsonText(By locator, String ExpectedText) {
		String screenShotPath = getScreenshot("automationScreenshot");
		try {
			softAssert.assertEquals(doGetText(locator), ExpectedText);
			LoggersUtil.info(ExpectedText + " : is getting displayed");
			/*
			 * test.log(Status.PASS, MarkupHelper.createLabel(ExpectedText +
			 * " : is getting	displayed", ExtentColor.PURPLE)); test.log(Status.PASS,
			 * "This Test Case is Passed",
			 * MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			 */
		} catch (Exception ex) {
			LoggersUtil.error(ExpectedText+" : is not getting displayed");
			/*
			 * test.log(Status.FAIL, MarkupHelper.createLabel(ExpectedText +
			 * " : is not getting	displayed", ExtentColor.RED)); try {
			 * test.log(Status.FAIL, "This Test Case is Passed",
			 * MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build()); }
			 * catch (IOException e) { // TODO Auto-generated catch block
			 * e.printStackTrace();
			 */
		}
	}

	public String getScreenshot(String screenshotName) {
		String dateName = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new java.util.Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = "/src/test/resources/Reports/screenshots" + "/screenShot_" + screenshotName + "_"
				+ dateName + ".png";
		File destFile = new File(destination);
		try {
			FileUtils.copyFile(source, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destination;

	}

}
