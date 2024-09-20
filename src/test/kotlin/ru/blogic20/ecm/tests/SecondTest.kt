package ru.blogic20.ecm.tests

import org.openqa.selenium.By
import org.testng.Assert
import org.testng.annotations.Test


class SecondTest: BaseTest() {
    @Test
    fun doTest(){
        app.sessionHelper.login("operatorDownload", "O9p0[-]=")
        app.mainPage.openUserMenu()
        app.userMenu.checkUserFullName("Оператор загрузки Владимирович")
    }




}