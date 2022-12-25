package ru.iteco.fmhandroid.ui;
import androidx.test.espresso.ViewInteraction;
import ru.iteco.fmhandroid.R;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.*;


public class News {
    public ViewInteraction newsScreen = onView(withId(R.id.container_list_news_include));
    public ViewInteraction sort = onView(withId(R.id.sort_news_material_button));
    public ViewInteraction filter = onView(withId(R.id.filter_news_material_button));
    public ViewInteraction category = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    public ViewInteraction dateStart = onView(withId(R.id.news_item_publish_date_start_text_input_edit_text));
    public ViewInteraction dateEnd = onView(withId(R.id.news_item_publish_date_end_text_input_edit_text));
    public ViewInteraction applyNews = onView(withId(R.id.filter_button));
}
