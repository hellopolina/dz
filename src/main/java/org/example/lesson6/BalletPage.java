package org.example.lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BalletPage extends BaseView{

    public BalletPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@data-target='.buy-block']")
    public WebElement buyTicketButton;

    @Step("Нажать на кнопку Купить Билет")
    public BalletPage clickBuyTicketButton() {
        buyTicketButton.click();
        return this;
    }

    @FindBy(xpath = "//a[contains(text(), 'Выбрать места')]")
    public WebElement selectSeat;

    @Step("Нажать на кнопку Выбрать места")
    public BalletPage clickSelectSeat() {
        selectSeat.click();
        return this;
    }

    @FindBy(css = "polygon:nth-child(1628)")
    public WebElement selectOnScheme;

    @Step("Выбрать место на схеме")
    public BalletPage clickSelectOnScheme() {
        selectSeat.click();
        return this;
    }

    @FindBy(xpath = "//div[@class='legend']/a[contains(text(), 'Оформить заказ')]")
    public WebElement checkoutButton;

    @Step("Нажать на кнопку Оформить заказ")
    public BasketPage clickCheckoutButton() {
        checkoutButton.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='heading']/span[contains(text(), 'Билеты')]")));
        return new BasketPage(driver);
    }
}
