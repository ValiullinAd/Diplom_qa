package ru.iteco.fmhandroid.ui.steps;

import android.app.Instrumentation;
import android.content.Intent;
import androidx.test.espresso.intent.Intents;
import io.qameta.allure.kotlin.Allure;
import org.hamcrest.Matcher;
import ru.iteco.fmhandroid.ui.elements.AboutElements;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.Intents.intending;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.hamcrest.core.AllOf.allOf;

public class AboutSteps {
    AboutElements about = new AboutElements();

    public void isAboutScreen() {
        Allure.step("Проверить, что это окно About");
        about.title.check(matches(isDisplayed()));
    }

    public void checkTerms() {
        Allure.step("Просмотр ссылки Пользовательское соглашение");
        Intents.init();
        Matcher<Intent> expectedIntent = allOf(hasAction(Intent.ACTION_VIEW), hasData("https://vhospice.org/#/terms-of-use"));
        intending(expectedIntent).respondWith(new Instrumentation.ActivityResult(0, null));
        about.terms.perform(click());
        intended(expectedIntent);
        Intents.release();
    }

    public void checkPrivacy() {
        Allure.step("Просмотр ссылки Политика конфиденциальности");
        Intents.init();
        Matcher<Intent> expectedIntent = allOf(hasAction(Intent.ACTION_VIEW), hasData("https://vhospice.org/#/privacy-policy/"));
        intending(expectedIntent).respondWith(new Instrumentation.ActivityResult(0, null));
        about.privacy.perform(click());
        intended(expectedIntent);
        Intents.release();
    }

    public void backButton() {
        Allure.step("Возврат к предыдущему экрану");
        about.backButton.perform(click());
    }
}
