import io.cucumber.junit.Cucumber
import io.cucumber.junit.CucumberOptions
import org.junit.runner.RunWith

@RunWith(Cucumber::class)
@CucumberOptions(
    features = ["src/test/resources/"],
    glue = ["ru.blogic20.ecm.autotests.actions"], // замените на ваши пакеты
    plugin = ["pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"]
)
class RunCucumberTest
