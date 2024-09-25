package ru.blogic20.ecm.autotests.page

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import ru.blogic20.ecm.autotests.configuration.Configuration
import ru.blogic20.ecm.autotests.model.User
import ru.blogic20.ecm.autotests.util.DriverFactory

/**
 * Page Object для страницы логина.
 */

class LoginPage(driver: WebDriver): WebPage(driver){

    val elementByName = "//*[@name='%1%']"

    fun login(login: String, pass: String) {
        navigateTo(Configuration.config.getString("baseUrl"))
        fillField(login, elementByName.params("username"))
        fillField(pass, elementByName.params("password"))
        click(By.tagName("button"))
    }

    fun login(user: User){
        login(user.login, user.password)
    }



}