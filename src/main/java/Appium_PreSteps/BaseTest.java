package Appium_PreSteps;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class BaseTest

{
	// public AppiumDriverLocalService service;

	public static AppiumServiceBuilder service;
	public static AppiumDriverLocalService LocalService;
	public static AndroidDriver driver;

	@BeforeClass
	public void configureAppium() throws MalformedURLException, URISyntaxException

	{

		// Run Appium server automatically

		/*
		 * File node_Path = new File("C:\\Program Files\\nodejs\\node.exe"); File
		 * appiumJs_Path = new File(
		 * "C:\\Users\\shara\\AppData\\Roaming\\npm\\node_modules\\appium\\lib\\main.js"
		 * ); service = new
		 * AppiumServiceBuilder().withAppiumJS(appiumJs_Path).withIPAddress("127.0.0.1")
		 * .usingPort(4723)
		 * .withTimeout(Duration.ofSeconds(60)).withArgument(GeneralServerFlag.
		 * LOG_LEVEL, "debug").build(); service.start();
		 */

		// Run Appium server automatically
		service = new AppiumServiceBuilder();
		service.withIPAddress("127.0.0.1");
		service.usingPort(4723);
		service.withArgument(GeneralServerFlag.LOG_LEVEL, "debug");
		LocalService = io.appium.java_client.service.local.AppiumDriverLocalService.buildService(service);
		LocalService.start();

		if (LocalService.isRunning())
			System.out.println("Appium server started successfully!");
		else
			System.out.println("Failed to start Appium server.");

		// create capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("SapEmulator");
		// options.setApp(System.getProperty("user.dir") +
		// "\\src\\main\\resources\\utils\\ApiDemos-debug.apk");
		options.setApp(System.getProperty("user.dir") + "\\src\\main\\resources\\utils\\General-Store.apk");
		// create object android /Ios driver
		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	public static void longPressAction(WebElement ele)

	{
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration", 2000));
	}

	public static void scrollToEndAction()

	{
		boolean canScrollMore;
		do

		{
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap
					.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 3.0));

		} while (canScrollMore);
	}

	public static void scrollToSpecificText()

	{
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
	}

	public static void swipeAction(WebElement ele, String direction)

	{
		// Swipe
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
				((RemoteWebElement) ele).getId(), "direction", direction.toLowerCase(), "percent", 0.75));

	}

	public static void dragAndDropAction(WebElement ele)

	{
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "endX", 648, "endY", 576));
	}

	public static void waitForElementToAppear(WebElement byElement)

	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(byElement));
	}

	public static void waitForElementToAttributeContains(WebElement byElement, String txt, String Cart)

	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(byElement, txt, Cart));
	}

	public static Double getFormattedAmount(String amount)

	{
		Double price = Double.parseDouble(amount.substring(1));
		return price;
	}

	@AfterClass
	public void tearDown()

	{
		driver.quit();
		LocalService.stop();
	}

}
