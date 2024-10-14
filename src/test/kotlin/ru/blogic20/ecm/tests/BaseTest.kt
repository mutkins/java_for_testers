//package ru.blogic20.ecm.tests
//
//import com.microsoft.playwright.*
//
//import ru.blogic20.ecm.autotests.configuration.Configuration
//import ru.blogic20.ecm.autotests.datastore.UserStore
//import ru.blogic20.ecm.autotests.util.PlaywrightBrowserStore
//
//open class BaseTest {
//    private lateinit var browserContext: BrowserContext
//    lateinit var page: Page
//    lateinit var playwright: Playwright
//    lateinit var browser: Browser
//
//
//    fun userInit(){
//        println("BeforeSuite initialization")
//        if (UserStore.users.isEmpty()) {
//            UserStore.init()
//        }
//
//    }
//
//
//    fun celebriumInit(){
//        io.celebrium.core.config.Configuration.init("data/celebrium_default.conf")
//    }
//
//
//    fun createContextAndPage() {
//        playwright = Playwright.create()
//        browser = playwright.chromium().launch(
//            BrowserType.LaunchOptions().setHeadless(false)
//                //Параметр для тестирования ПКР
//                .setSlowMo(500.0)
//        )
//        browserContext = browser.newContext(Browser.NewContextOptions().setLocale("ru-RU"))
//        browserContext.clearCookies()
//        val newPage = browserContext.newPage()
//        newPage.setDefaultTimeout(50000.0)
//        page = newPage
//        page.navigate(Configuration.config.getString("baseUrl"))
//    }
//
//
//    fun tearDown() {
////        DriverFactory.closeDriver()
//        PlaywrightBrowserStore.getLocal().close()
//
//    }
//
//    companion object{
//        lateinit var app: ApplicationManager
//    }
//
//}
