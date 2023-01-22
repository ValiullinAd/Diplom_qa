package ru.iteco.fmhandroid.ui.elements;

import androidx.test.espresso.ViewInteraction;
import ru.iteco.fmhandroid.R;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.utils.Utils.withIndex;

public class ClaimsElements {
    public ViewInteraction claimsScreen = onView(withId(R.id.claim_list_recycler_view));
    public ViewInteraction openFilter = onView(withId(R.id.filters_material_button));
    public ViewInteraction create = onView(withId(R.id.add_new_claim_material_button));
    public ViewInteraction closeClaim = onView(withId(R.id.close_image_button));
    public ViewInteraction openFirstClaim = onView(allOf(withIndex(withId(R.id.claim_list_card), 0)));
    public ViewInteraction saveButton = onView(withId(R.id.save_button));
    public ViewInteraction emptyFieldsWarning = onView(withText("Fill empty fields"));
    public ViewInteraction swipe = onView(withId(android.R.id.content));
    public ViewInteraction filterScreen = onView(withId(R.id.claim_filter_dialog_title));
    public ViewInteraction checkBoxOpen = onView(withId(R.id.item_filter_open));
    public ViewInteraction checkBoxInProgress = onView(withId(R.id.item_filter_in_progress));
    public ViewInteraction executed = onView(withId(R.id.item_filter_executed));
    public ViewInteraction cancelled = onView(withId(R.id.item_filter_cancelled));
    public ViewInteraction applyClaims = onView(withId(R.id.claim_list_filter_ok_material_button));
    public ViewInteraction creatingScreen = onView(withText("Creating"));
    public ViewInteraction createTitle = onView(withId(R.id.title_edit_text));
    public ViewInteraction createExecutor = onView(withId(R.id.executor_drop_menu_auto_complete_text_view));
    public ViewInteraction createDate = onView(withId(R.id.date_in_plan_text_input_edit_text));
    public ViewInteraction createTime = onView(withId(R.id.time_in_plan_text_input_edit_text));
    public ViewInteraction description = onView(withId(R.id.description_material_text_view));
    public ViewInteraction createDescription = onView(withId(R.id.description_edit_text));
    public ViewInteraction editButton = onView(withId(R.id.edit_processing_image_button));
    public ViewInteraction editTitle = onView(withId(R.id.title_edit_text));
    public ViewInteraction editExecutor = onView(withId(R.id.executor_drop_menu_auto_complete_text_view));
    public ViewInteraction editDate = onView(withId(R.id.date_in_plan_text_input_edit_text));
    public ViewInteraction editTime = onView(withId(R.id.time_in_plan_text_input_edit_text));
    public ViewInteraction editDescription = onView(withId(R.id.description_edit_text));
    public ViewInteraction fieldComment = onView(allOf(withHint("Comment"),withParent(withParent(withId(R.id.comment_text_input_layout)))));
    public ViewInteraction addComment = onView(withId(R.id.add_comment_image_button));
    public ViewInteraction editComment = onView(allOf(withIndex(withId(R.id.edit_comment_image_button), 1)));
    public ViewInteraction comment = onView(withId(R.id.comments_material_card_view));
    public ViewInteraction blockComment = onView(withId(R.id.all_claims_cards_block_constraint_layout));
}