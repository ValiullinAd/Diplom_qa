package ru.iteco.fmhandroid.ui;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.Claims;

import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

public class ClaimsSteps {
    Claims Claims = new Claims();

    public void isClaimsScreen() {
        Claims.claimsScreen.check(matches(isDisplayed()));
    }

    public void isClaimsButton() {
        Claims.buttonClaims.perform(click());
    }

    public void addClaimsButton(){
        Claims.buttonAddClaim.perform(click());
    }

    public void cancelClaimButton(){
        Claims.buttonCancelClaim.perform(click());
    }

    public void okButtonInError(){
        Claims.buttonOkError.perform(click());
    }

    public void okButtonNotification(){
        Claims.buttonOkNotification.perform(click());
    }

    public void saveButton(){
        Claims.buttonSave.perform(click());
    }

    public void okTimeButton(){
        Claims.buttonOkTime.perform(click());
    }

    public void dataField(){
        Claims.dateField.perform(click());
    }

    public void okDateButton(){
        Claims.buttonOkDate.perform(click());
    }

    public void timeField(){
        Claims.timeField.perform(click());
    }

    public void buttonOk(){
        Claims.buttonOk.perform(click());
    }

    public void cancelCheckBox(){
        Claims.checkBoxCancelled.perform(click());
    }

    public void buttonFilter(){
        Claims.buttonFilter.perform(click());
    }

    public void checkBoxOpen(){
        Claims.removeCheckBoxOpen.perform(click());
    }

    public void checkBoxInProgress(){
        Claims.removeCheckBoxInProgress.perform(click());
    }

    public void checkBoxExecute(){
        Claims.checkBoxExecuted.perform(click());
    }

    public void titleField(){

    }

}
