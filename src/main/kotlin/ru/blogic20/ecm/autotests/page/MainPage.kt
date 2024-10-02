package ru.blogic20.ecm.autotests.page

import io.celebrium.core.test.AssertType
import io.celebrium.core.test.Asserts
import io.celebrium.web.page.WebPage
import org.testng.Assert
import ru.blogic20.ecm.autotests.datastore.UserStore
import ru.blogic20.ecm.autotests.model.User
import ru.yandex.qatools.allure.annotations.Step
import java.time.Duration
import java.util.function.Function


class MainPage(fileName: String): WebPage(fileName) {


    fun openUserMenu() {
        click()
            .template("userMenuPopUp")
            .title("Клик по кнопке")
            .errorMessage("Ошибка при нажатии кнопки ")
            .perform()
    }
    @Step("Проверка выпадающего окошка \"Уведомления\"")
    fun notificationCheck(){
        click()
            .template("notificationsIcon")
            .title("Клик по кнопке-колокольчик")
            .errorMessage("Ошибка при нажатии по кнопке-колокольчик")
            .perform()

        val notificationTitle = text()
            .template("notificationsPopUpTitle")
            .title("Получение текста заголовка уведомлений")
            .timeout(50)
            .getFirst()

        Asserts.builder()
            .actual(notificationTitle)
            .expected("1Уведомления")
            .assertType(AssertType.BLOCK)
            .errorMessage("Значение поля \"$notificationTitle\" не соответствует ожидаемому.")
            .assertEquals()
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
//    fun logout(){
//        click(userMenuPopUp)
//        click(elementByInnerText.params("Выход"))
//    }
//
//    fun checkUserFullName(fullName: String) {
//        Assert.assertEquals(
//            findElement(By.xpath(userFullNameTitle)).text,
//            fullName
//        )
//    }
}
