package org.example.lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.common.IsElementDisplayedMatcher.isDisplayed;

public class AutorisationTest extends BaseTest{

    @Test
    void login() {
        driver.get("https://spb.kassir.ru/");
        new LoginPage(driver)
                .ckickButtonLogin()
                .fillInputLogin("hello.polina-LA@yandex.ru")
                .fillInputPassword("!QAZ1qaz")
                .clickFinishButton();

        assertThat(new MainPage(driver).successfulAutorisation, isDisplayed());

    }
}
