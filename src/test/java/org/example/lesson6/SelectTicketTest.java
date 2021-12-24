package org.example.lesson6;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.common.IsElementDisplayedMatcher.isDisplayed;

public class SelectTicketTest extends BaseTest{

    @Test
    void SelectTicket() {
        driver.get("https://spb.kassir.ru/");

        new LoginPage(driver)
                .ckickButtonLogin()
                .fillInputLogin("hello.polina-LA@yandex.ru")
                .fillInputPassword("!QAZ1qaz")
                .clickFinishButton();

        new MainPage(driver)
                .clickNewYearTab()
                .clickBallet();

        new BalletPage(driver)
                .clickBuyTicketButton()
                .clickSelectSeat()
                .clickSelectOnScheme()
                .clickCheckoutButton();

        assertThat(new BasketPage(driver).SelectedSeat, isDisplayed());
    }
}
