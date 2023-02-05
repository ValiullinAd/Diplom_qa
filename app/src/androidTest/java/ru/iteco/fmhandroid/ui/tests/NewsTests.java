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
    AuthorizationSteps auth = new AuthorizationSteps();
    MainSteps main = new MainSteps();
    NewsControlPanelSteps newsControlPanel = new NewsControlPanelSteps();
    NewsSteps news = new NewsSteps();

    @Rule
    public ActivityTestRule<AppActivity> mActivityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void authCheck() {
        SystemClock.sleep(5000);
        try {
            main.isMainScreen();
        } catch (NoMatchingViewException e) {
            auth.validAuth();
        }
        SystemClock.sleep(2000);
    }

    @Test
    @DisplayName("Сортировка новостей")
    public void sortNews() {
        main.openNews();
        news.sortNews();
        news.isNewsScreen();
    }

    @Test
    @DisplayName("Фильтрация новостей, Объявление")
    public void filterNewsAdd() {
        main.openNews();
        news.isNewsScreen();
        news.filterNews();
        news.isFilterScreen();
        news.selectFilterCategory("Объявление");
        news.applyNews();
        news.checkAutoFilter();

    }

    @Test
    @DisplayName("Фильтрация новостей, День рождения")
    public void filterNewsBirthday() {
        main.openNews();
        news.filterNews();
        news.isFilterScreen();
        news.selectFilterCategory("День рождения");
        news.applyNews();
        news.checkAutoFilter();
    }

    @Test
    @DisplayName("Фильтрация новостей, Зарплата")
    public void filterNewsSalary() {
        main.openNews();
        news.filterNews();
        news.isFilterScreen();
        news.selectFilterCategory("Зарплата");
        news.applyNews();
        news.checkAutoFilter();
    }

    @Test
    @DisplayName("Фильтрация новостей, Профсоюз")
    public void filterNewsUnion() {
        main.openNews();
        news.filterNews();
        news.isFilterScreen();
        news.selectFilterCategory("Профсоюз");
        news.applyNews();
        news.checkAutoFilter();
    }

    @Test
    @DisplayName("Фильтрация новостей, Праздник")
    public void filterNewsHoliday() {
        main.openNews();
        news.filterNews();
        news.isFilterScreen();
        news.selectFilterCategory("Праздник");
        news.applyNews();
        news.checkAutoFilter();
    }

    @Test
    @DisplayName("Фильтрация новостей, Массаж")
    public void filterNewsMassage() {
        main.openNews();
        news.filterNews();
        news.isFilterScreen();
        news.selectFilterCategory("Массаж");
        news.applyNews();
        news.checkAutoFilter();
    }

    @Test
    @DisplayName("Фильтрация новостей, Благодарность")
    public void filterNewsGratitude() {
        main.openNews();
        news.filterNews();
        news.isFilterScreen();
        news.selectFilterCategory("Благодарность");
        news.applyNews();
        news.checkAutoFilter();
    }

    @Test
    @DisplayName("Фильтрация новостей, Нужна помощь")
    public void filterNewsHelp() {
        main.openNews();
        news.filterNews();
        news.isFilterScreen();
        news.selectFilterCategory("Нужна помощь");
        news.applyNews();
        news.checkAutoFilter();
    }

    @Test
    @DisplayName("Фильтрация новостей без категории")
    public void filterNews() {
        main.openNews();
        news.filterNews();
        news.isFilterScreen();
        news.selectFilterCategory("");
        news.applyNews();
        news.checkAutoFilter();
    }

    @Test
    @DisplayName("Просмотр новости из Панели инструментов")
    public void viewNewsInControlPanel() {
        main.openNews();
        news.editNews();
        newsControlPanel.expandNews();
        newsControlPanel.checkExpandNews();
    }

    @Test
    @DisplayName("Сортировка новостей из Панели инструментов")
    public void sortNewsOnControlPanel() {
        main.openNews();
        news.editNews();
        newsControlPanel.sortNews();
        newsControlPanel.isControlPanelScreen();
    }

    @Test
    @DisplayName("Фильтрация Активных новостей")
    public void filterNewsByActiveCriteria() {
        main.openNews();
        news.editNews();
        newsControlPanel.filterNews();
        newsControlPanel.activeNews();
        newsControlPanel.filterButton();
        newsControlPanel.isControlPanelScreen();
    }

    @Test
    @DisplayName("Фильтрация Не Активных новостей")
    public void filterNewsByNotActiveCriteria() {
        main.openNews();
        news.editNews();
        newsControlPanel.filterNews();
        newsControlPanel.notActiveNews();
        newsControlPanel.filterButton();
        newsControlPanel.isControlPanelScreen();
    }

    @Test
    @DisplayName("Смена новости с Активна на Не активна")
    public void changeStatusNewsFromActiveToNotActive() {
        main.openNews();
        news.editNews();
        newsControlPanel.filterNews();
        newsControlPanel.activeNews();
        newsControlPanel.filterButton();
        newsControlPanel.editNews();
        newsControlPanel.editStatus();
        newsControlPanel.checkStatusNotActive();
        newsControlPanel.saveButton();
        newsControlPanel.isControlPanelScreen();
    }

    @Test
    @DisplayName("Смена статуса новости с Не активна на Активна")
    public void changeStatusNewsFromNotActiveToActive() {
        main.openNews();
        news.editNews();
        newsControlPanel.filterNews();
        newsControlPanel.notActiveNews();
        newsControlPanel.filterButton();
        newsControlPanel.editNews();
        newsControlPanel.editStatus();
        newsControlPanel.checkStatusActive();
        newsControlPanel.saveButton();
        newsControlPanel.isControlPanelScreen();
    }

    @Test
    @DisplayName("Создание новости из Панеле Управления")
    public void createNewsOnControlPanel() {
        main.openNews();
        news.editNews();
        newsControlPanel.createNews();
        newsControlPanel.selectCategory("Праздник");
        newsControlPanel.enterTitle("Не забыть отметить!");
        news.dateCreatingNews();
        news.clickNewsOkButton();
        news.timeCreatingNews();
        news.clickNewsOkButton();
        newsControlPanel.enterDescription("Описание");
        closeSoftKeyboard();
        newsControlPanel.saveButton();
        newsControlPanel.isControlPanelScreen();
    }

    @Test
    @DisplayName("Создание новости")
    public void createNews() {
        main.openNews();
        news.editNews();
        newsControlPanel.createNews();
        newsControlPanel.selectCategory("Праздник");
        newsControlPanel.enterTitle("Не забыть отметить!");
        news.dateCreatingNews();
        news.clickNewsOkButton();
        news.timeCreatingNews();
        news.clickNewsOkButton();
        newsControlPanel.enterDescription("Будем отмечать");
        closeSoftKeyboard();
        newsControlPanel.saveButton();
        news.checkCreation();
    }

    @Test
    @DisplayName("Создание новости без категории")
    public void createNewsWithEmptyCategory() {
        main.openNews();
        news.editNews();
        newsControlPanel.createNews();
        newsControlPanel.selectCategory("");
        newsControlPanel.enterTitle("Заголовок");
        news.dateCreatingNews();
        news.clickNewsOkButton();
        news.timeCreatingNews();
        news.clickNewsOkButton();
        newsControlPanel.enterDescription("Описание");
        closeSoftKeyboard();
        newsControlPanel.saveButton();
        news.fillEmptyField();
    }

    @Test
    @DisplayName("Новость без заголовка")
    public void createNewsWithoutTitle() {
        main.openNews();
        news.editNews();
        newsControlPanel.createNews();
        newsControlPanel.selectCategory("Праздник");
        newsControlPanel.enterEditTitle("");
        news.dateCreatingNews();
        news.clickNewsOkButton();
        news.timeCreatingNews();
        news.clickNewsOkButton();
        newsControlPanel.enterDescription("Описание");
        closeSoftKeyboard();
        newsControlPanel.saveButton();
        news.fillEmptyField();
        newsControlPanel.cancelButton();
        newsControlPanel.checkPopUpOk();
        newsControlPanel.isControlPanelScreen();
    }

    @Test
    @DisplayName("Новость без даты")
    public void createNewsWithoutDate() {
        main.openNews();
        news.editNews();
        newsControlPanel.isControlPanelScreen();
        newsControlPanel.createNews();
        newsControlPanel.selectCategory("Профсоюз");
        newsControlPanel.enterEditTitle("Hello!");
        newsControlPanel.enterDate("");
        news.timeCreatingNews();
        news.clickNewsOkButton();
        newsControlPanel.enterDescription("Описание");
        closeSoftKeyboard();
        newsControlPanel.saveButton();
        news.fillEmptyField();
        newsControlPanel.cancelButton();
        newsControlPanel.checkPopUpOk();
        newsControlPanel.isControlPanelScreen();
    }

    @Test
    @DisplayName("Новость без времени")
    public void createNewsWithoutTime() {
        main.openNews();
        news.editNews();
        newsControlPanel.isControlPanelScreen();
        newsControlPanel.createNews();
        newsControlPanel.selectCategory("Праздник");
        newsControlPanel.enterEditTitle("Piu");
        news.dateCreatingNews();
        news.clickNewsOkButton();
        newsControlPanel.enterTime("");
        newsControlPanel.enterDescription("Описание");
        closeSoftKeyboard();
        newsControlPanel.saveButton();
        news.fillEmptyField();
        newsControlPanel.cancelButton();
        newsControlPanel.checkPopUpOk();
        newsControlPanel.isControlPanelScreen();
    }

    @Test
    @DisplayName("Новость без описания")
    public void createNewsWithoutDescription() {
        main.openNews();
        news.editNews();
        newsControlPanel.isControlPanelScreen();
        newsControlPanel.createNews();
        newsControlPanel.selectCategory("Профсоюз");
        newsControlPanel.enterEditTitle("WOW");
        news.dateCreatingNews();
        news.clickNewsOkButton();
        news.timeCreatingNews();
        news.clickNewsOkButton();
        newsControlPanel.enterDescription(" ");
        closeSoftKeyboard();
        newsControlPanel.saveButton();
        news.fillEmptyField();
        newsControlPanel.cancelButton();
        newsControlPanel.checkPopUpOk();
        newsControlPanel.isControlPanelScreen();
    }

    @Test
    @DisplayName("Удаление новости")
    public void deleteNewsOnControlPanel() {
        main.openNews();
        news.editNews();
        newsControlPanel.deleteNews();
        newsControlPanel.checkPopUpOk();
        newsControlPanel.isControlPanelScreen();
    }

    @Test
    @DisplayName("Редактирование новости")
    public void editNewsOnControlPanel() {
        main.openNews();
        news.editNews();
        newsControlPanel.editNews();
        newsControlPanel.enterEditTitle("Новый заголовок");
        closeSoftKeyboard();
        newsControlPanel.saveButton();
        newsControlPanel.isControlPanelScreen();
    }
}
