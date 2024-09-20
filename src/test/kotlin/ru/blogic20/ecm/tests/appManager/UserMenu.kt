package ru.blogic20.ecm.tests.appManager

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.testng.Assert

class UserMenu(driver: WebDriver): HelperBase(driver) {

    fun checkUserFullName(name: String) {
        Assert.assertEquals(
            driver.findElement(By.xpath("//*[@class='namelabel']")).text,
            name
        )
    }
}