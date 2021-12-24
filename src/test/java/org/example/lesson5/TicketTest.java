package org.example.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.common.IsElementDisplayedMatcher.isDisplayed;

public class TicketTest {
    static WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 10);
        loginKassir();
    }

    @Test
    void checkChanges(){
        driver.findElement(By.xpath("//a[contains(text(), 'Новый год')]")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(), 'Балет Щелкунчик')]")));
        driver.findElement(By.xpath("//a[contains(text(), 'Балет Щелкунчик')]")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-target='.buy-block']")));
        driver.findElement(By.xpath("//a[@data-target='.buy-block']")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Выбрать места')]")));
        driver.findElement(By.xpath("//a[contains(text(), 'Выбрать места')]")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("polygon:nth-child(1628)")));
        driver.findElement(By.cssSelector("polygon:nth-child(1628)")).click();
        driver.findElement(By.xpath("//div[@class='legend']/a[contains(text(), 'Оформить заказ')]")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='js_head_basket_toggle']")));
        driver.findElement(By.xpath("//a[@id='js_head_basket_toggle']")).click();
        driver.findElement(By.xpath("//div[@class='buttons']//a[@href='/cart' and contains(text(), 'Оформить заказ')]")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='heading']/span[contains(text(), 'Билеты')]")));

        WebElement successfulElement = driver.findElement(By.xpath("//div[@class='seat' and contains(text(), 'ДК им. Ленсовета, Амфитеатр')]"));
        assertThat(successfulElement, isDisplayed());
    }

    public static void loginKassir(){
        driver.get("https://spb.kassir.ru/");
        driver.findElement(By.xpath("//a[@href='#' and contains(text(), 'Войти')]")).click();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("LoginForm_email")));
        driver.findElement(By.id("LoginForm_email")).sendKeys("hello.polina-LA@yandex.ru");
        driver.findElement(By.id("LoginForm_password")).sendKeys("!QAZ1qaz");
        driver.findElement(By.xpath("//button[contains(text(), 'Войти')]")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='text' and contains(text(), 'hello.p')]")));

    }

}