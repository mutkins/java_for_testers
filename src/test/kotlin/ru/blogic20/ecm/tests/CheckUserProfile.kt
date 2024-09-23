package ru.blogic20.ecm.tests

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.typesafe.config.ConfigRenderOptions
import com.typesafe.config.ConfigValueFactory
import org.openqa.selenium.By
import org.testng.Assert
import org.testng.annotations.DataProvider
import org.testng.annotations.Test
import ru.blogic20.ecm.autotests.configuration.Configuration
import ru.blogic20.ecm.autotests.datastore.UserStore
import ru.blogic20.ecm.autotests.model.User
import java.io.File


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
        app.sessionHelper.login(user.login, user.password)
        app.mainPage.openUserMenu()
        app.userMenu.checkUserFullName(user.display_name)
    }

    @Test(dataProvider = "adminDataProvider")
    fun doTestAdmin(user: User){
        app.sessionHelper.login(user.login, user.password)
        app.mainPage.openUserMenu()
        app.userMenu.checkUserFullName(user.display_name)
    }




}