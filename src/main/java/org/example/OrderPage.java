package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class OrderPage {

    private WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //  1. локаторы  для страницы АВТОРИЗАЦИИ
    //локатор кнопки "Заказать ВВЕРХУ HEADER"
    private By orderButtonHeader = By.xpath("//*[@id='root']/div/div/div[1]/div[2]/button[1]");
    //локатор кнопки "Заказать №2"
    private By orderButtonTwo = By.xpath(".//*[@id='root']/div/div[1]/div[4]/div[2]/div[5]/button");
    // локатор поля ввода «Имя»
    private By nameField = By.xpath(".//div/div[2]/div[2]/div[1]/input");
    // локатор поля ввода «Фамилия»
    private By secondNameField = By.xpath(".//div/div[2]/div[2]/div[2]/input");
    // локатор поля ввода «Адресс»
    private By addressField = By.xpath(".//div/div[2]/div[2]/div[3]/input");
    // локаторы поля  «Станция метро»
    private By metroStationSelect = By.cssSelector("div.Order_Form__17u6u > div:nth-child(4) > div > div > input");
    private By metroStList = By.tagName("li");
    private By certainMetroSt = By.xpath(".//li[@data-value='3']");
    // локатор поля ввода «Телефон»
    private By telNumberInput = By.xpath(".//div/div[2]/div[2]/div[5]/input");
    // локатор кнопки "Далее"
    private By nextButton = By.xpath(".//*[@id='root']/div/div[2]/div[3]/button");
    //локатор POP-UP СТАТУС ЗАКАЗА
    private By orderPopUp = By.className("Order_ModalHeader__3FDaJ");
    //локатор заголовка ПРО АРЕНДУ
    private By aboutRental = By.xpath(".//*[@id='root']/div/div[2]/div[1]");


    //МЕТОДЫ для АВТОРИЗАЦИИ
    public void setUsername(String username) {
        driver.findElement(nameField).sendKeys(username);
    }
    public void setSecondNameField(String secondName) {
        driver.findElement(secondNameField).sendKeys(secondName);
    }
    public void setAddressField(String address) {
        driver.findElement(addressField).sendKeys(address);
    }
    //МЕТОД ЗАПОЛНЕНИЯ полей ИМЯ,ФАМИЛИЯ,АДРЕС
    public void login(String username, String secondName, String address) {
        setUsername(username);
        setSecondNameField(secondName);
        setAddressField(address);}

    //методы для МЕТРО
    public void clickMetroStInput() {
        driver.findElement(metroStationSelect).click();
    }
    public void choiceMetroStList() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(metroStList));}
    public void clickCertainMetro() {
        driver.findElement(certainMetroSt).click();
    }
    public void choiceMetro() {
        clickMetroStInput();
        choiceMetroStList();
        clickCertainMetro();}

    //метод выбора метро для ПАРАМЕТРИЗОВАННОГО теста
    public void choiceKeysMetro(String metroStation) {
        WebElement metro = driver.findElement(By.cssSelector("div.Order_Form__17u6u > div:nth-child(4) > div > div > input"));
        metro.sendKeys(metroStation);
        metro.sendKeys(Keys.DOWN, Keys.ENTER);}

    // метод ввода поля ТЕЛЕФОН
    public void inputTelNumber(String telNumber) {
        driver.findElement(telNumberInput).sendKeys(telNumber);
    }

    //МЕТОД ожидания ЗАГРУЗКИ внесенных ДАННЫХ
    public void waitForLoadProfileData() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(driver -> (driver.findElement(nextButton).getText() != null
                && !driver.findElement(nextButton).getText().isEmpty()));}

    //МЕТОДЫ для КНОПОК
    public void pushButtonHeader() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(orderButtonHeader)).click();}
    public void pushOrderButtonTwo() {
        driver.findElement(orderButtonTwo).click();}
    public void setNextButton() {
        driver.findElement(nextButton).click();}


    //  2. ЛОКАТОРЫ для СТРАНИЦЫ "ПРО АРЕНДУ"
    //локаторы поля КОГДА ПРИВЕЗТИ самокат (КАЛЕНДАРЬ)
    private By whenToDeliverScooterField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //локатор поля СРОК АРЕНДЫ
    private By rentalPeriod = By.className("Dropdown-root");
    private final String dayRental = ".//div[text()='%s']";
    //локатор выбора ЦВЕТ САМОКАТА
    private By checkBoxScooter = By.className("Order_Title__3EKne");
    private By checkBoxColor = By.xpath(".//*[@id='black']");
    //локатор поля КОММЕНТАРИЙ для КУРЬЕРА
    private By commentForCourier = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    // локатор кнопки ЗАКАЗАТЬ на странице "ПРО АРЕНДУ"
    private By getOrder = By.xpath(".//*[@id='root']/div/div[2]/div[3]/button[2]");
    // локатор кнопки ХОТИТЕ ОФОРМИТЬ ЗАКАЗ "ДА"
    private By buttonOrderYes = By.xpath(".//button[text()='Да']");
    // POP-UP "ЗАКАЗ ОФОРМЛЕН
    private By popUpOrder = By.className("Order_ModalHeader__3FDaJ");

    //ОЖИДАНИЕ прогрузки ДАННЫХ ЗАКАЗА
    public void waitForLoadOrderData() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(driver -> (driver.findElement(getOrder).getText() != null
                && !driver.findElement(getOrder).getText().isEmpty()));}

    //МЕТОДЫ для страницы "ПРО АРЕНДУ"
    //метод выбора "ДАТЫ в КАЛЕНДАРЕ"
    public void choiceDataCalendarDeliverField(String data, String month, String year) {
        WebElement element = driver.findElement(whenToDeliverScooterField);
        element.click();
        element.sendKeys(data, month, year);
        element.sendKeys(Keys.ENTER);}
    public void choiceDataCalendDeliverField(String data) {
        WebElement element = driver.findElement(whenToDeliverScooterField);
        element.click();
        element.sendKeys(data);
        element.sendKeys(Keys.ENTER);}
    public void choiceDataString(String data) {
        choiceDataCalendDeliverField(data);}

    //метод выбора поля "СРОК АРЕНДЫ"
    public void setRentalPeriod() {
        driver.findElement(rentalPeriod).click();}
    public void daysOrderChoice(String daysRental) {
        driver.findElement(By.xpath(String.format(dayRental, daysRental))).click();}
    public void clickDropDownRental(String daysRental) {
        setRentalPeriod();
        daysOrderChoice(daysRental);}

    //метод выбора CHECKBOX SCOOTER
    public void choiceCheckBoxScooter() {
        driver.findElement(checkBoxScooter).click();}
    public void clickCheckBoxColor() {
        driver.findElement(checkBoxColor).click();}
    public void clickCheckBoxColorScooter() {
        choiceCheckBoxScooter();
        clickCheckBoxColor();}

    //метод поля КОММЕНТАРИЙ для КУРЬЕРА
    public void fillCommentForCourier(String comment) {
        driver.findElement(commentForCourier).sendKeys(comment);}
    public void commentForCourier(String comment) {
        fillCommentForCourier(comment);}

    //метод кнопки ЗАКАЗАТЬ на стр. ПРО АРЕНДУ
    public void clickGetOrder() {
        driver.findElement(getOrder).click();}

    //метод кнопки ХОТИТЕ СДЕЛАТЬ ЗАКАЗ "ДА"
    public void clickButtonOrderYes() {
        driver.findElement(buttonOrderYes).click();}

    //  проверка СТАТУСА ЗАКАЗА
    public void statusOfOrder(String popUpText) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBePresentInElementLocated(orderPopUp, popUpText));
    }

    public void popUpOfOrderVisible(){
    new WebDriverWait(driver, Duration.ofSeconds(5))
            .until(ExpectedConditions. visibilityOfElementLocated(orderPopUp));
    }

}








