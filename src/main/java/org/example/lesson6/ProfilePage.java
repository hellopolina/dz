package org.example.lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfilePage extends BaseView {

    //public static String successfulEditingElement;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//li/a[@href='user/profile' and contains(text(), 'Профиль')]")
    public WebElement tabProfile;

    @Step("Открыть вкладку Профиль")
    public ProfilePage clickTabProfile() {
        tabProfile.click();
        return this;
    }

    @FindBy(xpath = "//input[@name='User[address_street]']")
    public WebElement addressStreet;

    @Step("Указать улицу")
    public ProfilePage fillAddressStreet(String street) {
        addressStreet.sendKeys(street);
        return this;
    }

    @FindBy(xpath = "//input[@name='User[address_house]']")
    public WebElement addressHouse;

    @Step("Указать дом")
    public ProfilePage fillAddressHouse(String house) {
        addressHouse.sendKeys(house);
        return this;
    }

    @FindBy(xpath = "//input[@value='Сохранить изменения']")
    public WebElement saveButton;

    @Step("Сохранить изменения")
    public ProfilePage clickSaveButton() {
        saveButton.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@data-dismiss='alert']")));
        return this;
    }

    @FindBy(xpath = "//a[@data-dismiss='alert']")
    public static WebElement finalEditing;

    public static String successfulEditingElement = finalEditing.getText();
}
