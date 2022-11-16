package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest extends ChromeMode{
    public WebDriver driver;
    public org.apache.logging.log4j.Logger logger = LogManager.getLogger(BaseTest.class);

    public void startUp(String ...mode) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments(mode);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        chromeMode(mode); //вывод режима запуска в консоль
        logger.info("Драйвер поднят");
    }

    @AfterEach
    public void end(){
        if (driver!=null)
            System.out.println("Дрйвер off");
        driver.quit();
    }
}