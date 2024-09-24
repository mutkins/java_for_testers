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
    fun login(login: String, pass: String) {
        driver.get(Configuration.config.getString("baseUrl"))
        fillField(login, "//input[@name='username']")
        fillField(pass, "//input[@name='password']")
        driver.findElement(By.tagName("button")).click()
        Thread.sleep(1000)
    }

    fun login(user: User){
        login(user.login, user.password)
    }



}