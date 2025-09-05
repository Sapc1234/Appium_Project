package Appium_Introduction;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import Appium_PreSteps.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class E2E_AppTest extends BaseTest

{
	@Test

	public void app_Test() throws MalformedURLException, URISyntaxException, InterruptedException

	{
		
		Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.app.AlertDialogSamples");
		((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent",
				"io.appium.android.apis/io.appium.android.apis.app.AlertDialogSamples"));
		
		//driver.findElement(AppiumBy.accessibilityId("App")).click();
		//driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();

		
		driver.findElement(By.xpath("//android.widget.Button[@content-desc='OK Cancel dialog with a message']"))
				.click();

		String alertTxt = driver.findElement(By.id("android:id/alertTitle")).getText();

		System.out.println(alertTxt);
		// Assert.assertEquals(alertTxt, "Lorem ipsum dolor sit aie consectetur");

		driver.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();

		// Long Message

		driver.findElement(By.xpath("//android.widget.Button[@content-desc='OK Cancel dialog with a long message']"))
				.click();
		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		System.out.println(alertTitle);
		Assert.assertEquals(alertTitle, "Header title");

		String altMsg = driver.findElement(By.id("android:id/message")).getText();
		System.out.println(altMsg);
		driver.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button2']")).click();

		// Ultra Long msg

		String ulmsg = driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with ultra long message"))
				.getText();
		Assert.assertEquals(ulmsg, "OK Cancel dialog with ultra long message");
		System.out.println(ulmsg);
		driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with ultra long message")).click();
		String alTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		System.out.println(alTitle);
		Assert.assertEquals(alTitle, "Header title");
		driver.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();

		// List Dialog
		driver.findElement(AppiumBy.accessibilityId("List dialog")).click();
		List<WebElement> options = driver.findElements(AppiumBy.className("android.widget.TextView"));

		for (WebElement option : options)

		{
			if (option.getText().equalsIgnoreCase("Command one"))

			{
				waitForElementToAppear(option);
				option.click();
				break;
			}
		}

		String dialogMsg = driver.findElement(By.id("android:id/message")).getText();
		System.out.println(dialogMsg);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));

		// Single choice list

		driver.findElement(AppiumBy.accessibilityId("Single choice list")).click();

		String sclAlTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		System.out.println(sclAlTitle);
		Assert.assertEquals(sclAlTitle, "Single choice list");
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Satellite']")).click();
		String checkboxName = driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Satellite']"))
				.getText();
		System.out.println(checkboxName);
		driver.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();

		// Text Entry dialog
		driver.findElement(AppiumBy.accessibilityId("Text Entry dialog")).click();

		String textDialogTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		System.out.println(textDialogTitle);
		Assert.assertEquals(textDialogTitle, "Text Entry dialog");

		driver.findElement(By.id("io.appium.android.apis:id/username_edit")).sendKeys("Sapc");
		driver.findElement(By.id("io.appium.android.apis:id/password_edit")).sendKeys("Sapc1234");
		driver.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();

	}

}
