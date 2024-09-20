package ru.blogic20.ecm.tests.appManager

import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.Wait
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

open class HelperBase(val driver: WebDriver) {
    val wait: Wait<WebDriver> = WebDriverWait(driver, Duration.ofSeconds(10))

    fun fillField(text: String, xpath: String) {
        driver.findElement(By.xpath(xpath)).click()
        driver.findElement(By.xpath(xpath)).clear()
        driver.findElement(By.xpath(xpath)).sendKeys(text)
    }

    fun getElement(xpath:String): WebElement{
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)))
        return driver.findElement(By.xpath(xpath))
    }

}
