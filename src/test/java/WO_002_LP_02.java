import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 1-) Open the URL. 2-) Click "WebOrder" button on top bar. 3-) Enter invalid username
 * "InvalidUserName" and/or password "InvalidPassword". 4-) Click on the "Login" button
 * 5-) Verify that the appropriate error message is displayed.
 */

public class WO_002_LP_02 extends Hooks {

	@Test
	void verifyLoginFailureWithInvalidUserName() throws InterruptedException {
		// 2-) Click "WebOrder" button on top bar.
		WebElement webOrderButton = driver.findElement(By.xpath("//a[@href='/weborder']"));
		webOrderButton.click();

		// 3-) Enter invalid username "InvalidUserName" and/or password "InvalidPassword".
		WebElement userIdInputField = driver.findElement(By.id("login-username-input"));
		userIdInputField.sendKeys("Inar1");

		WebElement userPasswordInputField = driver.findElement(By.id("login-password-input"));
		userPasswordInputField.sendKeys("Academy");

		// 4-) Click on the "Login" button
		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();

		// 5-) Verify that the appropriate error message is displayed.
		WebElement alertText = driver.findElement(By.id("username-error-alert"));

		assertEquals("Invalid username", alertText.getText());
	}

}
