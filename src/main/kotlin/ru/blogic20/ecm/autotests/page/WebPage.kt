package ru.blogic20.ecm.autotests.page

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Wait
import org.openqa.selenium.support.ui.WebDriverWait
import ru.blogic20.ecm.autotests.util.DriverFactory
import java.time.Duration

open class WebPage(val driver: WebDriver) {


    fun fillField(text: String, xpath: String) {
        driver.findElement(By.xpath(xpath)).click()
        driver.findElement(By.xpath(xpath)).clear()
        driver.findElement(By.xpath(xpath)).sendKeys(text)
    }

    fun getElement(xpath:String): WebElement{
        return driver.findElement(By.xpath(xpath))
    }

}
