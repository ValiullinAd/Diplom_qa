package ru.iteco.fmhandroid.ui;

import android.os.SystemClock;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;

public class AuthorizationSteps {
    Authorization Auth = new Authorization();
    MainSteps Main = new MainSteps();

    public void isAuthorizationScreen() {
        Auth.authScreen.check(matches(isDisplayed()));
    }

    public void loginString(String login) {
        Auth.login.check(matches(isEnabled()));
        Auth.login.perform(replaceText(login));
    }

    public void passwordString(String password) {
        Auth.password.check(matches(isEnabled()));
        Auth.password.perform(replaceText(password));
    }

    public void clickButton() {
        Auth.signInButton.perform(click());
    }

    public void validAuth(){
        Auth.login.check(matches(isEnabled()));
        Auth.login.perform(replaceText("login2"));
        Auth.password.check(matches(isEnabled()));
        Auth.password.perform(replaceText("password2"));
        Auth.signInButton.perform(click());
        SystemClock.sleep(3000);
    }
    public void clickLogOut(){
        Auth.login.check(matches(isEnabled()));
    }
}
