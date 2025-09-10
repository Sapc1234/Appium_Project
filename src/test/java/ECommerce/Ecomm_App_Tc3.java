package ECommerce;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import Appium_PreSteps.BaseTest;
import io.appium.java_client.AppiumBy;

public class Ecomm_App_Tc3 extends BaseTest

{
	@Test

	public void fillForm()

	{
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='India']"))
				.click();
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("sharan");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();

		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

		waitForElementToAttributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),
				"text", "Cart");

		List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));

		int count = productPrices.size();
		double totalSum = 0;

		for (int i = 0; i < count; i++)

		{
			String amtString = productPrices.get(i).getText();
			Double price = getFormattedAmount(amtString);
			totalSum = totalSum + price;
		}

		System.out.println(totalSum);

		String displaySum = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		Double displayFormattedSum = getFormattedAmount(displaySum);
		
		Assert.assertEquals(totalSum, displayFormattedSum);
		WebElement element = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		longPressAction(element);
		
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();

	}

}
