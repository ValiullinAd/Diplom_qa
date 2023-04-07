package ru.iteco.fmhandroid.ui.steps;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.NewsElements;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import org.hamcrest.Matchers;

public class NewsSteps {
    NewsElements news = new NewsElements();

    public void isNewsScreen() {
        Allure.step("Проверить, что это oкно новостей");
        news.newsScreen.check(matches(isDisplayed()));
    }

    public void sortNews() {
        Allure.step("Нажать кнопку сортировки новостей");
        news.sort.perform(click());
    }

    public void filterNews() {
        Allure.step("Нажать кнопку фильтрации");
        news.filter.perform(click());
    }

    public void editNews() {
        Allure.step("Нажать кнопку редактирования");
        news.edit.perform(click());
    }

    public void isFilterScreen() {
        Allure.step("Проверить, что это окно новостей");
        news.filterScreen.check(matches(isDisplayed()));
    }

    public void selectFilterCategory(String text) {
        Allure.step("Выбрать категорию фильтрации");
        news.category.perform(click());
        news.category.perform(replaceText(text));
    }

    public void applyNews() {
        Allure.step("Подтверждение фильтрации новостей");
        news.applyNews.perform(click());
    }

    public void fillEmptyField(){
        Allure.step("Проверка пустых полей");
        onView(Matchers.allOf(withContentDescription("Fill empty fields"), isDisplayed()));
    }
    public void checkCreation(){
        Allure.step("Проверка созданной новости");
        news.checkCreationNews.check(matches(isDisplayed()));
    }
    public void dateCreatingNews(){
        Allure.step("Выбор даты");
        news.dateCreating.perform(click());
    }
    public void timeCreatingNews(){
        Allure.step("Выбор времени");
        news.timeCreation.perform(click());
    }
    public void clickNewsOkButton(){
        Allure.step("Нажать кнопку ОК Дата");
        news.okButtonClick.perform(click());
    }
    public void checkAutoFilter(){
        Allure.step("Проверка после фильтрации");
        news.autoFilter.check(matches(isDisplayed()));
    }

}

