package Appium_Introduction;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Appium_PreSteps.BaseTest;
import io.appium.java_client.AppiumBy;

public class Appium_BasicsWifi extends BaseTest

{
	@Test

	public void wifiSettingsName() throws MalformedURLException, URISyntaxException

	{
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String allertTitle = driver
				.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/alertTitle']")).getText();
		System.out.println(allertTitle);
		Assert.assertEquals(allertTitle, "WiFi settings");

		driver.findElement(By.id("android:id/edit")).sendKeys("Sharan wifi");
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();

	}
}
