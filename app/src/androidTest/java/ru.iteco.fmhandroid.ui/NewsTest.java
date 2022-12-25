package ru.iteco.fmhandroid.ui;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isFocusable;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

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
import ru.iteco.fmhandroid.ui.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.Claims;
import ru.iteco.fmhandroid.ui.MainPage;
import ru.iteco.fmhandroid.ui.MainSteps;
import ru.iteco.fmhandroid.ui.News;

@LargeTest
@RunWith(AndroidJUnit4.class)


public class NewsTest {
    AuthorizationSteps Auth = new AuthorizationSteps();
    MainSteps Main = new MainSteps();
    NewsSteps NewsSteps = new NewsSteps();
    
    @Rule
    public ActivityTestRule<AppActivity> activityTestRule =
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
    public void sortNews() {
        Main.openNews();
        NewsSteps.sortNews();
        NewsSteps.isNewsScreen();
    }

    @Test
    public void filterNewsAdd() {
        Main.openNews();
        NewsSteps.filterNews();
        NewsSteps.selectFilterCategory("Объявление");
        NewsSteps.applyNews();
        NewsSteps.isNewsScreen();
    }

    @Test
    public void filterNewsBirthday() {
        Main.openNews();
        NewsSteps.filterNews();
        NewsSteps.selectFilterCategory("День рождения");
        NewsSteps.applyNews();
        NewsSteps.isNewsScreen();
    }

    @Test
    public void filterNewsSalary() {
        Main.openNews();
        NewsSteps.filterNews();
        NewsSteps.selectFilterCategory("Зарплата");
        NewsSteps.applyNews();
        NewsSteps.isNewsScreen();
    }

    @Test
    public void filterNewsUnion() {
        Main.openNews();
        NewsSteps.filterNews();
        NewsSteps.selectFilterCategory("Профсоюз");
        NewsSteps.applyNews();
        NewsSteps.isNewsScreen();
    }

    @Test
    public void filterNewsHoliday() {
        Main.openNews();
        NewsSteps.filterNews();
        NewsSteps.selectFilterCategory("Праздник");
        NewsSteps.applyNews();
        NewsSteps.isNewsScreen();
    }

    @Test
    public void filterNewsMassage() {
        Main.openNews();
        NewsSteps.filterNews();
        NewsSteps.selectFilterCategory("Массаж");
        NewsSteps.applyNews();
        NewsSteps.isNewsScreen();
    }

    @Test
    public void filterNewsGratitude() {
        Main.openNews();
        NewsSteps.filterNews();
        NewsSteps.selectFilterCategory("Благодарность");
        NewsSteps.applyNews();
        NewsSteps.isNewsScreen();
    }

    @Test
    public void filterNewsHelp() {
        Main.openNews();
        NewsSteps.filterNews();
        NewsSteps.selectFilterCategory("Нужна помощь");
        NewsSteps.applyNews();
        NewsSteps.isNewsScreen();
    }

    @Test
    public void filterNews() {
        Main.openNews();
        NewsSteps.filterNews();
        NewsSteps.selectFilterCategory("");
        NewsSteps.applyNews();
        NewsSteps.isNewsScreen();
    }

    @Test
    public void filterNewsWithTimesPeriod() {
        Main.openNews();
        NewsSteps.filterNews();
        NewsSteps.selectFilterCategory("");
        NewsSteps.dateStart("20.10.2020");
        NewsSteps.dateEnd("26.11.2021");
        NewsSteps.applyNews();
        NewsSteps.isNewsScreen();

    }

}