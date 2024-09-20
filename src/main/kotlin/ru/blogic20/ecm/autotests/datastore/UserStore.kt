package ru.blogic20.ecm.autotests.datastore

import com.typesafe.config.ConfigBeanFactory
import ru.blogic20.ecm.autotests.configuration.Configuration
import ru.blogic20.ecm.autotests.model.User
import java.util.*

/**
 * Класс, описывающий хранилище пользователей.
 */
object UserStore {

    /**
     * Лист-набор пользователей из конфига.
     */
    var users = ArrayList<User>()

    /**
     * Метод, получающий список юезров из конфига стенда и записывающий их в лист
     */
    @JvmStatic
    fun init() {
        Configuration.config.getConfigList("users")?.forEach {
            val user = ConfigBeanFactory.create(it, User::class.java)
            users.add(user)
        }
    }

    /**
     * Метод, который возвращает юзера по его роли
     * @role - роль пользователя
     * @return- найденный пользователь
     */
    @JvmStatic
    fun getUserByRole(role: String): User {
        return users
                .stream()
                .filter { user -> user.role == role}
                .findFirst()
                .orElseThrow { AssertionError("Нет пользователя с данной ролью $role.") }
    }
}