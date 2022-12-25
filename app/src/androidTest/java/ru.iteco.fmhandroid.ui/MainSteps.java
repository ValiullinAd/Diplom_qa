package ru.iteco.fmhandroid.ui;
import ru.iteco.fmhandroid.ui.MainPage;

import static androidx.test.espresso.action.ViewActions.click;

public class MainSteps {
    MainPage Main = new MainPage();

    public void openClaims() {
        Main.mainMenuButton.perform(click());
        Main.claims.perform(click());
    }

    public void openNews() {
        Main.mainMenuButton.perform(click());
        Main.news.perform(click());
    }

    public void openAbout() {
        Main.mainMenuButton.perform(click());
        Main.about.perform(click());
    }

    public void logOut() {
        Main.authorizationButton.perform(click());
        Main.logOut.perform(click());
    }

    public void clickAllNewsButton() {
        Main.allNews.perform(click());
    }

    public void clickAllClaims() {
        Main.allClaims.perform(click());
    }

    public void backFromAbout(){
        Main.backButton.perform(click());
    }

    public void ourMission(){
        Main.ourMissionButton.perform(click());
    }

    public void mainMenuButton(){
        Main.mainMenuButton.perform(click());
    }

}