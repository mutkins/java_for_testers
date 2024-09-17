package appManager

import org.openqa.selenium.firefox.FirefoxDriver
import java.time.Duration
import java.util.concurrent.TimeUnit

open class ApplicationManager {
    lateinit var driver: FirefoxDriver
    lateinit var sessionHelper: SessionHelper
    lateinit var userMenu: UserMenu
    lateinit var mainPage: MainPage
    fun init() {
        driver = FirefoxDriver()
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1))
        driver.manage().window().maximize()
        this.sessionHelper = SessionHelper(driver)
        this.userMenu = UserMenu(driver)
        this.mainPage = MainPage(driver)
    }


    fun exit() {
//        driver.quit()
    }

}
