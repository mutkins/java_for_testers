package ru.blogic20.ecm.autotests.page

//import org.openqa.selenium.By
//import org.openqa.selenium.WebDriver
import com.microsoft.playwright.BrowserType
import ru.blogic20.ecm.autotests.configuration.Configuration
import ru.blogic20.ecm.autotests.model.User

import com.microsoft.playwright.Page
import com.microsoft.playwright.Playwright
import io.celebrium.web.allure.Attachments
import ru.blogic20.ecm.autotests.util.PlaywrightPageStore
import ru.yandex.qatools.allure.annotations.Step
import java.util.concurrent.TimeUnit


/**
 * Page Object для страницы логина.
 */

class LoginPage(val page:Page){

    @Step("Вход с учетными данными \"{0}\"/\"{1}\"")
    fun login(login: String, pass: String) {
        //Вынести инициализацию браузера и конфига селебриума куда-то
//        Attachments.attach("Логин на стенд ${Configuration.config.getString("baseUrl")}", AttachmentType.TEXT, "Stand")

        page
            .locator("//*[@name='username']")
            .fill(login)

        page
            .locator("//*[@name='password']")
            .fill(pass)
        page.click("//*[.='Войти']")


//
//        input()
//            .template("Поле")
//            .parameters("username")
//            .clear()
//            .value(login)
//            .title("Ввод логина: $login")
//            .errorMessage("Ошибка при вводе имени пользователя.")
//            .perform()
//        input()
//            .template("Поле")
//            .parameters("password")
//            .clear()
//            .value(pass)
//            .title("Ввод пароля: $pass")
//            .errorMessage("Ошибка при вводе пароля пользователя.")
//            .perform()
//        click()
//            .template("Кнопка")
//            .parameters("Войти")
//            .title("Клик по кнопке \"Войти\"")
//            .errorMessage("Ошибка при нажатии кнопки \"Войти\".")
//            .perform()
    }

    fun login(user: User){
        login(user.login, user.password)
    }



}