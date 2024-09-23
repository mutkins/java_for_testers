package org.example.model


class User {

    /**
     * Логин пользователя
     */
    var name: String = ""
    /**
     * Пароль пользователя
     */
    var password: String = ""
    /**
     * Домен пользователя
     */
    var domain: String = ""
    /**
     * Отображаемое в системе имя пользователя
     */
    var displayName: String = ""
    /**
     * Роль пользователя
     */
    var role: String = ""

    /**
     * Отображаемая в системе роль
     */
    var displayRole = ""

    /**
     * Сертификат пользователя
     */
    var certificate: String = ""
    /**
     * Пин-код пользователя
     */
    var pin: String = ""
    /**
     * Доверенность
     */
    var proxy: String = ""
    /**
     * Метод возвращает полное имя пользователя логин@домен
     *
     * @return полное имя пользователя
     */
    fun getFullName() = name + "@" + domain
}