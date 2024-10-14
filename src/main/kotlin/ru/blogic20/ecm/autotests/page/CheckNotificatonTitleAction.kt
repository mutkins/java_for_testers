package ru.blogic20.ecm.autotests.page

import io.cucumber.java.en.Given
import ru.blogic20.ecm.autotests.datastore.UserStore
import ru.blogic20.ecm.autotests.page.Common
import ru.blogic20.ecm.autotests.page.LoginPage

class CheckNotificatonTitleAction {
    @Given("Текст заголовка {string}")
    fun login(title: String){
    println("Текст заголовка $title")
    }
}