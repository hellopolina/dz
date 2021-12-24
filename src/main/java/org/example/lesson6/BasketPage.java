package org.example.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends BaseView{

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='seat' and contains(text(), 'ДК им. Ленсовета, Амфитеатр')]")
    public WebElement SelectedSeat;
}
