import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 1-) Open the URL. 2-) Click "WebOrder" button on top bar. 3-) Enter valid username
 * "Inar" and password "Academy". 4-) Navigate to the order page. 5-) Select
 * "SportsEquipment" from Product dropdown. 6-) Enter "1" as quantity number. 7-) Enter
 * "10" as discount percentage. 8-) Click on the "Calculate" button. 9-) Enter "Inar
 * Academy" as Name. 10-) Enter "1100 Congress Ave" as Street. 11-) Enter "Austin" as
 * City. 12-) Enter "TX" State. 13-) Enter "78701" as Zip Code(number). 14-) Enter
 * "4938220192845" as Card Number. 15-) Enter "09/26" Expire Date(mm/yy format). 16-)Click
 * "Process"" button. 17-) Verify the Card Type error message is displayed.
 */
public class WO_009_OP_04 extends Hooks {

    @Test
    void testVerifyOrderPlacementwithoutCardType() {
        List<String> orderInformation = new ArrayList<>();

        // Name
        orderInformation.add("Inar Academy");
        // Prod name
        orderInformation.add("SportsEquipment");
        // quantity
        orderInformation.add("1");
        // date
        orderInformation.add(DateTimeFormatter.ofPattern("MM/dd/yyyy").format(LocalDate.now()));
        // Street
        orderInformation.add("1100 Congress Ave");
        // City
        orderInformation.add("Austin");
        // State
        orderInformation.add("TX");
        // Valid Zip code
        orderInformation.add("78701");
        // Valid Card Type
        orderInformation.add("");
        // Valid Card Number (Visa starts with: 4, Mastercard starts with: 5, American
        // Express starts with: 34, 37.)
        orderInformation.add("4938220192845");
        // Valid Card Expire Date (format must be mm/yy)
        orderInformation.add("09/26");

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

        // Verify that the user is successfully logged in.
        WebElement heading = driver.findElement(By.id("welcome-heading"));
        String headingText = heading.getText();

        Assertions.assertEquals("Welcome, Inar!", headingText, "Heading Text is wrong");

        // 4 - Navigate to the order page.
        WebElement orderTabLink = driver.findElement(By.cssSelector("#order-tab > a"));
        orderTabLink.click();

        // select product as MyMoney
        WebElement productDropdownElement = driver.findElement(By.id("productSelect"));
        Select productDropdown = new Select(productDropdownElement);

        productDropdown.selectByVisibleText(orderInformation.get(1));

        // Enter "8" as quantity number.
        WebElement quantityInputField = driver.findElement(By.id("quantityInput"));
        quantityInputField.sendKeys(orderInformation.get(2));

        // Enter "20" as discount percentage.
        WebElement discountInputField = driver.findElement(By.id("discountInput"));
        discountInputField.sendKeys("10");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Click on the "Calculate" button.
        WebElement calculateButton = driver.findElement(By.xpath("//button[text()='Calculate']"));
        calculateButton.click();

        // Enter customer information
        WebElement nameField = driver.findElement(By.id("name"));
        WebElement streetField = driver.findElement(By.id("street"));
        WebElement cityField = driver.findElement(By.id("city"));
        WebElement stateField = driver.findElement(By.id("state"));
        WebElement zipCodeField = driver.findElement(By.id("zip"));

        nameField.sendKeys(orderInformation.get(0));
        streetField.sendKeys(orderInformation.get(4));
        cityField.sendKeys(orderInformation.get(5));
        stateField.sendKeys(orderInformation.get(6));
        zipCodeField.sendKeys(orderInformation.get(7));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,1000)");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement cardNumberField = driver.findElement(By.id("cardNumber"));
        cardNumberField.sendKeys(orderInformation.get(9));

        WebElement expiryDateField = driver.findElement(By.id("expiryDate"));
        expiryDateField.sendKeys(orderInformation.get(10));

        // click on "process" button
        WebElement processButton = driver.findElement(By.xpath("//button[text()='Process']"));
        processButton.click();

        // verify confirmation message
        WebElement confirmationElement = driver.findElement(By.xpath("//em[text()='Card type cannot be empty']"));
        String message = confirmationElement.getText();
        String expectedMsg = "Card type cannot be empty";
        Assertions.assertEquals(expectedMsg, message, "Confirmation Message is wrong!");

        // js.executeScript("window.scroll(0,-1000)");
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.PAGE_UP).release().build().perform();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Navigate to view all orders page.
        WebElement viewAllOrderLink = driver.findElement(By.cssSelector("#view-orders-tab > a"));
        viewAllOrderLink.click();
        WebElement invalidProductInformationAlert = driver.findElement(By.xpath("//em[text()='Card type cannot be empty']"));
        assertTrue(invalidProductInformationAlert.isDisplayed(), "Order is accepted without card type!");
    }

}
