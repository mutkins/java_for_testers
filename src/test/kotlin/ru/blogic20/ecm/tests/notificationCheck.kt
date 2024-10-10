package ru.blogic20.ecm.tests
import io.qameta.allure.*
import org.testng.annotations.Test
import ru.blogic20.ecm.autotests.datastore.UserStore
import ru.blogic20.ecm.autotests.model.User
import ru.blogic20.ecm.autotests.page.LoginPage
import ru.blogic20.ecm.autotests.page.MainPage
//import ru.blogic20.ecm.pages.PageStore

class NotificationCheck(): BaseTest() {

    @Test
    @Description("This test attempts to log into the website using a login and a password. Fails if any error happens.\n\nNote that this test does not test 2-Factor Authentication.")
    @Owner("John Doe")
    @Link(name = "Website", url = "https://dev.example.com/")
    @Issue("AUTH-123")
    @TmsLink("TMS-456")
    @Epic("Web interface")
    @Feature("Essential features")
    @Story("Authentication")
    fun doTest(){
        val user = UserStore.getUserByRole("Оператор Верификации")
        LoginPage(page).login(user.login, user.password)
        MainPage(page).notificationCheck()

    }
}