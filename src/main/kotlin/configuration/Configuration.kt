package org.example.configuration

//import com.google.inject.Singleton
import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory
import java.io.File

/**
* Created by rshershukov@it.ru on 25.07.17.
*/
//@Singleton
object Configuration {

    /**
     * Номер стенда
     */
    var standNumber: ThreadLocal<String> =ThreadLocal()
    var config: Config
        private set

    private val defaultConfig = ConfigFactory.parseFile(File("data/stand_configurations/${System.getProperty("stand")}.conf"))

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