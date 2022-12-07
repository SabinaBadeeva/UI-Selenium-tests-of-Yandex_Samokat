
package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;
import java.util.List;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {

        this.driver = driver;
    }

    //локатор кнопки ЗАКАЗАТЬ №2
    private By orderButton = By.xpath(".//*[@id='root']/div/div[1]/div[4]/div[2]/div[5]/button");

    // 1.локаторы  ACCORDION BUTTON "СКОЛЬКО ЭТО СТОИТ?"
    public By accordionButtonWhatPrice = By.xpath(".//*[@id='accordion__heading-0']");
    private By answerQuestionWhatPrice = By.xpath(".//*[@id='accordion__panel-0']");

    // 2.локаторы  ACCORDION BUTTON "ХОЧУ СРАЗУ НЕСКОЛЬКО САМОКАТОВ"
    private By accordionButtonWantSome = By.xpath(".//*[@id='accordion__heading-1']");
    private By answerButtonWantSome = By.xpath(".//*[@id='accordion__panel-1']");

    // 3.локаторы  ACCORDION BUTTON "КАК РАССЧИТЫВАЕТСЯ ВРЕМЯ АРЕНДЫ?"
    private By accordionButtonTimeRental = By.xpath(".//*[@id='accordion__heading-2']");
    private By answerAccordionButtonTimeRental = By.xpath(".//*[@id='accordion__panel-2']");

    // 4.локаторы  ACCORDION BUTTON "МОЖНО ЗАКАЗАТЬ САМОКАТ СЕГОДНЯ"
    private By accordionButtonGetOrderNow = By.xpath(".//*[@id='accordion__heading-3']");
    private By answerAccordionButtonGetOrderNow = By.xpath(".//*[@id='accordion__panel-3']");

    // 5.локаторы  ACCORDION BUTTON "МОЖНО ЛИ ПРОДЛИТЬ ЗАКАЗ"
    private By accordionButtonExtendOrder = By.xpath(".//*[@id='accordion__heading-4']");
    private By answerAccordionButtonExtendOrder = By.xpath(".//*[@id='accordion__panel-4']");

    // 6.локаторы  ACCORDION BUTTON "ВЫ ПРИВОЗИТЕ ЗАРЯДКУ ВМЕСТЕ С САМОКАТОМ?"
    private By accordionButtonChargeWithScooter = By.xpath(".//*[@id='accordion__heading-5']");
    private By answerButtonChargeWithScooter = By.xpath(".//*[@id='accordion__panel-5']");

    // 7.локаторы  ACCORDION BUTTON "МОЖНО ЛИ ОТМЕНИТЬ ЗАКАЗ"
    private By accordionButtonCancelOrder = By.xpath(".//*[@id='accordion__heading-6']");
    private By answerButtonCancelOrder = By.xpath(".//*[@id='accordion__panel-6']");

    // 8.локаторы  ACCORDION BUTTON "Я ЖИВУ ЗА МКАДОМ, ПРИВЕЗЁТЕ"
    private By accordionButtonLiveFar = By.xpath(".//*[@id='accordion__heading-7']");
    private By answerButtonLiveFar = By.xpath(".//*[@id='accordion__panel-7']");

    //СПИСОК ВСЕХ ЭЛЕМЕНТОВ БЛОКА ВОПРОСЫ
    private By listAllQuestions = By.xpath("//div[@class='accordion']");

    //СКРОЛЛЫ СТРАНИЦЫ
    public void scrollPaigeMain() {
        WebElement element = driver.findElement
                (orderButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);}

    public void scrollPageMainDown() {
        WebElement element = driver.findElement
                (By.xpath(".//*[@id='accordion__heading-3']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);}
    public void scrollPageDownFive() {
        WebElement element = driver.findElement
                (By.xpath(".//*[@id='accordion__heading-5']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);}
    public void scrollPageDown() {
        WebElement element = driver.findElement
                (By.xpath(".//*[@id='accordion__heading-6']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);}

    public void scrollPageDownLast() {
        WebElement element = driver.findElement
                (By.xpath(".//*[@id='accordion__heading-7']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);}


    // методы для ACCORDION COMPONENT
    // 1.метод для элемента "СКОЛЬКО ЭТО СТОИТ?"
    public void clickAccordionButtonWhatPrice(String dataUpperText) {
        driver.findElement(accordionButtonWhatPrice).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.textToBePresentInElementLocated(accordionButtonWhatPrice, dataUpperText));}

    public void seeAccordionButtonWhat() {
        driver.findElement(accordionButtonWhatPrice);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(accordionButtonWhatPrice));}
    public void getAnswerQuestionWhatPrice(String dataText) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBePresentInElementLocated(answerQuestionWhatPrice, dataText));}


    // 2.метод для элемента "ХОЧУ НЕСКОЛЬКО САМОКАТОВ"
    public void clickAccordionButtonWantSome(String dataUpperTextTwo) {
        WebElement el = driver.findElement(accordionButtonWantSome);
        el.click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBePresentInElementLocated(accordionButtonWantSome, dataUpperTextTwo));}
    public void getAnswerButtonWantSome(String dataTextTwo) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBePresentInElementLocated(answerButtonWantSome, dataTextTwo));}


    // 3.метод для элемента "КАК РАССЧИТЫВАЕТСЯ ВРЕМЯ АРЕНДЫ?"
    public void clickAccordionButtonTimeRental(String dataUpperTextThree) {
        driver.findElement(accordionButtonTimeRental).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBePresentInElementLocated(accordionButtonTimeRental, dataUpperTextThree));}
    public void getAnswerButtonTimeRental(String dataTextThree) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBePresentInElementLocated(answerAccordionButtonTimeRental, dataTextThree));}


    // 4.метод для элемента "МОЖНО ЗАКАЗАТЬ САМОКАТ СЕГОДНЯ"
    public void clickAccordionButtonGetOrderNow(String dataUpperTextFour) {
        driver.findElement(accordionButtonGetOrderNow).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBePresentInElementLocated(accordionButtonGetOrderNow, dataUpperTextFour));}
    public void getAnswerAccordionButtonGetOrderNow(String dataTextFour) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBePresentInElementLocated(answerAccordionButtonGetOrderNow, dataTextFour));}

    // 5.метод для элемента "МОЖНО ЛИ ПРОДЛИТЬ ЗАКАЗ"
    public void clickAccordionButtonExtendOrder(String dataUpperTextFive) {
        driver.findElement(accordionButtonExtendOrder).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBePresentInElementLocated(accordionButtonExtendOrder, dataUpperTextFive));}
    public void getAnswerAccordionButtonExtendOrder(String dataTextFive) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBePresentInElementLocated(answerAccordionButtonExtendOrder, dataTextFive));}


    // 6.метод для элемента "ВЫ ПРИВОЗИТЕ ЗАРЯДКУ ВМЕСТЕ С САМОКАТОМ?"
    public void clickAccordionButtonChargeWithScooter(String dataUpperTextSix) {
        driver.findElement(accordionButtonChargeWithScooter).click();
        WebElement web = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(accordionButtonChargeWithScooter));
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBePresentInElementLocated(accordionButtonChargeWithScooter, dataUpperTextSix));}
    public void getAnswerButtonChargeWithScooter(String dataTextSix) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBePresentInElementLocated(answerButtonChargeWithScooter, dataTextSix));}


    // 7.метод для элемента "МОЖНО ЛИ ОТМЕНИТЬ ЗАКАЗ"
    public void clickAccordionButtonCancelOrder(String dataUpperTextSeven) {
        driver.findElement(accordionButtonCancelOrder).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBePresentInElementLocated(accordionButtonCancelOrder, dataUpperTextSeven));}
    public void getAnswerAccordionButtonCancelOrder(String dataTextSeven) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBePresentInElementLocated(answerButtonCancelOrder, dataTextSeven));}

    // 8.метод для элемента "Я ЖИВУ ЗА МКАДОМ, ПРИВЕЗЁТЕ"
    public void clickAccordionButtonLiveFar(String dataUpperTextEight) {
        driver.findElement(accordionButtonLiveFar).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBePresentInElementLocated(accordionButtonLiveFar, dataUpperTextEight));}
    public void getAnswerAccordionButtonLiveFar(String dataTextEight) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBePresentInElementLocated(answerButtonLiveFar, dataTextEight));}}




