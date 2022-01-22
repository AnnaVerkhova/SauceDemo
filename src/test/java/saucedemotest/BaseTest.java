package saucedemotest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import web.pages.*;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected CatalogPage catalogPage;
    protected CartPage cartPage;
    protected CheckoutPage checkoutPage;
    protected CheckoutOverviewPage checkoutOverviewPage;
    protected CheckoutCompletePage checkoutCompletePage;


    public static final String USERNAME = "standard_user";
    public static final String PASSWORD = "secret_sauce";
    public static final String LOCKED_USER = "locked user name";
    public static final String FIRST_NAME_VALUE = "firstname";
    public static final String LAST_NAME_VALUE = "lastname";
    public static final String ZIP_VALUE = "postcode";


    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--ignore-popup-blocking");
        chromeOptions.addArguments("--ignore-certificate-errors");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        loginPage = new LoginPage(driver);
        catalogPage = new CatalogPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);


    }

    @AfterClass(alwaysRun = true)
    public void teardown() {
        driver.close();
        driver.quit();
    }
}
