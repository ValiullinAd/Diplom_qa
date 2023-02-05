package ru.iteco.fmhandroid.ui.steps;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.MainElements;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

public class MainSteps {
    MainElements main = new MainElements();

    public void isMainScreen() {
        Allure.step("Проверить, что это главное окно");
        main.allClaims.check(matches(isDisplayed()));
        main.allNews.check(matches(isDisplayed()));
    }
    public void clickButtonAllNews(){
        Allure.step("Переход на вкладку ВСЕ НОВОСТИ");
        main.allNews.perform(click());
        main.newsScreen.check(matches(isDisplayed()));
    }

    public void clickButtonAllClaims(){
        Allure.step("Переход на вкладку ВСЕ ЗАЯВКИ");
        main.allClaims.perform(click());
        main.claimsScreen.check(matches(isDisplayed()));
    }

    public void openClaims() {
        Allure.step("Переход в меню вкладки Заявки");
        main.mainMenuButton.perform(click());
        main.claims.perform(click());
        main.claimsScreen.check(matches(isDisplayed()));
    }

    public void openNews() {
        Allure.step("Переход в меню вкладки Новости");
        main.mainMenuButton.perform(click());
        main.news.perform(click());
        main.newsScreen.check(matches(isDisplayed()));
    }

    public void openAbout() {
        Allure.step("Переход в меню вкладки О приложении");
        main.mainMenuButton.perform(click());
        main.about.perform(click());
        main.aboutScreen.check(matches(isDisplayed()));
    }
    public void logOut() {
        Allure.step("Выход из приложения");
        main.profile.perform(click());
        main.logOut.perform(click());
        main.authScreen.check(matches(isDisplayed()));
    }
}
