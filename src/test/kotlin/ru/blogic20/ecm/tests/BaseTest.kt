package ru.blogic20.ecm.tests

import org.testng.annotations.*
import ru.blogic20.ecm.autotests.ApplicationManager
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
        app = ApplicationManager()
        app.init()
    }

    @AfterMethod
    fun tearDown() {
        app.exit()

    }

    companion object{
        lateinit var app: ApplicationManager
    }

}
