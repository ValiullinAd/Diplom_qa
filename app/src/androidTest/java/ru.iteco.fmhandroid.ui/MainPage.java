package ru.iteco.fmhandroid.ui;
import androidx.test.espresso.ViewInteraction;
import ru.iteco.fmhandroid.R;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.*;


public class MainPage {
    public static ViewInteraction authorizationButton = onView(withId(R.id.authorization_image_button));
    public static ViewInteraction logOut = onView((withText("Log out")));
    public static ViewInteraction claims = onView(withText("Claims"));
    public static ViewInteraction news = onView(withText("News"));
    public static ViewInteraction about = onView(withText("About"));
    public static ViewInteraction allNews = onView(withId(R.id.all_news_text_view));
    public static ViewInteraction allClaims = onView(withId(R.id.all_claims_text_view));
    public static ViewInteraction mainMenuButton = onView(withId(R.id.main_menu_image_button));
    public static ViewInteraction backButton = onView(withId(R.id.about_back_image_button));
    public static ViewInteraction ourMissionButton = onView(withId(R.id.our_mission_image_button));

}
