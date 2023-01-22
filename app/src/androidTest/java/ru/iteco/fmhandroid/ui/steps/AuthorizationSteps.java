package ru.iteco.fmhandroid.ui.steps;

import android.os.SystemClock;
import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.Authorization;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;

public class AuthorizationSteps {
    Authorization Auth = new Authorization();
    MainSteps Main = new MainSteps();

    public void isAuthorizationScreen() {
        Allure.step("Проверка oкна авторизации");
        Auth.authScreen.check(matches(isDisplayed()));
    }

    public void loginInputField(String login) {
        Allure.step("Заполнить поле логин");
        Auth.login.check(matches(isEnabled()));
        Auth.login.perform(replaceText(login));
    }

    public void passwordInputField(String password) {
        Allure.step("Заполнить поле пароль");
        Auth.password.check(matches(isEnabled()));
        Auth.password.perform(replaceText(password));
    }

    public void buttonClick() {
        Allure.step("Нажать кнопку Войти");
        Auth.signInButton.perform(click());
    }

    public void validAuth(){
        Allure.step("Заполнить поле логин");
        Auth.login.check(matches(isEnabled()));
        Auth.login.perform(replaceText("login2"));
        Allure.step("Заполнить поле пароль");
        Auth.password.check(matches(isEnabled()));
        Auth.password.perform(replaceText("password2"));
        Allure.step("Нажать на кнопку ВОЙТИ");
        Auth.signInButton.perform(click());
        SystemClock.sleep(3000);
        Main.isMainScreen();
    }
}
