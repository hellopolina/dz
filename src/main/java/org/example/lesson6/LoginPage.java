package org.example.lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BaseView{

    public LoginPage(WebDriver driver) {super(driver);}

    @FindBy(xpath = "//a[@href='#' and contains(text(), 'Войти')]")
    public WebElement buttonLogin;

    public LoginPage ckickButtonLogin() {
        buttonLogin.click();
        webDriverWait.until(
                ExpectedConditions.elementToBeClickable(By.id("LoginForm_email")));
        return this;
    }

    @FindBy(id = "LoginForm_email")
    public WebElement inputLogin;

    public LoginPage fillInputLogin(String login) {
        inputLogin.sendKeys(login);
        return this;
    }

    @FindBy(id = "LoginForm_password")
    public WebElement inputPassword;

    public LoginPage fillInputPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    @FindBy(xpath = "//button[contains(text(), 'Войти')]")
    public WebElement finishButton;

    public MainPage clickFinishButton() {
        finishButton.click();
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='text' and contains(text(), 'hello.p')]")));
        webDriverWait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='user-login-hint']")));
        return new MainPage(driver);
    }

    public void login(String login, String password) {
        ckickButtonLogin();
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        finishButton.click();
    }
}
