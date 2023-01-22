package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static org.hamcrest.Matchers.allOf;
import android.os.SystemClock;
import androidx.test.espresso.NoMatchingViewException;
import androidx.test.rule.ActivityTestRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps;
import ru.iteco.fmhandroid.ui.steps.NewsSteps;;

@RunWith(AllureAndroidJUnit4.class)
public class NewsTests {
    AuthorizationSteps Auth = new AuthorizationSteps();
    MainSteps Main = new MainSteps();
    NewsControlPanelSteps NewsControlPanel = new NewsControlPanelSteps();
    NewsSteps News = new NewsSteps();

    @Rule
    public ActivityTestRule<AppActivity> mActivityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void authCheck() {
        SystemClock.sleep(5000);
        try {
            Main.isMainScreen();
        } catch (NoMatchingViewException e) {
            Auth.validAuth();
        }
        SystemClock.sleep(2000);
    }

    @Test
    @DisplayName("Сортировка новостей")
    public void sortNews() {
        Main.openNews();
        News.sortNews();
        News.isNewsScreen();
    }

    @Test
    @DisplayName("Фильтрация новостей, Объявление")
    public void filterNewsAdd() {
        Main.openNews();
        News.filterNews();
        News.isFilterScreen();
        News.selectFilterCategory("Объявление");
        News.applyNews();
        News.isNewsScreen();
    }

    @Test
    @DisplayName("Фильтрация новостей, День рождения")
    public void filterNewsBirthday() {
        Main.openNews();
        News.filterNews();
        News.isFilterScreen();
        News.selectFilterCategory("День рождения");
        News.applyNews();
        News.isNewsScreen();
    }

    @Test
    @DisplayName("Фильтрация новостей, Зарплата")
    public void filterNewsSalary() {
        Main.openNews();
        News.filterNews();
        News.isFilterScreen();
        News.selectFilterCategory("Зарплата");
        News.applyNews();
        News.isNewsScreen();
    }

    @Test
    @DisplayName("Фильтрация новостей, Профсоюз")
    public void filterNewsUnion() {
        Main.openNews();
        News.filterNews();
        News.isFilterScreen();
        News.selectFilterCategory("Профсоюз");
        News.applyNews();
        News.isNewsScreen();
    }

    @Test
    @DisplayName("Фильтрация новостей, Праздник")
    public void filterNewsHoliday() {
        Main.openNews();
        News.filterNews();
        News.isFilterScreen();
        News.selectFilterCategory("Праздник");
        News.applyNews();
        News.isNewsScreen();
    }

    @Test
    @DisplayName("Фильтрация новостей, Массаж")
    public void filterNewsMassage() {
        Main.openNews();
        News.filterNews();
        News.isFilterScreen();
        News.selectFilterCategory("Массаж");
        News.applyNews();
        News.isNewsScreen();
    }

    @Test
    @DisplayName("Фильтрация новостей, Благодарность")
    public void filterNewsGratitude() {
        Main.openNews();
        News.filterNews();
        News.isFilterScreen();
        News.selectFilterCategory("Благодарность");
        News.applyNews();
        News.isNewsScreen();
    }

    @Test
    @DisplayName("Фильтрация новостей, Нужна помощь")
    public void filterNewsHelp() {
        Main.openNews();
        News.filterNews();
        News.isFilterScreen();
        News.selectFilterCategory("Нужна помощь");
        News.applyNews();
        News.isNewsScreen();
    }

    @Test
    @DisplayName("Фильтрация новостей без категории")
    public void filterNews() {
        Main.openNews();
        News.filterNews();
        News.isFilterScreen();
        News.selectFilterCategory("");
        News.applyNews();
        News.isNewsScreen();
    }

    @Test
    @DisplayName("Просмотр новости из Панели инструментов")
    public void viewNewsInControlPanel() {
        Main.openNews();
        News.editNews();
        NewsControlPanel.expandNews();
        NewsControlPanel.checkExpandNews();
    }

    @Test
    @DisplayName("Сортировка новостей из Панели инструментов")
    public void sortNewsOnControlPanel() {
        Main.openNews();
        News.editNews();
        NewsControlPanel.sortNews();
        NewsControlPanel.isControlPanelScreen();
    }

    @Test
    @DisplayName("Фильтрация Активных новостей")
    public void filterNewsByActiveCriteria() {
        Main.openNews();
        News.editNews();
        NewsControlPanel.filterNews();
        NewsControlPanel.activeNews();
        NewsControlPanel.filterButton();
        NewsControlPanel.isControlPanelScreen();
    }

    @Test
    @DisplayName("Фильтрация Не Активных новостей")
    public void filterNewsByNotActiveCriteria() {
        Main.openNews();
        News.editNews();
        NewsControlPanel.filterNews();
        NewsControlPanel.notActiveNews();
        NewsControlPanel.filterButton();
        NewsControlPanel.isControlPanelScreen();
    }

    @Test
    @DisplayName("Смена новости с Активна на Не активна")
    public void changeStatusNewsFromActiveToNotActive() {
        Main.openNews();
        News.editNews();
        NewsControlPanel.filterNews();
        NewsControlPanel.activeNews();
        NewsControlPanel.filterButton();
        NewsControlPanel.editNews();
        NewsControlPanel.editStatus();
        NewsControlPanel.checkStatusNotActive();
        NewsControlPanel.saveButton();
        NewsControlPanel.isControlPanelScreen();
    }

    @Test
    @DisplayName("Смена статуса новости с Не активна на Активна")
    public void changeStatusNewsFromNotActiveToActive() {
        Main.openNews();
        News.editNews();
        NewsControlPanel.filterNews();
        NewsControlPanel.notActiveNews();
        NewsControlPanel.filterButton();
        NewsControlPanel.editNews();
        NewsControlPanel.editStatus();
        NewsControlPanel.checkStatusActive();
        NewsControlPanel.saveButton();
        NewsControlPanel.isControlPanelScreen();
    }

    @Test
    @DisplayName("Создание новости из Панеле Управления")
    public void createNewsOnControlPanel() {
        Main.openNews();
        News.editNews();
        NewsControlPanel.createNews();
        NewsControlPanel.selectCategory("Праздник");
        NewsControlPanel.enterTitle("Не забыть отметить!");
        NewsControlPanel.enterDate("16.01.2023");
        NewsControlPanel.enterTime("01:59");
        NewsControlPanel.enterDescription("Описание");
        closeSoftKeyboard();
        NewsControlPanel.saveButton();
        NewsControlPanel.isControlPanelScreen();
    }

    @Test
    @DisplayName("Создание новости без категории")
    public void createNewsWithEmptyCategory() {
        Main.openNews();
        News.editNews();
        NewsControlPanel.createNews();
        NewsControlPanel.selectCategory("");
        NewsControlPanel.enterTitle("Заголовок");
        NewsControlPanel.enterDate("11.01.2023");
        NewsControlPanel.enterTime("11:22");
        NewsControlPanel.enterDescription("Описание");
        closeSoftKeyboard();
        NewsControlPanel.saveButton();
        SystemClock.sleep(1000);
        onView(allOf(withContentDescription("Fill empty fields"), isDisplayed()));
    }

    @Test
    @DisplayName("Новость без заголовка")
    public void createNewsWithoutTitle() {
        Main.openNews();
        News.editNews();
        NewsControlPanel.createNews();
        NewsControlPanel.selectCategory("Праздник");
        NewsControlPanel.enterEditTitle(" ");
        NewsControlPanel.enterDate("11.11.2022");
        NewsControlPanel.enterTime("11:22");
        NewsControlPanel.enterDescription("Описание");
        closeSoftKeyboard();
        NewsControlPanel.saveButton();
        SystemClock.sleep(1000);
        onView(allOf(withContentDescription("Fill empty fields"), isDisplayed()));
        NewsControlPanel.cancelButton();
        NewsControlPanel.checkPopUpOk();
        NewsControlPanel.isControlPanelScreen();
    }

    @Test
    @DisplayName("Новость без даты")
    public void createNewsWithoutDate() {
        Main.openNews();
        News.editNews();
        NewsControlPanel.isControlPanelScreen();
        NewsControlPanel.createNews();
        NewsControlPanel.selectCategory("Профсоюз");
        NewsControlPanel.enterDate("");
        NewsControlPanel.enterTime("11:22");
        NewsControlPanel.enterDescription("Описание");
        closeSoftKeyboard();
        NewsControlPanel.saveButton();
        SystemClock.sleep(1000);
        onView(allOf(withContentDescription("Fill empty fields"), isDisplayed()));
        NewsControlPanel.cancelButton();
        NewsControlPanel.checkPopUpOk();
        NewsControlPanel.isControlPanelScreen();
    }

    @Test
    @DisplayName("Новость без времени")
    public void createNewsWithoutTime() {
        Main.openNews();
        News.editNews();
        NewsControlPanel.isControlPanelScreen();
        NewsControlPanel.createNews();
        NewsControlPanel.selectCategory("Праздник");
        NewsControlPanel.enterDate("01.01.2023");
        NewsControlPanel.enterTime("");
        NewsControlPanel.enterDescription("Описание");
        closeSoftKeyboard();
        NewsControlPanel.saveButton();
        SystemClock.sleep(1000);
        onView(allOf(withContentDescription("Fill empty fields"), isDisplayed()));
        NewsControlPanel.cancelButton();
        NewsControlPanel.checkPopUpOk();
        NewsControlPanel.isControlPanelScreen();
    }

    @Test
    @DisplayName("Новость без описания")
    public void createNewsWithoutDescription() {
        Main.openNews();
        News.editNews();
        NewsControlPanel.isControlPanelScreen();
        NewsControlPanel.createNews();
        NewsControlPanel.selectCategory("Профсоюз");
        NewsControlPanel.enterDate("11.01.2023 ");
        NewsControlPanel.enterTime("11:33 ");
        NewsControlPanel.enterDescription("");
        closeSoftKeyboard();
        NewsControlPanel.saveButton();
        SystemClock.sleep(1000);
        onView(allOf(withContentDescription("Fill empty fields"), isDisplayed()));
        NewsControlPanel.cancelButton();
        NewsControlPanel.checkPopUpOk();
        NewsControlPanel.isControlPanelScreen();
    }

    @Test
    @DisplayName("Удаление новости")
    public void deleteNewsOnControlPanel() {
        Main.openNews();
        News.editNews();
        NewsControlPanel.deleteNews();
        NewsControlPanel.checkPopUpOk();
        NewsControlPanel.isControlPanelScreen();
    }

    @Test
    @DisplayName("Редактирование новости")
    public void editNewsOnControlPanel() {
        Main.openNews();
        News.editNews();
        NewsControlPanel.editNews();
        NewsControlPanel.enterEditTitle("Новый заголовок");
        closeSoftKeyboard();
        NewsControlPanel.saveButton();
        SystemClock.sleep(1000);
        NewsControlPanel.isControlPanelScreen();
    }
}
