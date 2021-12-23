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

public class CreateRequestTest {
    static WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
        loginToCrm();
    }

    @Test
    void checkChanges() throws InterruptedException {
        driver.get("https://crm.geekbrains.space/expense-request/");
        driver.findElement(By.xpath("//a[@title='Создать заявку на расход']")).click();

        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("crm_expense_request[description]")));
        driver.findElement(By.name("crm_expense_request[description]")).sendKeys("test");

        //Выбор параметров в выпадающих списках
        Select businessUnitSelect = new Select(driver.findElement(By.name("crm_expense_request[businessUnit]")));
        businessUnitSelect.selectByVisibleText("Research & Development");
        Select expenditureSelect = new Select(driver.findElement(By.name("crm_expense_request[expenditure]")));
        expenditureSelect.selectByVisibleText("01101 - ОС: вычислительная техника инфраструктуры");
        Select crm_expense_requestSelect = new Select(driver.findElement(By.name("crm_expense_request[currency]")));
        crm_expense_requestSelect.selectByVisibleText("Российский рубль");
        //Thread.sleep(5000);
        Select crm_expense_request_divisionSelect = new Select(driver.findElement(By.name("crm_expense_request[division]")));
        crm_expense_request_divisionSelect.selectByVisibleText("Аплана Софтвер");
        //Ввод числа в поле
        driver.findElement(By.name("crm_expense_request[sumPlan]")).sendKeys("100");
        driver.findElement(By.xpath("//input[contains(@id, 'date_selector_crm_expense_request_datePlan')]")).click();
        driver.findElement(By.xpath("//a[contains(text(), '11')]")).click();
//        Вынесем получение данной кнопки в проверку
//        driver.findElement(By.xpath("//button[contains(text(), 'Сохранить и закрыть')]")).click();

        WebElement successfulElement = driver.findElement(By.xpath("//button[contains(text(), 'Сохранить и закрыть')]"));
        Assertions.assertEquals("Сохранить и закрыть", successfulElement.getText());
    }

    @AfterAll
    static void tearDown() {
        driver.quit();}

    public static void loginToCrm() {
        driver.get("https://crm.geekbrains.space/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.xpath("//button")).click();
    }
}
