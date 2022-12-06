package org.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class QuestionsMainPageTest {
    //public  ChromeDriver driver;
    public FirefoxDriver driver;
    public org.example.MainPage mainPage;

    String url = "https://qa-scooter.praktikum-services.ru/";

    @Before
    public void openMainPage() {
        //System.setProperty("webdriver.chrome.driver","C:\\tools\\chromedriver\\chromedriver.exe");
        //driver = new ChromeDriver();
        System.setProperty("webdriver.geckodriver.driver", "C:\\tools\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        mainPage = new org.example.MainPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);

    }

    @Test
    public void whatPriceScooter()  {
        //СКРОЛЛ СТРАНИЦЫ и ОЖИДАНИЕ
        mainPage.scrollPaigeMain();
        //ПРОВЕРЯЕМ, что ЭЛЕМЕНТЫ СОДЕРЖАТ НУЖНЫЙ ТЕКСТ
        //  1.Элемент СКОЛЬКО ЭТО СТОИТ?
        mainPage.clickAccordionButtonWhatPrice("Сколько это стоит? И как оплатить?");
        mainPage.getAnswerQuestionWhatPrice("Сутки — 400 рублей. Оплата курьеру — наличными или картой.");
   }

    @Test
    public void wantSomeScooter()  {
        //  2.Элемент "ХОЧУ НЕСКОЛЬКО САМОКАТОВ?"
        //СКРОЛЛ СТРАНИЦЫ и ОЖИДАНИЕ
        mainPage.scrollPaigeMain();
        //ПРОВЕРЯЕМ, что после нажатия на стрелочку каждый ЭЛЕМЕНТ СОДЕРЖИТ НУЖНЫЙ ТЕКСТ
        mainPage.clickAccordionButtonWantSome("Хочу сразу несколько самокатов! Так можно?");
        mainPage.getAnswerButtonWantSome("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.");
    }

    @Test
    public void timeRentalScooter()  {
        mainPage.scrollPageDown();
        //  3.Элемент "КАК РАССЧИТЫВАЕТСЯ ВРЕМЯ АРЕНДЫ?"
        mainPage.clickAccordionButtonTimeRental("Как рассчитывается время аренды?");
        mainPage.getAnswerButtonTimeRental("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. " +
                "Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру." +
                " Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.");
    }

    @Test
    public void getOrderNowScooter()  {
        mainPage.scrollPageDown();
        //  4.Элемент "МОЖНО ЗАКАЗАТЬ САМОКАТ СЕГОДНЯ"
        mainPage.clickAccordionButtonGetOrderNow("Можно ли заказать самокат прямо на сегодня?");
        mainPage.getAnswerAccordionButtonGetOrderNow("Только начиная с завтрашнего дня. Но скоро станем расторопнее.");
    }

    @Test
    public void extendOrderScooter()  {
        mainPage.scrollPageDown();
        // 5.Элемент "МОЖНО ЛИ ПРОДЛИТЬ ЗАКАЗ"
        mainPage.clickAccordionButtonExtendOrder("Можно ли продлить заказ или вернуть самокат раньше?");
        mainPage.getAnswerAccordionButtonExtendOrder("Пока что нет! Но если что-то срочное — всегда можно позвонить " +
                "в поддержку по красивому номеру 1010.");
    }

    @Test
    public void chargeWithScooter() {
        //  СКРОЛЛ СТРАНИЦЫ
        mainPage.scrollPageMainDown();
        // 6.Элемент ВЫ ПРИВОЗИТЕ ЗАРЯДКУ?
        mainPage.clickAccordionButtonChargeWithScooter("Вы привозите зарядку вместе с самокатом?");
        mainPage.getAnswerButtonChargeWithScooter("Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.");
    }

    @Test
    public void cancelOrderScooter()  {
        //  СКРОЛЛ СТРАНИЦЫ
        mainPage.scrollPageMainDown();
        // 7.Элемент "МОЖНО ЛИ ОТМЕНИТЬ ЗАКАЗ"
        mainPage.clickAccordionButtonCancelOrder("Можно ли отменить заказ?");
        mainPage.getAnswerAccordionButtonCancelOrder("Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.");
    }

    @Test
    public void questionAboutLiveFar()  {
        //  СКРОЛЛ СТРАНИЦЫ
        mainPage.scrollPageMainDown();
        // 8.Элемент "Я ЖИВУ ЗА МКАДОМ, ПРИВЕЗЁТЕ"
        mainPage.clickAccordionButtonLiveFar("Я жизу за МКАДом, привезёте?");
        mainPage.getAnswerAccordionButtonLiveFar("Да, обязательно. Всем самокатов! И Москве, и Московской области.");
    }


    @Test
    public void questionAllElements()  {
        mainPage.scrollPageDown();
        mainPage.seeAccordionButtonWhat();
        //проверить, что в МАССИВЕ с ВОПРОСАМИ действительно содержится один из вопросов
        String allQuestions =  mainPage.allElemQuestion();
        String someQuestion =  "Можно ли отменить заказ?";
       assertTrue(allQuestions.contains(someQuestion));
        //System.out.println(someQuestion);
        //System.out.println(allQuestions);

    }

    @After
    public void quitDriver() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
