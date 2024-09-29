package ru.blogic20.ecm.tests
import org.testng.annotations.Test
import ru.blogic20.ecm.autotests.datastore.UserStore
import ru.blogic20.ecm.autotests.model.User
import ru.blogic20.ecm.pages.PageStore

class NotificationCheck(): BaseTest() {

    @Test
    fun doTest(){
        val user = UserStore.getUserByRole("Оператор Верификации")
        PageStore.getLocal().loginPage.login(user.login, user.password)
        PageStore.getLocal().mainPage.notificationCheck()

    }
}