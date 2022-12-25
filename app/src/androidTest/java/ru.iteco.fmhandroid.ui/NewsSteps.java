package ru.iteco.fmhandroid.ui;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.News;

import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

    public class NewsSteps {
        News News = new News();

        public void isNewsScreen() {
            News.newsScreen.check(matches(isDisplayed()));
        }

        public void sortNews() {
            News.sort.perform(click());
        }

        public void filterNews() {
            News.filter.perform(click());
        }

        public void selectFilterCategory(String text) {
            News.category.perform(click());
            News.category.perform(replaceText(text));
        }

        public void dateStart(String date) {
            News.dateStart.perform(replaceText(date));
        }

        public void dateEnd(String date) {
            News.dateEnd.perform(replaceText(date));
        }

        public void applyNews() {
            News.applyNews.perform(click());
        }

    }


