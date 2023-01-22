package ru.iteco.fmhandroid.ui.steps;

import android.os.SystemClock;
import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.NewsControlPanelElements;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;

public class NewsControlPanelSteps {
    NewsControlPanelElements NewsControlPanel = new NewsControlPanelElements();

    public void isControlPanelScreen() {
        Allure.step("Проверить, что это oкно Панели управления новостями");
        NewsControlPanel.controlPanelScreen.check(matches(isDisplayed()));
    }

    public void sortNews() {
        Allure.step("Нажать кнопку сортировка новостей");
        NewsControlPanel.sort.perform(click());
    }

    public void filterNews() {
        Allure.step("Нажать кнопку фильтр новостей");
        NewsControlPanel.filter.perform(click());
        NewsControlPanel.filterScreen.check(matches(isDisplayed()));
    }

    public void activeNews() {
        Allure.step("Выбор активных новостей на Панеле управлений новостями");
        NewsControlPanel.notActiveNews.perform(click());
    }

    public void notActiveNews() {
        Allure.step("Выбор неактивных новостей на Панеле управлений новостями");
        NewsControlPanel.activeNews.perform(click());
    }

    public void deleteNews() {
        Allure.step("Нажать на кнопку удалить новость");
        NewsControlPanel.deleteButton.perform(click());
    }

    public void checkPopUpOk() {
        Allure.step("Проверить наличие всплывающей кнопки OK");
        NewsControlPanel.popUpOk.perform(click());
    }

    public void createNews() {
        Allure.step("Нажать кнопку создания новости");
        NewsControlPanel.create.perform(click());
        NewsControlPanel.creatingScreen.check(matches(isDisplayed()));
    }

    public void selectCategory(String text) {
        Allure.step("Выбрать категорию для создания новости");
        NewsControlPanel.category.perform(click());
        NewsControlPanel.category.perform(replaceText(text));
    }

    public void enterTitle(String text) {
        Allure.step("Ввеод заголовка");
        NewsControlPanel.createTitle.perform(replaceText(text));
    }
    public void expandNews() {
        Allure.step("Развернуть новость");
        NewsControlPanel.buttonExpand.perform(click());
    }

    public void checkExpandNews() {
        Allure.step("Проверить открывшуюся новость");
        NewsControlPanel.description.check(matches(isDisplayed()));
    }

    public void saveButton() {
        Allure.step("Нажать на кнопку сохранить");
        NewsControlPanel.saveButton.perform(click());
        SystemClock.sleep(1500);
    }

    public void cancelButton() {
        Allure.step("Нажать на кнопку отменить");
        NewsControlPanel.cancelButton.perform(click());
    }

    public void filterButton() {
        Allure.step("Нажать на кнопку фильтр");
        NewsControlPanel.filterButton.perform(click());
    }

    public void editNews() {
        Allure.step("Нажать на кнопку редактировать новость");
        NewsControlPanel.editButton.perform(click());
        NewsControlPanel.editingScreen.check(matches(isDisplayed()));
    }

    public void enterEditTitle(String title) {
        Allure.step("Ввод отредактированного текста заголовка");
        NewsControlPanel.createTitle.perform(replaceText(title));
    }

    public void enterDate(String date) {
        Allure.step("Ввод даты");
        NewsControlPanel.date.perform(replaceText(date));
    }

    public void enterTime(String time) {
        Allure.step("Ввод времени");
        NewsControlPanel.time.perform(replaceText(time));
    }

    public void enterDescription(String description) {
        Allure.step("Ввод описания");
        NewsControlPanel.createDescription.perform(replaceText(description));
    }

    public void editStatus() {
        Allure.step("Изменить статус");
        NewsControlPanel.buttonStatus.perform(click());
    }

    public void checkStatusNotActive() {
        Allure.step("Проверить, что статус Не активный");
        NewsControlPanel.newsStatusNotActive.check(matches(isDisplayed()));
    }

    public void checkStatusActive() {
        Allure.step("Проверить, что статус Активный");
        NewsControlPanel.newsStatusActive.check(matches(isDisplayed()));
    }
}
