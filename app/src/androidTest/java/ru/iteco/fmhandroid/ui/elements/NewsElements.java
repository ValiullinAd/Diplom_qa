package ru.iteco.fmhandroid.ui.elements;

import androidx.test.espresso.ViewInteraction;
import ru.iteco.fmhandroid.R;
import static androidx.test.espresso.Espresso.onView;
import static org.hamcrest.core.AllOf.allOf;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.utils.Utils.withIndex;

public class NewsElements {
    public ViewInteraction newsScreen = onView(withId(R.id.container_list_news_include));
    public ViewInteraction sort = onView(withId(R.id.sort_news_material_button));
    public ViewInteraction filter = onView(withId(R.id.filter_news_material_button));
    public ViewInteraction edit = onView(withId(R.id.edit_news_material_button));
    public ViewInteraction filterScreen = onView(withId(R.id.filter_news_title_text_view));
    public ViewInteraction category = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    public ViewInteraction applyNews = onView(withId(R.id.filter_button));
    public ViewInteraction checkCreationNews = onView(allOf(withIndex(withId(R.id.news_item_material_card_view), 0)));
    public ViewInteraction dateCreating = onView(allOf(withId(R.id.news_item_publish_date_text_input_edit_text)));
    public ViewInteraction timeCreation = onView(allOf(withId(R.id.news_item_publish_time_text_input_edit_text)));
    public ViewInteraction okButtonClick = onView(withText("OK"));
    public ViewInteraction autoFilter = onView(withId(R.id.all_news_cards_block_constraint_layout));
}
