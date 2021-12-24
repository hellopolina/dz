package org.example.lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.common.IsElementDisplayedMatcher.isDisplayed;

public class EditingProfileTest extends BaseTest{

    @Test
    void editing() {
        driver.get("https://spb.kassir.ru/");

        new LoginPage(driver)
                .ckickButtonLogin()
                .fillInputLogin("hello.polina-LA@yandex.ru")
                .fillInputPassword("!QAZ1qaz")
                .clickFinishButton();

        new MainPage(driver)
                .clickOpenProfile();

        new ProfilePage(driver)
                .clickTabProfile()
                .fillAddressStreet("Тестовая улица")
                .fillAddressHouse("25")
                .clickSaveButton();

        Assertions.assertEquals("Ваш профиль успешно изменен!", ProfilePage.successfulEditingElement);
    }

}
