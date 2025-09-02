package Appium_Introduction;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Appium_PreSteps.BaseTest;
import io.appium.java_client.AppiumBy;

public class LongPress extends BaseTest

{
	@Test

	public void longPess_Gesture() throws MalformedURLException, URISyntaxException, InterruptedException

	{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		longPressAction(ele);
		Boolean menuText = driver.findElement(By.id("android:id/title")).isDisplayed();
		Assert.assertTrue(menuText);
		String menuTxt = driver.findElement(By.id("android:id/title")).getText();
		System.out.println(menuTxt);
	}
}
