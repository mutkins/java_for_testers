package ru.blogic20.ecm.tests

import org.example.configuration.Configuration
import ru.blogic20.ecm.tests.appManager.ApplicationManager
import org.testng.annotations.AfterClass
import org.testng.annotations.AfterMethod
import org.testng.annotations.AfterSuite
import org.testng.annotations.BeforeClass
import org.testng.annotations.BeforeMethod
import org.testng.annotations.BeforeSuite
import ru.blogic20.ecm.autotests.datastore.UserStore

open class BaseTest {

    @BeforeSuite
    fun userInit(){
        println("BeforeSuite initialization")
        if (UserStore.users.isEmpty()) {
            UserStore.init()
        }

    }
    @BeforeMethod
    fun setUp() {
        app.init()
    }

    @AfterMethod
    fun tearDown() {
        app.exit()
    }

    companion object{
        val app = ApplicationManager()
    }

}
