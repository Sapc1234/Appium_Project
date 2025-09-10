package ECommerce;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import Appium_PreSteps.BaseTest;
import io.appium.java_client.AppiumBy;

public class Ecomm_App_Tc1 extends BaseTest

{
	@Test

	public void fillForm()

	{
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='India']"))
				.click();
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("sharan");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		String toastMsg = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Assert.assertEquals(toastMsg, "Please enter your name");
	}

}
