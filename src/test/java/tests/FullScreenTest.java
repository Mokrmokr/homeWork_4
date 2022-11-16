package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utils.BaseTest;

public class FullScreenTest extends BaseTest {

    @Test
    public void fullScreenTest () {
        startUp();
        driver.manage().window().maximize();
        driver.get("https://otus.ru/");

        driver.findElement(By.cssSelector("button.header2__auth")).click();
        driver.findElement(By.xpath("//form[@action='/login/']//input[@name='email']")).clear();
        driver.findElement(By.xpath("//form[@action='/login/']//input[@name='email']")).sendKeys("makar.slepov@limavi.ru");
        driver.findElement(By.cssSelector("input.js-psw-input")).clear();
        driver.findElement(By.cssSelector("input.js-psw-input")).sendKeys("TestPassword1!");
        driver.findElement(By.xpath("//form[@action='/login/']//button[contains(text(), 'Войти')]")).click();

        logger.info(driver.manage().getCookies());

    }
}
