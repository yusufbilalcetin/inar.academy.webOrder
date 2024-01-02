import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * 1-) Open the URL. 2-) Click "WebOrder" button on top bar. 3-) Enter invalid username
 * "InvalidUserName" and/or password "InvalidPassword". 4-) Click on the "Login" button
 * 5-) Verify that the appropriate error message is displayed.
 */

public class WO_002_LP_02 extends Hooks {

	@Test
	void testInvalidUsernameOrPassword() {
		// 2. Click on weborder link
		WebElement webOrderLink = driver.findElement(By.xpath("//a[@href='/weborder']"));
		webOrderLink.click();

		// 3. Enter "InvalidUsername" as username and "InvalidPassword" password.
		WebElement userNameInputField = driver.findElement(By.id("login-username-input"));
		WebElement passwordInputField = driver.findElement(By.id("login-password-input"));

		userNameInputField.sendKeys("InvalidUsername");
		passwordInputField.sendKeys("InvalidPassword");

		// Click on the "Login" button.
		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();

		WebElement confirmationUsername = driver.findElement(By.id("username-error-alert"));
		String message = confirmationUsername.getText();
		String expectedMsg = "Invalid username";
		Assertions.assertEquals(expectedMsg, message, "Confirmation Message is wrong!");

		WebElement confirmationPassword = driver.findElement(By.id("password-error-alert"));
		String message2 = confirmationPassword.getText();
		String expectedMsg2 = "Invalid password";
		Assertions.assertEquals(expectedMsg2, message2, "Confirmation Message is wrong!");
	}

}
