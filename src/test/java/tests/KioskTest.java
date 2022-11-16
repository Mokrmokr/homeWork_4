package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import utils.BaseTest;

public class KioskTest extends BaseTest {

    @Test
    public void kioskTest () {
        startUp();
        driver.manage().window().fullscreen(); //Запуск в рехиме "Киоск"
        driver.navigate().forward();
        driver.get("https://demo.w3layouts.com/demos_new/template_demo/03-10-2020/photoflash-liberty-demo_Free/685659620/web/index.html?_ga=2.181802926.889871791.1632394818-2083132868.1632394818");

        driver.findElement(By.xpath("//a[contains(text(), 'Nature')]")).click();

//        Alert alert = driver.switchTo().alert();
//        alert.dismiss();

//        Assertions.assertEquals("Онлайн‑курсы для профессионалов, дистанционное обучение современным ...", str);
    }
}
