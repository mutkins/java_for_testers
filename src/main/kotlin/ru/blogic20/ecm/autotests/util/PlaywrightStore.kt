package ru.blogic20.ecm.autotests.util

import com.microsoft.playwright.Browser
import com.microsoft.playwright.Page
import com.microsoft.playwright.Playwright
import ru.blogic20.ecm.autotests.page.*

/**
 * Класс-хранилище экземпляров Page Objects.
 */
object PlaywrightStore {

    private val localStore: ThreadLocal<Playwright> = ThreadLocal()
    fun getLocal(): Playwright {
        if (localStore.get() == null) localStore.set(Playwright.create())
        return localStore.get()
    }
}