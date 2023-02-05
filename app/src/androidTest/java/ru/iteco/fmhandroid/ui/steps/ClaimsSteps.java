package ru.iteco.fmhandroid.ui.steps;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.ClaimsElements;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import androidx.test.espresso.matcher.ViewMatchers;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static org.hamcrest.core.AllOf.allOf;
import static ru.iteco.fmhandroid.ui.utils.Utils.withIndex;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import android.os.SystemClock;
import ru.iteco.fmhandroid.R;
import org.hamcrest.Matchers;

import android.os.SystemClock;

public class ClaimsSteps {
    ClaimsElements claims = new ClaimsElements();

    public void isClaimsScreen() {
        Allure.step("Проверить, что это экно заявок");
        claims.claimsScreen.check(matches(isDisplayed()));
    }

    public void filter() {
        Allure.step("Открыть фильтр");
        claims.openFilter.perform(click());
    }

    public void open() {
        Allure.step("Открыть заявку");
        claims.openFirstClaim.perform(click());
    }

    public void goBack() {
        Allure.step("Возврат из открытой заявки");
        claims.closeClaim.perform(click());
    }

    public void isFilteringScreen() {
        Allure.step("Проверить, что это окно фильтрации заявок");
        claims.filterScreen.check(matches(isDisplayed()));
    }

    public void removeCheckBoxOpen() {
        Allure.step("Снять флажок с чекбокса Открыта");
        claims.checkBoxOpen.perform(click());
    }

    public void removeCheckBoxInProgress() {
        Allure.step("Снять флажок с чекбокса В работе");
        claims.checkBoxInProgress.perform(click());
    }
    public void executedCheck() {
        Allure.step("Фильтрация заявок по критерию Выполнена");
        claims.executed.perform(click());
    }
    public void cancelledCheck() {
        Allure.step("Фильтрация заявок по критерию Отмененные");
        claims.cancelled.perform(click());
    }
    public void applyClaims() {
        Allure.step("Подтверждение фильтрации заявок");
        claims.applyClaims.perform(click());
        SystemClock.sleep(1000);
    }

    public void addNew() {
        Allure.step("Нажать кнопку добавления заявки");
        claims.create.perform(click());
    }

    public void isCreatingScreen() {
        Allure.step("Проверить, что это окно создания заявки");
        claims.creatingScreen.check(matches(isDisplayed()));
    }

    public void enterTitle(String text) {
        Allure.step("Ввести заголовок");
        claims.createTitle.perform(replaceText(text));
    }

    public void enterExecutor(String text) {
        Allure.step("Выбрать из списка ФИО исполнителя");
        claims.createExecutor.perform(replaceText(text));
    }

    public void enterDate(String text) {
        Allure.step("Ввести дату");
        claims.createDate.perform(replaceText(text));
    }

    public void enterTime(String text) {
        Allure.step("Ввести время");
        claims.createTime.perform(replaceText(text));
    }

    public void enterDescription(String text) {
        Allure.step("Ввести описание заявки");
        claims.createDescription.perform(replaceText(text),closeSoftKeyboard());
    }

    public void saveButton() {
        Allure.step("Нажать на кнопку сохранить");
        claims.saveButton.perform(click());
        SystemClock.sleep(1000);
    }

    public void checkEmpty() {
        Allure.step("Проверить уведомление о заполнении пустых полей");
        claims.emptyFieldsWarning.check(matches(isDisplayed()));
    }

    public void clickButtonAddComment(){
        Allure.step("Нажать на кнопку Добавить комментарий");
        claims.addComment.perform(click());
    }

    public void addToCommentField(){
        Allure.step("В поле Комментарий добавить комментарий");
        claims.fieldComment.perform(clearText(), replaceText("Новый комментарий"));
    }

    public void checkCommentField(){
        Allure.step("Проверить комментарий в поле Комментарий");
        claims.comment.check(matches(isDisplayed()));
    }

    public void checkBlockComment(){
        Allure.step("Проверить наличие блока с комментариями");
        claims.blockComment.perform(click());
    }

    public void onSwipe(){
        Allure.step("Свайп");
        claims.swipe.perform(swipeUp());
        SystemClock.sleep(2000);
    }

    public void checkClaim(){
        onView(withId(R.id.claim_list_recycler_view)).check(matches(isDisplayed()));
    }
    public void  dateCreationClaims(){
        claims.editDate.perform(click());

    }
    public void timeCreationClaims(){
        claims.editTime.perform(click());

    }
    public void clickOkClaimButton(){
        claims.okButton.perform(click());

    }
    public void checkVisualText(){
        onView(withText("Original text")).check(matches(isDisplayed()));
    }

    public void statusProcessingButton(){
        onView(allOf(withId(R.id.status_processing_image_button))).perform(click());
    }

    public void takeToWork(){
        onView(allOf(withId(android.R.id.title), withText("take to work"))).perform(click());
    }

    public void textInProgress(){
        onView(withId(R.id.status_label_text_view)).check(matches(withText("In progress"))).check(matches(isDisplayed()));
    }

    public void cancelClaim(){
        onView(Matchers.allOf(withId(android.R.id.title), withText("Cancel"))).perform(click());
    }

    public void textCancel(){
        onView(withId(R.id.status_label_text_view)).check(matches(withText("Canceled"))).check(matches(isDisplayed()));
    }

    public  void selectThrowOff(){
        onView(Matchers.allOf(withId(android.R.id.title), withText("Throw off"))).perform(click());
    }

    public void justText(){
        onView(withId(R.id.editText)).perform(replaceText("Какой то там текст")).perform(closeSoftKeyboard());
    }

    public void textOpen(){
        onView(withId(R.id.status_label_text_view)).check(matches(withText("Open"))).check(matches(isDisplayed()));
    }


}