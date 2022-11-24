package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    public WebDriver driver;
    public org.apache.logging.log4j.Logger logger = LogManager.getLogger(BaseTest.class);

    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        logger.info("Драйвер поднят");
    }

    public void startUpHeadless() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        logger.info("Драйвер поднят в режиме headless");
    }

    @AfterEach
    public void end(){
        if (driver!=null) {
            driver.close();
            driver.quit();
            System.out.println("Драйвер off");
        }
    }
}