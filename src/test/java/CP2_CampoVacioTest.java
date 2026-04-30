import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class CP2_CampoVacioTest {
    WebDriver driver;
    SistemaCitas sistema;

    @BeforeEach
    void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("file://" + System.getProperty("user.dir") + "/index.html");

        sistema = new SistemaCitas(driver);
    }

    @Test
    @DisplayName("CP2: Registro sin nombre de mascota")
    void testNombreVacio() {

        sistema.agendarCita("", "10:00 AM");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String resultadoObtenido = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("mensaje"))
        ).getText();

        assertEquals("Este campo es obligatorio", resultadoObtenido);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}