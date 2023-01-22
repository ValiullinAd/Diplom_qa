package ru.iteco.fmhandroid.ui.steps;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.ClaimsElements;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import android.os.SystemClock;

public class ClaimsSteps {
    ClaimsElements Claims = new ClaimsElements();

    public void isClaimsScreen() {
        Allure.step("Проверить, что это экно заявок");
        Claims.claimsScreen.check(matches(isDisplayed()));
    }

    public void filter() {
        Allure.step("Открыть фильтр");
        Claims.openFilter.perform(click());
    }

    public void open() {
        Allure.step("Открыть заявку");
        Claims.openFirstClaim.perform(click());
    }

    public void goBack() {
        Allure.step("Возврат из открытой заявки");
        Claims.closeClaim.perform(click());
    }

    public void isFilteringScreen() {
        Allure.step("Проверить, что это окно фильтрации заявок");
        Claims.filterScreen.check(matches(isDisplayed()));
    }

    public void removeCheckBoxOpen() {
        Allure.step("Снять флажок с чекбокса Открыта");
        Claims.checkBoxOpen.perform(click());
    }

    public void removeCheckBoxInProgress() {
        Allure.step("Снять флажок с чекбокса В работе");
        Claims.checkBoxInProgress.perform(click());
    }
    public void executedCheck() {
        Allure.step("Фильтрация заявок по критерию Выполнена");
        Claims.executed.perform(click());
    }
    public void cancelledCheck() {
        Allure.step("Фильтрация заявок по критерию Отмененные");
        Claims.cancelled.perform(click());
    }
    public void applyClaims() {
        Allure.step("Подтверждение фильтрации заявок");
        Claims.applyClaims.perform(click());
        SystemClock.sleep(1000);
    }

    public void addNew() {
        Allure.step("Нажать кнопку добавления заявки");
        Claims.create.perform(click());
    }

    public void isCreatingScreen() {
        Allure.step("Проверить, что это окно создания заявки");
        Claims.creatingScreen.check(matches(isDisplayed()));
    }

    public void enterTitle(String text) {
        Allure.step("Ввести заголовок");
        Claims.createTitle.perform(replaceText(text));
    }

    public void enterExecutor(String text) {
        Allure.step("Выбрать из списка ФИО исполнителя");
        Claims.createExecutor.perform(replaceText(text));
    }

    public void enterDate(String text) {
        Allure.step("Ввести дату");
        Claims.createDate.perform(replaceText(text));
    }

    public void enterTime(String text) {
        Allure.step("Ввести время");
        Claims.createTime.perform(replaceText(text));
    }

    public void enterDescription(String text) {
        Allure.step("Ввести описание заявки");
        Claims.createDescription.perform(replaceText(text),closeSoftKeyboard());
    }

    public void saveButton() {
        Allure.step("Нажать на кнопку сохранить");
        Claims.saveButton.perform(click());
        SystemClock.sleep(1000);
    }

    public void checkEmpty() {
        Allure.step("Проверить уведомление о заполнении пустых полей");
        Claims.emptyFieldsWarning.check(matches(isDisplayed()));
    }

    public void clickButtonAddComment(){
        Allure.step("Нажать на кнопку Добавить комментарий");
        Claims.addComment.perform(click());
    }

    public void addToCommentField(){
        Allure.step("В поле Комментарий добавить комментарий");
        Claims.fieldComment.perform(clearText(), replaceText("Новый комментарий"));
    }

    public void checkCommentField(){
        Allure.step("Проверить комментарий в поле Комментарий");
        Claims.comment.check(matches(isDisplayed()));
    }

    public void checkBlockComment(){
        Allure.step("Проверить наличие блока с комментариями");
        Claims.blockComment.perform(click());
    }

    public void onSwipe(){
        Allure.step("Свайп");
        Claims.swipe.perform(swipeUp());
        SystemClock.sleep(2000);
    }

}