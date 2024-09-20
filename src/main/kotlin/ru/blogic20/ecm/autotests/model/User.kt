package ru.blogic20.ecm.autotests.model


/**
* Created by rshershukov@it.ru on 08.06.17.
*/
class User() {

    var name: String = ""
    /**
     * Логин пользователя
     */
    var login: String = ""

    /**
     * Пароль пользователя
     */
    var password: String = ""

    /**
     * Отображаемое в системе имя пользователя
     */
    var display_name: String = ""
    /**
     * Роль пользователя
     */
    var role: String = ""
    /**
     * Отображаемая в системе роль
     */
//    var displayRole: String = ""

    override fun toString(): String {
        return "user=$login"
    }
}