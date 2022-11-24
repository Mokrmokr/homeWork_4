package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseTest;

public class FullScreenTest extends BaseTest {

    @Test
    public void fullScreenTest () {
        startUp();
        driver.manage().window().maximize();
        driver.get("https://otus.ru/");

        WebElement logInWindowButton = driver.findElement(By.cssSelector("button.header2__auth"));
        logInWindowButton.click();

        WebElement emailInput = driver.findElement(By.xpath("//form[@action='/login/']//input[@name='email']"));
        emailInput.clear();
        emailInput.sendKeys("makar.slepov@limavi.ru");

        WebElement passInput = driver.findElement(By.xpath("input.js-psw-input"));
        passInput.clear();
        passInput.sendKeys("TestPassword1!");

        WebElement logInButton = driver.findElement(By.xpath("//form[@action='/login/']//button[contains(text(), 'Войти')]"));
        logInButton.click();

        logger.info(driver.manage().getCookies());

    }
}
