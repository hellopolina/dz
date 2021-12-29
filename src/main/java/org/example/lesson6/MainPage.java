package org.example.lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BaseView{

    public MainPage(WebDriver driver) {
        super(driver);}

    @FindBy(xpath = "//span[@class='text' and contains(text(), 'hello.p')]")
    public WebElement successfulAutorisation;

    @FindBy(xpath = "//div[@id='user-login-hint']")
    public WebElement openProfile;

    @Step("Открыть вкладку Профиль")
    public ProfilePage clickOpenProfile() {
        openProfile.click();
        webDriverWait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//div/a[@href='/user/profile' and contains(text(), 'Профиль')]")));
        return new ProfilePage(driver);
    }

    @FindBy(xpath = "//a[contains(text(), 'Новый год')]")
    public WebElement newYearTab;

    @Step("Открыть вкладку Новый Год")
    public MainPage clickNewYearTab() {
        newYearTab.click();
        return this;
    }

    @FindBy(xpath = "//a[contains(text(), 'Балет Щелкунчик')]")
    public WebElement ballet;

    @Step("Перейти на страницу про Щелкунчика")
    public BalletPage clickBallet() {
        ballet.click();
        return new BalletPage(driver);
    }
}
