package ru.blogic20.ecm.autotests.util

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import java.time.Duration

object DriverFactory {

//    fun getDriver(): WebDriver{
//         val driver = when (System.getProperty("browser")){
//                "firefox"-> FirefoxDriver()
//                "chrome" -> ChromeDriver()
//                else -> FirefoxDriver()
//         }
//
//         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1))
//                driver.manage().window().maximize()
//         return driver
//    }
}