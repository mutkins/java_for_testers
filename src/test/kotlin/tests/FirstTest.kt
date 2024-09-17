package tests

import org.openqa.selenium.By
import org.testng.Assert
import org.testng.annotations.Test


class FirstTest: BaseTest() {

    @Test
    fun doTest() {
        app.sessionHelper.login("operatorDownload", "O9p0[-]=")
        app.mainPage.notificationCheck()

    }

}