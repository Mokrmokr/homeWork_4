package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utils.BaseTest;

public class HeadlessTest extends BaseTest {

    @Test
    public void headlessTest () {
        startUpHeadless(); //Запуск в режиме headless
        driver.get("https://duckduckgo.com/");

        driver.findElement(By.cssSelector("input#search_form_input_homepage")).sendKeys("ОТУС");
        driver.findElement(By.cssSelector("input#search_button_homepage")).click();
        String str = driver.findElement(By.xpath("//h2/a[@href=\"https://otus.ru/\"]/span")).getText();

        Assertions.assertEquals("Онлайн‑курсы для профессионалов, дистанционное обучение современным ...", str);
    }
}
