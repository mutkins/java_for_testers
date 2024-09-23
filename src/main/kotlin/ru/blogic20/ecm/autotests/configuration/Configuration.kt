package ru.blogic20.ecm.autotests.configuration


import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import java.io.File


object Configuration {

    /**
     * Номер стенда
     */
    var standNumber: ThreadLocal<String> =ThreadLocal()
    var config: Config
    var driver: WebDriver = when (System.getProperty("browser")){
            "firefox"-> FirefoxDriver()
            "chrome" -> ChromeDriver()
            else -> FirefoxDriver()
        }
        private set

//    private val defaultConfig = ConfigFactory.parseFile(File("data/stand_configurations/${System.getProperty("stand.path")}.conf"))
    private val defaultConfig = ConfigFactory.parseFile(File("data/configuration/244/config.conf"))
    /**
     * Инициализация
     */
    init {
        config = defaultConfig.resolve()
    }

    /**
     * Метод установки номера стенда
     */
    @JvmStatic
    fun init(standNum: String) {
        standNumber.set(standNum)
    }
}