package org.example.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SuccessfulLoginTest {
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
    }

    @Test
    void SuccessAutorisation() throws InterruptedException {
        driver.get("https://spb.kassir.ru/");
        driver.findElement(By.xpath("//a[@href='#' and contains(text(), 'Войти')]")).click();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("LoginForm_email")));
        driver.findElement(By.id("LoginForm_email")).sendKeys("hello.polina-LA@yandex.ru");
        driver.findElement(By.id("LoginForm_password")).sendKeys("!QAZ1qaz");
        driver.findElement(By.xpath("//button[contains(text(), 'Войти')]")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='text' and contains(text(), 'hello.p')]")));

        WebElement successfulElement = driver.findElement(By.xpath("//span[@class='text' and contains(text(), 'hello.p')]"));
        Assertions.assertEquals("hello.polina-la@yandex.ru", successfulElement.getText());
    }
}
