package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginKassir {
    private static WebDriver driver;

    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);

            driver.get("https://spb.kassir.ru/");
            driver.findElement(By.xpath("//a[@href='#' and contains(text(), 'Войти')]")).click();
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("LoginForm_email")));
            driver.findElement(By.id("LoginForm_email")).sendKeys("hello.polina-LA@yandex.ru");
            driver.findElement(By.id("LoginForm_password")).sendKeys("!QAZ1qaz");
            driver.findElement(By.xpath("//button[contains(text(), 'Войти')]")).click();
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='text' and contains(text(), 'hello.p')]")));
        }

}
