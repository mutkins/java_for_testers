package ru.blogic20.ecm.autotests.util

import com.microsoft.playwright.Page
import ru.blogic20.ecm.autotests.page.*

/**
 * Класс-хранилище экземпляров Page Objects.
 */
object PlaywrightPageStore {

    private val localStore: ThreadLocal<Page> = ThreadLocal()
    fun getLocal(): Page {
        if (localStore.get() == null) localStore.set(PlaywrightBrowserStore.getLocal().newPage())
        return localStore.get()
    }
}