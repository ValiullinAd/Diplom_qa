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
import ru.iteco.fmhandroid.ui.steps.MainSteps;

@RunWith(AllureAndroidJUnit4.class)
public class MainTests {
    AuthorizationSteps auth = new AuthorizationSteps();
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
    @DisplayName("ВСЕ НОВОСТИ")
    public void openAllNews(){
        main.clickButtonAllNews();
    }

    @Test
    @DisplayName("ВСЕ ЗАЯВКИ")
    public void openAllClaims(){
        main.clickButtonAllClaims();
    }

    @Test
    @DisplayName("Вкладка Заявки")
    public void openMenuClaims(){
        main.openClaims();
    }

    @Test
    @DisplayName("Вкладка Новости")
    public void openMenuNews(){
        main.openNews();
    }

    @Test
    @DisplayName("Вкладка О приложении")
    public void openMenuAbout(){
        main.openAbout();
    }
}
