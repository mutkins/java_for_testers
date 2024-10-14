package ru.blogic20.ecm.autotests.page

import io.cucumber.java.Before
import io.cucumber.java.After
import com.microsoft.playwright.*
import ru.blogic20.ecm.autotests.datastore.UserStore

open class Common {
    private lateinit var browser: Browser
    private lateinit var context: BrowserContext
    lateinit var page: Page
    @Before
    fun setUp() {
        // Инициализация Playwright и браузера
        val playwright = Playwright.create()
        browser = playwright.chromium().launch()
        context = browser.newContext()
        page = context.newPage()
        println("Браузер запущен и готов к тестам")
    }

    @Before
    fun userInit() {
        println("Users initialization")
        if (UserStore.users.isEmpty()) {
            UserStore.init()
        }
    }

    @After
    fun tearDown() {
        // Закрытие браузера после выполнения тестов
        page.close()
        context.close()
        browser.close()
        println("Браузер закрыт")
    }

}
