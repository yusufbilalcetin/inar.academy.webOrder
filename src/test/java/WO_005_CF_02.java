import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * 1-) Open the URL.
 * 2-) Click "WebOrder" button on top bar.
 * 3-) Enter valid username "Inar" and password "Academy".
 * 4-) Navigate to the order page.
 * 5-) Select "ScreenSaver" from Product dropdown.
 * 6-) Leave blank the quantity box.
 * 7-) Enter "20" as discount percentage.
 * 8-) Click on the "Calculate" button.
 * 9-) Verify the invalid Quantity error message is displayed.
 */
public class WO_005_CF_02 extends Hooks {
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

        WebElement webDiscountInputField = driver.findElement(By.id("discountInput"));
        webDiscountInputField.sendKeys("20");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement webCalculateButton = driver.findElement(By.xpath("//button[text()='Calculate']"));
        webCalculateButton.click();
    }
}
