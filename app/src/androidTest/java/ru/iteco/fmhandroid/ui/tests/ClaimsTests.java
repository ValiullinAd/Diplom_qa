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


@RunWith(AllureAndroidJUnit4.class)
public class ClaimsTests {
    AuthorizationSteps Auth = new AuthorizationSteps();
    ClaimsSteps Claims = new ClaimsSteps();
    MainSteps Main = new MainSteps();


    @Rule
    public ActivityTestRule<AppActivity> mActivityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void authCheck() {
        SystemClock.sleep(5000);
        try {
            Main.isMainScreen();
        } catch (NoMatchingViewException e) {
            Auth.validAuth();
        }
        SystemClock.sleep(2000);
    }

    @Test
    @DisplayName("Фильтрация заявок Открыта")
    public void applicationFilteringOpen(){
        Main.openClaims();
        Claims.isClaimsScreen();
        Claims.filter();
        Claims.isFilteringScreen();
        Claims.removeCheckBoxInProgress();
        Claims.applyClaims();
    }

    @Test
    @DisplayName("Фильтрация заявок В работе")
    public void applicationFilteringInProgress(){
        Main.openClaims();
        Claims.isClaimsScreen();
        Claims.filter();
        Claims.isFilteringScreen();
        Claims.removeCheckBoxOpen();
        Claims.applyClaims();
    }

    @Test
    @DisplayName("Фильтрация заявок Выполнена")
    public void applicationFilteringExecuted(){
        Main.openClaims();
        Claims.isClaimsScreen();
        Claims.filter();
        Claims.isFilteringScreen();
        Claims.executedCheck();
        Claims.applyClaims();
    }

    @Test
    @DisplayName("Фильтрация заявок Отмененные")
    public void applicationFilteringCancelled(){
        Main.openClaims();
        Claims.isClaimsScreen();
        Claims.filter();
        Claims.isFilteringScreen();
        Claims.cancelledCheck();
        Claims.applyClaims();
    }

    @Test
    @DisplayName("Открытие заявки")
    public void openClaim(){
        Main.openClaims();
        Claims.open();
        Claims.onSwipe();
        Claims.goBack();
        Claims.isClaimsScreen();
    }

    @Test
    @DisplayName("Создание Заявки")
    public void creatingNewClaim(){
        Main.openClaims();
        Claims.addNew();
        Claims.isCreatingScreen();
        Claims.enterTitle("Заголовок");
        Claims.enterExecutor("Курванен Фекла Емельяновна");
        Claims.enterDate("03.03.2023");
        Claims.enterTime("00:11");
        Claims.enterDescription("Описание");
        Claims.saveButton();
        Claims.isClaimsScreen();
    }

    @Test
    @DisplayName("Создание Заявки без темы")
    public void creatingNewClaimWithoutTitle(){
        Main.openClaims();
        Claims.addNew();
        Claims.isCreatingScreen();
        Claims.enterTitle(" ");
        Claims.enterExecutor("Кещян Ашот Геворгович");
        Claims.enterDate("02.02.2023");
        Claims.enterTime("11:22");
        Claims.enterDescription("Описание");
        Claims.saveButton();
        Claims.checkEmpty();
    }

    @Test
    @DisplayName("Создание Заявки без исполнителя")
    public void creatingNewClaimWithoutExecutor(){
        Main.openClaims();
        Claims.addNew();
        Claims.isCreatingScreen();
        Claims.enterTitle("Заголовок");
        Claims.enterExecutor(" ");
        Claims.enterDate("01.01.2023");
        Claims.enterTime("11:22");
        Claims.enterDescription("Описание");
        Claims.saveButton();
        Claims.checkBlockComment();
    }

    @Test
    @DisplayName("Создание Заявки без даты")
    public void creatingNewClaimWithoutDate(){
        Main.openClaims();
        Claims.addNew();
        Claims.isCreatingScreen();
        Claims.enterTitle("Какой то новый заголовок");
        Claims.enterExecutor("Байрактаровна Джавелина Унитазова ");
        Claims.enterDate("");
        Claims.enterTime("11:22");
        Claims.enterDescription("Описание");
        Claims.saveButton();
        Claims.checkEmpty();
    }

    @Test
    @DisplayName("Создание Заявки без времени")
    public void creatingNewClaimWithoutTime(){
        Main.openClaims();
        Claims.addNew();
        Claims.isCreatingScreen();
        Claims.enterTitle("Какой то заголовок");
        Claims.enterExecutor("Иванов Иван Иванович");
        Claims.enterDate("31.12.2022");
        Claims.enterTime("");
        Claims.enterDescription("Описание");
        Claims.saveButton();
        Claims.checkEmpty();
    }

    @Test
    @DisplayName("Создание Заявки без описания")
    public void creatingNewClaimWithoutDescription(){
        Main.openClaims();
        Claims.addNew();
        Claims.isCreatingScreen();
        Claims.enterTitle("Новый заголовок");
        Claims.enterExecutor("Пупкин Акакий Ануфриевич");
        Claims.enterDate("01.12.2022");
        Claims.enterTime("11:22 ");
        Claims.enterDescription("");
        Claims.saveButton();
        Claims.checkEmpty();
    }

    @Test
    @DisplayName("Добавление комментария к созданной заявке")
    public void addComment(){
        Main.openClaims();
        Claims.isClaimsScreen();
        Claims.filter();
        Claims.isFilteringScreen();
        Claims.removeCheckBoxInProgress();
        Claims.applyClaims();
        Claims.open();
        Claims.onSwipe();
        Claims.clickButtonAddComment();
        Claims.addToCommentField();
        Claims.saveButton();
        Claims.onSwipe();
        Claims.checkCommentField();
    }

}