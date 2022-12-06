package org.example;
import org.junit.After;
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
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderParamTest {

    //public  ChromeDriver driver;
    public FirefoxDriver driver;
    public org.example.OrderPage orderPage;
    public org.example.MainPage mainPage;
    String url = "https://qa-scooter.praktikum-services.ru/";
    private final String data;
    private final String rental;
    private final String colorScooter;
    private final String comment;
    private final boolean isOrderPass;

    public OrderParamTest(String data,  String rental, String colorScooter, String comment, Boolean isOrderPass) {
        this.data = data;
        this.rental = rental;
        this.colorScooter = colorScooter;
        this.comment = comment;
        this.isOrderPass = isOrderPass;
    }

    @Before
    public void openOrderPage() {
        //System.setProperty("webdriver.chrome.driver","C:\\tools\\chromedriver\\chromedriver.exe");
        //driver = new ChromeDriver();
        System.setProperty("webdriver.geckodriver.driver", "C:\\tools\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        orderPage = new OrderPage(driver);
        mainPage = new org.example.MainPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        //Нажать на кнопку ЗАКАЗАТЬ №2
        //Предварительный СКРОЛЛ СТРАНИЦЫ
        mainPage.scrollPaigeMain();
        // Ожидание загрузки
        mainPage.seeAccordionButtonWhat();
        //Нажать на кнопку Заказать(Нижняя)
        orderPage.pushOrderButtonTwo();
        //АВТОРИЗАЦИЯ
        orderPage.login("Сабина","Бадеева","Охотный ряд");
        //Выбор СТАНЦИИ МЕТРО
        orderPage.choiceMetro();
        //Ввод НОМЕРА ТЕЛ
        orderPage.inputTelNumber("+79001112233");
        //Ожидание ЗАГРУЗКИ ДАННЫХ
        orderPage.waitForLoadProfileData();
        orderPage.setNextButton();
    }

    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][]{
                {"12.10.2022", "четверо суток", "чёрный жемчуг", "Привезти к 12", true},
        {"30.12.2022", "четверо суток", "чёрный жемчуг", "Get to 18",true},
    };
    }

    @Test
    public void fillOrderField()  {
        //заполнение данных заказа на странице "ПРО АРЕНДУ"
        orderPage.choiceDataString(data);
        orderPage.clickDropDownRental();
        orderPage.clickCheckBoxColorScooter();
        orderPage.commentForCourier(comment);
        //Ожидание ЗАГРУЗКИ ДАННЫХ
        orderPage.waitForLoadOrderData();
        //клик по кнопке ЗАКАЗАТЬ
        orderPage.clickGetOrder();
        // клик по кнопке ДА (pop-up "Хотите оформить заказ?"
        orderPage.clickButtonOrderYes();

        // проверка, что видна надпись в Поп-Ап,если заказ оформлен
        String order = orderPage.isDisplayedHeader();
        assertTrue(order, isOrderPass);
        //System.out.println(order);
    }
    @After
    public void quitDriver() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
