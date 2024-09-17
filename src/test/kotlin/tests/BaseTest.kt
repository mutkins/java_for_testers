package tests

import appManager.ApplicationManager
import org.testng.annotations.AfterClass
import org.testng.annotations.AfterMethod
import org.testng.annotations.AfterSuite
import org.testng.annotations.BeforeClass
import org.testng.annotations.BeforeMethod
import org.testng.annotations.BeforeSuite

open class BaseTest {



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
