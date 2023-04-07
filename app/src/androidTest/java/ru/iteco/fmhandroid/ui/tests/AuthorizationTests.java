package ru.iteco.fmhandroid.ui.tests;

import android.os.SystemClock;
import androidx.test.espresso.NoMatchingViewException;
import androidx.test.rule.ActivityTestRule;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.AppActivity;

@RunWith(AllureAndroidJUnit4.class)
public class AuthorizationTests {
    AuthorizationSteps auth = new AuthorizationSteps();
    MainSteps main = new MainSteps();

    @Rule
    public ActivityTestRule<AppActivity> mActivityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void authCheck() {
        auth.waitAutorizationContainer();

        try {
            auth.isAuthorizationScreen();
        } catch (NoMatchingViewException e) {
            main.logOut();
        }
    }

    @Test
    @DisplayName("Вход с валидными данными")
    public void validAuth(){
        auth.isAuthorizationScreen();
        auth.validAuth();
        main.logOut();
    }

    @Test
    @DisplayName("Вход с пустым полем Логин")
    public void emptyLogin(){
        auth.isAuthorizationScreen();
        auth.loginInputField("");
        auth.passwordInputField("password2");
        auth.buttonClick();
        auth.emptyLoginOrPass();
    }

    @Test
    @DisplayName(" Вход с пустым полем Пароль")
    public void emptyPassword(){
        auth.isAuthorizationScreen();
        auth.loginInputField("login2");
        auth.passwordInputField("");
        auth.buttonClick();
        auth.emptyLoginOrPass();
    }

    @Test
    @DisplayName("Поле Логин заполнено невалидными данными")
    public void invalidLogin(){
        auth.isAuthorizationScreen();
        auth.loginInputField("123qweasd");
        auth.passwordInputField("password2");
        auth.buttonClick();
        auth.wrongLoginOrPass();
    }

    @Test
    @DisplayName("Поле Пароль заполнено невалидными данными")
    public void invalidPassword(){
        auth.isAuthorizationScreen();
        auth.loginInputField("login2");
        auth.passwordInputField("123qweasd");
        auth.buttonClick();
        auth.wrongLoginOrPass();
    }

    @Test
    @DisplayName("Авторизация с пустыми полями")
    public void emptyAuth() {
        auth.isAuthorizationScreen();
        auth.buttonClick();
        auth.emptyLoginOrPass();
    }

    @Test
    @DisplayName("Поле Логин заполнено символами")
    public void loginSpecialSymbols(){
        auth.isAuthorizationScreen();
        auth.loginInputField("@#%&${}|/?");
        auth.passwordInputField("password2");
        auth.buttonClick();
        auth.wrongLoginOrPass();
    }

    @Test
    @DisplayName("Поле Пароль заполнено символами")
    public void passwordSpecialSymbols(){
        auth.isAuthorizationScreen();
        auth.loginInputField("login2");
        auth.passwordInputField("@#%&${}|/?");
        auth.buttonClick();
        auth.wrongLoginOrPass();
    }

    @Test
    @DisplayName("Поле Логин заполнено пробелами")
    public void loginSpace(){
        auth.isAuthorizationScreen();
        auth.loginInputField("     ");
        auth.passwordInputField("password2");
        auth.buttonClick();
        auth.wrongLoginOrPass();
    }

    @Test
    @DisplayName("Поле Пароль заполнено пробелами")
    public void passwordSpace(){
        auth.isAuthorizationScreen();
        auth.loginInputField("login2");
        auth.passwordInputField("         ");
        auth.buttonClick();
        auth.wrongLoginOrPass();
    }
}
