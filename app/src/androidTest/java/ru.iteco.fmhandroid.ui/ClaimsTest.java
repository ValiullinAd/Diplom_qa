package ru.iteco.fmhandroid.ui;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.doubleClick;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.swipeDown;
import static androidx.test.espresso.action.ViewActions.swipeUp;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.isFocusable;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.widget.NestedScrollView;
import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.PerformException;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.espresso.util.HumanReadables;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.ui.MainPage;
import ru.iteco.fmhandroid.ui.ClaimsSteps;
import ru.iteco.fmhandroid.ui.MainSteps;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;

@LargeTest
@RunWith(AndroidJUnit4.class)

public class ClaimsTest {
    AuthorizationSteps Auth = new AuthorizationSteps();
    MainSteps Main = new MainSteps();
    Claims Claims = new Claims();
    ClaimsSteps ClaimsSteps = new ClaimsSteps();
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
    public void applicationFilteringOpen() {
        Main.mainMenuButton();
        ClaimsSteps.isClaimsButton();
        ClaimsSteps.buttonFilter();
        ClaimsSteps.checkBoxInProgress();
        ClaimsSteps.buttonOk();
        ClaimsSteps.isClaimsScreen();
    }

    @Test
    public void applicationFilteringInProgress() {
        Main.mainMenuButton();
        ClaimsSteps.isClaimsButton();
        ClaimsSteps.buttonFilter();
        ClaimsSteps.checkBoxOpen();
        ClaimsSteps.buttonOk();
        ClaimsSteps.isClaimsScreen();
    }

    @Test
    public void applicationFilteringExecuted() {
        Main.mainMenuButton();
        ClaimsSteps.isClaimsButton();
        ClaimsSteps.buttonFilter();
        ClaimsSteps.checkBoxOpen();
        ClaimsSteps.checkBoxInProgress();
        ClaimsSteps.checkBoxExecute();
        ClaimsSteps.buttonOk();
        ClaimsSteps.isClaimsScreen();
    }

    @Test
    public void applicationFilteringCancelled() {
        Main.mainMenuButton();
        ClaimsSteps.isClaimsButton();
        ClaimsSteps.buttonFilter();
        ClaimsSteps.checkBoxOpen();
        ClaimsSteps.checkBoxInProgress();
        ClaimsSteps.cancelCheckBox();
        ClaimsSteps.buttonOk();
        ClaimsSteps.isClaimsScreen();
    }

    @Test
    public void addNewClaim() {
        Main.mainMenuButton();
        ClaimsSteps.isClaimsButton();
        ClaimsSteps.addClaimsButton();
        Claims.titleField.perform(replaceText("Срочно"), closeSoftKeyboard());
        Claims.executorField.perform(replaceText("Спиридонов Максим Жорикович"), closeSoftKeyboard());
        ClaimsSteps.dataField();
        ClaimsSteps.okDateButton();
        ClaimsSteps.timeField();
        ClaimsSteps.okTimeButton();
        Claims.descriptionField.perform(replaceText("Срочный осмотр"), closeSoftKeyboard());
        ClaimsSteps.saveButton();
        ClaimsSteps.isClaimsScreen();
    }

    @Test
    public void titleFieldIsEmpty() {
        Main.mainMenuButton();
        ClaimsSteps.isClaimsButton();
        ClaimsSteps.addClaimsButton();
        Claims.titleField.perform(replaceText(""), closeSoftKeyboard());
        Claims.executorField.perform(replaceText("Козлов Олег Петрович"), closeSoftKeyboard());
        ClaimsSteps.dataField();
        ClaimsSteps.okDateButton();
        ClaimsSteps.timeField();
        ClaimsSteps.okTimeButton();
        Claims.descriptionField.perform(replaceText("Очень надо"), closeSoftKeyboard());
        ClaimsSteps.saveButton();
        onView(allOf(withId(R.id.message), isFocusable()));
        ClaimsSteps.okButtonInError();
        onView(allOf(withId(R.id.text_input_end_icon), isFocusable()));
        ClaimsSteps.cancelClaimButton();
        ClaimsSteps.okButtonNotification();
    }

    @Test
    public void titleFieldOneCharacter() {
        Main.mainMenuButton();
        ClaimsSteps.isClaimsButton();
        ClaimsSteps.addClaimsButton();
        Claims.titleField.perform(replaceText("Заявка"), closeSoftKeyboard());
        Claims.executorField.perform(replaceText("Козлов Лев Васильевич"), closeSoftKeyboard());
        ClaimsSteps.dataField();
        ClaimsSteps.okDateButton();
        ClaimsSteps.timeField();
        ClaimsSteps.okTimeButton();
        Claims.descriptionField.perform(replaceText("Нужна помощь"), closeSoftKeyboard());
        ClaimsSteps.saveButton();
        ClaimsSteps.isClaimsScreen();
    }

    @Test
    public void executorFieldIsEmpty() {
        Main.mainMenuButton();
        ClaimsSteps.isClaimsButton();
        ClaimsSteps.addClaimsButton();
        Claims.titleField.perform(replaceText("Заявка"), closeSoftKeyboard());
        Claims.executorField.perform(replaceText(""), closeSoftKeyboard());
        ClaimsSteps.dataField();
        ClaimsSteps.okDateButton();
        ClaimsSteps.timeField();
        ClaimsSteps.okTimeButton();
        Claims.descriptionField.perform(replaceText("Нужен тестировщик"), closeSoftKeyboard());
        ClaimsSteps.saveButton();
        ClaimsSteps.isClaimsScreen();
    }

    @Test
    public void executorFieldOtherData() {

        Main.mainMenuButton();
        ClaimsSteps.isClaimsButton();
        ClaimsSteps.addClaimsButton();
        Claims.titleField.perform(replaceText("Вводим Executor"), closeSoftKeyboard());
        Claims.executorField.perform(replaceText("Сидоров Сидро Сидорович"), closeSoftKeyboard());
        ClaimsSteps.dataField();
        ClaimsSteps.okDateButton();
        ClaimsSteps.timeField();
        ClaimsSteps.okTimeButton();
        Claims.descriptionField.perform(replaceText("Починить самокат"), closeSoftKeyboard());
        ClaimsSteps.saveButton();
        ClaimsSteps.isClaimsScreen();
    }

    @Test
    public void descriptionFieldIsEmpty() {

        Main.mainMenuButton();
        ClaimsSteps.isClaimsButton();
        ClaimsSteps.addClaimsButton();
        Claims.titleField.perform(replaceText("Без описания"), closeSoftKeyboard());
        Claims.executorField.perform(replaceText("Петров Петр Петрович"), closeSoftKeyboard());
        ClaimsSteps.dataField();
        ClaimsSteps.okDateButton();
        ClaimsSteps.timeField();
        ClaimsSteps.okTimeButton();
        Claims.descriptionField.perform(replaceText(""), closeSoftKeyboard());
        ClaimsSteps.saveButton();
        onView(allOf(withId(R.id.message), isFocusable()));
        ClaimsSteps.okButtonInError();
        onView(allOf(withId(R.id.text_input_end_icon), isFocusable()));
        ClaimsSteps.cancelClaimButton();
        ClaimsSteps.okButtonNotification();
    }

}