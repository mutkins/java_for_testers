package appManager

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver


class SessionHelper(driver: WebDriver): HelperBase(driver) {
    fun login(login: String, pass: String) {
        driver.get("http://172.19.199.244/share/page/arm?code=SBER_NPF")
        fillField(login, "//input[@name='username']")
        fillField(pass, "//input[@name='password']")
        driver.findElement(By.tagName("button")).click()
        Thread.sleep(1000)
    }



}