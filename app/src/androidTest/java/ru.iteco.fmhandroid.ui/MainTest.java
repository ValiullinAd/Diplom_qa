package ru.iteco.fmhandroid.ui;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.action.ViewActions.click;
import static org.hamcrest.Matchers.allOf;

import android.os.SystemClock;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;

import ru.iteco.fmhandroid.ui.MainPage;
import ru.iteco.fmhandroid.ui.MainSteps;

public class MainTest {

    AuthorizationSteps Auth = new AuthorizationSteps();
    MainSteps Main = new MainSteps();


    @Rule
    public ActivityTestRule<AppActivity> mActivityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void authCheck() {
        SystemClock.sleep(5000);
        try {
            Auth.validAuth();
        } catch (NoMatchingViewException e) {
            Main.logOut();
            Auth.validAuth();
        }
        SystemClock.sleep(2000);
    }

    @After
    public void Exit () {
        SystemClock.sleep(2000);
        Main.logOut();
        SystemClock.sleep(2000);
    }

    @Test
    public void openAllNews() {
        Main.clickAllNewsButton();
    }

    @Test
    public void openAllClaims(){
        Main.clickAllClaims();
    }

    @Test
    public void openClaims() {
        Main.openClaims();
    }

    @Test
    public void openAbout() {
        Main.openAbout();
        Main.backFromAbout();
    }

    @Test
    public void openNews() {
        Main.openNews();
    }

    @Test
    public  void ourMission(){
        Main.ourMission();
    }


}