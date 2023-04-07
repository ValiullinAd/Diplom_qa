package ru.iteco.fmhandroid.ui.utils;

import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import android.view.View;
import androidx.test.espresso.PerformException;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.util.HumanReadables;
import androidx.test.espresso.util.TreeIterables;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import java.util.concurrent.TimeoutException;
//import org.apache.commons.lang3.RandomStringUtils;
//import java.util.UUID;
//import java.util.Random;

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
    public static ViewAction waitDisplayed(final int viewId, final long millis) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isRoot();
            }

            @Override
            public String getDescription() {
                return "wait for a specific view with id <" + viewId + "> is shown during " + millis + " millis.";
            }

            @Override
            public void perform(final UiController uiController, final View view) {
                uiController.loopMainThreadUntilIdle();
                final long startTime = System.currentTimeMillis();
                final long endTime = startTime + millis;
                final Matcher<View> viewMatcher = withId(viewId);

                do {
                    for (View child : TreeIterables.breadthFirstViewTraversal(view)) {
                        // found view with required ID
                        if (viewMatcher.matches(child) && child.isShown()) {
                            return;
                        }
                    }

                    uiController.loopMainThreadForAtLeast(50);
                }
                while (System.currentTimeMillis() < endTime);

                // timeout happens
                throw new PerformException.Builder()
                        .withActionDescription(this.getDescription())
                        .withViewDescription(HumanReadables.describe(view))
                        .withCause(new TimeoutException())
                        .build();
            }
        };
    }
//    public static class textHelpers {
//        public static String getText(ViewInteraction matcher) {
//            final String[] text = new String[1];
//            ViewAction va = new ViewAction() {
//
//                @Override
//                public Matcher<View> getConstraints() {
//                    return isAssignableFrom(TextView.class);
//                }
//
//                @Override
//                public String getDescription() {
//                    return "Text of the view";
//                }
//
//                @Override
//                public void perform(UiController uiController, View view) {
//                    TextView tv = (TextView) view;
//                    text[0] = tv.getText().toString();
//                }
//            };
//
//            matcher.perform(va);
//
//            return text[0];
//        }
//    }
//    public class generatorText { char c; int b;
//        public void main(String[] args) {
//            String dict = "abcdefghijklmnopqrstuvwxyz";
//            //строка содержит все доступные символы
//            char c = dict[Random % dict.length];
//            //в переменную с записывается случайный из них
//            String dict2 = "123456789";
//            // строка содержит все доступные символы
//            int b = dict2[Random % dict2.length];
//            // в переменную с записывается случайный из них
//        }
//
//    }
//public class Test098889 {
//
//    public void main(String[] args) {
//        int length = 25;
//        System.out.println(generatePswd(length));
//    }
//
//    public char[] generatePswd(int len) {
//        System.out.println("Your Password: ");
//        String charsCaps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//        String nums = "0123456789";
//        String passSymbols = charsCaps + nums;
//        Random rnd = new Random();
//        char[] password = new char[len];
//
//        for (int i = 0; i < len; i++) {
//            password[i] = passSymbols.charAt(rnd.nextInt(passSymbols.length()));
//        }
//        return password;
//
//    }
//}


}

