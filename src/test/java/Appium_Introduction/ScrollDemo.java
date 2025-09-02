package Appium_Introduction;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.testng.annotations.Test;

import Appium_PreSteps.BaseTest;
import io.appium.java_client.AppiumBy;

public class ScrollDemo extends BaseTest

{
	@Test

	public void scrollDemoTest() throws MalformedURLException, URISyntaxException, InterruptedException

	{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();

		// where to scroll is known
		scrollToSpecificText();

		// where to scroll is don't know
		scrollToEndAction();
	}
}
