package ru.blogic20.ecm.autotests.page

import com.microsoft.playwright.Page
import io.celebrium.core.test.AssertType
import io.celebrium.web.page.WebPage
import org.testng.Assert
import ru.blogic20.ecm.autotests.datastore.UserStore
import ru.blogic20.ecm.autotests.model.User
import ru.blogic20.ecm.autotests.util.PlaywrightPageStore
import ru.yandex.qatools.allure.annotations.Step
import java.time.Duration
import java.util.function.Function


class MainPage(val page: Page){


    fun openUserMenu() {

        page
            .click("//*[@id='HEADER_USER_MENU_POPUP_text']")
    }
    @Step("Проверка выпадающего окошка \"Уведомления\"")
    fun notificationCheck(){

        page
            .click("//div[@title='Уведомления']")

        val notificationTitle =
            page
                .locator("//*[@aria-labelledby='NOTIFICATIONS_BOX_text']//*[@class='alf-menu-group-title']")
                .textContent()

        Assert.assertEquals(notificationTitle, "Уведомления")

    }
//    fun simpleSearch(text: String){
//        fillField(text,simpleSearchField)
//        findElement(simpleSearchField).sendKeys(Keys.RETURN)
//
//    }
//    fun openDocFromDocTable(fileName: String){
//        click(firstRowInDocTable)
//    }
//
    fun logout(){
        page.click("//*[@id='HEADER_USER_MENU_POPUP_text']")
        page.click("//*[.='Выход']")
    }

    fun checkUserFullName(fullName: String) {

        val text = page.textContent("//*[@class='namelabel']")
        Assert.assertEquals(text, fullName)
    }
}
