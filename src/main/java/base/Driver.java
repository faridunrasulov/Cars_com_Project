package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePages;
import pages.SearchResultPage;

import java.util.concurrent.TimeUnit;

public class Driver {

    public static WebDriver driver;
    private static String url = "https://www.cars.com/";
    public static HomePages homePages;
    public static SearchResultPage searchResultPage;

    @BeforeClass
    public static WebDriver setUp() {

//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        homePages = new HomePages();
        searchResultPage = new SearchResultPage();

        return driver;
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        if(driver != null){
            Thread.sleep(3000);
            driver.quit();
        }
    }
}
