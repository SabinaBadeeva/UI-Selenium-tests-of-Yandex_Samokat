import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogoSamocat {
    private WebDriver driver;

    public LogoSamocat(WebDriver driver) {

        this.driver = driver;
    }

    private By headerLogoScooter = By.cssSelector("a.Header_LogoScooter__3lsAR > img");

    // метод проверяет ВИДИМОСТЬ ЛОГОТИПА
    public void isDisplayedClickLogo() {
        WebElement logoPresent = driver.findElement(headerLogoScooter);
        if (driver.findElement(By.cssSelector("a.Header_LogoScooter__3lsAR > img")).isDisplayed()) {
            driver.findElement(By.cssSelector("a.Header_LogoScooter__3lsAR > img")).click();}
    }
    //метод проверяет -  содержит ли URL главной страницы определенный текст
    public void forUrlContains(String text) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.urlContains(text));
    }
    //метод проверяет - данный URL является URL главной страницы
    public void  urlIsUrlMaim(String urlMain){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(urlMain));

    }
}

