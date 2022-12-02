import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;


public class LogoSamocatTest {
    public FirefoxDriver driver;
            String url = "https://qa-scooter.praktikum-services.ru/order";
         public LogoSamocat logoSamocat;
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
        //Находимся на странице ЗАКАЗА
        driver.get(url);
        // Проверяем,что ЛОГОТИП ВИДЕН и переходим на главную стр.
        logoSamocat.isDisplayedClickLogo();
        //проверяем чатсть текста URL
        logoSamocat.forUrlContains("praktikum");
        //проверяем,что URL соответствует главной стр.
        logoSamocat.urlIsUrlMaim("https://qa-scooter.praktikum-services.ru/");
    }
    }



