package ru.blogic20.ecm.autotests.appManager

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import ru.blogic20.ecm.autotests.page.MainPage
import ru.blogic20.ecm.autotests.page.LoginPage
import java.time.Duration

open class ApplicationManager {
    lateinit var driver: WebDriver
    lateinit var loginPage: LoginPage
    lateinit var mainPage: MainPage
    fun init() {
        println("DRIVER INIT")
        println("System.getProperty(browser)=${System.getProperty("browser")}")
        driver = when (System.getProperty("browser")){
             "firefox"-> FirefoxDriver()
            "chrome" -> ChromeDriver()
            else -> FirefoxDriver()
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1))
        driver.manage().window().maximize()
        this.loginPage = LoginPage(driver)
        this.mainPage = MainPage(driver)
    }


    fun exit() {
        driver.quit()
    }

}
