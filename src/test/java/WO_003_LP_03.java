import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * 1-) Open the URL 2-) Click "WebOrder" button on top bar. 3-) Enter valid username
 * "Inar" and password "Academy". 4-) Click "Logout" button. 5-) Verify logout
 * successfully.
 */

public class WO_003_LP_03 extends Hooks {

	@Test
	void testLogoutFunctionality() {
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

		try {
			Thread.sleep(5500);
		}
		catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		WebElement logoutButton = driver.findElement(By.id("logout-button"));
		logoutButton.click();
	}

	@AfterEach
	void tearDown() {
		driver.quit();
	}

}
