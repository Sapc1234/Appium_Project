package Appium_Introduction;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import Appium_PreSteps.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MiscellaneousAppiumAction extends BaseTest

{
	@Test

	public void MiscellaneousTest() throws MalformedURLException, URISyntaxException

	{

		// App package and app ativity
		// adb devices->Gives information about currently opened app
		// adb shell ->This command lists connected devices and emulators. Enter the ADB
		// shell.
		// dumpsys window displays | grep -E "mCurrentFocus|mFocusedApp" ->Identify the
		// currently focused app.
		Activity activity = new Activity("io.appium.android.apis",
				"io.appium.android.apis.preference.PreferenceDependencies");
		((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent",
				"io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"));
		
		//driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		//driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		DeviceRotation landScape = new DeviceRotation(0, 0, 90);
		driver.rotate(landScape);

		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String allertTitle = driver
				.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/alertTitle']")).getText();
		System.out.println(allertTitle);
		Assert.assertEquals(allertTitle, "WiFi settings");

		// copy paste
		// copy to clipboard -paste it clipboard
		driver.setClipboardText("Sharan wifi");
		// driver.findElement(By.id("android:id/edit")).sendKeys("Sharan wifi");
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		driver.pressKey(new KeyEvent(AndroidKey.CLEAR));
	}
}
