package Appium_Introduction;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Appium_PreSteps.BaseTest;
import io.appium.java_client.AppiumBy;

public class DragAndDropDemo extends BaseTest

{
	@Test

	public void dragAndDropDemoTest() throws MalformedURLException, URISyntaxException, InterruptedException

	{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();

		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();

		WebElement source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));

		dragAndDropAction(source);

		String resultTxt = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();

		Assert.assertEquals(resultTxt, "Dropped!");

		System.out.println(resultTxt);

	}
}
