package ru.blogic20.ecm.autotests.configuration


import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory
import java.io.File


object Configuration {

    /**
     * Номер стенда
     */
    var standNumber: ThreadLocal<String> =ThreadLocal()
    var config: Config
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