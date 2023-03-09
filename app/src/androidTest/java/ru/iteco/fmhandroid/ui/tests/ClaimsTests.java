package ru.iteco.fmhandroid.ui.tests;

import android.os.SystemClock;
import androidx.test.espresso.NoMatchingViewException;
import androidx.test.rule.ActivityTestRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.ClaimsSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import androidx.test.filters.LargeTest;


@RunWith(AllureAndroidJUnit4.class)
@LargeTest


public class ClaimsTests {
    AuthorizationSteps auth = new AuthorizationSteps();
    ClaimsSteps claims = new ClaimsSteps();
    MainSteps main = new MainSteps();




    @Rule
    public ActivityTestRule<AppActivity> mActivityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void authCheck() {
        SystemClock.sleep(5000);
        try {
            main.isMainScreen();
        } catch (NoMatchingViewException e) {
            auth.validAuth();
        }
        SystemClock.sleep(2000);
    }

    @Test
    @DisplayName("Создание Заявки")
    public void creatingNewClaim(){
        main.openClaims();
        claims.addNew();
        claims.isCreatingScreen();
        claims.enterTitle("Original text2551112");
        claims.enterExecutor("Ivanov Ivan Ivanovich");
        claims.dateCreationClaims();
        claims.clickOkClaimButton();
        claims.timeCreationClaims();
        claims.clickOkClaimButton();
        claims.enterDescription("Описание");
        claims.saveButton();
        claims.findTitle();
        claims.checkVisualText();
    }

    @Test
    @DisplayName("Фильтрация заявок Открыта")
    public void applicationFilteringOpen(){
        main.openClaims();
        claims.isClaimsScreen();
        claims.filter();
        claims.isFilteringScreen();
        claims.removeCheckBoxInProgress();
        claims.applyClaims();
        claims.checkClaim();
    }

    @Test
    @DisplayName("Фильтрация заявок В работе")
    public void applicationFilteringInProgress(){
        main.openClaims();
        claims.isClaimsScreen();
        claims.filter();
        claims.isFilteringScreen();
        claims.removeCheckBoxOpen();
        claims.applyClaims();
        claims.checkClaim();
    }

    @Test
    @DisplayName("Фильтрация заявок Выполнена")
    public void applicationFilteringExecuted(){
        main.openClaims();
        claims.isClaimsScreen();
        claims.filter();
        claims.isFilteringScreen();
        claims.executedCheck();
        claims.applyClaims();
        claims.checkClaim();
    }

    @Test
    @DisplayName("Фильтрация заявок Отмененные")
    public void applicationFilteringCancelled(){
        main.openClaims();
        claims.isClaimsScreen();
        claims.filter();
        claims.isFilteringScreen();
        claims.cancelledCheck();
        claims.applyClaims();
        claims.checkClaim();
    }

    @Test
    @DisplayName("Открытие заявки")
    public void openClaim(){
        main.openClaims();
        claims.open();
        claims.onSwipe();
        claims.goBack();
        claims.isClaimsScreen();
    }

    @Test
    @DisplayName("Создание Заявки без темы")
    public void creatingNewClaimWithoutTitle(){
        main.openClaims();
        claims.addNew();
        claims.isCreatingScreen();
        claims.enterTitle(" ");
        claims.enterExecutor("Ivanov Ivan Ivanovich");
        claims.dateCreationClaims();
        claims.clickOkClaimButton();
        claims.timeCreationClaims();
        claims.clickOkClaimButton();
        claims.enterDescription("Описание");
        claims.saveButton();
        claims.checkEmpty();
    }

    @Test
    @DisplayName("Создание Заявки без исполнителя")
    public void creatingNewClaimWithoutExecutor(){
        main.openClaims();
        claims.addNew();
        claims.isCreatingScreen();
        claims.enterTitle("Заголовок");
        claims.enterExecutor(" ");
        claims.dateCreationClaims();
        claims.clickOkClaimButton();
        claims.timeCreationClaims();
        claims.clickOkClaimButton();
        claims.enterDescription("Описание");
        claims.saveButton();
        claims.checkBlockComment();
    }

    @Test
    @DisplayName("Создание Заявки без даты")
    public void creatingNewClaimWithoutDate(){
        main.openClaims();
        claims.addNew();
        claims.isCreatingScreen();
        claims.enterTitle("Какой то новый заголовок");
        claims.enterExecutor("Ivanov Ivan Ivanovich");
        claims.enterDate("");
        claims.timeCreationClaims();
        claims.clickOkClaimButton();
        claims.enterDescription("Описание");
        claims.saveButton();
        claims.checkEmpty();
    }

    @Test
    @DisplayName("Создание Заявки без времени")
    public void creatingNewClaimWithoutTime(){
        main.openClaims();
        claims.addNew();
        claims.isCreatingScreen();
        claims.enterTitle("Какой то заголовок");
        claims.enterExecutor("Ivanov Ivan Ivanovich");
        claims.dateCreationClaims();
        claims.clickOkClaimButton();
        claims.enterTime("");
        claims.enterDescription("Описание");
        claims.saveButton();
        claims.checkEmpty();
    }

    @Test
    @DisplayName("Создание Заявки без описания")
    public void creatingNewClaimWithoutDescription(){
        main.openClaims();
        claims.addNew();
        claims.isCreatingScreen();
        claims.enterTitle("Новый заголовок");
        claims.enterExecutor("Ivanov Ivan Ivanovich");
        claims.dateCreationClaims();
        claims.clickOkClaimButton();
        claims.timeCreationClaims();
        claims.clickOkClaimButton();
        claims.enterDescription("");
        claims.saveButton();
        claims.checkEmpty();
    }

    @Test
    @DisplayName("Добавление комментария к созданной заявке")
    public void addComment(){
        main.openClaims();
        claims.isClaimsScreen();
        claims.filter();
        claims.isFilteringScreen();
        claims.removeCheckBoxInProgress();
        claims.applyClaims();
        claims.open();
        claims.onSwipe();
        claims.clickButtonAddComment();
        claims.addToCommentField();
        claims.saveButton();
        claims.onSwipe();
        claims.checkCommentField();
    }

    @Test
    @DisplayName("Заявка в работу")
    public void changeClaimStatus2InProgress(){
        main.openClaims();
        claims.isClaimsScreen();
        claims.filter();
        claims.isFilteringScreen();
        claims.removeCheckBoxInProgress();
        claims.applyClaims();
        claims.open();
        claims.onSwipe();
        claims.statusProcessingButton();
        claims.takeToWork();
        claims.textInProgress();

    }

    @Test
    @DisplayName("Отмена заявки")
    public void changeClaimStatus2InCancel(){
        main.openClaims();
        claims.isClaimsScreen();
        claims.filter();
        claims.isFilteringScreen();
        claims.removeCheckBoxInProgress();
        claims.applyClaims();
        claims.open();
        claims.onSwipe();
        claims.statusProcessingButton();
        claims.cancelClaim();
        claims.textCancel();

    }

    @Test
    @DisplayName("Изменение статуса заявки")
    public void changeClaimStatus2ThrowOff(){
        main.openClaims();
        claims.isClaimsScreen();
        claims.filter();
        claims.isFilteringScreen();
        claims.removeCheckBoxInProgress();
        claims.applyClaims();
        claims.open();
        claims.onSwipe();
        claims.statusProcessingButton();
        claims.takeToWork();
        claims.textInProgress();
        claims.statusProcessingButton();
        claims.selectThrowOff();
        claims.justText();
        claims.clickOkClaimButton();
        claims.textOpen();

    }

}