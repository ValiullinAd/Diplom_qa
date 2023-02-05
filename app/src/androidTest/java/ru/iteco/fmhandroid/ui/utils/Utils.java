package ru.iteco.fmhandroid.ui.utils;

import android.view.View;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;
import ru.iteco.fmhandroid.R;
import android.os.SystemClock;
import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.PerformException;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.action.ViewActions.swipeUp;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static org.hamcrest.Matchers.allOf;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import android.view.MotionEvent;
import android.app.Instrumentation;
import androidx.test.espresso.ViewAction;
import static androidx.test.espresso.action.ViewActions.swipeUp;
import androidx.test.espresso.action.GeneralSwipeAction;
import androidx.test.espresso.action.Press;
import androidx.test.espresso.action.Swipe;
import androidx.test.espresso.action.GeneralLocation;



public class Utils {
    public static Matcher<View> withIndex(final Matcher<View> matcher, final int index) {
        return new TypeSafeMatcher<View>() {
            int currentIndex = 0;

            @Override
            public void describeTo(Description description) {
                description.appendText("with index: ");
                description.appendValue(index);
                matcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                return matcher.matches(view) && currentIndex++ == index;
            }
        };
    }

//    public static boolean isDisplayedWithSwipe(ViewInteraction locator, int recycler, boolean finishSwipe) {
//        try {
//            locator.check(matches(isDisplayed()));
//            return true;
//        } catch (NoMatchingViewException ignored) {
//        }
//        boolean invis = true;
//        int n = 1;
//        while (invis) {
//            try {
//                if (recycler == 1) {
//                    onView(allOf(withId(R.id.news_list_recycler_view), isDisplayed())).perform(actionOnItemAtPosition(n, swipeUp()));
//                } else {
//                    onView(allOf(withId(R.id.claim_list_recycler_view), isDisplayed())).perform(actionOnItemAtPosition(n, swipeUp()));
//                }
//            } catch (PerformException e) {
//                return false;
//            }
//            try {
//                locator.check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));//.check(matches(isDisplayed()));
//                invis = false;
//            } catch (NoMatchingViewException e) {
//                invis = true;
//            }
//            n++;
//            if (!invis & finishSwipe) {
//                try {
//                    if (recycler == 1) {
//                        onView(allOf(withId(R.id.news_list_recycler_view), isDisplayed())).perform(actionOnItemAtPosition(n, swipeUp()));
//                    } else {
//                        onView(allOf(withId(R.id.claim_list_recycler_view), isDisplayed())).perform(actionOnItemAtPosition(n, swipeUp()));
//                    }
//                } catch (PerformException e) {
//                    return false;
//                }
//            }
//            if (n > 400) {
//                return false;
//            }
//            SystemClock.sleep(2000);
//        };
//        return true;
//    }

    public static class Swipes {

        static void swiper(int start, int end, int delay) {
            long downTime = SystemClock.uptimeMillis();
            long eventTime = SystemClock.uptimeMillis();
            Instrumentation inst = getInstrumentation();

            MotionEvent event = MotionEvent.obtain(downTime, eventTime, MotionEvent.ACTION_DOWN, 500, start, 0);
            inst.sendPointerSync(event);
            eventTime = SystemClock.uptimeMillis() + delay;
            event = MotionEvent.obtain(downTime, eventTime, MotionEvent.ACTION_MOVE, 500, end, 0);
            inst.sendPointerSync(event);
            event = MotionEvent.obtain(downTime, eventTime, MotionEvent.ACTION_UP, 500, end, 0);
            inst.sendPointerSync(event);
            SystemClock.sleep(2000); //The wait is important to scroll
        }
        // This swipes all the way to the bottom of the screen
        public static void swipeToBottom(){
            swiper(1000, 650, 10);
        }

        // This scrolls down one page at a time
        public static void scrollSlowlyDown(){
            swiper(775, 100, 100);
        }

        // This swipes to the top
        public static void swipeToTop(){
            swiper(100, 1000, 0);
        }

        // This scrolls up one page at a time
        public static void scrollSlowlyUp(){
            swiper(100, 775, 100);
        }

    }

    public static ViewAction swipeUpSlow() {
        return new GeneralSwipeAction(Swipe.SLOW, GeneralLocation.BOTTOM_CENTER,
                GeneralLocation.TOP_CENTER, Press.FINGER);
    }

}
