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
    AuthorizationSteps Auth = new AuthorizationSteps();
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
    @DisplayName("ВСЕ НОВОСТИ")
    public void openAllNews(){
        Main.clickButtonAllNews();
    }

    @Test
    @DisplayName("ВСЕ ЗАЯВКИ")
    public void openAllClaims(){
        Main.clickButtonAllClaims();
    }

    @Test
    @DisplayName("Вкладка Заявки")
    public void openMenuClaims(){
        Main.openClaims();
    }

    @Test
    @DisplayName("Вкладка Новости")
    public void openMenuNews(){
        Main.openNews();
    }

    @Test
    @DisplayName("Вкладка О приложении")
    public void openMenuAbout(){
        Main.openAbout();
    }
}
