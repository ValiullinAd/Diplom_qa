package ru.iteco.fmhandroid.ui.steps;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.NewsElements;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

public class NewsSteps {
    NewsElements News = new NewsElements();

    public void isNewsScreen() {
        Allure.step("Проверить, что это oкно новостей");
        News.newsScreen.check(matches(isDisplayed()));
    }

    public void sortNews() {
        Allure.step("Нажать кнопку сортировки новостей");
        News.sort.perform(click());
    }

    public void filterNews() {
        Allure.step("Нажать кнопку фильтрации");
        News.filter.perform(click());
    }

    public void editNews() {
        Allure.step("Нажать кнопку редактирования");
        News.edit.perform(click());
    }

    public void isFilterScreen() {
        Allure.step("Проверить, что это окно новостей");
        News.filterScreen.check(matches(isDisplayed()));
    }

    public void selectFilterCategory(String text) {
        Allure.step("Выбрать категорию фильтрации");
        News.category.perform(click());
        News.category.perform(replaceText(text));
    }

    public void applyNews() {
        Allure.step("Подтверждение фильтрации новостей");
        News.applyNews.perform(click());
    }
}

