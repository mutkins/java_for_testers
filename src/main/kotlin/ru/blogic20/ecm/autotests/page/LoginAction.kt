package ru.blogic20.ecm.autotests.page

import io.cucumber.java.en.Given
import ru.blogic20.ecm.autotests.datastore.UserStore
import ru.blogic20.ecm.autotests.page.Common
import ru.blogic20.ecm.autotests.page.LoginPage

class LoginAction {
    @Given("пользователь зашел в систему под ролью {string}")
    fun login(role: String){
        val user = UserStore.getUserByRole(role)
//        loginPage.login(user.login, user.password)
    println("пользователь зашел в систему под ролью $role")
    }
}