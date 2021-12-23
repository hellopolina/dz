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

public class BuyTicketSportTest {
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
    void AddingTicketToCart() throws InterruptedException {
        //Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(text(), 'Спорт')]")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(), 'Спорт в Санкт-Петербурге')]")));
        driver.findElement(By.xpath("//a[contains(text(), 'Волейбол ВФВ 2021')]")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-target='.buy-block']")));
        driver.findElement(By.xpath("//a[@data-target='.buy-block']")).click();
        Thread.sleep(2000);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[@id='sector_8506275']/td[@class='col-buy']/a")));
        driver.findElement(By.xpath("//tbody/tr[@id='sector_8506275']/td[@class='col-buy']/a")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("polygon:nth-child(9)")));
        driver.findElement(By.cssSelector("polygon:nth-child(9)")).click();
        driver.findElement(By.xpath("//div[@class='legend']/a[contains(text(), 'Оформить заказ')]")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='js_head_basket_toggle']")));
        driver.findElement(By.xpath("//a[@id='js_head_basket_toggle']")).click();
        driver.findElement(By.xpath("//div[@class='buttons']//a[@href='/cart' and contains(text(), 'Оформить заказ')]")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='heading']/span[contains(text(), 'Билеты')]")));

        WebElement successfulElement = driver.findElement(By.xpath("//div[@class='seat' and contains(text(), '205, Ряд 20, Место 101')]"));
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