package ru.iteco.fmhandroid.ui;

import androidx.test.espresso.ViewInteraction;
import ru.iteco.fmhandroid.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.allOf;

public class Claims {

   public static ViewInteraction buttonClaims = onView(allOf(withId(android.R.id.title), withText("Claims")));
   public static ViewInteraction buttonFilter = onView(allOf(withId(R.id.filters_material_button)));
   public static ViewInteraction removeCheckBoxOpen = onView(allOf(withId(R.id.item_filter_open)));
   public static ViewInteraction removeCheckBoxInProgress = onView(allOf(withId(R.id.item_filter_in_progress)));
   public static ViewInteraction checkBoxExecuted = onView(allOf(withId(R.id.item_filter_executed)));
   public static ViewInteraction checkBoxCancelled = onView(allOf(withId(R.id.item_filter_cancelled)));
   public static ViewInteraction buttonOk = onView(allOf(withId(R.id.claim_list_filter_ok_material_button)));
   public static ViewInteraction buttonAddClaim = onView(allOf(withId(R.id.add_new_claim_material_button)));
   public static ViewInteraction titleField = onView(allOf(withHint("Title"), withParent(withParent(withId(R.id.title_text_input_layout)))));
   public static ViewInteraction executorField = onView(allOf(withId(R.id.executor_drop_menu_auto_complete_text_view)));
   public static ViewInteraction dateField = onView(allOf(withId(R.id.date_in_plan_text_input_edit_text)));
   public static ViewInteraction buttonOkDate = onView(allOf(withId(android.R.id.button1)));
   public static ViewInteraction timeField = onView(allOf(withId(R.id.time_in_plan_text_input_edit_text)));
   public static ViewInteraction buttonOkTime = onView(allOf(withId(android.R.id.button1)));
   public static ViewInteraction descriptionField = onView(allOf(withId(R.id.description_edit_text)));
   public static ViewInteraction buttonSave = onView(allOf(withId(R.id.save_button)));
   public static ViewInteraction buttonOkError = onView(allOf(withId(android.R.id.button1)));
   public static ViewInteraction buttonCancelClaim = onView(allOf(withId(R.id.cancel_button)));
   public static ViewInteraction buttonOkNotification = onView(allOf(withId(android.R.id.button1)));
   public static ViewInteraction claimsScreen = onView(withId(R.id.claim_list_recycler_view));

}

