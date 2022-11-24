package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseTest;

import java.time.Duration;

public class KioskTest extends BaseTest {

    private WebDriverWait wait;

    @Test
    public void kioskTest () throws InterruptedException {
        startUp();
        driver.manage().window().fullscreen(); //Запуск в режиме "Киоск"
        driver.get("https://demo.w3layouts.com/demos_new/template_demo/03-10-2020/photoflash-liberty-demo_Free/685659620/web/index.html?_ga=2.181802926.889871791.1632394818-2083132868.1632394818");

        WebElement element = driver.findElement(By.xpath("//a[contains(text(), 'Nature')]"));
        element.sendKeys(Keys.PAGE_DOWN);

        WebElement picture = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@data-id='id-1']//img")));
        driver.findElement(By.xpath("//li[@data-id='id-1']//div[@class='content-overlay']")).click();

        WebElement pictureInModalWindow = driver.findElement(By.cssSelector("div.pp_pic_holder"));
        Assertions.assertTrue(pictureInModalWindow.isDisplayed());
    }
}
