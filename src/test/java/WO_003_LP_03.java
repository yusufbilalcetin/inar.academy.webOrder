import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 1-) Open the URL 2-) Click "WebOrder" button on top bar. 3-) Enter valid username
 * "Inar" and password "Academy". 4-) Click "Logout" button. 5-) Verify logout
 * successfully.
 */

public class WO_003_LP_03 extends Hooks {

	@Test
	void testLogoutFunctionality() {
		// 2-) Click "WebOrder" button on top bar.
		WebElement webOrderButton = driver.findElement(By.xpath("//a[@href='/weborder']"));
		webOrderButton.click();

		// 3-) Enter valid username "Inar" and password "Academy".
		WebElement userIdInputField = driver.findElement(By.id("login-username-input"));
		userIdInputField.sendKeys("Inar");

		WebElement userPasswordInputField = driver.findElement(By.id("login-password-input"));
		userPasswordInputField.sendKeys("Academy");

		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();

		// 4-) Click "Logout" button.
		WebElement logoutButton = driver.findElement(By.id("logout-button"));
		logoutButton.click();

		// 5-) Verify logout successfully.
		WebElement logoutPageh1 = driver.findElement(By.xpath("/html/body/center[1]/h1"));
		assertEquals("404 Not Found", logoutPageh1.getText());
	}

}
