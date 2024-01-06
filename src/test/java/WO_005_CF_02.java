import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 1-) Open the URL. 2-) Click "WebOrder" button on top bar. 3-) Enter valid username
 * "Inar" and password "Academy". 4-) Navigate to the order page. 5-) Select "ScreenSaver"
 * from Product dropdown. 6-) Leave blank the quantity box. 7-) Enter "20" as discount
 * percentage. 8-) Click on the "Calculate" button. 9-) Verify the invalid Quantity error
 * message is displayed.
 */
public class WO_005_CF_02 extends Hooks {

	List<String> orderInformation = new ArrayList<>();

	@Test
	void testVerifyCalculateFunctionalityInOrderPageInvalidInput() {
		// 2. Click on weborder link
		WebElement webOrderLink = driver.findElement(By.xpath("//a[@href='/weborder']"));
		webOrderLink.click();

		// 3. Enter "Inar" as username and "Academy" password.
		WebElement userNameInputField = driver.findElement(By.id("login-username-input"));
		WebElement passwordInputField = driver.findElement(By.id("login-password-input"));

		userNameInputField.sendKeys("Inar");
		passwordInputField.sendKeys("Academy");

		// Click on the "Login" button.
		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();

		WebElement webOrderButton = driver.findElement(By.xpath("//a[@href='/weborder/order']"));
		webOrderButton.click();

		WebElement productDropdown = driver.findElement(By.xpath("//*[@id=\"productSelect\"]"));
		Select productSelect = new Select(productDropdown);
		productSelect.selectByVisibleText("HomeDecor");

		WebElement webDiscountInputField = driver.findElement(By.id("discountInput"));
		webDiscountInputField.sendKeys("20");

		WebElement webCalculateButton = driver.findElement(By.xpath("//button[text()='Calculate']"));
		webCalculateButton.click();

		WebElement totalTextField = driver.findElement(By.id("totalInput"));
		assertEquals("638", totalTextField.getAttribute("value"));
	}

}
