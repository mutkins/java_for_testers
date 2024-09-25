package ru.blogic20.ecm.tests

import org.testng.annotations.Test
import ru.blogic20.ecm.autotests.model.User


class CheckUserProfileByFactory(var user: User): BaseTest() {

    @Test()
    fun doTest(){
        app.loginPage.login(user.login, user.password)
        app.mainPage.openUserMenu()
        app.mainPage.checkUserFullName(user.display_name)
        app.mainPage.logout()
    }




}