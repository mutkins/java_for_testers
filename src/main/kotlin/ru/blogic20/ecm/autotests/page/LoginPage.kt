package ru.blogic20.ecm.autotests.page

//import org.openqa.selenium.By
//import org.openqa.selenium.WebDriver
import ru.blogic20.ecm.autotests.configuration.Configuration
import ru.blogic20.ecm.autotests.model.User
import io.celebrium.core.driver.DriverFactory
import io.celebrium.utils.TimeManager
import io.celebrium.web.allure.AttachmentType
import io.celebrium.web.allure.Attachments
import io.celebrium.web.page.WebPage
import org.openqa.selenium.Dimension
import org.openqa.selenium.Point
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxProfile
import org.openqa.selenium.remote.DesiredCapabilities
import java.util.concurrent.TimeUnit


/**
 * Page Object для страницы логина.
 */

class LoginPage(fileName: String):WebPage(fileName){


    fun login(login: String, pass: String) {
        io.celebrium.core.config.Configuration.init("data/celebrium_default.conf")

        val gridHubUrl = System.getProperty("grid.url")
        val capabilities = DesiredCapabilities.firefox()
        val profile = FirefoxProfile()
        profile.setPreference("intl.accept_languages", "ru-RU")
        capabilities.setCapability(FirefoxDriver.PROFILE, profile)
        val driver = DriverFactory.initDriver(gridHubUrl, capabilities)
        driver.manage().deleteAllCookies()
        driver.manage().window().position = Point(0, 0)
        driver.manage().window().size = Dimension(1920, 1080)
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS)
        DriverFactory.registerDriver(driver)
        DriverFactory.getDriver().get(Configuration.config.getString("baseUrl"))

        input()
            .template("Поле")
            .parameters("username")
            .clear()
            .value(login)
            .title("Ввод логина: $login")
            .errorMessage("Ошибка при вводе имени пользователя.")
            .perform()
        input()
            .template("Поле")
            .parameters("password")
            .clear()
            .value(pass)
            .title("Ввод пароля: $pass")
            .errorMessage("Ошибка при вводе пароля пользователя.")
            .perform()
        click()
            .template("Кнопка")
            .parameters("Войти")
            .title("Клик по кнопке \"Войти\"")
            .errorMessage("Ошибка при нажатии кнопки \"Войти\".")
            .perform()
    }

    fun login(user: User){
        login(user.login, user.password)
    }



}