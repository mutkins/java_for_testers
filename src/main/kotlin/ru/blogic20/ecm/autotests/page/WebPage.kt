//package ru.blogic20.ecm.autotests.page
//
//import org.openqa.selenium.By
//import org.openqa.selenium.WebDriver
//import org.openqa.selenium.WebElement
//import org.openqa.selenium.support.ui.ExpectedConditions
//import org.openqa.selenium.support.ui.Wait
//import org.openqa.selenium.support.ui.WebDriverWait
//import ru.blogic20.ecm.autotests.util.DriverFactory
//import java.time.Duration
//
//
//open class WebPage(val driver: WebDriver) {
//
//
//    // Метод для заполнения полей
//    fun fillField(text: String, xpath: String): WebElement {
//        val element = findElement(By.xpath(xpath))
//        element.click()
//        element.clear()
//        element.sendKeys(text)
//        return element
//    }
//
//    fun getElement(xpath:String): WebElement{
//        return driver.findElement(By.xpath(xpath))
//    }
//
//    // Метод для навигации по URL
//    fun navigateTo(url: String) {
//        driver.get(url)
//    }
//
//    // Метод для поиска элемента по XPath
//    fun findElement(xpath: String): WebElement{
//        return driver.findElement(By.xpath(xpath))
//    }
//
//    // Универсальный метод для поиска элемента по любому критерию
//    fun findElement(by: By): WebElement {
//        return driver.findElement(by)
//    }
//    // Метод для клика по элементу
//    fun click(xpath: String): WebElement {
//        val element = findElement(xpath)
//        element.click()
//        return element
//    }
//
//    fun click(by: By) {
//        findElement(by).click()
//    }
//
//}
