package ru.blogic20.ecm.tests

import io.celebrium.core.driver.DriverFactory
import org.openqa.selenium.Dimension
import org.openqa.selenium.Point
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxProfile
import org.openqa.selenium.remote.DesiredCapabilities
import org.testng.annotations.*
import ru.blogic20.ecm.autotests.ApplicationManager
import ru.blogic20.ecm.autotests.configuration.Configuration
import ru.blogic20.ecm.autotests.datastore.UserStore
import java.util.concurrent.TimeUnit

open class BaseTest {

    @BeforeSuite
    fun userInit(){
        println("BeforeSuite initialization")
        if (UserStore.users.isEmpty()) {
            UserStore.init()
        }

    }

    @BeforeSuite
    fun celebriumInit(){
        io.celebrium.core.config.Configuration.init("data/celebrium_default.conf")
    }

//    @BeforeMethod
//    fun setUp() {
//        app = ApplicationManager()
//        app.init()
//    }

    @BeforeMethod
    fun initWebDriver(){
        println("WEB DRIVER INITIALIZATION")
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

    }

    @AfterMethod
    fun tearDown() {
        DriverFactory.closeDriver()

    }

    companion object{
        lateinit var app: ApplicationManager
    }

}
