package ru.blogic20.ecm.tests

import org.testng.annotations.DataProvider
import org.testng.annotations.Test
import ru.blogic20.ecm.autotests.datastore.UserStore
import ru.blogic20.ecm.autotests.model.User


class CheckUserProfile: BaseTest() {

    @DataProvider
    fun userDataProvider(): Iterator<Array<User>>{
        val list = mutableListOf<Array<User>>()
        UserStore.users.forEach{
            list.add(arrayOf(it))
        }
        return list.iterator()
    }


    @DataProvider
    fun adminDataProvider(): Iterator<Array<User>>{
        return mutableListOf(arrayOf(UserStore.getUserByRole("Администратор"))).iterator()
    }

    @Test(dataProvider = "userDataProvider")
    fun doTest(user: User){
        app.loginPage.login(user.login, user.password)
//        app.mainPage.openUserMenu()
//        app.mainPage.checkUserFullName(user.display_name)
    }

    @Test(dataProvider = "adminDataProvider")
    fun doTestAdmin(user: User){
        app.loginPage.login(user.login, user.password)
//        app.mainPage.openUserMenu()
//        app.mainPage.checkUserFullName(user.display_name)
    }




}