import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class LogoSamocatTest {
    public FirefoxDriver driver;
            String url = "https://qa-scooter.praktikum-services.ru/order";
         public LogoSamocat logoSamocat;
        String currentURL = null;
    @Before
    public void openMainPage() {
        //System.setProperty("webdriver.chrome.driver","C:\\tools\\chromedriver\\chromedriver.exe");
        //driver = new ChromeDriver();
        System.setProperty("webdriver.geckodriver.driver","C:\\tools\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        logoSamocat = new LogoSamocat(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);

    }

    // тест проверяет, что после клика на КНОПКУ САМОКАТ переходим на ГЛАВНУЮ СТРАНИЦУ
    @Test
    public void getPageLogoScooter() {
        // Изначално находимся на странице ЗАКАЗА
        // проверяем, если ЛОГОТИП видиден, то можно по нему кликнуть и кликаем
        logoSamocat.headerLogoScooterIsClick();
        //перешли на Главную страницу и получаем её url
        currentURL = driver.getCurrentUrl();
        //проверяем, что  ЛОГОТИП есть ссылка на Главную страницу
        String mainUrlPage = currentURL;
        String logoMain = logoSamocat.logoGetLogo();
        //System.out.println(logoMain + " ссылка ЛОГО на главную страницу");
        //System.out.println(currentURL + " ссылка Главной страницы");
        assertEquals(logoMain,mainUrlPage);
        System.out.println(mainUrlPage.equals(logoMain) + " Мы находимся на главной странице");
    }
    @After
    public void quitDriver() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}



