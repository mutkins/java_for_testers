package ru.blogic20.ecm.autotests.util

import com.microsoft.playwright.Browser
import com.microsoft.playwright.BrowserType
import com.microsoft.playwright.Page
import ru.blogic20.ecm.autotests.page.*

/**
 * Класс-хранилище экземпляров Page Objects.
 */
object PlaywrightBrowserStore {

    private val localStore: ThreadLocal<Browser> = ThreadLocal()
    fun getLocal(): Browser {
        if (localStore.get() == null) localStore.set(PlaywrightStore.getLocal().chromium().launch(BrowserType.LaunchOptions().setHeadless(false)))
        return localStore.get()
    }
}