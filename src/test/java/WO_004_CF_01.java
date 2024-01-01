import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * 1-) Open the URL.
 * 2-) Click "WebOrder" button on top bar.
 * 3-) Enter valid username "Inar" and password "Academy".
 * 4-) Navigate to the order page.
 * 5-) Select "HomeDecor" from Product dropdown.
 * 6-) Enter "5" as quantity number.
 * 7-) Enter "15" as discount percentage.
 * 8-) Click on the "Calculate" button.
 * 9-) Verify that the total amount is successfully displayed.
 */
public class WO_004_CF_01 extends Hooks {
    @Test
    void testVerifyCalculateFunctionalityInOrderPage(){
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

        WebElement webQuantityInputField = driver.findElement(By.id("quantityInput"));
        WebElement webDiscountInputField = driver.findElement(By.id("discountInput"));

        webQuantityInputField.sendKeys("5");
        webDiscountInputField.sendKeys("15");

        WebElement webCalculateButton = driver.findElement(By.xpath("//button[text()='Calculate']"));
        webCalculateButton.click();
    }
}
