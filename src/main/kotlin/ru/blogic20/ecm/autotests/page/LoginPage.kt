package ru.blogic20.ecm.autotests.page

//import org.openqa.selenium.By
//import org.openqa.selenium.WebDriver

import com.microsoft.playwright.Page


/**
 * Page Object для страницы логина.
 */

class LoginPage(val page: Page){

//    @Step("Вход с учетными данными \"{0}\"/\"{1}\"")
    fun login(login: String, password: String) {
        page
            .locator("//*[@name='username']")
            .fill(login)

        page
            .locator("//*[@name='password']")
            .fill(password)
        page.click("//*[.='Войти']")

    }

}