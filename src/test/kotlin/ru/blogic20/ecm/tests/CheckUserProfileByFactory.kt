package ru.blogic20.ecm.tests

import io.qameta.allure.*
import org.testng.annotations.Test
import org.testng.reporters.jq.Main
import ru.blogic20.ecm.autotests.model.User
import ru.blogic20.ecm.autotests.page.LoginPage
import ru.blogic20.ecm.autotests.page.MainPage

//import ru.blogic20.ecm.pages.PageStore


class CheckUserProfileByFactory(var user: User): BaseTest() {

    @Test
    @Description("This test attempts to log into the website using a login and a password. Fails if any error happens.\n\nNote that this test does not test 2-Factor Authentication.")

    fun doTest(){
        LoginPage(page).login(user.login, user.password)
        MainPage(page).openUserMenu()
//        MainPage(page).checkUserFullName(user.display_name)
//        MainPage(page).logout()

//        PageStore.getLocal().loginPage.login(user.login, user.password)
//        app.mainPage.openUserMenu()
//        app.mainPage.checkUserFullName(user.display_name)
//        app.mainPage.logout()
    }




}