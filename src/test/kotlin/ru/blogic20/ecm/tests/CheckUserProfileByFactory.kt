package ru.blogic20.ecm.tests

import io.qameta.allure.*
import org.testng.annotations.Test
import ru.blogic20.ecm.autotests.model.User
import ru.blogic20.ecm.pages.PageStore


class CheckUserProfileByFactory(var user: User): BaseTest() {

    @Test
    @Description("This test attempts to log into the website using a login and a password. Fails if any error happens.\n\nNote that this test does not test 2-Factor Authentication.")

    fun doTest(){
        PageStore.getLocal().loginPage.login(user.login, user.password)
//        app.mainPage.openUserMenu()
//        app.mainPage.checkUserFullName(user.display_name)
//        app.mainPage.logout()
    }




}