package tests
import org.testng.annotations.Test

class DocumentSearch: BaseTest() {

    @Test
    fun doTest(){
        app.sessionHelper.login("sberReader", "O9p0[-]=")
        app.mainPage.simpleSearch("filename")
        app.mainPage.openDocFromDocTable("filename")

    }
}