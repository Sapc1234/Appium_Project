package ECommerce;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import Appium_PreSteps.BaseTest;
import io.appium.java_client.AppiumBy;

public class Ecomm_App_Tc2 extends BaseTest

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
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
		int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();

		for (int i = 0; i < productCount; i++)

		{
			String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i)
					.getText();
			if (productName.equalsIgnoreCase("Jordan 6 Rings"))

			{
				// click on add to cart
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			}
		}
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

		waitForElementToAttributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),
				"text", "Cart");
		String lastPageProduct = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		Assert.assertEquals(lastPageProduct, "Jordan 6 Rings");
	}

}
