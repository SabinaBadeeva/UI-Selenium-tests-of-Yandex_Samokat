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
        this.driver = driver;}

    //локатор ЛОГОТИПА САМОКАТ
    private By headerLogoScooter = By.cssSelector("a.Header_LogoScooter__3lsAR > img");

    // метод если ЛОГОТИП ВИДЕН,тогда КЛИКАЕМ по нему
    public void headerLogoScooterIsClick(){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(headerLogoScooter)).click();}

    // метод получения текста ЛОГОТИПА
   public String logoGetLogo(){
       String logoPageTitle=driver.findElement(By.cssSelector("a.Header_LogoScooter__3lsAR")).getAttribute("href");
       return logoPageTitle;}

    //метод проверяет - данный URL является URL главной страницы
    public void  urlIsUrlMaim(String urlMain){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(urlMain));}
}

