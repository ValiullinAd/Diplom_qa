package ru.iteco.fmhandroid.ui.steps;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.elements.Authorization;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.utils.Utils.waitDisplayed;

public class AuthorizationSteps {
    Authorization auth = new Authorization();
    MainSteps main = new MainSteps();

    public void isAuthorizationScreen() {
        Allure.step("Проверка oкна авторизации");
        auth.authScreen.check(matches(isDisplayed()));
    }

    public void waitAutorizationContainer(){
        Allure.step("Ожидание загрузки контейнера");
        auth.inRoot.perform(waitDisplayed(R.id.container_custom_app_bar_include_on_fragment_main, 5000));
    }

    public void loginInputField(String login) {
        Allure.step("Заполнить поле логин");
        auth.login.check(matches(isEnabled()));
        auth.login.perform(replaceText(login));
    }

    public void passwordInputField(String password) {
        Allure.step("Заполнить поле пароль");
        auth.password.check(matches(isEnabled()));
        auth.password.perform(replaceText(password));
    }

    public void buttonClick() {
        Allure.step("Нажать кнопку Войти");
        auth.signInButton.perform(click());
    }

    public void validAuth(){
        Allure.step("Заполнить поле логин");
        auth.login.check(matches(isEnabled()));
        auth.login.perform(replaceText("login2"));
        Allure.step("Заполнить поле пароль");
        auth.password.check(matches(isEnabled()));
        auth.password.perform(replaceText("password2"));
        Allure.step("Нажать на кнопку ВОЙТИ");
        auth.signInButton.perform(click());
        main.isMainScreenLoaded();
        main.isMainScreen();
    }
    public void emptyLoginOrPass(){
        Allure.step("Пустой логин или пароль");
        onView(allOf(withContentDescription("Login and password cannot be empty"), isDisplayed()));
    }
    public void wrongLoginOrPass(){
        Allure.step("Неверный логин или пароль");
        onView(allOf(withContentDescription("Wrong login or password"), isDisplayed()));
    }
}
