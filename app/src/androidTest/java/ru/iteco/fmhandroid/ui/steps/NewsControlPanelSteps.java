package ru.iteco.fmhandroid.ui.steps;

import android.os.SystemClock;
import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.NewsControlPanelElements;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;

public class NewsControlPanelSteps {
    NewsControlPanelElements newsControlPanel = new NewsControlPanelElements();

    public void isControlPanelScreen() {
        Allure.step("Проверить, что это oкно Панели управления новостями");
        newsControlPanel.controlPanelScreen.check(matches(isDisplayed()));
    }

    public void sortNews() {
        Allure.step("Нажать кнопку сортировка новостей");
        newsControlPanel.sort.perform(click());
    }

    public void filterNews() {
        Allure.step("Нажать кнопку фильтр новостей");
        newsControlPanel.filter.perform(click());
        newsControlPanel.filterScreen.check(matches(isDisplayed()));
    }

    public void activeNews() {
        Allure.step("Выбор активных новостей на Панеле управлений новостями");
        newsControlPanel.notActiveNews.perform(click());
    }

    public void notActiveNews() {
        Allure.step("Выбор неактивных новостей на Панеле управлений новостями");
        newsControlPanel.activeNews.perform(click());
    }

    public void deleteNews() {
        Allure.step("Нажать на кнопку удалить новость");
        newsControlPanel.deleteButton.perform(click());
    }

    public void checkPopUpOk() {
        Allure.step("Проверить наличие всплывающей кнопки OK");
        newsControlPanel.popUpOk.perform(click());
    }

    public void createNews() {
        Allure.step("Нажать кнопку создания новости");
        newsControlPanel.create.perform(click());
        newsControlPanel.creatingScreen.check(matches(isDisplayed()));
    }

    public void selectCategory(String text) {
        Allure.step("Выбрать категорию для создания новости");
        newsControlPanel.category.perform(click());
        newsControlPanel.category.perform(replaceText(text));
    }

    public void enterTitle(String text) {
        Allure.step("Ввеод заголовка");
        newsControlPanel.createTitle.perform(replaceText(text));
    }
    public void expandNews() {
        Allure.step("Развернуть новость");
        newsControlPanel.buttonExpand.perform(click());
    }

    public void checkExpandNews() {
        Allure.step("Проверить открывшуюся новость");
        newsControlPanel.description.check(matches(isDisplayed()));
    }

    public void saveButton() {
        Allure.step("Нажать на кнопку сохранить");
        newsControlPanel.saveButton.perform(click());
        SystemClock.sleep(1500);
    }

    public void cancelButton() {
        Allure.step("Нажать на кнопку отменить");
        newsControlPanel.cancelButton.perform(click());
    }

    public void filterButton() {
        Allure.step("Нажать на кнопку фильтр");
        newsControlPanel.filterButton.perform(click());
    }

    public void editNews() {
        Allure.step("Нажать на кнопку редактировать новость");
        newsControlPanel.editButton.perform(click());
        newsControlPanel.editingScreen.check(matches(isDisplayed()));
    }

    public void enterEditTitle(String title) {
        Allure.step("Ввод отредактированного текста заголовка");
        newsControlPanel.createTitle.perform(replaceText(title));
    }

    public void enterDate(String date) {
        Allure.step("Ввод даты");
        newsControlPanel.date.perform(replaceText(date));
    }

    public void enterTime(String time) {
        Allure.step("Ввод времени");
        newsControlPanel.time.perform(replaceText(time));
    }

    public void enterDescription(String description) {
        Allure.step("Ввод описания");
        newsControlPanel.createDescription.perform(replaceText(description));
    }

    public void editStatus() {
        Allure.step("Изменить статус");
        newsControlPanel.buttonStatus.perform(click());
    }

    public void checkStatusNotActive() {
        Allure.step("Проверить, что статус Не активный");
        newsControlPanel.newsStatusNotActive.check(matches(isDisplayed()));
    }

    public void checkStatusActive() {
        Allure.step("Проверить, что статус Активный");
        newsControlPanel.newsStatusActive.check(matches(isDisplayed()));
    }
}
