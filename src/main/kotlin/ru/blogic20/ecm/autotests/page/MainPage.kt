package ru.blogic20.ecm.autotests.page

import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.Wait
import org.openqa.selenium.support.ui.WebDriverWait
import org.testng.Assert
import java.time.Duration
import java.util.function.Function


class MainPage(driver: WebDriver): WebPage(driver) {

    fun goToMainPage(){
        driver.get(System.getProperty("baseUrl"))
        Thread.sleep(1000)
    }

    fun openUserMenu() {
        driver.findElement(By.xpath("//*[@id='HEADER_USER_MENU_POPUP_text']")).click()
        Thread.sleep(1000)
        driver.findElement(By.xpath("//*[@id='HEADER_USER_MENU_PROFILE_text']")).click()
    }
    fun notificationCheck(){
        driver.findElement(By.xpath("//div[@title='Уведомления']")).click()
        Assert.assertEquals(driver.findElement((By.xpath("//*[@aria-labelledby='NOTIFICATIONS_BOX_text']//*[@class='alf-menu-group-title']"))).text,
            "Уведомления")
    }
    fun simpleSearch(text: String){
        fillField(text,"//*[@placeholder='Поиск по таблице' and not(ancestor::div[contains(@class,'hidden1')])]")
        getElement("//*[@placeholder='Поиск по таблице' and not(ancestor::div[contains(@class,'hidden1')])]").sendKeys(Keys.RETURN)

    }
    fun openDocFromDocTable(fileName: String){
        getElement("//*[@id='arm-documents-grid']//tbody[@tabindex='0']//tr[1]//td[4]//*[.='" + "filename.pdf']")
        getElement("//*[@id='arm-documents-grid']//tbody[@tabindex='0']//tr[1]//td[3]//a").click()
    }

    fun logout(){
        Thread.sleep(1000)
        openUserMenu()
        driver.findElement(By.xpath("//*[.='Выход']")).click()
        Thread.sleep(1000)
    }

    fun checkUserFullName(name: String) {
        Assert.assertEquals(
            driver.findElement(By.xpath("//*[@class='namelabel']")).text,
            name
        )
    }
}