import org.example.OrderPage;
import org.example.OrderPage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class InputNameSurnameAddressParamTest {
    //public  ChromeDriver driver;
    public FirefoxDriver driver;
    public OrderPage orderPage;
    private final String userName;
    private final String secondName;
    private final String address;
    private final String metroStation;
    private final String telNumber;
    private final boolean isLoggedPass;
    public String url = "https://qa-scooter.praktikum-services.ru/order";

    public InputNameSurnameAddressParamTest(String userName,String secondName,
                                            String address, String telNumber, String metroStation, Boolean isLoggedPass){
        this.userName = userName;
        this.secondName = secondName;
        this.address = address;
        this.metroStation = metroStation ;
        this.telNumber = telNumber;
        this.isLoggedPass = isLoggedPass;
    }

    @Before
    public void openMainPage() {
        //System.setProperty("webdriver.chrome.driver","C:\\tools\\chromedriver\\chromedriver.exe");
        //driver = new ChromeDriver();
        System.setProperty("webdriver.geckodriver.driver","C:\\tools\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        orderPage = new OrderPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);

    }

    @Parameterized.Parameters
    public static Object[][] getPersonalData() {
        return new Object[][] {
                {"Сабина","Бадеева","Санкт-Петербург, Суворовский пр.","+79005556677","Бульвар Рокоссовского",true},
                {"Sabina", "Badeeva","Санкт-Петербург, Суворовский пр.","+79005556677","Невский проспект", false},
                {"Иван", "Иванов", "Москва, Охотный ряд","abcdifg","Преображенская",false},
        };
    }
    @Test
    public void inputDataFields() throws InterruptedException {
        orderPage.setUsername(userName);
        orderPage.setSecondNameField(secondName);
        orderPage.setAddressField(address);
        orderPage.choiceMetro();
        orderPage.inputTelNumber(telNumber);
        orderPage.setNextButton();

        //Проверяем,что присутствует  элемент метро
        orderPage.visibleEleMetroStation();
    }

}
