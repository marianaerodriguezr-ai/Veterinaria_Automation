import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class CP1_AgendarCitaTest {
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
    @DisplayName("CP1: Agendar cita correctamente")
    void testAgendar() {
        sistema.agendarCita("Sookie", "10:00 AM");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String resultado = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("mensaje"))
        ).getText();

        assertTrue(resultado.contains("Cita creada"), "El mensaje no es el esperado");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}