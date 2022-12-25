package ru.iteco.fmhandroid.ui;

import android.os.SystemClock;
import androidx.test.espresso.NoMatchingViewException;
import androidx.test.rule.ActivityTestRule;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static org.hamcrest.Matchers.allOf;

@RunWith(AllureAndroidJUnit4.class)
public class AuthorizationTests {
    AuthorizationSteps Auth = new AuthorizationSteps();
    MainSteps Main = new MainSteps();

    @Rule
    public ActivityTestRule<AppActivity> mActivityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void authCheck() {
        SystemClock.sleep(5000);
        try {
            Auth.isAuthorizationScreen();
        } catch (NoMatchingViewException e) {
            Main.logOut();
        }
    }


    @Test
    public void validAuth(){
        Auth.isAuthorizationScreen();
        Auth.validAuth();
        Main.logOut();
    }

    @Test
    public void invalidAuth(){
        Auth.isAuthorizationScreen();
        Auth.loginString("login");
        Auth.passwordString("password");
        Auth.clickButton();
        onView(allOf(withContentDescription("Wrong login or password"), isDisplayed()));
    }

    @Test
    public void emptyLoginAndPassword(){
        Auth.isAuthorizationScreen();
        Auth.loginString("");
        Auth.passwordString("");
        Auth.clickButton();
        onView(allOf(withContentDescription("Login and password cannot be empty"), isDisplayed()));
    }

    @Test
    public void emptyLogin(){
        Auth.isAuthorizationScreen();
        Auth.loginString("");
        Auth.passwordString("Password");
        Auth.clickButton();
        onView(allOf(withContentDescription("Login and password cannot be empty"), isDisplayed()));
    }

    @Test
    public void emptyPassword(){
        Auth.isAuthorizationScreen();
        Auth.loginString("login2");
        Auth.passwordString("");
        Auth.clickButton();
        onView(allOf(withContentDescription("Login and password cannot be empty"), isDisplayed()));
    }

}
