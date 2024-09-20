package ru.blogic20.ecm.tests
import org.testng.annotations.Factory
import ru.blogic20.ecm.autotests.datastore.UserStore


class TestFactory() {

    @Factory
    fun createInstances(): Array<Any>{
        UserStore.init()
        var list = mutableListOf<Any>()
        UserStore.users.forEach {
            list.add(CheckUserProfileByFactory(it))
        }
        return list.toTypedArray()
    }
}