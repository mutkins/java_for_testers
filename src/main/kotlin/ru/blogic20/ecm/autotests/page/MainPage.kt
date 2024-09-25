package ru.blogic20.ecm.autotests.page

import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.Wait
import org.openqa.selenium.support.ui.WebDriverWait
import org.testng.Assert
import java.time.Duration
import java.util.function.Function


class MainPage(driver: WebDriver): WebPage(driver) {

    val userMenuPopUp = "//*[@id='HEADER_USER_MENU_POPUP_text']"
    val userMenuProfile = "//*[@id='HEADER_USER_MENU_PROFILE_text']"
    val notificationsIcon = "//div[@title='Уведомления']"
    val notificationsPopUpTitle = "//*[@aria-labelledby='NOTIFICATIONS_BOX_text']//*[@class='alf-menu-group-title']"
    val simpleSearchField = "//*[@placeholder='Поиск по таблице' and not(ancestor::div[contains(@class,'hidden1')])]"
    val firstRowInDocTable = "//*[@id='arm-documents-grid']//tbody[@tabindex='0']//tr[1]//td[3]//a"
    val logoutButton = "//*[.='Выход']"
    val userFullNameTitle = "//*[@class='namelabel']"
    val elementByInnerText = "//*[.='%1%']"
    val elementByName = "//*[@name='%1%']"

    fun goToMainPage(){
        navigateTo(System.getProperty("baseUrl"))
    }

    fun openUserMenu() {
        click(userMenuPopUp)
        click(userMenuProfile)
    }
    fun notificationCheck(){
        click(notificationsIcon)
        Assert.assertEquals(
            findElement(notificationsPopUpTitle).text,
            "Уведомления")
    }
    fun simpleSearch(text: String){
        fillField(text,simpleSearchField)
        findElement(simpleSearchField).sendKeys(Keys.RETURN)

    }
    fun openDocFromDocTable(fileName: String){
        click(firstRowInDocTable)
    }

    fun logout(){
        click(userMenuPopUp)
        click(elementByInnerText.params("Выход"))
    }

    fun checkUserFullName(fullName: String) {
        Assert.assertEquals(
            findElement(By.xpath(userFullNameTitle)).text,
            fullName
        )
    }
}

typealias Xpath = String

fun Xpath.params(vararg params: String): Xpath {
    var template = this
    params.forEachIndexed { index, param ->
        template = template.replace("%${index + 1}%", param)
    }
    return template
}