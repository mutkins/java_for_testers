package ru.blogic20.ecm.tests.appManager

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import java.time.Duration
import java.util.concurrent.TimeUnit

open class ApplicationManager {
    lateinit var driver: WebDriver
    lateinit var sessionHelper: SessionHelper
    lateinit var userMenu: UserMenu
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
        this.sessionHelper = SessionHelper(driver)
        this.userMenu = UserMenu(driver)
        this.mainPage = MainPage(driver)
    }


    fun exit() {
        driver.quit()
    }

}
