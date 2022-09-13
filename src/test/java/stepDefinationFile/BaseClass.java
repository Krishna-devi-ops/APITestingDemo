package stepDefinationFile;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static WebDriver driver;

    @Before
    public void setup() {
        String url="https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/";
        System.setProperty("webdriver.chrome.driver", "D:/KrishnaProjects/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

    }

    @After
    public void tearDown() {
        driver.close();
    }
}
