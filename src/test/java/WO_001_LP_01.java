import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 1-) Open the URL. 2-) Click "WebOrder" button on top bar. 3-) Enter "Inar" as username
 * and "Academy" password. 4-) Click on the "Login" button. 5-) Verify that the user is
 * successfully logged in.
 */
public class WO_001_LP_01 extends Hooks {

	@Test
	void testSuccesfulLoginPlace() {
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
	}

	@AfterEach
	void tearDown() {
		driver.quit();
	}

}
